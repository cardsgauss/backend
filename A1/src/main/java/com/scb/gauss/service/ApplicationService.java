package com.scb.gauss.service;

import java.util.List;

import com.scb.gauss.bean.Application;
import com.scb.gauss.bean.Customer;




public interface ApplicationService {
	public int add(Customer a);
	public List<Application> list();
	public int delete(int id);
	}
