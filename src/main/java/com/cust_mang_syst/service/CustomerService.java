package com.cust_mang_syst.service;

import java.util.List;

import com.cust_mang_syst.vo.CustomerDetails;

public interface CustomerService {

	CustomerDetails insertCustDetails(CustomerDetails customer);

	List<CustomerDetails> getAllCustDetails();

	CustomerDetails getCustDetById(String id);

	boolean updateCustDetById(CustomerDetails customer, String id);

	boolean deleteCustDetById(String id);

}
