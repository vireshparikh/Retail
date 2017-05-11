package com.retaillite.pojo;

public class Order {
	private Integer order_UID;
	private String cart_Customer_Number;
	private Double order_Total;
	private Double order_Payment_Amount;
	private String order_Payment_Method;
	private String order_Delivery_Status_Flag;

	public Integer getOrder_UID() {
		return order_UID;
	}

	public void setOrder_UID(Integer order_UID) {
		this.order_UID = order_UID;
	}

	public String getCart_Customer_Number() {
		return cart_Customer_Number;
	}

	public void setCart_Customer_Number(String oart_Customer_Number) {
		this.cart_Customer_Number = oart_Customer_Number;
	}

	public Double getOrder_Total() {
		return order_Total;
	}

	public void setOrder_Total(Double order_Total) {
		this.order_Total = order_Total;
	}

	public Double getOrder_Payment_Amount() {
		return order_Payment_Amount;
	}

	public void setOrder_Payment_Amount(Double order_Payment_Amount) {
		this.order_Payment_Amount = order_Payment_Amount;
	}

	public String getOrder_Payment_Method() {
		return order_Payment_Method;
	}

	public void setOrder_Payment_Method(String order_Payment_Method) {
		this.order_Payment_Method = order_Payment_Method;
	}

	public String getOrder_Delivery_Status_Flag() {
		return order_Delivery_Status_Flag;
	}

	public void setOrder_Delivery_Status_Flag(String order_Delivery_Status_Flag) {
		this.order_Delivery_Status_Flag = order_Delivery_Status_Flag;
	}

}
