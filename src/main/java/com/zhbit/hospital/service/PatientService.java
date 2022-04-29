package com.zhbit.hospital.service;

import com.zhbit.hospital.bean.Patient;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lzy
 * 2022/4/22 21:38
 */
public interface PatientService {
    /**
     * 根据用户名及密码获取患者信息
     * @return
     */
    Patient getPatientByUsernameAndPassword(String P_username,String P_pwd);

    Patient getPatientById(int id);

    boolean updatePatient(Patient patient);

    List<Patient> getAll();

    boolean deletePatientById(int id);

//    boolean registerPatient(String username, String password,
//                            String name, String sex,
//                            int age, String num,
//                            String med, String ill);
    boolean registerPatient(Patient patient);


}
