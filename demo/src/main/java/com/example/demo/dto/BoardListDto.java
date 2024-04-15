package com.example.demo.dto;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class BoardListDto {
    private Long bno;           // 게시판번호
    private Long cno;           // 댓글번호
    private String title;       // 게시판 제목
    private String contents;    // 댓글

    @QueryProjection
    public BoardListDto(Long bno, Long cno, String title, String contents) {
        this.bno = bno;
        this.cno = cno;
        this.title = title;
        this.contents = contents;
    }
}
