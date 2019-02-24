package com.java.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 窗体主表（窗体主要信息） TODO:使用行政区划编码和年度条件查询时，返回list
 * 
 * @author hew
 *
 */
public class PIFormDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private int formId;
	private String formGuid;
	private String name;
	private String menuId;
	private int isShowDialogue;
	private int processId;
	private int voucherId;
	private int stepDescId;
	private String admdivCode;
	private String dbYear;
	private String formClientGuid;
	private List<PIFormDetailDTO> piFormDetailDtos;


	public int getFormId()
	{
		return formId;
	}

	public void setFormId(int formId)
	{
		this.formId = formId;
	}

	public String getFormGuid()
	{
		return formGuid;
	}

	public void setFormGuid(String formGuid)
	{
		this.formGuid = formGuid;
	}

	public String getMenuId()
	{
		return menuId;
	}

	public void setMenuId(String menuId)
	{
		this.menuId = menuId;
	}

	public int getIsShowDialogue()
	{
		return isShowDialogue;
	}

	public void setIsShowDialogue(int isShowDialogue)
	{
		this.isShowDialogue = isShowDialogue;
	}

	public int getProcessId()
	{
		return processId;
	}

	public void setProcessId(int processId)
	{
		this.processId = processId;
	}

	public int getVoucherId()
	{
		return voucherId;
	}

	public void setVoucherId(int voucherId)
	{
		this.voucherId = voucherId;
	}

	public int getStepDescId()
	{
		return stepDescId;
	}

	public void setStepDescId(int stepDescId)
	{
		this.stepDescId = stepDescId;
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

	public List<PIFormDetailDTO> getPiFormDetailDtos() {
		return piFormDetailDtos;
	}

	public void setPiFormDetailDtos(List<PIFormDetailDTO> piFormDetailDtos) {
		this.piFormDetailDtos = piFormDetailDtos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFormClientGuid()
	{
		return formClientGuid;
	}

	public void setFormClientGuid(String formClientGuid)
	{
		this.formClientGuid = formClientGuid;
	}
}
