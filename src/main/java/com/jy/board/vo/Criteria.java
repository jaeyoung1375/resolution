package com.jy.board.vo;

import lombok.Data;

@Data
public class Criteria {
    // 현재 페이지
    private int pageNum;
    // 한 페이지당 보여질 게시물 개수
    private int amount;
    // 검색 키워드
    private String keyword;
    // 검색 타입
    private String type;
    // 검색 타입 배열 변환
    private String[] typeArr;
    // 기본 생성자 -> 기본 세팅
    public Criteria(){
        this(1,10);
    }
    public Criteria(int pageNum, int amount){
        this.pageNum = pageNum;
        this.amount = amount;
    }

    public void setType(){
        this.type = type;
        this.typeArr = type.split("");
    }
}
