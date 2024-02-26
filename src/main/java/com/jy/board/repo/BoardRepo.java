package com.jy.board.repo;


import com.jy.board.dto.BoardDto;

import java.util.List;

public interface BoardRepo {

    // 전체 게시물 조회
    public List<BoardDto> selectList();
    // 게시물 상세 조회
    public BoardDto selectOne(int bno);
    // 게시물 단일 삭제
    public int deleteById(int bno);
}
