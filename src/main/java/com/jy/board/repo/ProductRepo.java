package com.jy.board.repo;

import com.jy.board.dto.ProductDto;

import java.util.List;

public interface ProductRepo {
    List<ProductDto> productList();
}
