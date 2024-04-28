package com.jy.board.repo;

import com.jy.board.dto.ProductDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductRepoImpl implements ProductRepo{
    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<ProductDto> productList() {
        return sqlSession.selectList("product.productList");
    }
}
