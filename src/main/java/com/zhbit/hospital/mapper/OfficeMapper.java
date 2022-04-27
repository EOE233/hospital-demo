package com.zhbit.hospital.mapper;

import com.zhbit.hospital.bean.Office;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficeMapper {

    List<Office> getAll();
    
}