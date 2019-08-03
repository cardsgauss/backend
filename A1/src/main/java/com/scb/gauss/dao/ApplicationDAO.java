package com.scb.gauss.dao;

import java.util.List;

import com.scb.gauss.bean.Application;
//import com.scb.gauss.bean.Customer;
import com.scb.gauss.bean.Customer;






public interface ApplicationDAO {
	public int add(Customer a);
	public List<Application> list();
	public int delete(int id);	
//	public create(int id,String name);
}