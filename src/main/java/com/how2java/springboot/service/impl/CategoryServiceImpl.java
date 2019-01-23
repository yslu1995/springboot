package com.how2java.springboot.service.impl;

import com.github.pagehelper.Page;
import com.how2java.springboot.mapper.CategoryMapper;
import com.how2java.springboot.pojo.Category;
import com.how2java.springboot.service.CategoryService;
import com.how2java.springboot.util.Page4Navigator;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
//表示 分类数据在 redis 中都放在 category 这个分组里。
@CacheConfig(cacheNames = "category")
public class CategoryServiceImpl implements CategoryService {

    @Resource
    CategoryMapper categoryMapper;

//    @Override
//    @Cacheable(key="'category '+#p0.offset + '-' + #p0.pageSize ")
//    public Page4Navigator<Category> list(Pageable pageable) {
////        Page<Category> pageFromJPA=  categoryMapper.findAll(pageable);
////        Page4Navigator<Category> page = new Page4Navigator<>(pageFromJPA,5);
////        return page;
//    }

    @Override
    @Cacheable(key = "'category '+ #p0")
    public Category get(String id) {
        Category c = categoryMapper.get(id);
        return c;
    }

    @Override
    @CacheEvict(allEntries = true)
//  @CachePut(key="'category '+ #p0")
    public void save(Category category) {
        // TODO Auto-generated method stub
        categoryMapper.save(category);
    }

    @Override
    @CacheEvict(allEntries = true)
//  @CacheEvict(key="'category '+ #p0")
    public void delete(String id) {
        // TODO Auto-generated method stub
        categoryMapper.delete(id);
    }

}