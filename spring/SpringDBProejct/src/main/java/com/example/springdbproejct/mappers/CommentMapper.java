package com.example.springdbproejct.mappers;

import com.example.springdbproejct.dtos.CommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    // 모든 댓글 가져오기
    List<CommentDTO> get_all_comments(String userId);
    // 댓글 추가
    void insert_comment(CommentDTO commentDTO);
    // 댓글 수정
    void update_comment(int no, CommentDTO commentDTO);
    // 댓글 삭제
    void delete_comment(int no);
}
