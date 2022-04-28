package com.zhbit.hospital.mapper;

import com.zhbit.hospital.bean.Patient;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientMapper {

    Patient getPatientByUsernameAndPassword(@Param("username") String P_username, @Param("password") String P_pwd);

    Patient getPatientById(@Param("id") int id);

    boolean updatePatient(@Param("patient") Patient patient);

    List<Patient> getAll();

    boolean deletePatient(@Param("id") int id);
}
