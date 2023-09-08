package com.example.security.mapper;

import com.example.security.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    // 해당 ID의 유저가 존재하는지 확인
    UserDTO get_user_by_id(String userID);

    // 유저 새로 등록
    void post_user(UserDTO userDTO);
}
