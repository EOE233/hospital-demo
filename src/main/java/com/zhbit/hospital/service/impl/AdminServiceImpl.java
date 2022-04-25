package com.zhbit.hospital.service.impl;

import com.zhbit.hospital.bean.Administrator;
import com.zhbit.hospital.mapper.AdminMapper;
import com.zhbit.hospital.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public Collection<Administrator> getAll() {
        return adminMapper.getAll();
    }

    @Override
    public Administrator getAdministratorByIdAndPassword(String mId, String mPwd) {
        return adminMapper.getAdministratorByIdAndPassword(mId, mPwd);
    }
}
