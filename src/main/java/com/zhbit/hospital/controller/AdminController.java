package com.zhbit.hospital.controller;

import com.zhbit.hospital.bean.*;
import com.zhbit.hospital.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.print.Doc;
import javax.servlet.http.HttpSession;
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

    @RequestMapping(value = "/Admin")
    public String toAdminHome() {
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

    @RequestMapping(value = "/AdminUpdateDoctor/{id}", method = RequestMethod.GET)
    public String toUpdateDoctor(Model model, @PathVariable("id") int id) {
        Doctor doctor = doctorService.getDoctorById(id);
        model.addAttribute("doctor", doctor);
        return "Admin/DoctorUpdate";
    }

    @RequestMapping(value = "/AdminUpdateDoctor", method = RequestMethod.PUT)
    public String updateDoctor(Doctor doctor) {
        doctorService.updateDoctor(doctor);
        return "redirect:/AdminDoctor";
    }

    @RequestMapping(value = "/AdminDeleteDocotr/{id}", method = RequestMethod.GET)
    public String deleteDoctorAdmin(@PathVariable("id") int id) {
        adminService.deleteDoctor(id);
        return "redirect:/AdminDoctor";
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

    @RequestMapping(value = "/AdminUpdatePatient/{id}", method = RequestMethod.GET)
    public String toUpdatePatient(@PathVariable("id") int id, Model model) {
        Patient patient = patientService.getPatientById(id);
        model.addAttribute("patient", patient);
        return "Admin/PatientUpdate";
    }

    @RequestMapping(value = "/AdminUpdatePatient", method = RequestMethod.PUT)
    public String updatePatient(Patient patient) {
        patientService.updatePatient(patient);
        return "redirect:/AdminPatient";
    }

    @RequestMapping(value = "/AdminDeletePatient/(id}", method = RequestMethod.GET)
    public String deletePatient(@PathVariable("id") int id) {
        patientService.deletePatientById(id);
        return "redirect:/AdminPatient";
    }


}
