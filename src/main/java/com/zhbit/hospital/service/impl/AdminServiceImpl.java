package com.zhbit.hospital.service.impl;

import com.zhbit.hospital.bean.Administrator;
import com.zhbit.hospital.bean.Doctor;
import com.zhbit.hospital.bean.Patient;
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

    /**
     * 医生模块
     */
    @Override
    public boolean deleteDoctor(int id) {
        return adminMapper.deleteDoctor(id);
    }
    @Override
    public Doctor getDoctorById(int id) {
        return adminMapper.getDoctorById(id);
    }
    @Override
    public boolean updateDoctor(Doctor doctor) {
        return adminMapper.updateDoctor(doctor);
    }

    @Override
    public Patient getPatientById(int id) {
        return adminMapper.getPatientById(id);
    }

    @Override
    public boolean updatePatient(String username, String password, String med, String illness, int id) {
        return adminMapper.updatePatient(username, password, med, illness, id);
    }
}
