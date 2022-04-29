package com.zhbit.hospital.service;

import com.zhbit.hospital.bean.Interview;
import com.zhbit.hospital.bean.SCH;
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

    boolean addInterview(int P_id, SCH sch);

    boolean delInterview(int id);

    List<SCH> getSCHByDateOrTime(String searchDate, String searchTime);
}
