package com.example.boot;

import com.example.boot.dtos.CommentDTO;
import com.example.boot.mappers.CommentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootProjectApplicationTests {
    @Autowired
    CommentMapper commentMapper;
    @Test
    void contextLoads() {
        for(int i = 0; i < 100; i++) {
            // CommentDTO에 @Builder
            CommentDTO dto = CommentDTO.builder()
                    .text("comment" + i)
                    .userID("korea")
                    .boardNo(1)
                    .build();
            commentMapper.insert_comment(dto);
        }
    }

}
