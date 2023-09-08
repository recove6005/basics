package com.example.springproject.mvc.vo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @NonNull
    private String name;
    private int price;
}