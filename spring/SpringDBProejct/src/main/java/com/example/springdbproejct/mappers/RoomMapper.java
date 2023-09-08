package com.example.springdbproejct.mappers;

import com.example.springdbproejct.dtos.RoomDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoomMapper {
    RoomDTO get_room(byte no); // 해당 번호를 가진 방을 조회
    List<RoomDTO> get_rooms(int capacity);
    boolean create_room(RoomDTO roomDTO);
    boolean create_rooms(List<RoomDTO> roomDTOS);
}
