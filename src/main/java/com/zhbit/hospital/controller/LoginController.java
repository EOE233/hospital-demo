package com.zhbit.hospital.controller;

import com.zhbit.hospital.bean.*;
import com.zhbit.hospital.mapper.SCHMapper;
import com.zhbit.hospital.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {


    @Autowired
    PatientService patientService;
    @Autowired
    InterviewService interviewService;
    @Autowired
    DoctorService doctorService;
    @Autowired
    SCHMapper schMapper;
    @Autowired
    SCHService schService;
    @Autowired
    AdminService adminService;


    /**
     * 登录验证
     *
     * @param loginType
     * @param username
     * @param password
     * @param model
     * @return
     */
    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public String patientLogin(String loginType, String username, String password, Model model, HttpSession session) {
        //判断登录类型
        if ("patient".equals(loginType)) {
            //患者登录
            //获取当前登录的患者的信息
            Patient patient = patientService.getPatientByUsernameAndPassword(username, password);
            if (patient != null) {
                //获取当前登录患者的所有预约
                List<Interview> interviews = interviewService.getInterviewByP_id(patient.getP_id());
                //将登录的用户共享到session域
                session.setAttribute("Logined_User", patient);
                //将当前登录的患者和所有预约的信息传到Request域
                model.addAttribute("interviews", interviews);
                model.addAttribute("patient", patient);
                //跳转患者主页
                return "Patient/PatientHome";
            } else {
                return "index";
            }
        } else if ("doctor".equals(loginType)) {
            //医生登录
            //获取医生对象和预约该医生的所用预约信息
            Doctor doctor = doctorService.getDoctorByUsernameAndPassword(username, password);
            List<SCH> schs = schService.getSCHByD_id(doctor.getD_id());
            if (doctor != null) {
                //List<SCH> schs = schMapper.getSCHByD_id(doctor.getD_id());
                //将登录的用户共享到session域
                session.setAttribute("Logined_User", doctor);
                //将数据共享到Request域
                model.addAttribute("doctor", doctor);
                model.addAttribute("schs", schs);
                //跳转到医生主页
                return "Doctor/DoctorHome";
            }

        } else {
            Administrator admin = adminService.getAdministratorByIdAndPassword(username, password);
            if (admin != null) {
                //将登录的用户共享到session域
                session.setAttribute("Logined_User", admin);
                model.addAttribute("admin", admin);
                return "Admin/AdminHome";
            }
        }
        return "index";
    }

    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public String returnLogin() {
        return "index";
    }


}
