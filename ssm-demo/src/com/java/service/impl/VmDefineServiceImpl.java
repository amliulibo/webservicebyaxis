package com.java.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.dao.VMDefineDao;
import com.java.entity.VMDefineDTO;
import com.java.service.VmDefineService;

@Service("VmDefineService")
public class VmDefineServiceImpl implements VmDefineService
{
	@Resource
	private VMDefineDao vmDefineDao;
	
	@Override
	public List<VMDefineDTO> selectVmDefine(String voucherId, String voucherName)
	{
		// TODO Auto-generated method stub
		return vmDefineDao.selectVmDefine(voucherId, voucherName);
	}

}
