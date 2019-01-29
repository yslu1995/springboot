package com.how2java.springboot.test;


import cn.hutool.core.date.DateUtil;
import com.how2java.springboot.SpringbootApplication;
import com.how2java.springboot.mapper.CategoryMapper;
import com.how2java.springboot.pojo.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
//引入配置的bean工厂（已经注入过很多bean了）
@SpringBootTest(classes = SpringbootApplication.class)
public class Test {

//    @Resource  资源引入

    //自动装配（从工厂中取出）
    @Autowired
    CategoryMapper categoryMapper;

//    @Before
//    public void begore(){
//        context = new ClassPathXmlApplicationContext("classpath:spring/spring-config.xml");
//        categoryMapper = (CategoryMapper)context.getBean("categoryMapper");
//    }

    @org.junit.Test
    public void test2() {
        List<Category> cs = categoryMapper.findAll();
        for (Category c : cs) {
            System.out.println("c.getName():" + c.getName());
        }
        String dateStr = "2012-12-12 12:12:12";
        Date date = DateUtil.parse(dateStr);
        System.out.println(date);
    }
    
}
