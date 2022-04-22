package com.zhbit.hospital.service;

import com.zhbit.hospital.bean.Interview;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lzy
 * 2022/4/22 21:38
 */
public interface InterviewService {
    List<Interview> getInterviewByP_id (int id);
}
