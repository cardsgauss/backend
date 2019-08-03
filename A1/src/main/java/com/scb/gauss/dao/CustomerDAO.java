package com.scb.gauss.dao;

import java.util.List;

import com.scb.gauss.bean.Customer;







public interface CustomerDAO {
	public int add(Customer customer);
	public List<Customer> list();
	public int delete(int id);
	public Customer get(int id);
	public int update(Customer customer);
	public int appeal(Customer customer);
//	public void status(Customer c);
	public int isaadhar(long a);
	public void appealStatus(Customer c);
	public void docStatus(Customer c);
}