package com.zhbit.hospital.controller;

import com.zhbit.hospital.bean.Doctor;
import com.zhbit.hospital.bean.Interview;
import com.zhbit.hospital.bean.SCH;
import com.zhbit.hospital.mapper.DoctorMapper;
import com.zhbit.hospital.mapper.InterviewMapper;
import com.zhbit.hospital.mapper.SCHMapper;
import com.zhbit.hospital.service.DoctorService;
import com.zhbit.hospital.service.InterviewService;
import com.zhbit.hospital.service.SCHService;
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
    DoctorMapper doctorMapper;
    @Autowired
    DoctorService doctorService;

    @Autowired
    InterviewMapper interviewMapper;
    @Autowired
    InterviewService  interviewService;

    @Autowired
    SCHMapper schMapper;
    @Autowired
    SCHService schService;

    /**
     * 获取所有医生信息
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/Doctor", method = RequestMethod.GET)
    public String getDoctor(Model model) {
        Collection<Doctor> list = doctorService.getAll();
        model.addAttribute("doctors", list);
        return "Doctor/DoctorHome";
    }

    /**
     * 删除医生信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/Doctor/{id}", method = RequestMethod.DELETE)
    public String deleteDoctor(@PathVariable("id") int id) {
        doctorService.deleteDoctor(id);
        return "redirect:/Doctor";
    }

    /**
     * 跳转到修改医生信息界面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/DoctorUpdate/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") int id, Model model) {
        Doctor doctor = doctorService.getDoctorById(id);
        model.addAttribute("doctor", doctor);
        return "Doctor/DoctorUpdate";
    }

    /**
     * 修改医生信息
     *
     * @param doctor
     * @return
     */
    @RequestMapping(value = "/Doctor", method = RequestMethod.PUT)
    public String updateDoctor(Doctor doctor) {
        doctorService.updateDoctor(doctor);
        int id = doctor.getD_id();
        return "redirect:/Doctor/" + id;
    }

    @RequestMapping(value = "/Doctor")
    public String toDoctorHome(String username, String password, Model model) {
        Doctor doctor = doctorService.getDoctorByUsernameAndPassword(username, password);
        List<Interview> interviews = interviewService.getInterviewByD_id(doctor.getD_id());
        model.addAttribute("interviews", interviews);
        model.addAttribute("doctor", doctor);
        return "Doctor/DoctorHome";
    }

    @RequestMapping(value = "/Doctor/{id}")
    public String updateToDoctorHome(@PathVariable("id") int id, Model model) {
        Doctor doctor = doctorService.getDoctorById(id);
        System.out.println(doctor);
        List<SCH> schs = schService.getSCHByD_id(doctor.getD_id());
        model.addAttribute("doctor", doctor);
        model.addAttribute("schs", schs);
        return "Doctor/DoctorHome";

    }



}
