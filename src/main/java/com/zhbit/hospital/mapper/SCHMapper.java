package com.zhbit.hospital.mapper;

import com.zhbit.hospital.bean.SCH;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SCHMapper {

    List<SCH> getSCHByD_id (@Param("id") int id);

}
