package com.wangkai.carselect.bean;

public class CarSubBrand {
	private int pk;
	private int brand_id;
	private String sub_brand_name;
	
	
	
	public CarSubBrand(int pk, int brand_id, String sub_brand_name) {
		super();
		this.pk = pk;
		this.brand_id = brand_id;
		this.sub_brand_name = sub_brand_name;
	}
	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
	}
	public int getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}
	public String getSub_brand_name() {
		return sub_brand_name;
	}
	public void setSub_brand_name(String sub_brand_name) {
		this.sub_brand_name = sub_brand_name;
	}
}
