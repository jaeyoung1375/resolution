package com.jy.board.repo;


import com.jy.board.dto.BoardDto;
import com.jy.board.vo.Criteria;

import java.util.List;
import java.util.Map;

public interface BoardRepo {

    // 전체 게시물 조회
    public List<BoardDto> selectList(Map map);
    // 게시물 상세 조회
    public BoardDto selectOne(int bno);
    // 게시물 단일 삭제
    public int deleteById(int bno);
    // 게시물 등록
    public void writeBoard(BoardDto boardDto);
    // 조회수 증가
    public void updateViewCnt(int bno);

    // 게시물 총 개수
    public int getTotal();
}
