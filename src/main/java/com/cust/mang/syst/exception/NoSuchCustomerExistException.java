package com.cust.mang.syst.exception;

public class NoSuchCustomerExistException extends RuntimeException {

	String massage;

	public NoSuchCustomerExistException() {
		super();
	}

	public NoSuchCustomerExistException(String massage) {
		super(massage);
		this.massage = massage;
	}
}
