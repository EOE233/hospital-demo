package com.zhbit.hospital.controller;

import com.zhbit.hospital.bean.*;
import com.zhbit.hospital.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 医生管理模块
     */
    @RequestMapping(value = "/AdminDoctor")
    public String toDoctorInfo(Model model) {
        Collection<Doctor> doctors = doctorService.getAll();
        model.addAttribute("doctors", doctors);
        return "Admin/DoctorInfo";
    }

    //---
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
    //---


    /**
     * 科室管理模块
     */
    @RequestMapping(value = "/AdminOffice")
    public String toOfficeInfo(Model model) {
        List<Office> offices = officeService.getAll();
        model.addAttribute("offices", offices);
        return "Admin/OfficeInfo";
    }

    //增加内容

    /**
     * 前往修改科室页面
     */
    @GetMapping(value = "/AdminUpdateOffice/{id}")
    public String toUpdateOffice(Model model, @PathVariable("id") int id){
        Office office = officeService.getOfficeById(id);
        model.addAttribute("office", office);
        return "Admin/OfficeUpdate";
    }

    /**
     * 修改科室信息
     */
    @PutMapping("/AdminUpdateOffice")
    public String updateOffice(Office office){
        officeService.updateOffice(office);
        return "redirect:/AdminOffice";
    }

    /**
     * 删除科室
     */
    @GetMapping("/AdminDeleteOffice/{id}")
    public String deleteOfficeAdmin(@PathVariable("id") int id){
        adminService.deleteOffice(id);
        return "redirect:/AdminOffice";
    }

    /**
     * 诊室管理模块
     */
    @RequestMapping(value = "/AdminSurgery")
    public String toSurgeryInfo(Model model) {
        List<Surgery> surgeries = surgeryService.getAll();
        model.addAttribute("surgeries", surgeries);
        return "Admin/SurgeryInfo";
    }

    @GetMapping("/AdminUpdateSurgery/{id}")
    public String toUpdateSurgery(Model model, @PathVariable("id") int id){
        Surgery surgery = surgeryService.getSurgeryById(id);
        model.addAttribute("surgery", surgery);
        return "Admin/SurgeryUpdate";
    }
    @PutMapping("AdminUpdateSurgery")
    public String updateSurgery(Surgery surgery){
        surgeryService.updateSurgery(surgery);
        return "redirect:/AdminSurgery";
    }
    @GetMapping("/AdminDeleteSurgery/{id}")
    public String deleteSurgeryAdmin(@PathVariable("id") int id){
        adminService.deleteSurgery(id);
        return "redirect:/AdminSurgery";
    }


    /**
     * 预约管理模块
     */
    @RequestMapping(value = "/AdminInterview")
    public String toInterviewInfo(Model model) {
        List<Interview> interviews = interviewService.getAll();
        model.addAttribute("interviews", interviews);
        return "Admin/InterviewInfo";
    }
    @GetMapping("/AdminUpdateInterview/{id}")
    public String toUpdateInterview(Model model, @PathVariable("id") int id){
        Interview interview = interviewService.getInterviewById(id);
        model.addAttribute("interview", interview);
        return "Admin/InterviewUpdate";
    }
    @PutMapping("AdminUpdateInterview")
    public String updateInterview(Interview interview){
        interviewService.updateInterview(interview);
        return "redirect:/AdminInterview";
    }
    @GetMapping("/AdminDeleteInterview/{id}")
    public String deleteInterviewAdmin(@PathVariable("id") int id){
        Interview interview = interviewService.getInterviewById(id);
        SCH sch = schService.getSCHByTimeAndD_id(interview.getI_date(), interview.getI_time(), interview.getD_id());
        System.out.println(sch);
        int sch_booked = sch.getSCH_booked();
        int sch_size = sch.getSCH_size();
        if (sch_booked > 0) {
            sch_booked--;
            sch.setSCH_booked(sch_booked);
            schService.updateSCH(sch);
        } else {
            return "ERROR";
        }
        adminService.deleteInterview(id);
        return "redirect:/AdminInterview";
    }

    /**
     * 排班管理模块
     */
    @RequestMapping(value = "/AdminSCH")
    public String toSCHInfo(Model model) {
        List<SCH> schs = schService.getAll();
        model.addAttribute("schs", schs);
        return "Admin/SCHInfo";
    }
    @GetMapping("/AdminUpdateSCH/{id}")
    public String toUpdateSCH(Model model, @PathVariable("id") int id){
        SCH sch = schService.getSCHById(id);
        model.addAttribute("sch", sch);
        return "Admin/SCHUpdate";
    }
    @PutMapping("/AdminDeleteSCH")
    public String updateSCH(SCH sch){
        schService.updateSCH(sch);
        return "redirect:/AdminSCH";
    }

    @GetMapping("/AdminDeleteSCH/{id}")
    public String deleteSCHAdmin(@PathVariable("id") int id){
        adminService.deleteSCH(id);
        return "redirect:/AdminSCH";
    }

    /**
     * 患者管理模块
     */
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

    @GetMapping("/AdminDeletePatient/{id}")
    public String deletePatientAdmin(@PathVariable("id") int id){
        adminService.deletePatient(id);
        return "redirect:/AdminPatient";
    }
}
