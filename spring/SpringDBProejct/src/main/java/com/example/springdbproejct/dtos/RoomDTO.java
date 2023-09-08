package com.example.springdbproejct.dtos;

import lombok.*;

import java.util.List;

@ToString
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
    private byte no;
    private byte capacity;
    List<UserDTO> userDTOList;
    public RoomDTO(byte capacity){
        this.capacity = capacity;
    }
}
