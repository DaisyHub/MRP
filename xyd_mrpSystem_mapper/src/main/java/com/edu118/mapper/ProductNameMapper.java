package com.edu118.mapper;

import com.edu118.po.ProductName;
import com.edu118.po.ProductNameExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductNameMapper {
    long countByExample(ProductNameExample example);

    int deleteByExample(ProductNameExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(ProductName record);

    int insertSelective(ProductName record);

    List<ProductName> selectByExample(ProductNameExample example);

    ProductName selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") ProductName record, @Param("example") ProductNameExample example);

    int updateByExample(@Param("record") ProductName record, @Param("example") ProductNameExample example);

    int updateByPrimaryKeySelective(ProductName record);

    int updateByPrimaryKey(ProductName record);
}