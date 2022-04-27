package com.zhbit.hospital.service.impl;

import com.zhbit.hospital.bean.Interview;
import com.zhbit.hospital.mapper.InterviewMapper;
import com.zhbit.hospital.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzy
 * 2022/4/22 21:39
 */
@Service
public class InterviewServiceImpl implements InterviewService {
    @Autowired
    InterviewMapper interviewMapper;
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
}
