package com.cust_mang_syst.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cust_mang_syst.vo.CustomerDetails;

@Repository
public interface CustomerDetailsDao extends JpaRepository<CustomerDetails, String>{

//	@Query("update"+ "customer_details set name=?, where cust_id=?")
//	boolean updateCustDet(CustomerDetails customer, String id);

}
