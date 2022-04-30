package com.zhbit.hospital.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 统一异常处理
 */
@ControllerAdvice
@Component
public class ExceptionController {
    /**
     * 处理空指针异常
     * @return 跳转到错误页面
     */
    @ExceptionHandler({NullPointerException.class})
    public ModelAndView handlerException(Exception ex){
        String msg = ex.getMessage();
        ModelAndView modelAndView = new ModelAndView();
        //将异常信息存入域中
        modelAndView.addObject("msg", msg);
        //跳转到错误页面
        modelAndView.setViewName("ERROR");
        return modelAndView;
    }
}
