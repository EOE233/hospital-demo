package com.zhbit.hospital.mapper;

import com.zhbit.hospital.bean.Doctor;
import com.zhbit.hospital.bean.SCH;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SCHMapper {

    List<SCH> getSCHByD_id (@Param("id") int id);

    List<SCH> getAll();

    SCH getSCHById(@Param("id") int id);

    boolean updateSCH(@Param("sch") SCH sch);

    SCH getSCHByTimeAndD_id(@Param("date") String date, @Param("time") String time, @Param("id") int id);

}
