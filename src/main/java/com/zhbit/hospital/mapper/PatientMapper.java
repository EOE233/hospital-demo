package com.zhbit.hospital.mapper;

import com.zhbit.hospital.bean.Patient;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientMapper {

    Patient getPatientByUsernameAndPassword (@Param("username") String P_username,@Param("password") String P_pwd);

}
