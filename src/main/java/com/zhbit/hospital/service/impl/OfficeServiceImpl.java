package com.zhbit.hospital.service.impl;

import com.zhbit.hospital.bean.Office;
import com.zhbit.hospital.mapper.OfficeMapper;
import com.zhbit.hospital.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {

    @Autowired
    OfficeMapper officeMapper;

    @Override
    public List<Office> getAll() {
        return officeMapper.getAll();
    }
}
