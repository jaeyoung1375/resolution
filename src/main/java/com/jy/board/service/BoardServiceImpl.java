package com.jy.board.service;

import com.jy.board.dto.BoardDto;
import com.jy.board.repo.BoardRepo;
import com.jy.board.vo.SearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    BoardRepo boardRepo;

    public List<BoardDto> searchSelectList(SearchVO vo){
        Map map = new HashMap();
        map.put("page",vo.getPage());
        map.put("pageSize", vo.getPageSize());
        return boardRepo.searchSelectList(vo);
    }

    public int getSearchResultCnt(SearchVO vo){
        return boardRepo.SearchResultCnt(vo);
    }
}
