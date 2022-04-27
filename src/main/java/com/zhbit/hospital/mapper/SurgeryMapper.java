package com.zhbit.hospital.mapper;

import com.zhbit.hospital.bean.Surgery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurgeryMapper {

    List<Surgery> getAll();

}
