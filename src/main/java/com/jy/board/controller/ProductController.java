package com.jy.board.controller;

import com.jy.board.dto.ProductDto;
import com.jy.board.repo.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/list")
    public List<ProductDto> productList(){
        List<ProductDto> productList = productRepo.productList();
        log.info("list : "+productList);
        return productList;
    }
}
