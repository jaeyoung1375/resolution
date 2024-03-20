//package com.jy.board.vo;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class PaginationVOTest {
//    @Test
//    public void test(){
//        PaginationVO vo = new PaginationVO(266,26);
//        Assertions.assertThat(vo.getBeginPage()).isEqualTo(21);
//        Assertions.assertThat(vo.getTotalPage()).isEqualTo(27);
//        vo.print();
//    }
//
//    @Test
//    public void test2(){
//        PaginationVO vo = new PaginationVO(266,5);
//        Assertions.assertThat(vo.getBeginPage()).isEqualTo(1);
//
//        vo.print();
//    }
//
//}