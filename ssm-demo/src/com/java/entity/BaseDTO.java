package com.java.entity;

import java.io.Serializable;

/**
 * 处理对象表
 * 
 * @author hew
 *
 */
public class BaseDTO implements Serializable
{
	private String editFlag;

	public String getEditFlag()
	{
		return editFlag;
	}

	public void setEditFlag(String editFlag)
	{
		this.editFlag = editFlag;
	}
	
}
