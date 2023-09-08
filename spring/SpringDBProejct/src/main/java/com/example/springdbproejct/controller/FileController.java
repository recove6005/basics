package com.example.springdbproejct.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileController {
    // 파일 저장 경로
    private final String SAVE_PATH = "C:\\Users\\hanib\\OneDrive\\바탕 화면\\testfile";

    @GetMapping("/file/upload")
    public void get_file_upload(){}

    // consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    // => jsp의 form에서 enctype이 "multipart/form-data"로 요청했다면 매핑 대상이다
    @PostMapping(value = "/file/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void post_file_upload(List<MultipartFile> myFile) {
        upload_files(myFile);
    }

    @GetMapping("/file/download")
    public void get_file_download(Model model) throws Exception{
        Map<String, String> fileDatas = new HashMap<>();
        File file = new File(SAVE_PATH);
        Arrays.stream(file.list()).parallel().forEach(nowFileName -> {
            try {
                File nowFile = new File(SAVE_PATH, nowFileName);
                if (nowFile.isFile()) { //디렉터리가 아니라 파일이라면
                    FileInputStream fileInputStream = new FileInputStream(nowFile);
                    String fileData = new String(fileInputStream.readAllBytes());
                    String[] fileNames = nowFile.getName().split("_");
                    String fileName = fileNames[fileNames.length - 1];
                    fileDatas.put(fileName, fileData);
                    fileInputStream.close();
                }
            }catch (Exception e){
                System.out.println("Error: " + nowFileName + "이 없습니다!!!");
            }
        });
        model.addAttribute("fileDatas", fileDatas);
    }

    // 이미지일 경우
//    @GetMapping("/file/image")
//    public void get_image_download(
//            @RequestParam("imgName") String imageFileName,
//            HttpServletResponse response
//    ) throws Exception{
//        response.addHeader("Content-disposition", "attachment; fileName=" + imageFileName);
//        OutputStream out = response.getOutputStream();
//        File file = new File(SAVE_PATH + imageFileName);
//        FileInputStream input = new FileInputStream(file);
//        out.write(input.readAllBytes());
//        input.close();
//        out.close();
//    }
    @GetMapping("/file/image")
    public ResponseEntity<Resource> get_image_download(
            @RequestParam("imgName") String imageFileName
    ) throws Exception{
        Resource resource = new FileSystemResource(SAVE_PATH + imageFileName);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", Files.probeContentType(resource.getFile().toPath()));
        return ResponseEntity.ok().headers(httpHeaders).body(resource);
    }



    // 파일 저장 담당하는 일반 메소드
    private void upload_files(List<MultipartFile> multipartFile){
        for(MultipartFile file : multipartFile){
            //UUID: 중복될 가능성이 거의 없는 16자리 코드 값
            String UUID = java.util.UUID.randomUUID().toString(); // 랜덤 글자 생성하기 (16자리)
            String fileName = file.getOriginalFilename(); // 원래 파일 이름 가져오기
            try {
                Path savePath = Paths.get(SAVE_PATH, UUID + "_" + fileName); //SAVE_PATH에 UUID+파일이름 합쳐서 전체 경로 생성
                file.transferTo(savePath); // 실제 경로에 저장한다
            }catch (IOException e){
                System.out.println("[" + fileName + "] 파일 저장 시 에러 발생!");
            }
        }
//        System.out.println("=== post_file_upload 로 왔습니다~ ===");
//        System.out.println("파일명:" + myFile.getName());
//        System.out.println("원본파일명:" + myFile.getOriginalFilename());
//        System.out.println("파일크기:" + myFile.getSize());
//        System.out.println("ContentType:" + myFile.getContentType());
//        System.out.println("파일내용:" + new String(myFile.getBytes()));
    }


//    @GetMapping("/upload")
//    public void get_file_upload() {
//
//    }
//
//    @PostMapping
//    public void test(MultipartHttpServletRequest request) {
//        request.getParameter("myFile");
//    }
//
//    // consumes = MediaType.MULTIPART_FORM_DATA_VALUE
//    // jsp의 form에서 enctype이 "multipart/form-data"로 요청이 왔다면 매핑 대상
//
//    @PostMapping(value=  "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public void post_file_upload(List<MultipartFile> myFile) {
//        // File 1개 전달
//        // System.out.println("This is post_file_upload().");
//        // System.out.println("Original file name : " + myFile.getOriginalFilename());
//        // System.out.println("File name : " + myFile.getName());
//        // System.out.println("File size : " + myFile.getSize());
//        // System.out.println("Content Type : " + myFile.getContentType());
//        // System.out.println("File content : " + new String(myFile.getBytes()));
//
//        // Path savePath = Paths.get("C:\\" + myFile.getOriginalFilename());
//        // myFile.transferTo(savePath);
//
//        // InputStream is = myFile.getInputStream();
//        // OutputStream os = new FileOutputStream("copied.txt");
//        // os.write(is.readAllBytes());
//        // System.out.println("File copy is completed.");
//
//        // File copiedFile = new File("copied.text");
//        // myFile.transferTo(copiedFile);
//
//        // 여러 개의 File 업로드 시 List로 받음
//        // System.out.println(myFile);
//        // 랜덤 글자 생성 -> 파일 name 뒤에 붙여서 파일을 구분함.
//        // String UUID = java.util.UUID.randomUUID().toString();
//        upload_files(myFile);
//    }
//
//    // 파일 저장을 담당하는 일반 메소드
//    private void upload_files(List<MultipartFile> multipartFiles) {
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
//
//    @GetMapping("/download")
//    public void get_file_download(Model model) {
//        // 파일 이름(String), 파일 내용(String)
//        Map<String, String> fileDatas = new HashMap<>();
//        File file = new File(SAVE_PATH);
//        Arrays.stream(file.list()).parallel().forEach(nowFileName -> {
//            try {
//                File nowFile = new File(SAVE_PATH, nowFileName);
//                if (nowFile.isFile()) {
//                    // 디렉터리 x file o
//                    FileInputStream fis = new FileInputStream(nowFile);
//                    String fileData = new String(fis.readAllBytes());
//                    String[] fileNames = nowFile.getName().split("_"); // UUID 제거
//                    String fileName = fileNames[fileNames.length-1]; // UUID 제거
//                    fileDatas.put(fileName, fileData);
//                    System.out.println(fileData);
//                    fis.close();
//                }
//            } catch (Exception e) {
//                System.out.println("Error : " + nowFileName + " is not exists.");
//            }
//        });
//        model.addAttribute("fileData", fileDatas);
//    }
//
//    // 이미지 파일 다운로드
//    @PostMapping("/image")
//    public ResponseEntity<Resource> get_image_download(@RequestParam("imgName") String imgFileName, HttpServletResponse resp) throws Exception {
////        resp.addHeader("Content-disposition", "attachment; fileName=" + imgFileName);
////        OutputStream out = resp.getOutputStream();
////        File file = new File(SAVE_PATH + imgFileName);
////        FileInputStream fis = new FileInputStream(file);
////        out.write(fis.readAllBytes());
////        fis.close();
////        out.close();
//        Resource resource = new FileSystemResource(SAVE_PATH + imgFileName);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Content-Type", Files.probeContentType(resource.getFile().toPath()));
//        return ResponseEntity.ok().headers(httpHeaders).body(resource);
//    }
}
