package com.zhbit.hospital.service;

import com.zhbit.hospital.bean.Surgery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SurgeryService {

    List<Surgery> getAll();
    Surgery getSurgeryById(int id);
    boolean updateSurgery(Surgery surgery);

}
