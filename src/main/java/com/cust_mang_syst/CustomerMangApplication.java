package com.cust_mang_syst;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class CustomerMangApplication {


	public static void main(String[] args) {
		
		
		System.out.println("Customer Details Started :: ");
		SpringApplication.run(CustomerMangApplication.class, args);
		System.out.println("Customer Details Ended :: ");
	}

}
