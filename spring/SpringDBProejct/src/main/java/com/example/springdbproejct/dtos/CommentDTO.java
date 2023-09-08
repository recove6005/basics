package com.example.springdbproejct.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private int no;
    private String userId;
    private String text;
    @JsonFormat(pattern = "yyyy년 MM월 dd일")
    private LocalDateTime writeDate;
}