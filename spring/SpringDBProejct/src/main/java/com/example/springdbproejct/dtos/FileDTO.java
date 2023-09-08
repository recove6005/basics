package com.example.springdbproejct.dtos;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

@ToString
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO implements Serializable {
    private List<MultipartFile> fileName;
    private MultipartFile mainImage;
}
