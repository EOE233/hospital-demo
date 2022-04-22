package com.zhbit.hospital.service;

import com.zhbit.hospital.bean.Doctor;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

/**
 * @author lzy
 * 2022/4/22 21:38
 */
public interface DoctorService {
    Collection<Doctor> getAll();

    boolean deleteDoctor(int id);

    Doctor getDoctorById(int id);

    boolean updateDoctor(Doctor doctor);

    Doctor getDoctorByUsernameAndPassword(String username, String password);
}
