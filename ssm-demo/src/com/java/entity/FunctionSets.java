package com.java.entity;

import java.io.Serializable;

public class FunctionSets implements Serializable{
	public String id;
	public String appID;
	public String name;
	public String codeName;
	public String description;
	public String resourceLevel;
	public String lowestSet;
	public String inherited;
	public String classify;
	public String modifyTime;
	public String icon;
	public int sortID;
	public int childrenCount;
	public String createTime;
	private String useYears;
	private String parentid;
	
	/** 
	 * @return parentid 
	 */
	public String getParentid() {
		return parentid;
	}
	/** 
	 * @param parentid 要设置的 parentid 
	 */
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getUseYears() {
		return useYears;
	}
	public void setUseYears(String useYears) {
		this.useYears = useYears;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
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
	public String getResourceLevel() {
		return resourceLevel;
	}
	public void setResourceLevel(String resourceLevel) {
		this.resourceLevel = resourceLevel;
	}
	public String getLowestSet() {
		return lowestSet;
	}
	public void setLowestSet(String lowestSet) {
		this.lowestSet = lowestSet;
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
	public int getSortID() {
		return sortID;
	}
	public void setSortID(int sortID) {
		this.sortID = sortID;
	}
	public int getChildrenCount() {
		return childrenCount;
	}
	public void setChildrenCount(int childrenCount) {
		this.childrenCount = childrenCount;
	}
}