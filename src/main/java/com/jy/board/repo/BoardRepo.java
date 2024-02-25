package com.jy.board.repo;


import com.jy.board.dto.BoardDto;

import java.util.List;

public interface BoardRepo {

    // 전체 게시물 조회
    public List<BoardDto> selectList();
}
