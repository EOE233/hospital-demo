package com.zhbit.hospital.mapper;

import com.zhbit.hospital.bean.Administrator;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AdminMapper {
    Collection<Administrator> getAll();

    /**
     * 登录
     * @param mId
     * @param mPwd
     * @return
     */
    Administrator getAdministratorByIdAndPassword(@Param("mId") String mId, @Param("mPwd") String mPwd);
}
