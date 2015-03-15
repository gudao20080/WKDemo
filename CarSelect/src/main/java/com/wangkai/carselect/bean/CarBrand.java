package com.wangkai.carselect.bean;

public class CarBrand {
	private int pk;
	private int brand_id;
	private String brand_name;
	private String first_letter;
	private int has_sub_brand;
	
	
	
	public CarBrand(int pk, int brand_id, String brand_name,
			String first_letter, int has_sub_brand) {
		super();
		this.pk = pk;
		this.brand_id = brand_id;
		this.brand_name = brand_name;
		this.first_letter = first_letter;
		this.has_sub_brand = has_sub_brand;
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
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getFirst_letter() {
		return first_letter;
	}
	public void setFirst_letter(String first_letter) {
		this.first_letter = first_letter;
	}
	public int getHas_sub_brand() {
		return has_sub_brand;
	}
	public void setHas_sub_brand(int has_sub_brand) {
		this.has_sub_brand = has_sub_brand;
	}
	

}
