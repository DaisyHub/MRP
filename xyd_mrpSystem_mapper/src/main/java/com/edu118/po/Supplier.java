package com.edu118.po;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class Supplier {
	//XYD-xyd   //XYD-muyu 5-15
	@Pattern(regexp="XYD-[\\w]{5,15}",message="请输入5到15位的供应商编号，格式为：XYD-xxxxxx")
    private String supplierId;

    @NotBlank(message="请输入供应商信息！")
    private String supplierName;

    private String supplierContacts;

    private String supplierCall;

    private String supplierAddress;

    private String remarks;

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId == null ? null : supplierId.trim();
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    public String getSupplierContacts() {
        return supplierContacts;
    }

    public void setSupplierContacts(String supplierContacts) {
        this.supplierContacts = supplierContacts == null ? null : supplierContacts.trim();
    }

    public String getSupplierCall() {
        return supplierCall;
    }

    public void setSupplierCall(String supplierCall) {
        this.supplierCall = supplierCall == null ? null : supplierCall.trim();
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress == null ? null : supplierAddress.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", supplierContacts="
				+ supplierContacts + ", supplierCall=" + supplierCall + ", supplierAddress=" + supplierAddress
				+ ", remarks=" + remarks + "]";
	}
}