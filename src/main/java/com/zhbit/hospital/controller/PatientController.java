package com.zhbit.hospital.controller;

import com.zhbit.hospital.bean.Patient;
import com.zhbit.hospital.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PatientController {

    @Autowired
    PatientMapper patientMapper;

    @RequestMapping(value = "/PatientUpdate", method = RequestMethod.GET)
    public String toUpdate(String username, String password, Model model) {
        Patient patient = patientMapper.getPatientByUsernameAndPassword(username, password);
        model.addAttribute("patient", patient);
        return "Patient/PatientUpdate";
    }

}
