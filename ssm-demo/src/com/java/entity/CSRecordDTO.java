package com.java.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CSRecordDTO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int itemId;
    public String itemCode;
    public String itemName;
    public String startDate;
    public String endDate;
    public String useState;
    public String useScope;
    public String admdivCode;
    public int parentId;
    public int levelNo;
    public int isLeaf;
    private int divType;
    
    public String guid;
    
    public String elementCode;
    
    public String FOREIGNKEYCOLUMN;
    
    

    //public List<KeyValuePairDTO> extendFieldValues;

    //public Map<String,Object> extendValues;
    
          
    
	/*public Map<String, Object> getExtendValues() {
		return extendValues;
	}


	public void setExtendValues(Map<String, Object> extendValues) {
		this.extendValues = extendValues;
	}*/


	public String getGuid() {
		return guid;
	}


	public void setGuid(String guid) {
		this.guid = guid;
	}


	public String getElementCode() {
		return elementCode;
	}


	public void setElementCode(String elementCode) {
		this.elementCode = elementCode;
	}


	public String getFOREIGNKEYCOLUMN() {
		return FOREIGNKEYCOLUMN;
	}


	public void setFOREIGNKEYCOLUMN(String fOREIGNKEYCOLUMN) {
		FOREIGNKEYCOLUMN = fOREIGNKEYCOLUMN;
	}


	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public String getItemCode() {
		return itemCode;
	}


	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getUseState() {
		return useState;
	}


	public void setUseState(String useState) {
		this.useState = useState;
	}


	public String getUseScope() {
		return useScope;
	}


	public void setUseScope(String useScope) {
		this.useScope = useScope;
	}


	public String getAdmdivCode() {
		return admdivCode;
	}


	public void setAdmdivCode(String admdivCode) {
		this.admdivCode = admdivCode;
	}


	public int getParentId() {
		return parentId;
	}


	public void setParentId(int parentId) {
		this.parentId = parentId;
	}


	public int getLevelNo() {
		return levelNo;
	}


	public void setLevelNo(int levelNo) {
		this.levelNo = levelNo;
	}


	public int getIsLeaf() {
		return isLeaf;
	}


	public void setIsLeaf(int isLeaf) {
		this.isLeaf = isLeaf;
	}


	public int getDivType()
	{
		return divType;
	}


	public void setDivType(int divType)
	{
		this.divType = divType;
	}

/*
	public List<KeyValuePairDTO> getExtendFieldValues() {
		if(extendFieldValues==null){
			extendFieldValues=new ArrayList<KeyValuePairDTO>();
		}
		return extendFieldValues;
	}


	public void setExtendFieldValues(List<KeyValuePairDTO> extendFieldValues) {
		this.extendFieldValues = extendFieldValues;
	}
       */
    
	
	/****************
     *获取指定属性的value值
     *	 
	 *
	 */
	
	/*public Object getExFieldValue(String fieldName){
		
		if(extendFieldValues!=null&&extendFieldValues.size()>0){
			
			Object res=null;
			for(KeyValuePairDTO one:extendFieldValues){
				if(one.getKey().toUpperCase().equals(fieldName.toUpperCase())){
					
					res= one.getValue();
					break;
				}
				
			}
			
			return res;
		}else{
			
			
			return null;
			
		}
		
		
		
		
		
	}*/
	
	
	
}
