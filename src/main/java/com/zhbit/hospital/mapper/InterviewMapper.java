package com.zhbit.hospital.mapper;

import com.zhbit.hospital.bean.Interview;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewMapper {

    List<Interview> getInterviewByP_id (@Param("P_id") int id);

}
