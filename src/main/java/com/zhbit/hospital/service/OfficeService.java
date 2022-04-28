package com.zhbit.hospital.service;

import com.zhbit.hospital.bean.Doctor;
import com.zhbit.hospital.bean.Office;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OfficeService {

    List<Office> getAll();

    Office getOfficeById(int id);

    boolean updateOffice(Office office);
}
