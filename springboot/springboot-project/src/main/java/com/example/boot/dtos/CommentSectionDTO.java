package com.example.boot.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Builder
public class CommentSectionDTO {
    private int boardNo; // 해당 게시물 번호
    List<CommentDTO> commentDTOList; // 해당 게시물의 댓글 전체 리스트

    // 댓글 페이징
    private int nowPageNum; // 현재 사용자가 보고 있는 페이지
    private int showPageCnt; // 한 페이지에 보여줄 페이지 개수
    private int showCommCnt; // 한 페이지에 보여줄 댓글 개수
    private int allPageCnt; // 총 페이지 개수
    private int startCommNum;   // 현재 페이지에서 시작할 댓글 번호

    private int startPageNum; // 현재 화면에서의 시작 페이지 번호
    private int endPageNum; // 현재 화면에서의 마지막 페이지 번호

    public void set_comment_section_info() {
        allPageCnt = (int) Math.ceil((double) commentDTOList.size() / showCommCnt);
        startCommNum = commentDTOList.size() % allPageCnt == 0
                ? commentDTOList.size() % allPageCnt * (nowPageNum - 1) + 1
                : commentDTOList.size() % allPageCnt * (nowPageNum) + 1;

        startPageNum = nowPageNum - showPageCnt / 2;
        endPageNum = nowPageNum + showPageCnt / 2;

        if (startPageNum < 1) {
            endPageNum = showPageCnt;
            startPageNum = 1;
        } else if (endPageNum > allPageCnt) {
            startPageNum = allPageCnt - showPageCnt + 1;
            endPageNum = allPageCnt;
        }
        System.out.println("allPageCount: " + allPageCnt);
        System.out.println("showPageCount: " + showPageCnt);
        System.out.println("startPageNum: " + startPageNum);
        System.out.println("endPageNum: " + endPageNum);
        System.out.println("startCommNum: " + startCommNum);
        // 보여줄 댓글 부분만 index 슬라이싱해서 다시 설정
        commentDTOList = commentDTOList.subList(startCommNum, startCommNum + showCommCnt + 1);
    }

    /*
        20개의 댓글이 있을 때
        한 페이지 당 3개의 댓글을 보여주려면
        전체 페이지 개수는 => 20 / 3 = 6. 총 7개의 페이지 필요
        현제 3페이지에 위치할 때 => 7 8 9 댓글을 출력. 시작은 7.
        => 댓글 시작 번호는
        => 21 / 7(내림) * 3 + 1
        => 20 / 7(내림) * 3 + 1
        => 전체 댓글 수 / 전체 페이지 개수 * 현제 페이지 번호 + 1
        => 나눴을 때 맞아떨어지면 현재 페이지 번호에서 -1, 아니면 그대로

        한 화면 당 페이지 번호는 5개씩 보여주려면
        4 페이지에 위치할 때 => 2 3 4 5 6 => 양쪽에 5/ 2 , 현재 페이지에서 -2 와 +2
    */
}
