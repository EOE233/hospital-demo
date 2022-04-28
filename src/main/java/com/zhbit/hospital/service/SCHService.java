package com.zhbit.hospital.service;

import com.zhbit.hospital.bean.SCH;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface SCHService {
    List<SCH> getSCHByD_id (int id);

    List<SCH> getAll();

    SCH getSCHById(int id);

    boolean updateSCH(SCH sch);
}
