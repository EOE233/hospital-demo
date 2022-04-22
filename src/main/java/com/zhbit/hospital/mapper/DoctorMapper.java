package com.zhbit.hospital.mapper;

import com.zhbit.hospital.bean.Doctor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface DoctorMapper {

    Collection<Doctor> getAll();

    boolean deleteDoctor(@Param("id") int id);

    Doctor getDoctorById(@Param("id") int id);

    boolean updateDoctor(@Param("doctor") Doctor doctor);

    Doctor getDoctorByUsernameAndPassword(@Param("username")String username, @Param("password") String password);
}
