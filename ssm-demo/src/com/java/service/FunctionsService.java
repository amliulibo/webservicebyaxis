package com.java.service;

import java.util.List;
import java.util.Map;

import com.java.entity.CSRecordDTO;
import com.java.entity.Functions;
import com.java.entity.User;

public interface FunctionsService
{
	/**
	* 得到指定应用下的所有功能菜单
	* @param schema 数据库schema
	* @param AppId 应用标识
	* @return  功能对象列表  
	* @throws
	 */
	public List<Functions> selectFunctionsInApp( String AppId,String sName,String sClass,String sParentId);
	
	
	public List<Functions> selectFunctions( String AppId);
	
	public List<Functions> selectFunctionSet( String parentid);
	
	List<CSRecordDTO> selectAdmdiv(String id);
	
}
