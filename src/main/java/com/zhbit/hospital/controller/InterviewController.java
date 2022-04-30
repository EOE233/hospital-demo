package com.zhbit.hospital.controller;

import com.zhbit.hospital.bean.Patient;
import com.zhbit.hospital.bean.SCH;
import com.zhbit.hospital.service.InterviewService;
import com.zhbit.hospital.service.SCHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class InterviewController {
    @Autowired
    InterviewService interviewService;
    @Autowired
    SCHService schService;

    @RequestMapping(value = "/InterviewAdd" , method = RequestMethod.GET)
    public String toAddInterview(Model model) {
        List<SCH> schs = schService.getAll();
        model.addAttribute("schs",schs);
        return "Patient/InterviewAdd";
    }

    //添加预约信息
    @RequestMapping(value = "/Interview" , method = RequestMethod.POST)
    public String addInterview(SCH sch , HttpSession session){
        interviewService.addInterview(((Patient)session.getAttribute("Logined_User")).getP_id(),sch);
        return "redirect:/PatientHome";
    }

    //根据日期或者时间查询医生排班
    @RequestMapping(value = "/SCH" , method = RequestMethod.POST)
    public String getSCHbyDateOrTime(@RequestParam (value = "searchDate") String  searchDate , @RequestParam(value = "searchTime") String searchTime , Model model){
        List<SCH> schs = interviewService.getSCHByDateOrTime(searchDate, searchTime);
        model.addAttribute("schs",schs);
        return "Patient/InterviewAdd";
    }

    //删除预约信息
    @RequestMapping(value = "/DelInterview/{id}")
    public String delInterview(@PathVariable("id") int id){
        interviewService.delInterview(id);
        return "redirect:/PatientHome";
    }
}
