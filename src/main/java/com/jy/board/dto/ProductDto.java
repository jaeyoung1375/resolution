package com.jy.board.dto;

import lombok.Data;

@Data
public class ProductDto {
    private int productNo;
    private String categoryCode;
    private String productName;
    private int productPrice;
    private int productStock;
    private String productColor;
    private String productSize;
    private String productImage;
}
