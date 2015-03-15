package com.wangkai.carselect.bean;

public class CarModel {
	private int pk;
	private int model_id;
	private String model_name;
	private int brand_id;
	private String sub_brand_name;
	private String price_type;
	private String class_type;
	private String size_type;
	
	
	
	public CarModel(int pk, int model_id, String model_name, int brand_id,
			String sub_brand_name, String price_type, String class_type,
			String size_type) {
		super();
		this.pk = pk;
		this.model_id = model_id;
		this.model_name = model_name;
		this.brand_id = brand_id;
		this.sub_brand_name = sub_brand_name;
		this.price_type = price_type;
		this.class_type = class_type;
		this.size_type = size_type;
	}
	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
	}
	public int getModel_id() {
		return model_id;
	}
	public void setModel_id(int model_id) {
		this.model_id = model_id;
	}
	public String getModel_name() {
		return model_name;
	}
	public void setModel_name(String model_name) {
		this.model_name = model_name;
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
	public String getPrice_type() {
		return price_type;
	}
	public void setPrice_type(String price_type) {
		this.price_type = price_type;
	}
	public String getClass_type() {
		return class_type;
	}
	public void setClass_type(String class_type) {
		this.class_type = class_type;
	}
	public String getSize_type() {
		return size_type;
	}
	public void setSize_type(String size_type) {
		this.size_type = size_type;
	}
}
