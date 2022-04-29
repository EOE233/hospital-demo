package com.zhbit.hospital.service.impl;

import com.zhbit.hospital.bean.SCH;
import com.zhbit.hospital.mapper.SCHMapper;
import com.zhbit.hospital.service.SCHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SCHServiceImpl implements SCHService {
    @Autowired
    SCHMapper schMapper;

    @Override
    public List<SCH> getAll() {
        return schMapper.getAll();
    }

    @Override
    public SCH getSCHById(int id) {
        return schMapper.getSCHById(id);
    }

    @Override
    public boolean updateSCH(SCH sch) {
        return schMapper.updateSCH(sch);
    }

    @Override
    public SCH getSCHByTimeAndD_id(String date, String time, int id) {
        return schMapper.getSCHByTimeAndD_id(date, time, id);
    }

    @Override
    public List<SCH> getSCHByD_id(int id) {
        return schMapper.getSCHByD_id(id);
    }
}
