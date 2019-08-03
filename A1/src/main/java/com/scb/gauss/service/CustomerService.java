package com.scb.gauss.service;

import java.util.List;

import com.scb.gauss.bean.Customer;


public interface CustomerService {
	public int add(Customer customer);
	public List<Customer> list();
	public int delete(int id);
	public Customer get(int id);
	public int update(Customer customer);
	public int appeal(Customer customer);
//	public void status(Customer c);
	public int isaadhar(long a);
	public void docStatus(Customer c);
	public void appealStatus(Customer c);


	}
