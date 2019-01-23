package com.how2java.springboot.service;

import com.how2java.springboot.pojo.Category;

/**
 * @Description:
 * @Author: LYS
 * @Date: 2019/1/23 13:58
 */
public interface CategoryService {
//    Page4Navigator<Category> list(Pageable pageable);

    void save(Category category);

    void delete(String id);

    Category get(String id);
}
