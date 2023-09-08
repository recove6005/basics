package com.example.springdbproejct.controller;

import com.example.springdbproejct.dtos.FileDTO;
import com.example.springdbproejct.services.BoardService;
import com.example.springdbproejct.dtos.BoardDTO;
import com.example.springdbproejct.mappers.BoardMapper;
import com.example.springdbproejct.vos.FileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    private final String SAVE_PATH = "C:\\Users\\hanib\\OneDrive\\바탕 화면\\testfile\\";

    @Autowired
    private BoardService boardService;
    @Autowired
    private BoardMapper boardMapper;

    @GetMapping("/main")
    public void get_board_main(Model model){
        // DB에서 전체 게시물들을 조회한다
        List<BoardDTO> boardDTOS = boardMapper.get_boards();
        // 조회된 게시물들을 "boards"이름으로 model에 추가하여 jsp에서 사용할 수 있도록 한다
        model.addAttribute("boards", boardDTOS);
    }

    @GetMapping("/view")
    public void get_board_view(Model model, @RequestParam int no){
        boardMapper.increase_count(no); // 조회수 1 증가시켜라
        BoardDTO boardDTO = boardMapper.get_board(no); // 해당 no게시물 가져와라
        FileVO fileVO = boardMapper.get_files(no); // 해당 no게시물의 파일 내용 가져와라
        System.out.println(fileVO);
        List<String> files = fileVO.getFileName();
        System.out.println(files);
        List<String> normalFiles = new ArrayList<>(); //일반 파일 개수 모아주기
        files.forEach(fileName -> {
            String[] names = fileName.split("[.]");
            if(names[names.length - 1].equals("jpg")){
                //메인 이미지
                model.addAttribute("mainImage", fileName);
            }else{
                //일반 파일
                normalFiles.add(fileName);
            }
        });
        model.addAttribute("board", boardDTO); //jsp로 해당 게시물 객체 보내라
        model.addAttribute("normalFiles", normalFiles); //jsp로 해당 파일 객체 보내라
    }

    @GetMapping("/delete")
    public String get_board_delete(@RequestParam int no){
        boardMapper.delete_board(no);
        return "redirect:/board/main";
    }

    // View 페이지에서 => 수정 페이지로 이동하는 GET 요청
    // 게시물의 no를 받아와서 해당 게시물의 정보를 보여줘야 함
    @GetMapping("/update")
    public String get_board_update(Model model, int no){
        BoardDTO boardDTO = boardMapper.get_board(no);
        model.addAttribute("board", boardDTO);
        return "/board/modify";
    }
    // 수정 페이지에서 수정 버튼 눌렀을 때 (submit)을 했을 때
    // 실제로 DB의 데이터를 변경하고 다시 main페이지로 이동함
    @PostMapping("/update")
    public String post_board_update(BoardDTO boardDTO){
        System.out.println("post_board_update => " + boardDTO);
        boardMapper.update_board(boardDTO);
        return "redirect:/board/main";
    }

    // 게시물 추가 페이지로 이동하는 메소드
    @GetMapping("/insert")
    public String get_board_insert(){
        return "/board/add";
    }

    // 실제 DB와 연동하여 전달받은 내용으로 insert를 시도하는 메소드
    @PostMapping("/insert")
    public String post_board_insert(BoardDTO boardDTO){
        FileDTO fileDTO = boardDTO.getFileDTO();
        List<String> fileNames = new ArrayList<>();
        upload_files(fileNames, fileDTO.getFileName()); //받은 파일들 저장
        upload_files(fileNames, Arrays.asList(fileDTO.getMainImage())); //받은 파일 저장
        boardService.insert_board(fileNames, boardDTO); //DB에 파일 경로 저장
        return "redirect:/board/main"; //Controller로 가세요
    }

    @GetMapping("/file/{fileName}")
    public ResponseEntity<Resource> get_file_download(
            @PathVariable("fileName") String fileName
    ) throws Exception{
        Resource resource = new FileSystemResource(SAVE_PATH + fileName);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", Files.probeContentType(resource.getFile().toPath()));
        return ResponseEntity.ok().headers(httpHeaders).body(resource);
    }

    // 파일 저장 담당하는 일반 메소드
    private void upload_files(List<String> fileNames, List<MultipartFile> multipartFile) {
        for (MultipartFile file : multipartFile) {
            //UUID: 중복될 가능성이 거의 없는 16자리 코드 값
            String UUID = java.util.UUID.randomUUID().toString(); // 랜덤 글자 생성하기 (16자리)
            String fileName = file.getOriginalFilename(); // 원래 파일 이름 가져오기
            try {
                Path savePath = Paths.get(SAVE_PATH, UUID + "_" + fileName); //SAVE_PATH에 UUID+파일이름 합쳐서 전체 경로 생성
                fileNames.add(UUID + "_" + fileName);
                file.transferTo(savePath); // 실제 경로에 저장한다
            } catch (IOException e) {
                System.out.println("[" + fileName + "] 파일 저장 시 에러 발생!");
            }
        }
    }


