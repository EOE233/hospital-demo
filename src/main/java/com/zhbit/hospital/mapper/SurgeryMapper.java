package com.zhbit.hospital.mapper;

import com.zhbit.hospital.bean.Doctor;
import com.zhbit.hospital.bean.Surgery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurgeryMapper {

    List<Surgery> getAll();
    Surgery getSurgeryById(@Param("id") int id);
    boolean updateSurgery(@Param("surgery") Surgery surgery);

}
