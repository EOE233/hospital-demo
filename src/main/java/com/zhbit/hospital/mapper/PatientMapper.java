package com.zhbit.hospital.mapper;

import com.zhbit.hospital.bean.Patient;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientMapper {

    Patient getPatientByUsernameAndPassword(@Param("username") String P_username, @Param("password") String P_pwd);

    Patient getPatientById(@Param("id") int id);

    boolean updatePatient(@Param("username") String username, @Param("password") String password, @Param("med") String med, @Param("illness") String illness, @Param("id") int id);

}
