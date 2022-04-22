package com.zhbit.hospital.service.impl;

import com.zhbit.hospital.bean.Doctor;
import com.zhbit.hospital.mapper.DoctorMapper;
import com.zhbit.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author lzy
 * 2022/4/22 21:39
 */
@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorMapper doctorMapper;
    @Override
    public Collection<Doctor> getAll() {
        return doctorMapper.getAll();
    }

    @Override
    public boolean deleteDoctor(int id) {
        return doctorMapper.deleteDoctor(id);
    }

    @Override
    public Doctor getDoctorById(int id) {
        return doctorMapper.getDoctorById(id);
    }

    @Override
    public boolean updateDoctor(Doctor doctor) {
        return doctorMapper.updateDoctor(doctor);
    }

    @Override
    public Doctor getDoctorByUsernameAndPassword(String username, String password) {
        return doctorMapper.getDoctorByUsernameAndPassword(username, password);
    }
}
