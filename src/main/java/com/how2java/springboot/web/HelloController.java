package com.how2java.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;

/**
 * @Description: hello
 * @Author: LYS
 * @Date: 2019/1/21 10:57
 */
//@RestController 是spring4里的新注解，是@ResponseBody和@Controller的缩写。 已经注入了
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model m) throws Exception{
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
//        m.addAttribute("apple", "吃了吗");
//        if(true){
//            throw new Exception("some exception");
//        }
        return "hello";
    }
}

