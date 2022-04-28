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
     * 医生管理模块
     */
    boolean deleteDoctor(int id);
    Doctor getDoctorById(int id);
    boolean updateDoctor(Doctor doctor);

    /**
     * 患者管理模块
     */
    Patient getPatientById(int id);
    boolean updatePatient(String username, String password, String med, String illness, int id);
    boolean deletePatient(int id);
    /**
     * 科室管理模块
     */
    boolean deleteOffice(int id);

    /**
     * 诊室信息管理模块
     */
    boolean deleteSurgery(int id);

    /**
     * 预约管理模块
     */
    boolean deleteInterview(int id);

    /**
     * 排班管理模块
     */
    boolean deleteSCH(int id);

    /**
     * 修改管理员信息
     */
    boolean updateAdmin(String username, String password);

    /**
     * 通过id获取管理员信息
     */
    Administrator getAdminById(String id);


}
