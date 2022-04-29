package com.zhbit.hospital.service.impl;

import com.zhbit.hospital.bean.Interview;
import com.zhbit.hospital.bean.SCH;
import com.zhbit.hospital.mapper.InterviewMapper;
import com.zhbit.hospital.mapper.SCHMapper;
import com.zhbit.hospital.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lzy
 * 2022/4/22 21:39
 */
@Service
public class InterviewServiceImpl implements InterviewService {
    @Autowired
    InterviewMapper interviewMapper;
    @Autowired
    SCHMapper schMapper;
    @Override
    public List<Interview> getInterviewByP_id(int id) {
        return interviewMapper.getInterviewByP_id(id);
    }

    @Override
    public List<Interview> getInterviewByD_id(int id) {
        return interviewMapper.getInterviewByD_id(id);
    }

    @Override
    public List<Interview> getAll() {
        return interviewMapper.getAll();
    }

    @Override
    public Interview getInterviewById(int id) {
        return interviewMapper.getInterviewById(id);
    }

    @Override
    public boolean updateInterview(Interview interview) {
        return interviewMapper.updateInterview(interview);
    }


    @Override
    @Transactional
    public boolean addInterview(int P_id, SCH sch) {
        interviewMapper.addInterview(P_id , sch.getSCH_date() , sch.getSCH_time() , sch.getD_id());
        schMapper.addInterviewWithUpdateSCHBooked(sch.getSCH_id(),sch.getSCH_booked()+1);
        return true;
    }

    @Override
    @Transactional
    public boolean delInterview(int id) {
        //1.根据预约id查询预约信息
        Interview interview = interviewMapper.getInterviewById(id);
        //2.根据预约信息查询对于的医生排班
        SCH sch = schMapper.getSCHByTimeAndD_id(interview.getI_date(), interview.getI_time(), interview.getD_id());
        //3.删除该预约信息
        interviewMapper.delInterview(id);
        //4.医生排班中已预约人数减1
        schMapper.addInterviewWithUpdateSCHBooked(sch.getSCH_id(),sch.getSCH_booked()-1);
        return true;
    }


    @Override
    public List<SCH> getSCHByDateOrTime(String searchDate, String searchTime) {
        return schMapper.getSCHByDateOrTime(searchDate,searchTime);
    }
}
