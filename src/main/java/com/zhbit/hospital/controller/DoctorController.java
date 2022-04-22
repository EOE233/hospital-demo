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

    @RequestMapping(value = "/Doctor", method = RequestMethod.GET)
    public String getDoctor(Model model) {
        Collection<Doctor> list = mapper.getAll();
        model.addAttribute("doctors", list);
        return "Doctor/DoctorInfo";
    }

    @RequestMapping(value = "/Doctor/{id}", method = RequestMethod.DELETE)
    public String deleteDoctor(@PathVariable("id") int id) {
        mapper.deleteDoctor(id);
        return "redirect:/Doctor";
    }

    @RequestMapping(value = "/Doctor/{id}", method = RequestMethod.GET)
    public String toUpdate (@PathVariable("id") int id, Model model) {
        Doctor doctor = mapper.getDoctorById(id);
        model.addAttribute("doctor", doctor);
        return "Doctor/DoctorUpdate";
    }

    @RequestMapping(value = "/Doctor", method = RequestMethod.PUT)
    public String updateDoctor (Doctor doctor) {
        mapper.updateDoctor(doctor);
        return "redirect:/Doctor";
    }


}
