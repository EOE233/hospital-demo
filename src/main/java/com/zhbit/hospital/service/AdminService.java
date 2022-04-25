package com.zhbit.hospital.service;

import com.zhbit.hospital.bean.Administrator;
import com.zhbit.hospital.bean.Doctor;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

public interface AdminService {
    Collection<Administrator> getAll();

    /**
     * 管理员登录
     * @param mId
     * @param mPwd
     * @return
     */
    Administrator getAdministratorByIdAndPassword(String mId, String mPwd);

    /**
     * 管理医生信息
     */
    boolean deleteDoctor(int id);
    Doctor getDoctorById(int id);
    boolean updateDoctor(Doctor doctor);
}
