package com.example.boot.controller;

import com.example.boot.dtos.CommentDTO;
import com.example.boot.mappers.BoardMapper;
import com.example.boot.mappers.CommentMapper;
import com.example.boot.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentService commentService;
    // 댓글 작성 (POST) - /comment
    @PostMapping
    public void post_comment(@RequestBody CommentDTO commentDTO){
        commentMapper.insert_comment(commentDTO);
    }

    // 댓글 수정 (PUT)  - /comment/{댓글번호}
    @PutMapping("/{no}")
    public void update_comment(
            @PathVariable int no,
            @RequestBody CommentDTO commentDTO
            ) {
        commentDTO.setNo(no);
        commentMapper.update_comment(commentDTO);
    }

    // 댓글 삭제 (DELETE) - /comment/{댓글번호}
    @DeleteMapping("/{no}")
    public void delete_comment(@PathVariable int no) {
        commentMapper.delete_comment(no);
    }

    // 댓글 조회 (GET) - /comment/{게시물번호}
    @GetMapping("/{boardNo}")
    public List<CommentDTO> get_comment(@PathVariable int boardNo, @RequestParam int pageNo){
            return  commentService.get_all_comments(boardNo, pageNo);
    }
}
