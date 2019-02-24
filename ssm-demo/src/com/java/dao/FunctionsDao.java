package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.java.entity.CSRecordDTO;
import com.java.entity.Functions;


public interface FunctionsDao
{
	/**
	* 得到指定应用下的所有功能菜单
	* @param schema 数据库schema
	* @param AppId 应用标识
	* @return  功能对象列表  
	* @throws
	 */
	public List<Functions> selectFunctionsInApp(@Param("AppId")String AppId,@Param("sName")String sName,@Param("sClass")String sClass,@Param("sParentId")String sParentId);
	
	public List<Functions> selectFunctions(@Param("id")String id);
	
	public List<Functions> selectFunctionSet(@Param("id")String id);
	
	List<CSRecordDTO> selectAdmdiv(@Param("id") String id);

}
