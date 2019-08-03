package com.scb.gauss.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.gauss.bean.Application;
import com.scb.gauss.bean.Customer;
import com.scb.gauss.dao.ApplicationDAO;
import com.scb.gauss.service.ApplicationService;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private ApplicationDAO appDAO;

	static {
		System.out.println("In Service");
	}

	@Override
	public int add(Customer a) {
		// TODO Auto-generated method stub
		return appDAO.add(a);
	}

	@Override
	public List<Application> list() {
		// TODO Auto-generated method stub
		return appDAO.list();
	}

	@Override
	public int delete(int id) { // TODO Auto-generated method stub
		return appDAO.delete(id);

	}

}
