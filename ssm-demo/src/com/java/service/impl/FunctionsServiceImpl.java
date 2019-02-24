package com.java.service.impl;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.entity.CSRecordDTO;
import com.java.entity.Functions;
import com.java.service.FunctionsService;



@Service("FunctionsService")
public class FunctionsServiceImpl implements  FunctionsService
{
	@Resource
	private com.java.dao.FunctionsDao FunctionsDao;

	@Override
	public List<Functions> selectFunctionsInApp(String AppId,String sName,String sClass,String sParentId)
	{
		return FunctionsDao.selectFunctionsInApp( AppId,sName,sClass,sParentId);
	}

	@Override
	public List<Functions> selectFunctions(String id)
	{
		// TODO Auto-generated method stub
		return FunctionsDao.selectFunctions(id);
	}

	@Override
	public List<Functions> selectFunctionSet(String parentid)
	{
		// TODO Auto-generated method stub
		return FunctionsDao.selectFunctionSet( parentid);
	}

	@Override
	public List<CSRecordDTO> selectAdmdiv(String id)
	{
		// TODO Auto-generated method stub
		return FunctionsDao.selectAdmdiv(id);
	}

	


}
