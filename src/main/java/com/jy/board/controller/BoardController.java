package com.jy.board.controller;

import com.jy.board.dto.BoardDto;
import com.jy.board.repo.BoardRepo;
import com.jy.board.service.BoardService;
import com.jy.board.vo.PaginationVO;
import com.jy.board.vo.SearchVO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepo boardRepo;
    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    public String main(){
        return "index";
    }

    @GetMapping("/list")
    public String selectList(Model model, @ModelAttribute SearchVO search){


        int totalCnt = boardService.getSearchResultCnt(search);
        model.addAttribute("totalCnt",totalCnt);

        PaginationVO ph = new PaginationVO(totalCnt,search);

        List<BoardDto> list = boardService.searchSelectList(search);
        model.addAttribute("list",list);
        model.addAttribute("ph",ph);

        Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
        model.addAttribute("startOfToday",startOfToday.toEpochMilli());


        return "board/list";
    }

    @GetMapping("/detail")
    public String selectOne(@RequestParam int bno, Model model, HttpServletRequest request){
        BoardDto boardDto = boardRepo.selectOne(bno);
        boardRepo.updateViewCnt(bno);
        String userIp = request.getRemoteAddr();
        String referer = request.getHeader("referer");
        model.addAttribute("userIp",userIp);
       model.addAttribute("boardDto",boardDto);

       return "board/detail";
    }

    @PostMapping("/delete")
    public String deleteById(int bno, Model model){
        BoardDto boardDto = boardRepo.selectOne(bno);
        boardRepo.deleteById(boardDto.getBno());
        model.addAttribute("boardDto",boardDto);
        return "redirect:/board/list";
    }

    @GetMapping("/write")
    public String writeForm(Model model, SearchVO search){
        model.addAttribute("mode","new");
        model.addAttribute("search",search);
        return "/board/writeForm";
    }
    @PostMapping("/write")
    public String writeForm(@ModelAttribute BoardDto boardDto){
        boardRepo.writeBoard(boardDto);
        return "redirect:/board/list";
    }


}
