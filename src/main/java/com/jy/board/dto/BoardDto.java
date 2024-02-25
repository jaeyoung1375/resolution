package com.jy.board.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class BoardDto {
    private int bno;
    private String writer;
    private String title;
    private String content;
    private Date cdate;
    private int viewCnt;
}
