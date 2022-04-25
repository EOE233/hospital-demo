package com.zhbit.hospital.service;

import com.zhbit.hospital.bean.Administrator;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

public interface AdminService {
    Collection<Administrator> getAll();
    Administrator getAdministratorByIdAndPassword(String mId, String mPwd);
}
