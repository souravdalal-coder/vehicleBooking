package com.proj.repository;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proj.model.Customer;

@Repository
//
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	
	//public Customer addCustomer(@Param("c")Customer c);
	/*public Customer removeCustomer(Customer customer);
	public Customer viewCustomer(Customer c);
	public Customer updateCustomer(Customer c);
	@Query(" select b.customer from Booking b where b.vehicle in(select v from Vehicle v where v.type=(:vtype)")
	public List<Customer> viewAllCustomer(@Param("vtype")String vtype);
	@Query("select b.customer from Booking b where b.vehicle in(select v from Vehicle v where v.location=(:location)")
	public List<Customer> viewAllCustomersByLocation(@Param("location")String location);
	*/
	@Query("select c.address from Customer c where c.address= :location")
	public List<Customer> findByAddress(@Param("location")String location);
}
