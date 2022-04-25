package com.zhbit.hospital.controller;

import com.zhbit.hospital.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

}