//    @Autowired
//    private BoardService boardService;
//
//    @Autowired
//    private BoardMapper boardMapper;
//
//    @GetMapping("/main")
//    public void get_board_main(Model model) {
//        // DB에서 전체 게시물들을 조회
//        List<BoardDTO> boardDTOList = boardMapper.get_boards();
//
//        // 조회된 게시물들을 "boards"이름으로 model에 추가하여 jsp에서 사용할 수 있도록 한다
//        // main.jsp에서 ${boards}
//        model.addAttribute("boards", boardDTOList);
//    }
//
//    @GetMapping("/view")
//    public void get_board_view(Model model, @RequestParam int no) {
//        // title 클릭 전에 조회수 올리는 작업
//        boardMapper.increase_count(no);
//        // 해당 no 게시물 조회
//        BoardDTO boardDTO = boardMapper.get_board(no);
//
//        FileVO fileVO = boardMapper.get_files(no);
//        List<String> files = fileVO.getFileName();
//        List<String> normalFiles = new ArrayList<>(); // 일반 파일 개수 모아주기
//        files.forEach(fileName -> {
//            String[] names = fileName.split(".");
//            if(names[names.length -1].equals("jpg")) {
//                // 메인 이미지
//                model.addAttribute("mainImage", fileName);
//            } else {
//                // 일반 파일
//                normalFiles.add(fileName);
//            }
//        });
//        model.addAttribute("board", boardDTO); // jsp로 해당 게시물 객체 전달
//        model.addAttribute("normalFile", normalFiles); // jsp로 해당 파일 객체 전달
//
//
//    }
//
//    @GetMapping("/delete")
//    public String delete_board(@RequestParam int no) {
//        boardMapper.delete_board(no);
//        return "redirect:/board/main";
//    }
//
//    @GetMapping("/update")
//    public String get_update_board(Model model, int no) {
//        // 수정 페이지로 이동하는 GET 요청
//        // 게시물 no를 받아온 후 해당 게시물 정보 출력
//        BoardDTO boardDTO = boardMapper.get_board(no);
//        model.addAttribute("board", boardDTO);
//        return "/board/modify";
//    }
//
//    @PostMapping("/update")
//    public String post_update_board(BoardDTO boardDTO) {
//        // 수정 페이지에서 submit 했을 경우 : 실제 DB 업데이트 후 main 페이지로 이동
//        // input name과 boardDTO 인스턴스 name이 같으므로 컨트롤러가 자동 매핑~
//        boardMapper.update_board(boardDTO);
//        return "redirect:/board/main";
//    }
//
//    @GetMapping("/insert")
//    public String get_insert_board() {
//        return "/board/add";
//    }
//
//    @PostMapping("/insert")
//    public String post_insert_board(BoardDTO boardDTO) {
//        FileDTO fileDTO = boardDTO.getFileDTO();
//        upload_files(fileDTO.getFileName());
//        upload_files(Arrays.asList(fileDTO.getMainImage())); // 받은 파일 저장
//        boardService.insert_board(boardDTO);
//        // boardMapper.insert_board(boardDTO);
//        return "redirect:/board/main";
//    }
//
//    @GetMapping("/file")
//    public ResponseEntity<Resource> get_file_download(
//            @RequestParam("fileName") String fileName
//    ) throws Exception{
//        Resource resource = new FileSystemResource(SAVE_PATH + fileName);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Content-Type", Files.probeContentType(resource.getFile().toPath()));
//        return ResponseEntity.ok().headers(httpHeaders).body(resource);
//    }
//
//    private void upload_files(List<MultipartFile> multipartFiles) {
//        FileDTO fileDTO = new FileDTO();
//        fileDTO.getFileName();
//        for(MultipartFile file : multipartFiles) {
//            String UUID = java.util.UUID.randomUUID().toString(); // 랜덤 글자 생성
//            String fileName = file.getOriginalFilename(); // 원본 파일 이름
//            try {
//                Path savePath = Paths.get(SAVE_PATH, UUID + "_" + fileName); // SAVA_PATH에 UUID + fileName, 전체 경로 생성
//                file.transferTo(savePath); // 실제 경로에 저장
//            } catch (IOException e) {
//                System.out.println("[" + fileName + "]" + " file saveing is failed.");
//            }
//
//        }
//    }
}