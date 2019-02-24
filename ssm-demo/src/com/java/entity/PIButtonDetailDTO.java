package com.java.entity;

import java.io.Serializable;

/**
 * 按钮细表
 * 
 * @author hew
 *
 */
public class PIButtonDetailDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private int buttonDetailId;
	private String buttonDetailGuid;
	private int buttonId;
	private String buttonConfigTypeCode;
	private String buttonConfigTypeValue;
	private String admdivCode;
	private String dbYear;
	private String memo;	
	

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getButtonDetailId()
	{
		return buttonDetailId;
	}

	public void setButtonDetailId(int buttonDetailId)
	{
		this.buttonDetailId = buttonDetailId;
	}

	public String getButtonDetailGuid()
	{
		return buttonDetailGuid;
	}

	public void setButtonDetailGuid(String buttonDetailGuid)
	{
		this.buttonDetailGuid = buttonDetailGuid;
	}

	public int getButtonId()
	{
		return buttonId;
	}

	public void setButtonId(int buttonId)
	{
		this.buttonId = buttonId;
	}

	public String getButtonConfigTypeCode()
	{
		return buttonConfigTypeCode;
	}

	public void setButtonConfigTypeCode(String buttonConfigTypeCode)
	{
		this.buttonConfigTypeCode = buttonConfigTypeCode;
	}

	public String getButtonConfigTypeValue()
	{
		return buttonConfigTypeValue;
	}

	public void setButtonConfigTypeValue(String buttonCondigTypeValue)
	{
		this.buttonConfigTypeValue = buttonCondigTypeValue;
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
