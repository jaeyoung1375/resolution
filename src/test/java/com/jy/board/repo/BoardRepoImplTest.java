package com.jy.board.repo;

import com.jy.board.dto.BoardDto;
import com.jy.board.service.BoardService;
import com.jy.board.vo.SearchVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepoImplTest {
    @Autowired
    private BoardService boardService;

    @Test
    public void searchSelectPageTest() throws Exception{
        SearchVO vo = new SearchVO(1,10,"제목","T");
        List<BoardDto> list = boardService.searchSelectList(vo);
        System.out.println("list = " + list);
    }

    @Test
    public void searchResultCnt() throws Exception{
        SearchVO vo = new SearchVO(1,10,"제목","T");
        int cnt = boardService.getSearchResultCnt(vo);

        System.out.println("cnt = " + cnt);
    }

}