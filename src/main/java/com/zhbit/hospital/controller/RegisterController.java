package com.zhbit.hospital.controller;

import com.zhbit.hospital.bean.Patient;
import com.zhbit.hospital.service.PatientService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lzy
 * 2022/4/29 10:43
 */
@Controller
public class RegisterController {
    @Autowired
    PatientService patientService;

    /**
     * 跳转到注册页面
     */
    @RequestMapping("/PatientRegister")
    public String toPatientRegister(){
        return "/Patient/PatientRegister";
    }

    /**
     * 注册患者
//     * @param username 用户名
//     * @param password 密码
//     * @param name 姓名
//     * @param sex 性别
//     * @param age 年龄
//     * @param num 身份证
//     * @param med 过敏药物
//     * @param ill 既往病史
     */
//    @PostMapping("/Register")
//    public String patientRegister(String username, String password,
//                                  String name, String sex,
//                                  @Param("age") String age2, String num,
//                                  String med, String ill){
//        int age = Integer.parseInt(age2);
//        patientService.registerPatient(username, password, name, sex, age, num, med, ill);
//        //返回登录页面
//        return "index";
//    }

    @PostMapping("/Register")
    public String patientRegister(Patient patient){
        patientService.registerPatient(patient);
        //返回登录页面
        return "index";
    }

}
