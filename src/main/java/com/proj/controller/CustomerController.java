package com.proj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.model.Customer;
import com.proj.service.ICustomerService;


@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	ICustomerService cusService;
	
	
	@PostMapping(consumes="application/json", produces="application/json")
	@RequestMapping("/addcustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		Customer customerResult = cusService.addCustomer(customer);
		if(customerResult!=null) {
			return new ResponseEntity<Customer>(customerResult,HttpStatus.OK); 
		}
		return new ResponseEntity<Customer>(customerResult,HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(consumes="application/json", produces="application/json")
	@RequestMapping("/deletecustomer")
	public ResponseEntity<Customer> removeCustomer(Customer customer) {
		Customer customerResult = cusService.removeCustomer(customer);
		if(customerResult!=null) {
			return new ResponseEntity<Customer>(customerResult,HttpStatus.OK); 
		}
		return new ResponseEntity<Customer>(customerResult,HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(consumes="application/json", produces="application/json")
	@RequestMapping("/showcustomer")
	public ResponseEntity<Customer> viewCustomer(Customer c) {
		Customer customerResult = cusService.viewCustomer(c);
		if(customerResult!=null) {
			return new ResponseEntity<Customer>(customerResult,HttpStatus.OK); 
		}
		return new ResponseEntity<Customer>(customerResult,HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(consumes="application/json", produces="application/json")
	@RequestMapping("/updatecustomer")
	public ResponseEntity<Customer> updateCustomer(Customer c) {
		Customer customerResult = cusService.updateCustomer(c);
		if(customerResult!=null) {
			return new ResponseEntity<Customer>(customerResult,HttpStatus.OK); 
		}
		return new ResponseEntity<Customer>(customerResult,HttpStatus.NOT_FOUND);
	}
	@GetMapping(consumes="application/json", produces="application/json")
	@RequestMapping("/showcustomer/{location}")
	public ResponseEntity<List<Customer>> viewAllCustomersByLocation(@PathVariable("location")String location){
		List<Customer> customerResult = cusService.viewAllCustomersByLocation(location);
		if(customerResult!=null) {
			return new ResponseEntity<List<Customer>>(customerResult,HttpStatus.OK); 
		}
		return new ResponseEntity<List<Customer>>(customerResult,HttpStatus.NOT_FOUND);
	}
	
}
