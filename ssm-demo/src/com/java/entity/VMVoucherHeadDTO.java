package com.java.entity;

import java.io.Serializable;

public class VMVoucherHeadDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 表头配置流水号。
	 */
	private int vchheadid;
	
	/**
	 * 单据定义流水号。
	 */
	private int voucherid;
	
	/**
	 * 表头类型：1-主单据表头、2-细单据表头。
	 */
	private int headtype;
	
	/**
	 * 表头编码，采用级次编码，两位一级。
	 */
	private String code;
	
	/**
	 * 表头名称。
	 */
	private String name;
	
	/**
	 * 表头级次。
	 */
	private int levelno;
	
	/**
	 * 表头是否末级。
	 */
	private int isend;
	
	/**
	 * 对应单据列定义流水号。非末级表头置空。
	 */
	private int vmcolumnid;	
	private String supercode;
	
	
	public int getVchheadid() {
		return vchheadid;
	}
	public void setVchheadid(int vchheadid) {
		this.vchheadid = vchheadid;
	}
	public int getVoucherid() {
		return voucherid;
	}
	public void setVoucherid(int voucherid) {
		this.voucherid = voucherid;
	}
	public int getHeadtype() {
		return headtype;
	}
	public void setHeadtype(int headtype) {
		this.headtype = headtype;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevelno() {
		return levelno;
	}
	public void setLevelno(int levelno) {
		this.levelno = levelno;
	}
	public int getIsend() {
		return isend;
	}
	public void setIsend(int isend) {
		this.isend = isend;
	}
	public int getVmcolumnid() {
		return vmcolumnid;
	}
	public void setVmcolumnid(int vmcolumnid) {
		this.vmcolumnid = vmcolumnid;
	}
	public String getSupercode() {
		return supercode;
	}
	public void setSupercode(String supercode) {
		this.supercode = supercode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	

}
