package com.jy.board.repo;

import com.jy.board.dto.BoardDto;
import com.jy.board.vo.SearchVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Repository
public class BoardRepoImpl implements BoardRepo {

    @Autowired
    private SqlSession sqlSession;
    @Override
    public List<BoardDto> selectList(Map map) {

        return sqlSession.selectList("board.selectList",map);
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

    @Override
    public void updateViewCnt(int bno) {
         sqlSession.update("board.updateViewCnt",bno);
    }

    @Override
    public int getTotal() {
        return sqlSession.selectOne("board.getTotal");
    }



    public List<BoardDto> searchSelectList(SearchVO vo) {

        return sqlSession.selectList("board.searchSelectList",vo);
    }

    @Override
    public int SearchResultCnt(SearchVO vo) {
        return sqlSession.selectOne("board.searchResultCnt",vo);
    }
}
