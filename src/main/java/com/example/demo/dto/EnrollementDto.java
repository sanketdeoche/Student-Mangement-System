package com.example.demo.dto;

import java.sql.Date;

public class EnrollementDto {

	private int courseid;
	private int batchid;
	private int fees;
	private String status;
	private int installementpaid;
	private Date nextinstallement;
	private int installementpending;

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public int getBatchid() {
		return batchid;
	}

	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getInstallementpaid() {
		return installementpaid;
	}

	public void setInstallementpaid(int installementpaid) {
		this.installementpaid = installementpaid;
	}

	public Date getNextinstallement() {
		return nextinstallement;
	}

	public void setNextinstallement(Date nextinstallement) {
		this.nextinstallement = nextinstallement;
	}

	public int getInstallementpending() {
		return installementpending;
	}

	public void setInstallementpending(int installementpending) {
		this.installementpending = installementpending;
	}

}
