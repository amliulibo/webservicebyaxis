package com.java.entity;

import java.io.Serializable;

/**
 * 窗体细表（用于配置窗体扩展信息）
 * 
 * @author hew
 *
 */
public class PIFormDetailDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private int formDetailId;
	private String formDetailGuid;
	private int formId;
	private String formConfigTypeCode;
	private String formConfigTypeValue;
	private String admdivCode;
	private String dbYear;	
	private String memo;
	

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getFormDetailId()
	{
		return formDetailId;
	}

	public void setFormDetailId(int formDetailiId)
	{
		this.formDetailId = formDetailiId;
	}

	public String getFormDetailGuid()
	{
		return formDetailGuid;
	}

	public void setFormDetailGuid(String formDetailGuid)
	{
		this.formDetailGuid = formDetailGuid;
	}

	public int getFormId()
	{
		return formId;
	}

	public void setFormId(int formId)
	{
		this.formId = formId;
	}

	public String getFormConfigTypeCode()
	{
		return formConfigTypeCode;
	}

	public void setFormConfigTypeCode(String formConfigTypeCode)
	{
		this.formConfigTypeCode = formConfigTypeCode;
	}

	public String getFormConfigTypeValue()
	{
		return formConfigTypeValue;
	}

	public void setFormConfigTypeValue(String formConfigtypeValue)
	{
		this.formConfigTypeValue = formConfigtypeValue;
	}
	
	public String getAdmdivCode()
	{
		return admdivCode;
	}

	public void setAdmdivCode(String admdivCode)
	{
		this.admdivCode = admdivCode;
	}

	public String getDbYear()
	{
		return dbYear;
	}

	public void setDbYear(String dbYear)
	{
		this.dbYear = dbYear;
	}	

}
