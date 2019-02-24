package com.java.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.dao.CommonDao;
import com.java.service.CommonService;

@Service("PIProcessService")
public class CommonServiceImpl implements CommonService
{
	@Resource
	private CommonDao CommonDao;

	@Override
	public List<Map<String, Object>> selectXZQHCode()
	{
		// TODO Auto-generated method stub
		return CommonDao.selectXZQHCode();
	}
	



}
