package com.java.entity;

import java.io.Serializable;

public class Functions implements Serializable {

	private String id;
	private String appID;
	private String name;
	private String codeName;
	private String description;
	private int sortID;
	private String inherited;
	private String classify;
	private String modifyTime;
	private String icon;
	private String appCodeName;
	private String appName;
	private String createTime;
	private String parentId;
	private String assembly;
	private String className;
	private String p1;
	private String p2;
	private String p3;
	private String p4;
	private String p5;
	private String useYears;
	private String url;

	/** 
	 * @return url 
	 */
	public String getUrl() {
		return url;
	}

	/** 
	 * @param url 要设置的 url 
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	public String getUseYears() {
		return useYears;
	}

	public void setUseYears(String useYears) {
		this.useYears = useYears;
	}

	/**
	 * @return parentid
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * @param parentid
	 *            要设置的 parentid
	 */
	public void setParentId(String parentid) {
		this.parentId = parentid;
	}

	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	// 关联角色ID
	private String roleID;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAppID() {
		return appID;
	}

	public void setAppID(String appID) {
		this.appID = appID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSortID() {
		return sortID;
	}

	public void setSortID(int sortID) {
		this.sortID = sortID;
	}

	public String getInherited() {
		return inherited;
	}

	public void setInherited(String inherited) {
		this.inherited = inherited;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getAppCodeName() {
		return appCodeName;
	}

	public void setAppCodeName(String appCodeName) {
		this.appCodeName = appCodeName;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

	public String getAssembly() {
		return assembly;
	}

	public void setAssembly(String assembly) {
		this.assembly = assembly;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getP1() {
		return p1;
	}

	public void setP1(String p1) {
		this.p1 = p1;
	}

	public String getP2() {
		return p2;
	}

	public void setP2(String p2) {
		this.p2 = p2;
	}

	public String getP3() {
		return p3;
	}

	public void setP3(String p3) {
		this.p3 = p3;
	}

	public String getP4() {
		return p4;
	}

	public void setP4(String p4) {
		this.p4 = p4;
	}

	public String getP5() {
		return p5;
	}

	public void setP5(String p5) {
		this.p5 = p5;
	}
}