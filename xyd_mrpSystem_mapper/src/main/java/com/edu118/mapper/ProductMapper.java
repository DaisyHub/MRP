package com.edu118.mapper;

import com.edu118.po.Product;
import com.edu118.po.ProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    long countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Integer productId);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}