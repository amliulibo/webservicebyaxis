package com.java.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.dao.PIButtonDao;
import com.java.entity.PIButtonDTO;
import com.java.service.PIButtonService;

@Service("PiButtonService")
public class PIButtonServiceImpl implements PIButtonService
{
	@Resource
	PIButtonDao piButtonDao;

	@Override
	public List<PIButtonDTO> selectPiButton(String formID,String buttonName)
	{
		// TODO Auto-generated method stub
		return piButtonDao.selectPiButton(formID, buttonName);
	}


}
