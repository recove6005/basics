package com.example.springdbproejct.vos;

import lombok.*;

import java.util.List;

@ToString
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileVO {
    private int boardNo;
    private List<String> fileName;
}