package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.java.entity.PIButtonDTO;


public interface PIButtonDao
{
	public List<PIButtonDTO> selectPiButton(@Param("formID")String formID,@Param("buttonName")String buttonName);
}
