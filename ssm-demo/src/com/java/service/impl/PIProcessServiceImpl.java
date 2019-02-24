package com.java.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.dao.PIProcessDao;
import com.java.dao.VMDefineDao;
import com.java.entity.PIProcessDTO;
import com.java.entity.VMDefineDTO;
import com.java.service.PIProcessService;
import com.java.service.VmDefineService;

@Service("PIProcessService")
public class PIProcessServiceImpl implements PIProcessService
{
	@Resource
	private PIProcessDao piProcessDao;
	
	@Override
	public List<PIProcessDTO> selectProcess(String voucherId, String voucherName)
	{
		// TODO Auto-generated method stub
		return piProcessDao.selectProcess(voucherId, voucherName);
	}

	@Override
	public int insertProcess(PIProcessDTO dto)
	{
		// TODO Auto-generated method stub
		 return piProcessDao.insertProcess(dto);
		 
	}

	@Override
	public int updateProcess(PIProcessDTO dto)
	{
		// TODO Auto-generated method stub
		return piProcessDao.updateProcess(dto);
	}

	@Override
	public int deleteProcess(PIProcessDTO dto)
	{
		// TODO Auto-generated method stub
		return piProcessDao.deleteProcess(dto);
	}

}
