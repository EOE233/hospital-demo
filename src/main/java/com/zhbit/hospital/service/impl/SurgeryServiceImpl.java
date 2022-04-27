package com.zhbit.hospital.service.impl;

import com.zhbit.hospital.bean.Surgery;
import com.zhbit.hospital.mapper.SurgeryMapper;
import com.zhbit.hospital.service.SurgeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgeryServiceImpl implements SurgeryService {

    @Autowired
    SurgeryMapper surgeryMapper;

    @Override
    public List<Surgery> getAll() {
        return surgeryMapper.getAll();
    }
}
