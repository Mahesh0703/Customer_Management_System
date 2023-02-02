package com.cust_mang_syst.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class CustomerDetails {

	@Id
	@Column(name = "Cust_Id")
	@NotNull
	String cust_Id;

	@Column(name = "Name")
	@NotEmpty
	@Size(min = 4, message = "user name should have at least 4 characters :: ")
	String cust_Name;

	@Column(name = "Mobile_Num")
	long cust_MobNo;

	@Email
	@Column(name = "Mail_Id")
	@Email
	String cust_MailId;

	@Column(name = "City")
	String cust_City;

	@Column(name = "PinCode")
	int cust_PinCode;

	public void setCust_Id(String cust_Id) {
		this.cust_Id = cust_Id;
	}

	public String getCust_Id() {
		return cust_Id;
	}

	public String getCust_Name() {
		return cust_Name;
	}

	public void setCust_Name(String cust_Name) {
		this.cust_Name = cust_Name;
	}

	public long getCust_MobNo() {
		return cust_MobNo;
	}

	public void setCust_MobNo(long cust_MobNo) {
		this.cust_MobNo = cust_MobNo;
	}

	public String getCust_MailId() {
		return cust_MailId;
	}

	public void setCust_MailId(String cust_MailId) {
		this.cust_MailId = cust_MailId;
	}

	public String getCust_City() {
		return cust_City;
	}

	public void setCust_City(String cust_City) {
		this.cust_City = cust_City;
	}

	public int getCust_PinCode() {
		return cust_PinCode;
	}

	public void setCust_PinCode(int cust_PinCode) {
		this.cust_PinCode = cust_PinCode;
	}

	public CustomerDetails() {
		super();

	}

	public CustomerDetails(@NotNull String cust_Id,
			@NotEmpty @Size(min = 4, message = "user name should have at least 4 characters :: ") String cust_Name,
			long cust_MobNo, @Email @Email String cust_MailId, String cust_City, int cust_PinCode) {
		super();
		this.cust_Id = cust_Id;
		this.cust_Name = cust_Name;
		this.cust_MobNo = cust_MobNo;
		this.cust_MailId = cust_MailId;
		this.cust_City = cust_City;
		this.cust_PinCode = cust_PinCode;
	}

	public String toString() {
		return "CustomerDetails are :: [Customer_Id=" + cust_Id + ", Customer_Name=" + cust_Name + ", Customer_MobNo="
				+ cust_MobNo + ", Customer_MailId=" + cust_MailId + ", Customer_City=" + cust_City
				+ ", Customer_PinCode=" + cust_PinCode + "]";
	}

}
