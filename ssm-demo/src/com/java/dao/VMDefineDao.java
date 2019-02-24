package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.java.entity.VMDefineDTO;


public interface VMDefineDao
{
	public List<VMDefineDTO> selectVmDefine(@Param("voucherId")String voucherId,@Param("voucherName")String voucherName);
}
