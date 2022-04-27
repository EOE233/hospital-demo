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

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
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

    @RequestMapping(value = "/PatientUpdate", method = RequestMethod.GET)
    public String toUpdate() {
        return "Patient/PatientUpdate";
    }

    @RequestMapping(value = "/PatientHome", method = RequestMethod.GET)
    public String toPatientHome(HttpSession session, Model model) {
        //从session域中获取patient对象
        Patient patient = (Patient) session.getAttribute("Logined_User");
        //获取患者的预约信息
        List<Interview> interviews = interviewService.getInterviewByP_id(patient.getP_id());
        //共享到request域中
        model.addAttribute("interviews", interviews);
        return "Patient/PatientHome";
    }

    @RequestMapping(value = "/Patient", method = RequestMethod.PUT)
    public String updatePatient(Patient patient, HttpSession session, Model model) {
        //更新患者信息
        patientService.updatePatient(patient);
        //将新的患者信息共享到session域中
        session.setAttribute("Logined_User", patient);
        //获取患者的预约信息
        List<Interview> interviews = interviewService.getInterviewByP_id(patient.getP_id());
        //将预约信息共享到request域
        model.addAttribute("interviews", interviews);
        return "Patient/PatientHome";
    }
}
