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

    List<Interview> getInterviewByD_id (@Param("D_id") int id);

    List<Interview> getAll();

    Interview getInterviewById(int id);

    boolean updateInterview(Interview interview);

}
