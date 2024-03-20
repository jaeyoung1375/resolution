package com.jy.board.vo;
import lombok.Data;
import org.springframework.web.util.UriComponentsBuilder;

//VO(Value Object)
//- 필요에 의해 특정 값들을 묶어서 사용하고 싶을 때 만드는 클래스
//- DTO는 테이블과 같은 모양이어야 하지만 VO는 제약이 없다
//- 등록하지 않고 일회용으로 사용한다
@Data
public class PaginationVO {
//    private int page; // 현재 페이지
//    private int pageSize; // 한 페이지의 크기
//    private String type;
//    private String keyword;

    private SearchVO search;

    private int totalCnt; // 총 게시물 개수
    private int naviSize = 10; // 페이지 내비게이션의 크기
    private int totalPage; // 전체 페이지의 개수
    private int beginPage; // 내비게이션의 첫번째 페이지
    private int endPage; // 내비게이션의 마지막 페이지
    boolean showPrev; // 이전 페이지로 이동하는 링크를 보여줄 것인지의 여부
    boolean showNext; // 다음 페이지로 이동하는 링크를 보여줄 것인지의 여부





    public PaginationVO(int totalCnt, SearchVO search){
        this.totalCnt = totalCnt;
        this.search = search;

        doPaging(totalCnt,search);
    }

    public void doPaging(int totalCnt, SearchVO vo){
        this.totalCnt = totalCnt;


        totalPage = (int)Math.ceil(totalCnt / (double)vo.getPageSize());
        beginPage =  (vo.getPage() -1)/ naviSize * naviSize + 1;
        endPage = Math.min(beginPage + naviSize -1,totalPage);
        showPrev = beginPage != 1;
        showNext = endPage != totalPage;
    }



    void print(){
        System.out.println("page = " + search.getPage());
        System.out.print(showPrev ? "[PREV] " : " ");
        for(int i = beginPage; i<=endPage; i++){
            System.out.print(i+ " ");
        }
        System.out.print(showNext ? " [NEXT] : " :"");
    }
}