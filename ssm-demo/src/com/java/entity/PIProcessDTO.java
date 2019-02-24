package com.java.entity;

import java.io.Serializable;

/**
 * 处理对象表
 * 
 * @author hew
 *
 */
public class PIProcessDTO extends BaseDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private int processId;
	private String processGuid;
	private int type;
	private String code;
	private String name;
	private String assemblyOrPackage;
	private String method;
	private int isNet;
	private String description;
	private String admdivCode;
	private String dbYear;

	public int getProcessId()
	{
		return processId;
	}

	public void setProcessId(int processId)
	{
		this.processId = processId;
	}

	public String getProcessGuid()
	{
		return processGuid;
	}

	public void setProcessGuid(String processGuid)
	{
		this.processGuid = processGuid;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAssemblyOrPackage()
	{
		return assemblyOrPackage;
	}

	public void setAssemblyOrPackage(String assemblyOrPackage)
	{
		this.assemblyOrPackage = assemblyOrPackage;
	}

	public String getMethod()
	{
		return method;
	}

	public void setMethod(String method)
	{
		this.method = method;
	}

	public int getIsNet()
	{
		return isNet;
	}

	public void setIsNet(int isNet)
	{
		this.isNet = isNet;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getAdmdivCode()
	{
		return admdivCode;
	}

	public void setAdmdivCode(String admdivcode)
	{
		this.admdivCode = admdivcode;
	}

	public String getDbYear()
	{
		return dbYear;
	}

	public void setDbYear(String dbyear)
	{
		this.dbYear = dbyear;
	}
}
