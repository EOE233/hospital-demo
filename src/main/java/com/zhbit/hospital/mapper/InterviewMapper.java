package com.zhbit.hospital.mapper;

import com.zhbit.hospital.bean.Interview;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 预约信息
 */
@Repository
public interface InterviewMapper {

    List<Interview> getInterviewByP_id (@Param("P_id") int id);

    List<Interview> getInterviewByD_id (@Param("D_id") int id);

    List<Interview> getAll();

    Interview getInterviewById(@Param("id") int id);

    boolean updateInterview(@Param("interview") Interview interview);

//    boolean addInterview(@Param("interview") Interview interview);

    boolean addInterview(@Param("P_id") int logined_user, @Param("I_date") String sch_date, @Param("I_time") String sch_time, @Param("D_id") int d_id);

    boolean delInterview(@Param("I_id") int id);
}
