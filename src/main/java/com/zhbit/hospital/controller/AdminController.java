package com.zhbit.hospital.controller;

import com.zhbit.hospital.bean.Administrator;
import com.zhbit.hospital.bean.Doctor;
import com.zhbit.hospital.service.AdminService;
import com.zhbit.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;

    @Autowired
    DoctorService doctorService;

    @RequestMapping(value = "/Admin/{id}")
    public String toAdminHome(@PathVariable("id") String id, Model model) {
        Administrator admin = adminService.getAdminById(id);
        model.addAttribute("admin", admin);
        return "Admin/AdminHome";
    }

    @RequestMapping(value = "/AdminUpdate")
    public String toAdminUpdate(Administrator admin, Model model) {
        model.addAttribute("admin", admin);
        System.out.println(admin);
        return "Admin/AdminUpdate";
    }

    @RequestMapping(value = "/Admin", method = RequestMethod.PUT)
    public String upDateAdmin(Administrator admin) {
        adminService.updateAdmin(admin.getM_id(), admin.getM_pwd());
        return "redirect:/Admin/" + admin.getM_id();
    }

    @RequestMapping(value = "/AdminDoctor/{id}")
    public String toDoctorInfo(@PathVariable("id") String id, Model model) {
        Collection<Doctor> doctors = doctorService.getAll();
        model.addAttribute("doctors", doctors);
        model.addAttribute("id", id);
        return "Admin/DoctorInfo";
    }

}
