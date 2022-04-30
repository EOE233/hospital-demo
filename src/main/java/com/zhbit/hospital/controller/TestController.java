package com.zhbit.hospital.controller;

import com.zhbit.hospital.bean.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author lzy
 * 2022/4/30 16:39
 */
@Controller
public class TestController {
    @RequestMapping("/test")
    public String test(HttpSession session){
        String str = null;
        str.toString();
        return "index";
    }
}
