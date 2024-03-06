package com.jy.board.repo;

import com.jy.board.dto.MemberDto;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository
public class MemberRepoImpl implements MemberRepo {
    @Autowired
    private SqlSession sqlSession;
    @Override
    public void join(MemberDto memberDto) {
        sqlSession.insert("member.join",memberDto);
    }

    @Override
    public void updateLastLoginIp(String lastLoginIp, String id) {
        Map<String,String> param = new HashMap<>();
        param.put("lastLoginIp",lastLoginIp);
        param.put("id",id);
        sqlSession.update("member.updateLoginIp",param);
    }

    @Override
    public void updateLastLoginDate(String id) {
        sqlSession.update("member.updateLoginDate",id);
    }

    @Override
    public MemberDto findById(String id) {

        return sqlSession.selectOne("member.findById",id);
    }
}
