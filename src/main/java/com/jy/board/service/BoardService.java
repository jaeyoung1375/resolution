package com.jy.board.service;

import com.jy.board.dto.BoardDto;
import com.jy.board.vo.SearchVO;

import java.util.List;

public interface BoardService {
    public List<BoardDto> searchSelectList(SearchVO vo);
    public int getSearchResultCnt(SearchVO vo);
}
