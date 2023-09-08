package com.example.boot.mappers;

import com.example.boot.dtos.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    //해당 id를 가지는 유저 정보 조회
    UserDTO get_user(
            @Param("id") String id,
            @Param("pw") String pw
    );

    UserDTO is_user_exist(
            @Param("id") String id,
            @Param("nickName") String nickName
    );




    List<UserDTO> get_users(); // 전체 유저 조회
    // 해당 capacity 이하의 방에 있는 사람들의 리스트
    List<UserDTO> get_users_of_capacity(byte capacity);
    //유저를 삽입하는 insert (회원가입)
    boolean insert_user(
            @Param("id") String id,
            @Param("pw") String pw,
            @Param("nickName") String nickName
    );

    boolean insert_user(UserDTO userDTO);
}