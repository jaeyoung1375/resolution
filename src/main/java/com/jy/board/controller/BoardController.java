package com.jy.board.controller;

import com.jy.board.dto.BoardDto;
import com.jy.board.repo.BoardRepo;
import com.jy.board.vo.PaginationVO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String selectList(Model model, @RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer pageSize){
        Map map = new HashMap();
        map.put("page",page);
        map.put("pageSize", pageSize);

        int totalCnt = boardRepo.getTotal();
        PaginationVO vo = new PaginationVO(totalCnt,page,pageSize);
        List<BoardDto> selectList = boardRepo.selectList(map);
        model.addAttribute("selectList",selectList);
        model.addAttribute("vo",vo);


        return "board/list";
    }

    @GetMapping("/detail")
    public String selectOne(@RequestParam int bno, Model model, HttpServletRequest request){
        BoardDto boardDto = boardRepo.selectOne(bno);
        boardRepo.updateViewCnt(bno);
        String userIp = request.getRemoteAddr();
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
    public String writeForm(){
        return "/board/writeForm";
    }
    @PostMapping("/write")
    public String writeForm(@ModelAttribute BoardDto boardDto){
        boardRepo.writeBoard(boardDto);
        return "redirect:/board/list";
    }


}
