package com.retaillite.pojo;

import java.util.Date;

public class Queue {
	private Integer cq_UID;
	private String cq_Customer_Number;
	private String cq_Status;
	private Date end_DateTime;
	private Date start_DateTime;

	public Integer getCq_UID() {
		return cq_UID;
	}

	public void setCq_UID(Integer cq_UID) {
		this.cq_UID = cq_UID;
	}

	public String getCq_Customer_Number() {
		return cq_Customer_Number;
	}

	public void setCq_Customer_Number(String cq_Customer_Number) {
		this.cq_Customer_Number = cq_Customer_Number;
	}

	public String getCq_Status() {
		return cq_Status;
	}

	public void setCq_Status(String cq_Status) {
		this.cq_Status = cq_Status;
	}

	public Date getEnd_DateTime() {
		return end_DateTime;
	}

	public void setEnd_DateTime(Date end_DateTime) {
		this.end_DateTime = end_DateTime;
	}

	public Date getStart_DateTime() {
		return start_DateTime;
	}

	public void setStart_DateTime(Date start_DateTime) {
		this.start_DateTime = start_DateTime;
	}

}
