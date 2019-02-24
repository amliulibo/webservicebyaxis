package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.java.entity.PIProcessDTO;
import com.java.entity.VMDefineDTO;

public interface PIProcessDao
{
	public List<PIProcessDTO> selectProcess(@Param("processID")String voucherId,@Param("processName")String voucherName);
	
	public int insertProcess(PIProcessDTO dto);
	
	public int updateProcess(PIProcessDTO dto);
	
	public int deleteProcess(PIProcessDTO dto);
}
