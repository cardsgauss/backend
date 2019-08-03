package com.scb.gauss.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.gauss.bean.Product;

import com.scb.gauss.dao.ProductDAO;
import com.scb.gauss.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDAO prodDAO;
@Override
	public List<Product> list()
	{
		return prodDAO.list();
	}
	
}
