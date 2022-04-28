package com.zhbit.hospital.mapper;

import com.zhbit.hospital.bean.Doctor;
import com.zhbit.hospital.bean.Office;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficeMapper {

    List<Office> getAll();

    Office getOfficeById(@Param("id") int id);

    boolean updateOffice(@Param("office") Office office);

}