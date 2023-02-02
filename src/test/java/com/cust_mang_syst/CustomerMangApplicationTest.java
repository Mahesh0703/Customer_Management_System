package com.cust_mang_syst;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cust_mang_syst.dao.CustomerDetailsDao;
import com.cust_mang_syst.service.CustomerService;
import com.cust_mang_syst.vo.CustomerDetails;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerMangApplicationTest {

	@MockBean
	private CustomerDetailsDao custDao;

	@Autowired
	private CustomerService custService;

	@Test
	public void getCustDetByIdTest() {
		String id = "105";
		CustomerDetails cust = new CustomerDetails("105", "Mock", 1221344356, "jaxon@hotmail.com", "France", 123321);
		Mockito.when(custDao.findById(id)).thenReturn(Optional.of(cust));

		assertEquals(cust, custService.getCustDetById(id));
	}

	@Test
	public void updateCustDetByIdTest() {
		String id = "106";
		boolean flag = true;
		boolean result = false;

		CustomerDetails cust1 = new CustomerDetails("106", "Mock", 1221344356, "jaxon@hotmail.com", "France", 123321);
		CustomerDetails cust2 = new CustomerDetails("106", "Sank", 1221344356, "mfasf@hotmail.com", "India", 101197);

		Mockito.when(custDao.findById(id)).thenReturn(Optional.of(cust1));

		result = custService.updateCustDetById(cust2, id);

		assertEquals(flag, result);
	}

	@Test
	public void getAllCutDetTest() {

		List<CustomerDetails> list = new ArrayList<>();

		list.add(new CustomerDetails("106", "Mock", 1221344356, "jaxon@hotmail.com", "France", 123321));
		list.add(new CustomerDetails("105", "Sank", 1221344356, "mfasf@hotmail.com", "France", 123321));
		list.add(new CustomerDetails("103", "Ales", 1221344356, "ghj@hotmail.com", "France", 123321));
		list.add(new CustomerDetails("107", "Jon", 1221344356, "hk@hotmail.com", "France", 123321));

		List<CustomerDetails> sortedList = list.stream().sorted(Comparator.comparing(CustomerDetails::getCust_Name))
				.collect(Collectors.toList());

		Mockito.when(custDao.findAll()).thenReturn(list);

		custService.getAllCustDetails();
		verify(custDao).findAll();

		assertEquals(sortedList, custService.getAllCustDetails());
	}
}
