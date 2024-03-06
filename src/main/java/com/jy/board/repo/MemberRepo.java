package com.jy.board.repo;

import com.jy.board.dto.MemberDto;



public interface MemberRepo {
    // 회원가입
    void join(MemberDto memberDto);

    // 로그인 시  IP 업데이트
    void updateLastLoginIp(String ip, String id);

    // 로그인 시 로그인 일자 업데이트
    void updateLastLoginDate(String id);

    // 아이디로 회원 조회
    MemberDto findById(String id);

}
