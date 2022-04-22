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

    @Autowired
    PatientMapper patientMapperapper;
    @Autowired
    InterviewMapper interviewMapper;
    @Autowired
    DoctorMapper doctorMapper;

    @RequestMapping(value = "/Login")
    public String patientLogin(String loginType, String username, String password, Model model){
        if ("patient".equals(loginType)) {
            Patient patient = patientMapperapper.getPatientByUsernameAndPassword(username, password);
            if (patient.getP_id() != 0) {
                model.addAttribute("patient", patient);
                System.out.println(patient);

                return "Patient/PatientHome";
            }else {
                return "ERROR";
            }
        } else if ("doctor".equals(loginType)) {
            Collection<Doctor> doctors = doctorMapper.getAll();
            model.addAttribute("doctors", doctors);
            return "Doctor/DoctorInfo";
        }
        return "ERROR";
    }
}
