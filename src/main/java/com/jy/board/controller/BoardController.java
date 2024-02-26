package com.jy.board.controller;

import com.jy.board.dto.BoardDto;
import com.jy.board.repo.BoardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepo boardRepo;

    @GetMapping("/")
    public String main(){
        return "index";
    }

    @GetMapping("/list")
    public String selectList(Model model){
        List<BoardDto> selectList  = boardRepo.selectList();
        model.addAttribute("selectList",selectList);

        return "board/list";
    }

    @GetMapping("/detail")
    public String selectOne(@RequestParam int bno, Model model){
        BoardDto boardDto = boardRepo.selectOne(bno);
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

}
