package com.jy.board.vo;

import lombok.Data;
import org.springframework.web.util.UriComponentsBuilder;

@Data
public class SearchVO {
    private Integer pageSize = 10;
    private Integer page = 1;
    private String type = "";
    private String keyword = "";

    public String getQueryString(Integer page){
        return  UriComponentsBuilder.newInstance()
                .queryParam("page",page)
                .queryParam("pageSize",getPageSize())
                .queryParam("type",getType())
                .queryParam("keyword",getKeyword())
                .build().toString();
    }
    public String getQueryString(){
        // ?page=1&pageSize=10&type=T&keyword=title
        return getQueryString(page);
    }

    public SearchVO(){}
    public SearchVO(Integer page, Integer pageSize, String keyword, String type){
        this.page = page;
        this.pageSize = pageSize;
        this.keyword = keyword;
        this.type = type;

    }
}
