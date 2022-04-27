package com.zhbit.hospital.controller;

import com.zhbit.hospital.bean.*;
import com.zhbit.hospital.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;

    @Autowired
    DoctorService doctorService;

    @Autowired
    PatientService patientService;

    @Autowired
    InterviewService interviewService;

    @Autowired
    SCHService schService;

    @Autowired
    SurgeryService surgeryService;

    @Autowired
    OfficeService officeService;

    @RequestMapping(value = "/Admin/{id}")
    public String toAdminHome(@PathVariable("id") String id, Model model) {
        Administrator admin = adminService.getAdminById(id);
        model.addAttribute("admin", admin);
        return "Admin/AdminHome";
    }

    @RequestMapping(value = "/AdminUpdate")
    public String toAdminUpdate(Administrator admin, Model model) {
        model.addAttribute("admin", admin);
        System.out.println(admin);
        return "Admin/AdminUpdate";
    }

    @RequestMapping(value = "/Admin", method = RequestMethod.PUT)
    public String upDateAdmin(Administrator admin) {
        adminService.updateAdmin(admin.getM_id(), admin.getM_pwd());
        return "redirect:/Admin/" + admin.getM_id();
    }

    @RequestMapping(value = "/AdminDoctor")
    public String toDoctorInfo(Model model) {
        Collection<Doctor> doctors = doctorService.getAll();
        model.addAttribute("doctors", doctors);
        return "Admin/DoctorInfo";
    }

    @RequestMapping(value = "/AdminOffice")
    public String toOfficeInfo(Model model) {
        List<Office> offices = officeService.getAll();
        model.addAttribute("offices", offices);
        return "Admin/OfficeInfo";
    }

    @RequestMapping(value = "/AdminSurgery")
    public String toSurgeryInfo(Model model) {
        List<Surgery> surgeries = surgeryService.getAll();
        model.addAttribute("surgeries", surgeries);
        return "Admin/SurgeryInfo";
    }

    @RequestMapping(value = "/AdminInterview")
    public String toInterviewInfo(Model model) {
        List<Interview> interviews = interviewService.getAll();
        model.addAttribute("interviews", interviews);
        return "Admin/InterviewInfo";
    }

    @RequestMapping(value = "/AdminSCH")
    public String toSCHInfo(Model model) {
        List<SCH> schs = schService.getAll();
        model.addAttribute("schs", schs);
        return "Admin/SCHInfo";
    }

    @RequestMapping(value = "/AdminPatient")
    public String toPatientInfo(Model model) {
        List<Patient> patients = patientService.getAll();
        model.addAttribute("patients", patients);
        return "Admin/PatientInfo";
    }


}
