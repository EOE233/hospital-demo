package com.zhbit.hospital.controller;

import com.zhbit.hospital.bean.Doctor;
import com.zhbit.hospital.bean.Interview;
import com.zhbit.hospital.bean.Patient;
import com.zhbit.hospital.mapper.DoctorMapper;
import com.zhbit.hospital.mapper.InterviewMapper;
import com.zhbit.hospital.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.List;

@Controller
public class LoginController {

    //定义需要用到的Mapper
    @Autowired
    PatientMapper patientMapperapper;
    @Autowired
    InterviewMapper interviewMapper;
    @Autowired
    DoctorMapper doctorMapper;

    /**
     * 登录验证
     * @param loginType
     * @param username
     * @param password
     * @param model
     * @return
     */
    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public String patientLogin(String loginType, String username, String password, Model model){
        //判断登录类型
        if ("patient".equals(loginType)) {
            //患者登录
            //获取当前登录的患者的信息
            Patient patient = patientMapperapper.getPatientByUsernameAndPassword(username, password);
            if (patient.getP_id() != 0) {
                //获取当前登录患者的所有预约
                List<Interview> interviews = interviewMapper.getInterviewByP_id(patient.getP_id());
                //将当前登录的患者和所有预约的信息传到Request域
                model.addAttribute("interviews", interviews);
                model.addAttribute("patient", patient);
                //跳转患者主页
                return "Patient/PatientHome";
            }else {
                return "ERROR";
            }
        } else if ("doctor".equals(loginType)) {
            //医生登录
            Collection<Doctor> doctors = doctorMapper.getAll();
            model.addAttribute("doctors", doctors);
            return "Doctor/DoctorInfo";
        }
        return "ERROR";
    }

    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public String returnLogin() {
        return "index";
    }
}
