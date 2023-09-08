package com.example.springdbproejct.services;

import com.example.springdbproejct.dtos.BoardDTO;
import com.example.springdbproejct.dtos.FileDTO;
import com.example.springdbproejct.mappers.BoardMapper;
import com.example.springdbproejct.vos.FileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardMapper boardMapper;
    // 게시물 하나의 업로드 담당 서비스
    public boolean insert_board(List<String> fileNames, BoardDTO boardDTO){
        FileDTO fileDTO = boardDTO.getFileDTO();
        FileVO fileVO = new FileVO(boardDTO.getNo(), fileNames);
        return boardMapper.insert_board(boardDTO) && boardMapper.insert_file(fileVO);
    }
}
