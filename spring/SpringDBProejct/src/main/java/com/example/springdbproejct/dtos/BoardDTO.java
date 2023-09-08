package com.example.springdbproejct.dtos;

import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private int no;
    private String userID;
    private String title;
    private String content;
    private LocalDateTime writeDate;
    private int count;
    private FileDTO fileDTO;
}
