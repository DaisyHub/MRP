package com.edu118.po;

public class Unit {
    private Integer uid;

    private String unitName;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

	@Override
	public String toString() {
		return "Unit [uid=" + uid + ", unitName=" + unitName + "]";
	}
}