package com.java.entity;

import java.io.Serializable;

public class VMColumnDefineDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int vmColumnID;
	
	private int voucherID;// 单据流水号
	
	private int vchHeadID;// 表头流水号
	
	private int colAttachType; // 列定义归属类型 1--主单，2--主细单
	
	private int dcColumnID;// 字典表类型
	
	private int showWidth;
	
	private int showStyle;  // 显示风格：1--编码；2--名称；3--编码加名称
	
	private int inputStyle; // 1--下拉框，2--选择框；3--手工录入
	
	private int isReadOnly; 
	
	private int isMustInput;
	
	private int cfgLevel; // 管理级别 0-系统 1--用户
	
	private int isSum; // 是否合计列
	
	private int isFilter;
	
	private int isSort;
	
	private int isRight;// 权限列
	
	private int isAMT; // 金额列
	
	private int isMerge; // 是否合并列
	
	private int isGroup; // 是否分组用列
	
	private int isAuxiliary;// 是否辅助显示
	
	private int isHide;
	
	private int auxiliaryStyle; //辅助显示风格 1-编码 2--名称，3-编码名称
	
	private int isCompute; // 是否计算列
	
	private int activeType; // 激活类型0--无、1--定制规则、2--jie
	
	private int activeCol; // 激活列
	
	private int computerRuleId; // 计算规则ID
	
	private int customClassID; // 自定义类列。
	
	private int serialRuleID; // 单据生成规则定义流水号
	
	private String formula; // fp公式
	
	private String remark; // 备注
	
	private int useLevelNO; // 使用级次
	
	private int colRelationID;
	
	/**
	 * 字典表列编码
	 */
    private String columnCode;

    /**
     * 字典表列名称
     */
    private String columnName;

	public int getVmColumnID() {
		return vmColumnID;
	}

	public void setVmColumnID(int vmColumnID) {
		this.vmColumnID = vmColumnID;
	}

	public int getVoucherID() {
		return voucherID;
	}

	public void setVoucherID(int voucherID) {
		this.voucherID = voucherID;
	}

	public int getVchHeadID() {
		return vchHeadID;
	}

	public void setVchHeadID(int vchHeadID) {
		this.vchHeadID = vchHeadID;
	}

	public int getColAttachType() {
		return colAttachType;
	}

	public void setColAttachType(int colAttachType) {
		this.colAttachType = colAttachType;
	}

	public int getDcColumnID() {
		return dcColumnID;
	}

	public void setDcColumnID(int dcColumnID) {
		this.dcColumnID = dcColumnID;
	}

	public int getShowWidth() {
		return showWidth;
	}

	public void setShowWidth(int showWidth) {
		this.showWidth = showWidth;
	}

	public int getShowStyle() {
		return showStyle;
	}

	public void setShowStyle(int showStyle) {
		this.showStyle = showStyle;
	}

	public int getInputStyle() {
		return inputStyle;
	}

	public void setInputStyle(int inputStyle) {
		this.inputStyle = inputStyle;
	}

	public int getIsReadOnly() {
		return isReadOnly;
	}

	public void setIsReadOnly(int isReadOnly) {
		this.isReadOnly = isReadOnly;
	}

	public int getIsMustInput() {
		return isMustInput;
	}

	public void setIsMustInput(int isMustInput) {
		this.isMustInput = isMustInput;
	}

	public int getCfgLevel() {
		return cfgLevel;
	}

	public void setCfgLevel(int cfgLevel) {
		this.cfgLevel = cfgLevel;
	}

	public int getIsSum() {
		return isSum;
	}

	public void setIsSum(int isSum) {
		this.isSum = isSum;
	}

	public int getIsFilter() {
		return isFilter;
	}

	public void setIsFilter(int isFilter) {
		this.isFilter = isFilter;
	}

	public int getIsSort() {
		return isSort;
	}

	public void setIsSort(int isSort) {
		this.isSort = isSort;
	}

	public int getIsRight() {
		return isRight;
	}

	public void setIsRight(int isRight) {
		this.isRight = isRight;
	}

	public int getIsAMT() {
		return isAMT;
	}

	public void setIsAMT(int isAMT) {
		this.isAMT = isAMT;
	}

	public int getIsMerge() {
		return isMerge;
	}

	public void setIsMerge(int isMerge) {
		this.isMerge = isMerge;
	}

	public int getIsGroup() {
		return isGroup;
	}

	public void setIsGroup(int isGroup) {
		this.isGroup = isGroup;
	}

	public int getIsAuxiliary() {
		return isAuxiliary;
	}

	public void setIsAuxiliary(int isAuxiliary) {
		this.isAuxiliary = isAuxiliary;
	}

	public int getIsHide() {
		return isHide;
	}

	public void setIsHide(int isHide) {
		this.isHide = isHide;
	}

	public int getAuxiliaryStyle() {
		return auxiliaryStyle;
	}

	public void setAuxiliaryStyle(int auxiliaryStyle) {
		this.auxiliaryStyle = auxiliaryStyle;
	}

	public int getIsCompute() {
		return isCompute;
	}

	public void setIsCompute(int isCompute) {
		this.isCompute = isCompute;
	}

	public int getActiveType() {
		return activeType;
	}

	public void setActiveType(int activeType) {
		this.activeType = activeType;
	}

	public int getActiveCol() {
		return activeCol;
	}

	public void setActiveCol(int activeCol) {
		this.activeCol = activeCol;
	}

	public int getComputerRuleId() {
		return computerRuleId;
	}

	public void setComputerRuleId(int computerRuleId) {
		this.computerRuleId = computerRuleId;
	}

	public int getCustomClassID() {
		return customClassID;
	}

	public void setCustomClassID(int customClassID) {
		this.customClassID = customClassID;
	}

	public int getSerialRuleID() {
		return serialRuleID;
	}

	public void setSerialRuleID(int serialRuleID) {
		this.serialRuleID = serialRuleID;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getUseLevelNO() {
		return useLevelNO;
	}

	public void setUseLevelNO(int useLevelNO) {
		this.useLevelNO = useLevelNO;
	}

	public int getColRelationID() {
		return colRelationID;
	}

	public void setColRelationID(int colRelationID) {
		this.colRelationID = colRelationID;
	}

	public String getColumnCode() {
		return columnCode;
	}

	public void setColumnCode(String columnCode) {
		this.columnCode = columnCode;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	} 
	
	
	
	

}
