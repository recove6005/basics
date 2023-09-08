package com.example.boot.services;

import com.example.boot.dtos.BoardDTO;
import com.example.boot.dtos.FileDTO;
import com.example.boot.mappers.BoardMapper;
import com.example.boot.vos.FileVO;
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
