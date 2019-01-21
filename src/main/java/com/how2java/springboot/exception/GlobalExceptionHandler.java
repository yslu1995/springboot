package com.how2java.springboot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 异常处理类
 * @Author: LYS
 * @Date: 2019/1/21 14:27
 *
 *  新增加一个类GlobalExceptionHandler，用于捕捉Exception异常以及其子类。
 *  捕捉到之后，把异常信息，发出异常的地址放进ModelAndView里，然后跳转到 errorPage.jsp
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("errorPage");
        return mav;
    }
}
