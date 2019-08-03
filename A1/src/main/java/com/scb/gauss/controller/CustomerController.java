package com.scb.gauss.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scb.gauss.bean.Customer;
import com.scb.gauss.service.CustomerService;


@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService custService;
	
	static
	{
		System.out.println("In Controller");
	}

	/* Adding a resource */
	@PostMapping("/add")
	private int add(@RequestBody Customer customer) {
		
		return custService.add(customer);
	}
	@GetMapping("/")
	private Collection<Customer> list() {
		return custService.list();
	}
	@DeleteMapping("delete/{id}")
	private int delete(@PathVariable int id) {
		return custService.delete(id);
	}
	@GetMapping("/{id}")
	private Customer get(@PathVariable int id) {
		return custService.get(id);
	}
	@PutMapping("/update")
	private int update(@RequestBody Customer customer) {
		return custService.update(customer);
	}
	@PutMapping("/appeal")
	private int appeal(@RequestBody Customer customer) {
		return custService.appeal(customer);
	}
//	@PutMapping("/status")
//	private void status(@RequestBody Customer customer) {
//		 custService.update(customer);
//	
//	
//    @GetMapping("/{aadhar}")
//    private void isaadhar(@RequestBody int aadhar) {
//          custService.isaadhar(aadhar);
//    }
	@GetMapping("/aadhaar/{aadhar}")
	private int isaadhar(@PathVariable long aadhar) {
		 return custService.isaadhar(aadhar);
	}
	
	@PutMapping("/appealstatus")
	private void appealstatus(@RequestBody Customer c) {
		 custService.appealStatus(c);
	}
	
	@PutMapping("/docstatus")
	private void docstatus(@RequestBody Customer c) {
		 custService.docStatus(c);
	}
	
	

	}
