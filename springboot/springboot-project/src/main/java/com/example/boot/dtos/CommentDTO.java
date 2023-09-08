package com.example.boot.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDTO {
    private int no;
    private String userID;
    private int boardNo;
    private String title;
    private String text;
    private LocalDateTime writeDate;


}