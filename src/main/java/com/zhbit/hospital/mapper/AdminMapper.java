package com.zhbit.hospital.mapper;

import com.zhbit.hospital.bean.Administrator;
import com.zhbit.hospital.bean.Doctor;
import com.zhbit.hospital.bean.Patient;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AdminMapper {
    Collection<Administrator> getAll();

    /**
     * 登录
     * @param mId
     * @param mPwd
     * @return
     */
    Administrator getAdministratorByIdAndPassword(@Param("mId") String mId, @Param("mPwd") String mPwd);

    /**
     * 医生信息管理
     * 包含删除医生、获取医生信息和更新医生信息
     */
    boolean deleteDoctor(@Param("id") int id);
    Doctor getDoctorById(@Param("id") int id);
    boolean updateDoctor(@Param("doctor") Doctor doctor);

    /**
     * 患者信息管理
     * 包含获取患者信息和更新患者信息
     */
    Patient getPatientById(@Param("id") int id);
    boolean updatePatient(@Param("username") String username, @Param("password") String password, @Param("med") String med, @Param("illness") String illness, @Param("id") int id);
    boolean deletePatient(@Param("id") int id);

    /**
     * 科室信息管理
     * 包含删除科室
     */
    boolean deleteOffice(@Param("id") int id);

    /**
     * 诊室信息管理
     * 包含删除诊室
     */
    boolean deleteSurgery(@Param("id") int id);

    /**
     * 预约管理模块
     * 删除预约信息
     */
    boolean deleteInterview(@Param("id") int id);

    /**
     * 排班管理
     */
    boolean deleteSCH(@Param("id") int id);

    /**
     * 修改管理员信息
     */
    boolean updateAdmin(@Param("id") String id, @Param("password") String password);

    /**
     * 通过id获取管理员信息
     */
    Administrator getAdminById(@Param("id") String id);
}
