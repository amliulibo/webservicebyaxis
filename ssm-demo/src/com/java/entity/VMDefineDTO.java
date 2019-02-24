package com.java.entity;

import java.io.Serializable;

public class VMDefineDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 单据定义流水号。
	 */
	private int voucherid;
	
	/**
	 * 单据类型流水号。
	 */
	private int vouchertypeid;
	
	/**
	 * 交易令流水号。
	 */
	private int bctypeid;
	
	/**
	 * 单据编码。
	 */
	private String vouchercode;
	
	/**
	 * 单据名称。
	 */
	private String vouchername;
	
	/**
	 * 单据描述。
	 */
	private String vouchercaption;
	
	/**
	 * 单据风格：1-仅主单、2-主细单。
	 */
	private int voucherstyle;
	
	/**
	 * 主单表定义编码。
	 */
	private String mainvchtable;
	
	/**
	 * 主单行类型：0-不定行数、1-固定行数。
	 */
	private int mainvchrowtype;
	
	/**
	 * 主单行数。
	 */
	private int mainvchrowcount;
	
	/**
	 * 主单合计行类型：0-无合计行、1-底部合计行、2-顶部合计行。
	 */
	private int mainvchsumrowtype;
	
	/**
	 * 主单录入表单界面布局栏数。
	 */
	private int mainvchfformcols;
	
	/**
	 * 细单表定义编码。
	 */
	private String detailvchtable;
	
	/**
	 * 细单行类型：0-不定行数、1-固定行数。
	 */
	private int detailvchrowtype;
	
	/**
	 * 细单行数。
	 */
	private int detailvchrowcount;
	
	/**
	 * 细单合计行类型：0-无合计行、1-底部合计行、2-顶部合计行。
	 */
	private int detailvchsumrowtype;
	
	/**
	 * 主单录入表单界面布局栏数。
	 */
	private int detailvchfformcols;
	
	/**
	 * 是否为账务记账单据：0-否、1-是。
	 */
	private int isfmsource;
	
	/**
	 * 是否为来源单：0-否、1-是。
	 */
	private int isvmsource;
	
	/**
	 * 是否为退单：0-否、1-是。
	 */
	private int isrefund;
	
	/**
	 * UUID ,缓存机制
	 */
	private String gid;
	
	/**
	 * 细单外键关联列
	 */
	private String foreignKeyColumn; 
	
	/**
	 * 备注。
	 */
	private String remark;
	
	
	public int getVoucherid() {
		return voucherid;
	}
	public void setVoucherid(int voucherid) {
		this.voucherid = voucherid;
	}
	public int getVouchertypeid() {
		return vouchertypeid;
	}
	public void setVouchertypeid(int vouchertypeid) {
		this.vouchertypeid = vouchertypeid;
	}
	public int getBctypeid() {
		return bctypeid;
	}
	public void setBctypeid(int bctypeid) {
		this.bctypeid = bctypeid;
	}
	public String getVouchercode() {
		return vouchercode;
	}
	public void setVouchercode(String vouchercode) {
		this.vouchercode = vouchercode;
	}
	public String getVouchername() {
		return vouchername;
	}
	public void setVouchername(String vouchername) {
		this.vouchername = vouchername;
	}
	public String getVouchercaption() {
		return vouchercaption;
	}
	public void setVouchercaption(String vouchercaption) {
		this.vouchercaption = vouchercaption;
	}
	public int getVoucherstyle() {
		return voucherstyle;
	}
	public void setVoucherstyle(int voucherstyle) {
		this.voucherstyle = voucherstyle;
	}
	public String getMainvchtable() {
		return mainvchtable;
	}
	public void setMainvchtable(String mainvchtable) {
		this.mainvchtable = mainvchtable;
	}
	public int getMainvchrowtype() {
		return mainvchrowtype;
	}
	public void setMainvchrowtype(int mainvchrowtype) {
		this.mainvchrowtype = mainvchrowtype;
	}
	public int getMainvchrowcount() {
		return mainvchrowcount;
	}
	public void setMainvchrowcount(int mainvchrowcount) {
		this.mainvchrowcount = mainvchrowcount;
	}
	public int getMainvchsumrowtype() {
		return mainvchsumrowtype;
	}
	public void setMainvchsumrowtype(int mainvchsumrowtype) {
		this.mainvchsumrowtype = mainvchsumrowtype;
	}
	public int getMainvchfformcols() {
		return mainvchfformcols;
	}
	public void setMainvchfformcols(int mainvchfformcols) {
		this.mainvchfformcols = mainvchfformcols;
	}
	public String getDetailvchtable() {
		return detailvchtable;
	}
	public void setDetailvchtable(String detailvchtable) {
		this.detailvchtable = detailvchtable;
	}
	public int getDetailvchrowtype() {
		return detailvchrowtype;
	}
	public void setDetailvchrowtype(int detailvchrowtype) {
		this.detailvchrowtype = detailvchrowtype;
	}
	public int getDetailvchrowcount() {
		return detailvchrowcount;
	}
	public void setDetailvchrowcount(int detailvchrowcount) {
		this.detailvchrowcount = detailvchrowcount;
	}
	public int getDetailvchsumrowtype() {
		return detailvchsumrowtype;
	}
	public void setDetailvchsumrowtype(int detailvchsumrowtype) {
		this.detailvchsumrowtype = detailvchsumrowtype;
	}
	public int getDetailvchfformcols() {
		return detailvchfformcols;
	}
	public void setDetailvchfformcols(int detailvchfformcols) {
		this.detailvchfformcols = detailvchfformcols;
	}
	public int getIsfmsource() {
		return isfmsource;
	}
	public void setIsfmsource(int isfmsource) {
		this.isfmsource = isfmsource;
	}
	public int getIsvmsource() {
		return isvmsource;
	}
	public void setIsvmsource(int isvmsource) {
		this.isvmsource = isvmsource;
	}
	public int getIsrefund() {
		return isrefund;
	}
	public void setIsrefund(int isrefund) {
		this.isrefund = isrefund;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	
	public String getForeignKeyColumn() {
		return foreignKeyColumn;
	}
	public void setForeignKeyColumn(String foreignKeyColumn) {
		this.foreignKeyColumn = foreignKeyColumn;
	}
	
	
}
