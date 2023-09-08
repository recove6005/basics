package com.example.boot.mappers;

import com.example.boot.dtos.BoardDTO;
import com.example.boot.vos.FileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    // 현재 모든 게시물 정보 가져오기 (board-Main)
    List<BoardDTO> get_boards();
    // 해당 no의 게시물 정보 가져오기 (board-no)
    BoardDTO get_board(int no);
    // 해당 no의 게시물의 count(조회수)를 1 증가시키기
    boolean increase_count(int no);
    // 전달받은 no의 게시물의 delete 시도
    boolean delete_board(int no);
    // 전달받은 dto 객체의 내용으로 기존 게시물의 update 시도
    boolean update_board(BoardDTO boardDTO);
    // 전달받은 dto 객체의 내용으로 새로운 게시물을 insert 시도
    boolean insert_board(BoardDTO boardDTO);
    // 전달받은 dto 객체 내부의 File내용으로 새로운 게시물의 파일들을 insert 시도
    boolean insert_file(FileVO fileVO);
    // 전달받은 no게시물의 파일들을 전부 가져오기 시도
    FileVO get_files(int no);
}