package com.how2java.springboot.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.springboot.mapper.CategoryMapper;
import com.how2java.springboot.pojo.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @Description:
 * @Author: LYS
 * @Date: 2019/1/21 15:47
 */
@Controller
public class CategoryController {
    @Resource
    CategoryMapper categoryMapper;

    @RequestMapping("/addCategory")
    public String listCategory(Category c) throws Exception {
        c.setId(getUUID());
        categoryMapper.save(c);
        return "redirect:listCategory";
    }

    @RequestMapping("/deleteCategory")
    public String deleteCategory(Category c) throws Exception {
        categoryMapper.delete(c.getId());
        return "redirect:listCategory";
    }

    @RequestMapping("/updateCategory")
    public String updateCategory(Category c) throws Exception {
        categoryMapper.update(c);
        return "redirect:listCategory";
    }

    @RequestMapping("/editCategory")
    public String listCategory(String id, Model m) throws Exception {
        Category c = categoryMapper.get(id);
        m.addAttribute("c", c);
        return "editCategory";
    }

//    @RequestMapping("/listCategory")
//    public String listCategory(Model m) throws Exception {
//        List<Category> cs = categoryMapper.findAll();
//        m.addAttribute("cs", cs);
//        return "listCategory";
//    }

    @RequestMapping("/listCategory")
    public String listCategory(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start, size, "id desc");
        List<Category> cs = categoryMapper.findAll();
        PageInfo<Category> page = new PageInfo<>(cs);
        m.addAttribute("page", page);
        return "listCategory";
    }

    private String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
