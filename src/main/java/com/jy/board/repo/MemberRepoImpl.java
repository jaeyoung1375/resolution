package com.jy.board.repo;

import com.jy.board.dto.MemberDto;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class MemberRepoImpl implements MemberRepo {
    @Autowired
    private SqlSession sqlSession;
    @Override
    public void join(MemberDto memberDto) {

    }

    @Override
    public void updateLastLoginIp(String ip) {
        sqlSession.update("member.updateLastLoginIp",ip);
    }

    @Override
    public void updateLastLoginDate() {
        sqlSession.update("member.updateLastLoginDate");
    }

    @Override
    public MemberDto findById(String id) {

        return sqlSession.selectOne("member.findById",id);
    }
}
