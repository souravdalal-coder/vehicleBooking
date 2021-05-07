package com.proj.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.model.Customer;

import com.proj.repository.ICustomerRepository;

@Service
public class ICustomerServiceImp implements ICustomerService{

	@Autowired
	ICustomerRepository cusRepository;
	//@Autowired
	//IBookingRepository bookingRepository;
	
	@Override
	@Transactional
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		cusRepository.save(customer);
		return customer;
		//return cusRepository.addCustomer(customer);
	}

	@Override
	public Customer removeCustomer(Customer customer) {
		// TODO Auto-generated method stub
		cusRepository.delete(customer);
		return customer;
	}

	@Override
	public Customer viewCustomer(Customer c) {
		// TODO Auto-generated method stub
		Optional<Customer> customer = cusRepository.findById(c.getCustomerId());
		if(customer !=null) {
			return c;
		}
		return null;
	}

	@Override
	public Customer updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		Optional<Customer> customer = cusRepository.findById(c.getCustomerId());
		if(customer != null) {
			return null;
		}
		else {
		cusRepository.save(c);
		return c;
		}
	}

//	@Override
//	public List<Customer> viewAllCustomer(String vtype) {
//		
//		List<Customer> customers = bookingRepository.findByVehicle(vtype);
//		return customers;
//	}

	@Override
	public List<Customer> viewAllCustomersByLocation(String location) {
		// TODO Auto-generated method stub
		
		return cusRepository.findByAddress(location);
	}

}
