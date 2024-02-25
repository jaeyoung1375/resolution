package com.jy.board.repo;

import com.jy.board.dto.BoardDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardRepoImpl implements BoardRepo {

    @Autowired
    private SqlSession sqlSession;
    @Override
    public List<BoardDto> selectList() {
        return sqlSession.selectList("board.selectList");
    }
}
