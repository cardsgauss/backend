package com.scb.gauss.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.gauss.bean.Customer;
import com.scb.gauss.dao.CustomerDAO;
import com.scb.gauss.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO cusDAO;
	
	static
	{
		System.out.println("In Service");
	}

	@Override
	public int add(Customer customer) {
		return cusDAO.add(customer);
	}
	@Override
	public List<Customer> list() {
		return cusDAO.list();
	}
	@Override
	public int delete(int id) {
		return cusDAO.delete(id);
	}
	@Override
	public Customer get(int id) {
		return cusDAO.get(id);
	}
	@Override
	public int update(Customer customer) {
		// TODO Auto-generated method stub
		return cusDAO.update(customer);
	}
	@Override
	public int appeal(Customer customer) {
		// TODO Auto-generated method stub
		return cusDAO.appeal(customer);
	}
//	@Override
//	public void status(Customer c) {
//		// TODO Auto-generated method stub
//		 cusDAO.status(c);
//		
//	}
	@Override
    public int isaadhar(long a) {
          // TODO Auto-generated method stub
          return cusDAO.isaadhar(a);
    }
	@Override
	public void docStatus(Customer c) {
		// TODO Auto-generated method stub
		cusDAO.docStatus(c);
	}
	@Override
	public void appealStatus(Customer c) {
		// TODO Auto-generated method stub
		cusDAO.appealStatus(c);
	}

	

	}


