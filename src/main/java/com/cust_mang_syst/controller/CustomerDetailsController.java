package com.cust_mang_syst.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cust_mang_syst.service.CustomerService;
import com.cust_mang_syst.vo.CustomerDetails;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerDetailsController {

	public static final Logger log = LogManager.getLogger(CustomerDetailsController.class);
	
	@Autowired
	CustomerService service;

	@PostMapping("/open/addding")
	public ResponseEntity<?> insertCustomerDetails(@Valid @RequestBody CustomerDetails customer) {
		
		log.debug("Enter CustomerDetailsController.insertCustomerDetails(@Valid @RequestBody CustomerDetails customer) :: "+customer);
		
		CustomerDetails insertedDetails = service.insertCustDetails(customer);
		
		log.debug("Exit from CustomerDetailsController.insertCustomerDetails(@Valid @RequestBody CustomerDetails customer) : "
		+ insertedDetails);
		
		return ResponseEntity.ok(insertedDetails);
	}

	@GetMapping("/open/all")
	public ResponseEntity<?> getAllCustDetails() {
		log.debug("Enter into CustomerDetailsController.getAllCustDetails() ::");
		
		List<CustomerDetails> allCustDetails = service.getAllCustDetails();

		log.debug("Exit from CustomerDetailsController.getAllCustDetails() ::"+ allCustDetails);
		
		return ResponseEntity.ok(allCustDetails);
	}

	@GetMapping("/open/{Id}")
	public ResponseEntity<?> getCustDetById(@Valid @PathVariable("Id") String Id) {
		log.debug("Enter into CustomerDetailsController.getCustDetById("
				+ "@Valid @PathVariable(\"Id\") String Id) ::"+ " Id of Customer is :: "+Id);
		
		CustomerDetails custDetById = service.getCustDetById(Id);
		
		log.debug("Exit from CustomerDetailsController.getAllCustDetails() ::"+ custDetById );
		
		return ResponseEntity.ok(custDetById);

	}

	@PutMapping("/user/updating/{Id}")
	public ResponseEntity<?> updateCustDetById(@RequestBody CustomerDetails customer, @PathVariable("Id") String Id) {
		
		log.debug("Enter into CustomerDetailsController.updateCustDetById"
				+ "(@RequestBody CustomerDetails customer, @PathVariable(Id) String Id) ::"+ 
				" Id of Customer is :: "+Id+ "new Customer ::"+customer);
		
		if (service.updateCustDetById(customer, Id))
			return ResponseEntity.ok("Customer Details Updated in DataBase ::");
		else
			return ResponseEntity.ok("Customer Details failed to updation inn Database ::");
		
		

	}

	@DeleteMapping("/user/remove/{Id}")
	public ResponseEntity<?> deleteCustById(@PathVariable("Id") String Id) {

		log.debug("Enter into CustomerDetailsController.deleteCustById(@PathVariable(Id) String Id) ::"+ 
				" Id of Customer is :: "+Id);
		if (service.deleteCustDetById(Id))
			return ResponseEntity.ok("Customer Detailes deleted from Database ");
		else
			return ResponseEntity.ok("Failed to deletion from Database ");
	}

	@GetMapping("/admin")
	public ResponseEntity<?> adminUser() {
		return ResponseEntity.ok("Welcome Admin User");
	}

	@GetMapping("/normal")
	public ResponseEntity<?> normalUser() {
		return ResponseEntity.ok("Welcome Normal User");
	}
}
