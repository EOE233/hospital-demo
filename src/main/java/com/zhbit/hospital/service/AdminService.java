package com.zhbit.hospital.service;

import com.zhbit.hospital.bean.Administrator;
import com.zhbit.hospital.bean.Doctor;
import com.zhbit.hospital.bean.Patient;
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

    /**
     * 管理患者信息
     */
    Patient getPatientById(int id);
    boolean updatePatient(String username, String password, String med, String illness, int id);

    /**
     * 修改管理员信息
     */
    boolean updateAdmin(String username, String password);

    /**
     * 通过id获取管理员信息
     */
    Administrator getAdminById(String id);


}
