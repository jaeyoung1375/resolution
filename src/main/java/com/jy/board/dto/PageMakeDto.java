package com.jy.board.dto;

import com.jy.board.vo.Criteria;
import lombok.Data;

@Data
public class PageMakeDto {
    // 시작 페이지
    private int beginPage;
    // 마지막 페이지
    private int endPage;
    // 이전 페이지, 다음 페이지 존재 유무
    private boolean prev,next;
    // 전체 게시물 개수
    private int totalPage;
    // 현재 페이지, 페이지당 게시물 개수 정보
    private Criteria cri;

    public PageMakeDto(Criteria cri, int totalPage){
        this.cri = cri;
        this.totalPage = totalPage;

        // 마지막 페이지
        this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
        // 시작 페이지
        this.beginPage = endPage - 9;

        // 전체 마지막 페이지
        int realEnd =  (int)(Math.ceil(totalPage *1.0) / cri.getAmount());

        // 전체 마지막 페이지가 화면에 보이는 마지막 페이지보다 작은 경우 보이는 페이지를 전체 마지막 페이지로 변경
        if(realEnd <this.endPage){
            this.endPage = realEnd;
        }

        prev = beginPage != 1;
        next = endPage < realEnd;
    }
}
