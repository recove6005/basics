package com.example.springdbproejct.restController;

import com.example.springdbproejct.dtos.CommentDTO;
import com.example.springdbproejct.mappers.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentMapper commentMapper;

    @GetMapping
    public List<CommentDTO> get_all_comment() {
        return commentMapper.get_all_comments(null);
    }

    @GetMapping("/{userId}")
    public List<CommentDTO> get_all_comment_of_user(@PathVariable String userId) {
        return commentMapper.get_all_comments(userId);
    }

    @PostMapping("/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void post_comment(@RequestBody CommentDTO commentDTO) {
        System.out.println(commentDTO);
        commentMapper.insert_comment(commentDTO);
        System.out.println("insert is completed.");
    }

    // comment 수정
    @PutMapping("/{no}")
    @ResponseStatus(HttpStatus.CREATED)
    public void put_comment(
            @PathVariable int no,
            @RequestBody CommentDTO commentDTO
    ) {
        commentMapper.update_comment(no, commentDTO);
    }

    // comment 삭제
    @DeleteMapping("/{no}")
    @ResponseStatus(HttpStatus.OK)
    public void delete_comment(@PathVariable int no) {
        commentMapper.delete_comment(no);
    }


}