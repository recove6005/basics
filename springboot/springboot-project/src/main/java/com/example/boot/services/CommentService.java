package com.example.boot.services;

import com.example.boot.dtos.CommentDTO;
import com.example.boot.dtos.CommentSectionDTO;
import com.example.boot.mappers.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentService {
    @Autowired
    private CommentMapper commentMapper;
    public List<CommentDTO> get_all_comments(int boardNo, int pageNo){
        List<CommentDTO> commentDTOList = commentMapper.get_all_comments(boardNo);
        CommentSectionDTO commentSectionDTO = CommentSectionDTO.builder()
                .boardNo(boardNo)
                .commentDTOList(commentDTOList)
                .showPageCnt(5) // 보여주고 싶은 페이지 개수
                .nowPageNum(pageNo) // 현재 페이지 넘버
                .showCommCnt(3) // 한 페이지에 보여주고 싶은 댓글 개수
                .build();
        commentSectionDTO.set_comment_section_info();
        return commentDTOList;
    }
}
