package com.example.springdbproejct.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DateMapper {
    @Select("SELECT NOW()")
    String select_now();
    String select_now2();

}
