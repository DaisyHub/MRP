package com.edu118.po;

public class CustomBomBean {
	private String bomId;
	private Integer partsId;
	private String unit;
	private Integer count;
	private String remarks;
	private String partsName;
	private String supplierId;
	private String typeNum;
	
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getTypeNum() {
		return typeNum;
	}
	public void setTypeNum(String typeNum) {
		this.typeNum = typeNum;
	}
	public String getBomId() {
		return bomId;
	}
	public void setBomId(String bomId) {
		this.bomId = bomId;
	}
	public Integer getPartsId() {
		return partsId;
	}
	public void setPartsId(Integer partsId) {
		this.partsId = partsId;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getPartsName() {
		return partsName;
	}
	public void setPartsName(String partsName) {
		this.partsName = partsName;
	}
	@Override
	public String toString() {
		return "CustomBomBean [bomId=" + bomId + ", partsId=" + partsId + ", unit=" + unit + ", count=" + count
				+ ", remarks=" + remarks + ", partsName=" + partsName + "]";
	}
	
}
