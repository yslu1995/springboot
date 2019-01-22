package com.how2java.springboot.mapper;

import com.how2java.springboot.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description:
 * @Author: LYS
 * @Date: 2019/1/21 15:43
 */
@Mapper
public interface CategoryMapper {

    List<Category> findAll();

    int save(Category category);

    void delete(String id);

    Category get(String id);

    int update(Category category);
}
