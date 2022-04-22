package com.zhbit.hospital.controller;

import com.zhbit.hospital.bean.Doctor;
import com.zhbit.hospital.mapper.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.List;

@Controller
public class DoctorController {

    @Autowired
    DoctorMapper mapper;

    /**
     * 获取所有医生信息
     * @param model
     * @return
     */
    @RequestMapping(value = "/Doctor", method = RequestMethod.GET)
    public String getDoctor(Model model) {
        Collection<Doctor> list = mapper.getAll();
        model.addAttribute("doctors", list);
        return "Doctor/DoctorInfo";
    }

    /**
     * 删除医生信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/Doctor/{id}", method = RequestMethod.DELETE)
    public String deleteDoctor(@PathVariable("id") int id) {
        mapper.deleteDoctor(id);
        return "redirect:/Doctor";
    }

    /**
     * 跳转到修改医生信息界面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/Doctor/{id}", method = RequestMethod.GET)
    public String toUpdate (@PathVariable("id") int id, Model model) {
        Doctor doctor = mapper.getDoctorById(id);
        model.addAttribute("doctor", doctor);
        return "Doctor/DoctorUpdate";
    }

    /**
     * 修改医生信息
     * @param doctor
     * @return
     */
    @RequestMapping(value = "/Doctor", method = RequestMethod.PUT)
    public String updateDoctor (Doctor doctor) {
        mapper.updateDoctor(doctor);
        return "redirect:/Doctor";
    }


}
