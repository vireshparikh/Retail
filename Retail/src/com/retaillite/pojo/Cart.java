package com.retaillite.pojo;

public class Cart {

	private Integer cart_UID;
	private String cart_Customer_Number;
	private String product_UPC;
	private Integer cart_Quantity;
	private Double cart_Total;
	private String cart_Order_Paid_Flag;

	public Integer getCart_UID() {
		return cart_UID;
	}

	public void setCart_UID(Integer cart_UID) {
		this.cart_UID = cart_UID;
	}

	public String getCart_Customer_Number() {
		return cart_Customer_Number;
	}

	public void setCart_Customer_Number(String cart_Customer_Number) {
		this.cart_Customer_Number = cart_Customer_Number;
	}

	public String getProduct_UPC() {
		return product_UPC;
	}

	public void setProduct_UPC(String product_UPC) {
		this.product_UPC = product_UPC;
	}

	public Integer getCart_Quantity() {
		return cart_Quantity;
	}

	public void setCart_Quantity(Integer cart_Quantity) {
		this.cart_Quantity = cart_Quantity;
	}

	public Double getCart_Total() {
		return cart_Total;
	}

	public void setCart_Total(Double cart_Total) {
		this.cart_Total = cart_Total;
	}

	public String getCart_Order_Paid_Flag() {
		return cart_Order_Paid_Flag;
	}

	public void setCart_Order_Paid_Flag(String cart_Order_Paid_Flag) {
		this.cart_Order_Paid_Flag = cart_Order_Paid_Flag;
	}

}
