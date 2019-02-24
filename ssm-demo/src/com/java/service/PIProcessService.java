package com.java.service;

import java.util.List;

import com.java.entity.PIProcessDTO;


public interface PIProcessService
{
	public List<PIProcessDTO> selectProcess(String voucherId,String voucherName);
	
	public int insertProcess(PIProcessDTO dto);
	
	public int updateProcess(PIProcessDTO dto);
	
	public int deleteProcess(PIProcessDTO dto);
}
