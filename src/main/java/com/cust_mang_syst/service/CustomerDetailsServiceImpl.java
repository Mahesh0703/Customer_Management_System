package com.cust_mang_syst.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cust.mang.syst.exception.NoSuchCustomerExistException;
import com.cust_mang_syst.controller.CustomerDetailsController;
import com.cust_mang_syst.dao.CustomerDetailsDao;
import com.cust_mang_syst.vo.CustomerDetails;

@Service
public class CustomerDetailsServiceImpl implements CustomerService {

	public static final Logger log = LogManager.getLogger(CustomerDetailsController.class);

	@Autowired
	CustomerDetailsDao custDao;

	public CustomerDetails insertCustDetails(CustomerDetails customer) {
		log.debug("Enter CustomerDetailsServiceImpl.insertCustomerDetails(CustomerDetails customer) :: " + customer);

		if (customer != null)
			return custDao.save(customer);
		else
			log.debug("Exit from CustomerDetailsServiceImpl.insertCustomerDetails(CustomerDetails customer) :: "
					+ "Because customer is Null :: ");

		throw new NullPointerException("Customer value is null :: ");
	}

	public List<CustomerDetails> getAllCustDetails() {

		log.debug("Enter CustomerDetailsServiceImpl.getAllCustDetails() :: ");

		List<CustomerDetails> allCust = custDao.findAll();
		if (allCust.size() > 0)
			return allCust.stream().sorted(Comparator.comparing(CustomerDetails::getCust_Name))
					.collect(Collectors.toList());
		else
			throw new NoSuchCustomerExistException(
					"Any Customer Details not present in our record please add some customer record :: ");

	}

	public CustomerDetails getCustDetById(String id) {

		log.debug("Enter CustomerDetailsServiceImpl.getCustDetById(String id) and Customer Id is :: " + id);

		return custDao.findById(id)
				.orElseThrow(() -> new NoSuchCustomerExistException("No customer Present with Id :" + id));
	}

	public boolean updateCustDetById(CustomerDetails customer, String id) {

		log.debug("Enter CustomerDetailsServiceImpl.updateCustDetById(CustomerDetails customer, String id) :: ");
		Optional<CustomerDetails> custDet = custDao.findById(id);
		if (custDet == null || custDet.isEmpty())
			throw new NoSuchCustomerExistException(
					"Customer not present with this :: " + id + "  please enter valid Cutomer Id");
		else {
			CustomerDetails customerDetails = custDet.get();
			customerDetails.setCust_Name(customer.getCust_Name());
			customerDetails.setCust_MobNo(customer.getCust_MobNo());
			customerDetails.setCust_MailId(customer.getCust_MailId());
			customerDetails.setCust_City(customer.getCust_City());
			customerDetails.setCust_PinCode(customer.getCust_PinCode());
			custDao.save(customerDetails);

			log.debug(
					"Exit from CustomerDetailsServiceImpl.updateCustDetById(CustomerDetails customer, String id) :: ");

			return true;
		}
	}

	public boolean deleteCustDetById(String id) {

		log.debug("Enter CustomerDetailsServiceImpl.deleteCustDetById(String id) :: ");

		Optional<CustomerDetails> cust = custDao.findById(id);
		if (cust.isPresent()) {
			custDao.deleteById(id);
			return true;
		} else
			throw new NoSuchCustomerExistException("Customer Not found in database and removing pending :: ");
	}

}
