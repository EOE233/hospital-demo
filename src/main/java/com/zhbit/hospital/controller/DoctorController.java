package com.zhbit.hospital.controller;

import com.zhbit.hospital.bean.Doctor;
import com.zhbit.hospital.bean.SCH;
import com.zhbit.hospital.service.DoctorService;
import com.zhbit.hospital.service.SCHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DoctorController {

    @Autowired
    DoctorService doctorService;
    @Autowired
    SCHService schService;

    /**
     * 跳转到更改医生信息页面
     */
    @RequestMapping(value = "/DoctorUpdate", method = RequestMethod.GET)
    public String toUpdate() {
        return "Doctor/DoctorUpdate";
    }

    /**
     * 更新医生信息后跳回医生主页
     */
    @RequestMapping(value = "/Doctor", method = RequestMethod.PUT)
    public String updateDoctor(Doctor doctor, HttpSession session, Model model) {
        //更新医生信息
        doctorService.updateDoctor(doctor);
        //重新获取排班信息
        List<SCH> schs = schService.getSCHByD_id(doctor.getD_id());
        //将新的排班信息和医生信息共享
        model.addAttribute("schs", schs);
        session.setAttribute("Logined_User", doctor);
        //返回医生主页
        return "Doctor/DoctorHome";
    }

    @RequestMapping(value = "/DoctorHome", method = RequestMethod.GET)
    public String toDoctorHome(HttpSession session, Model model) {
        //从session域中获取登录的医生对象
        Doctor doctor = (Doctor) session.getAttribute("Logined_User");
        //获取医生的排班信息
        List<SCH> schs = schService.getSCHByD_id(doctor.getD_id());
        //共享到request域中
        model.addAttribute("schs", schs);
        //返回医生主页
        return "Doctor/DoctorHome";
    }

}
