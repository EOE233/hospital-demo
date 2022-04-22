package com.zhbit.hospital.service;

import com.zhbit.hospital.bean.Doctor;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;


public interface DoctorService {
    Collection<Doctor> getAll();

    boolean deleteDoctor(int id);

    Doctor getDoctorById(int id);

    boolean updateDoctor(Doctor doctor);

    Doctor getDoctorByUsernameAndPassword(String username, String password);
}
