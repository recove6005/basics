package com.example.springdbproejct.mappers;

import com.example.springdbproejct.dtos.StdClubDTO;
import com.example.springdbproejct.dtos.StdDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StdMapper {
    @Select("SELECT * FROM `stdtbl` LIMIT 1")
    StdDTO get_student();

    List<StdClubDTO> get_information();

}
