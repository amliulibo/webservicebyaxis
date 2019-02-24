package com.java.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.dao.PiFormDao;
import com.java.entity.PIFormDTO;
import com.java.service.PiFormService;

@Service("PiFormService")
public class PiFormServiceImpl implements PiFormService
{
	@Resource
	PiFormDao piFormDao;

	@Override
	public List<PIFormDTO> selectPiForm(String menuid,String formName)
	{
		// TODO Auto-generated method stub
		return piFormDao.selectPiForm(menuid,formName);
	}


}
