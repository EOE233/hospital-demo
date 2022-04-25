package com.zhbit.hospital.controller;

import com.zhbit.hospital.bean.Interview;
import com.zhbit.hospital.bean.Patient;
import com.zhbit.hospital.mapper.InterviewMapper;
import com.zhbit.hospital.mapper.PatientMapper;
import com.zhbit.hospital.service.InterviewService;
import com.zhbit.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PatientController {

    @Autowired
    PatientMapper patientMapper;
    @Autowired
    PatientService patientService;

    @Autowired
    InterviewMapper interviewMapper;
    @Autowired
    InterviewService interviewService;

    @RequestMapping(value = "/PatientUpdate/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") int id, Model model) {
        Patient patient = patientService.getPatientById(id);
        model.addAttribute("patient", patient);
        System.out.println(patient);
        return "Patient/PatientUpdate";
    }

    @RequestMapping(value = "/PatientHome/{id}", method = RequestMethod.GET)
    public String toPatientHome(@PathVariable("id") int id, Model model) {
        Patient patient = patientService.getPatientById(id);
        List<Interview> interviews = interviewService.getInterviewByP_id(id);
        model.addAttribute("interviews", interviews);
        model.addAttribute("patient", patient);
        return "Patient/PatientHome";
    }

    @RequestMapping(value = ("/Patient"), method = RequestMethod.PUT)
    public String updatePatient(int id, String username, String password, String med, String illness) {
        boolean flag = patientService.updatePatient(username, password, med, illness, id);
        if (flag) {
            return "redirect:/PatientHome/" + id;
        } else {
            return "ERROR";
        }
    }



}
