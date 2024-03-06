package com.jy.board.controller;

import com.jy.board.dto.MemberDto;
import com.jy.board.repo.MemberRepo;
import com.jy.board.service.PasswordUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@RequestMapping("/member")
@Controller
public class MemberController {

    @Autowired
    private MemberRepo memberRepo;
    @Autowired
    private PasswordUtils passwordUtils;

    @GetMapping("/join")
    public String join(){
        return "member/join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute MemberDto memberDto){

        // 비밀번호 암호화
        String EncryptPassword = passwordUtils.SHA256Encrypt(memberDto.getPassword());
        memberDto.setPassword(EncryptPassword);

        memberRepo.join(memberDto);

        return "redirect:/board/list";
    }

    @GetMapping("/login")
    public String login(){

        return "member/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDto memberDto, HttpServletRequest request, HttpSession session) {

        MemberDto originalMember = memberRepo.findById(memberDto.getId());
        log.info("실제 사용자 : " + originalMember);


        String ip = request.getRemoteAddr();
        memberDto.setLastLoginIp(ip);

        // 로그인 아이피 업데이트
        memberRepo.updateLastLoginIp(memberDto.getLastLoginIp(),memberDto.getId());
        // 로그인 일자 업데이트
        memberRepo.updateLastLoginDate(memberDto.getId());

        log.info("로그인한 사용자 : " + memberDto);
        // 비밀번호 유효성 검증
        String encryptPassword = passwordUtils.SHA256Encrypt(memberDto.getPassword());
        if(originalMember.getPassword().equals(encryptPassword) && originalMember.getId().equals(memberDto.getId())){
            
            // 로그인 성공
            session.setAttribute("memberDto",memberDto);
        }
            log.info("로그인 세션 정보 : "+session.getAttribute("memberDto"));

        return "redirect:/board/list";
    }


}
