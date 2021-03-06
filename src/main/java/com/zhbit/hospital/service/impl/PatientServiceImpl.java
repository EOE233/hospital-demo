package com.zhbit.hospital.service.impl;

import com.zhbit.hospital.bean.Patient;
import com.zhbit.hospital.mapper.PatientMapper;
import com.zhbit.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzy
 * 2022/4/22 21:39
 */
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientMapper patientMapper;

//    @Override
//    public boolean registerPatient(String username, String password, String name, String sex, int age, String num, String med, String ill) {
//        return patientMapper.registerPatient(username, password, name, sex, age, num, med, ill);
//    }
    /**
     * 注册患者
     */
    @Override
    public boolean registerPatient(Patient patient) {
        return patientMapper.registerPatient(patient);
    }


    @Override
    public Patient getPatientByUsernameAndPassword(String P_username,String P_pwd) {
        return patientMapper.getPatientByUsernameAndPassword(P_username,P_pwd);
    }

    @Override
    public List<Patient> getAll() {
        return patientMapper.getAll();
    }

    @Override
    public boolean deletePatientById(int id) {
        return patientMapper.deletePatient(id);
    }

    @Override
    public Patient getPatientById(int id) {
        return patientMapper.getPatientById(id);
    }

    @Override
    public boolean updatePatient(Patient patient) {
        return patientMapper.updatePatient(patient);
    }

}
