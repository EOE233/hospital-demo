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
    public List<SCH> getSCHByD_id(int id) {
        return schMapper.getSCHByD_id(id);
    }
}
