package com.zhbit.hospital.mapper;

import com.zhbit.hospital.bean.Administrator;
import com.zhbit.hospital.bean.Doctor;
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

}
