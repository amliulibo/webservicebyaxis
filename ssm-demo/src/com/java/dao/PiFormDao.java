package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.java.entity.PIFormDTO;

public interface PiFormDao
{
	public List<PIFormDTO> selectPiForm(@Param("menuid")String menuid,@Param("formName")String formName);
}
