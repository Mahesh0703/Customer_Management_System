package com.cust.mang.syst.exception;

import java.util.Date;

public class ErrorResponse {

	private int status;
	private String errorMassage;
	private String requestUri;
	private Date timeStamp;

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(int status, String errorMassage, String requestUri, Date timeStamp) {
		super();
		this.status = status;
		this.errorMassage = errorMassage;
		this.requestUri = requestUri;
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getErrorMassage() {
		return errorMassage;
	}

	public void setErrorMassage(String errorMassage) {
		this.errorMassage = errorMassage;
	}

	public String getRequestUri() {
		return requestUri;
	}

	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
}
