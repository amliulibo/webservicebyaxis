package com.java.entity;

import java.io.Serializable;

public class VMSelectDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 流水号。
	 */
	private int itemid;
	
	/**
	 * 单据定义流水号。
	 */
	private int voucherid;
	
	/**
	 * 单据列定义流水号。
	 */
	private int vmcolumnid;
	
	/**
	 * 查询域显示顺序。
	 */
	private int showseq;
	
	/**
	 * 查询域显示名称。
	 */
	private String fcolname;
	
	/**
	 * 查询条件是否必添：0-否、1-是。
	 */
	private int ismustselect;
	
	/**
	 * 查询条件是否可以设置多个值：0-否、1-是。
	 */
	private int ismultivalue;
	
	/**
	 * 列编码
	 */
	private String fcolcode;
	
	/**
	 * 类型(1是主单2细单)
	 */
	private int selecttype;
	
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getVoucherid() {
		return voucherid;
	}
	public void setVoucherid(int voucherid) {
		this.voucherid = voucherid;
	}
	public int getVmcolumnid() {
		return vmcolumnid;
	}
	public void setVmcolumnid(int vmcolumnid) {
		this.vmcolumnid = vmcolumnid;
	}
	public int getShowseq() {
		return showseq;
	}
	public void setShowseq(int showseq) {
		this.showseq = showseq;
	}
	public String getFcolname() {
		return fcolname;
	}
	public void setFcolname(String fcolname) {
		this.fcolname = fcolname;
	}
	public int getIsmustselect() {
		return ismustselect;
	}
	public void setIsmustselect(int ismustselect) {
		this.ismustselect = ismustselect;
	}
	public int getIsmultivalue() {
		return ismultivalue;
	}
	public void setIsmultivalue(int ismultivalue) {
		this.ismultivalue = ismultivalue;
	}
	public String getFcolcode() {
		return fcolcode;
	}
	public void setFcolcode(String fcolcode) {
		this.fcolcode = fcolcode;
	}
	public int getSelecttype() {
		return selecttype;
	}
	public void setSelecttype(int selecttype) {
		this.selecttype = selecttype;
	}
	
}
