package com.edu118.po;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class Parts {
    private Integer partsId;
    private String partsSummary;
    
    @Pattern(regexp="XYD-[\\d]{14}-[\\d]{5}",message="请按格式输入配件入库单号，格式为：XYD-20180105141127-63885")
    @NotBlank(message="请按格式输入配件入库单号，格式为：XYD-20180105141127-63885")
    private String partsDanhao;

    @NotBlank(message="请输入供应商的编号！")
    private String supplierId;

    @NotBlank(message="请输入物料类型的编号！")
    private String typeNum;

    @NotBlank(message="请输入配件名称！")
    private String partsName;

    @NotBlank(message="请输入配件使用的单位！")
    private String unit;

    @NotNull(message="请输入配件数量，如果没有可以填0！")
    private Integer count;

    @Range(min=1,max=2,message="请按要求输入数据：1为采购、2为领用！")
    @NotNull(message="请按要求输入数据：1为采购、2为领用！")
    private Integer flag;

    @Pattern(regexp="((19|20)[0-9]{2})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]) ([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]",
    		message="请按格式输入日期：2018-01-05 14:11:27")
    @NotBlank(message="请按格式输入日期：2018-01-05 14:11:27")
    private String date;

    private String remarks;

    public Integer getPartsId() {
        return partsId;
    }

    public void setPartsId(Integer partsId) {
        this.partsId = partsId;
    }

    public String getPartsSummary() {
        return partsSummary;
    }

    public void setPartsSummary(String partsSummary) {
        this.partsSummary = partsSummary == null ? null : partsSummary.trim();
    }

    public String getPartsDanhao() {
        return partsDanhao;
    }

    public void setPartsDanhao(String partsDanhao) {
        this.partsDanhao = partsDanhao == null ? null : partsDanhao.trim();
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId == null ? null : supplierId.trim();
    }

    public String getTypeNum() {
        return typeNum;
    }

    public void setTypeNum(String typeNum) {
        this.typeNum = typeNum == null ? null : typeNum.trim();
    }

    public String getPartsName() {
        return partsName;
    }

    public void setPartsName(String partsName) {
        this.partsName = partsName == null ? null : partsName.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

	@Override
	public String toString() {
		return "Parts [partsId=" + partsId + ", partsSummary=" + partsSummary + ", partsDanhao=" + partsDanhao
				+ ", supplierId=" + supplierId + ", typeNum=" + typeNum + ", partsName=" + partsName + ", unit=" + unit
				+ ", count=" + count + ", flag=" + flag + ", date=" + date + ", remarks=" + remarks + "]";
	}
}