package com.zhbit.hospital.service;

import com.zhbit.hospital.bean.SCH;

import java.util.List;


public interface SCHService {
    List<SCH> getSCHByD_id(int id);

    List<SCH> getAll();

    SCH getSCHById(int id);

    boolean updateSCH(SCH sch);

    SCH getSCHByTimeAndD_id(String date, String time, int id);
}
