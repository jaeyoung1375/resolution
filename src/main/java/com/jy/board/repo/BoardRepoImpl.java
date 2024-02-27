package com.jy.board.repo;

import com.jy.board.dto.BoardDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public class BoardRepoImpl implements BoardRepo {

    @Autowired
    private SqlSession sqlSession;
    @Override
    public List<BoardDto> selectList() {
        return sqlSession.selectList("board.selectList");
    }

    @Override
    public BoardDto selectOne(int bno) {

        return sqlSession.selectOne("board.selectOne",bno);
    }

    @Override
    public int deleteById(int bno) {
        return sqlSession.delete("board.deleteById",bno);
    }

    @Override
    public void writeBoard(BoardDto boardDto) {
        sqlSession.insert("board.writeBoard",boardDto);
    }
}
