package com.edu118.po;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class Type {
	@Range(min=1,max=2,message="请选择物料类型：1是成品，2是配件！")
    private Integer typeId;
	
	@Pattern(regexp="XYD-[\\w]{5,15}",message="请输入5到15位的物料编号，格式为：XYD-xxxxxx")
	@NotBlank(message="类型编号不能为空！")
    private String typeNum;

	@NotBlank(message="类型名称不能为空！")
    private String typeName;
	
    private String typeDesc;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeNum() {
        return typeNum;
    }

    public void setTypeNum(String typeNum) {
        this.typeNum = typeNum == null ? null : typeNum.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc == null ? null : typeDesc.trim();
    }

	@Override
	public String toString() {
		return "Type [typeId=" + typeId + ", typeNum=" + typeNum + ", typeName=" + typeName + ", typeDesc=" + typeDesc
				+ "]";
	}
}