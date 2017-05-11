package com.retaillite.pojo;

public class Product {

	private String product_UPC;
	private String product_Name;
	private String product_Desc;
	private Double product_RRP;
	private Double product_SP;

	public String getProduct_UPC() {
		return product_UPC;
	}

	public void setProduct_UPC(String product_UPC) {
		this.product_UPC = product_UPC;
	}

	public String getProduct_Name() {
		return product_Name;
	}

	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}

	public String getProduct_Desc() {
		return product_Desc;
	}

	public void setProduct_Desc(String product_Desc) {
		this.product_Desc = product_Desc;
	}

	public Double getProduct_RRP() {
		return product_RRP;
	}

	public void setProduct_RRP(Double product_RRP) {
		this.product_RRP = product_RRP;
	}

	public Double getProduct_SP() {
		return product_SP;
	}

	public void setProduct_SP(Double product_SP) {
		this.product_SP = product_SP;
	}

	public String getProduct_Disc_Code() {
		return product_Disc_Code;
	}

	public void setProduct_Disc_Code(String product_Disc_Code) {
		this.product_Disc_Code = product_Disc_Code;
	}

	public String getProduct_QR_Code() {
		return product_QR_Code;
	}

	public void setProduct_QR_Code(String product_QR_Code) {
		this.product_QR_Code = product_QR_Code;
	}

	private String product_Disc_Code;
	private String product_QR_Code;

}
