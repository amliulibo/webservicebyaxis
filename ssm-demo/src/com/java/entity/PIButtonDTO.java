package com.java.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 按钮主表（配置按钮主要信息）
 * 
 * @author hew
 *
 */
public class PIButtonDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private int buttonId;
	private String buttonGuid;
	private int formId;
	private String name;
	private String hint;
	private String icon;
	private String helpno;
	private int processId;
	private int actionDescId;
	private int buttonOrder;
	private String admdivCode;
	private String dbYear;
	private int buttonType;
	private String mergename;
	private String mergeicon;
	

	//private List<PIButtonDetailDTO> piButtonDetailDtos;

	public int getButtonId()
	{
		return buttonId;
	}

	public void setButtonId(int buttonId)
	{
		this.buttonId = buttonId;
	}

	public String getButtonGuid()
	{
		return buttonGuid;
	}

	public void setButtonGuid(String buttonGuid)
	{
		this.buttonGuid = buttonGuid;
	}

	public int getFormId()
	{
		return formId;
	}

	public void setFormId(int formId)
	{
		this.formId = formId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getHint()
	{
		return hint;
	}

	public void setHint(String hint)
	{
		this.hint = hint;
	}

	public String getIcon()
	{
		return icon;
	}

	public void setIcon(String icon)
	{
		this.icon = icon;
	}

	public String getHelpno()
	{
		return helpno;
	}

	public void setHelpno(String helpno)
	{
		this.helpno = helpno;
	}

	public int getProcessId()
	{
		return processId;
	}

	public void setProcessId(int processId)
	{
		this.processId = processId;
	}

	public int getActionDescId()
	{
		return actionDescId;
	}

	public void setActionDescId(int actionDescId)
	{
		this.actionDescId = actionDescId;
	}

	public int getButtonOrder()
	{
		return buttonOrder;
	}

	public void setButtonOrder(int buttonOrder)
	{
		this.buttonOrder = buttonOrder;
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

	/*public List<PIButtonDetailDTO> getPiButtonDetailDtos() {
		return piButtonDetailDtos;
	}

	public void setPiButtonDetailDtos(List<PIButtonDetailDTO> piButtonDetailDtos) {
		this.piButtonDetailDtos = piButtonDetailDtos;
	}*/

	public int getButtonType() {
		return buttonType;
	}

	public void setButtonType(int buttonType) {
		this.buttonType = buttonType;
	}
	
	public String getMergename() {
		return mergename;
	}

	public void setMergename(String mergename) {
		this.mergename = mergename;
	}
	
	public String getMergeicon() {
		return mergeicon;
	}

	public void setMergeicon(String mergeicon) {
		this.mergeicon = mergeicon;
	}

}
