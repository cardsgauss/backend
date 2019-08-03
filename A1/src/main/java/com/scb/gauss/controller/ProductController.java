package com.scb.gauss.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scb.gauss.bean.Product;
import com.scb.gauss.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService prodService;
	@GetMapping("/")
	private Collection<Product> list() {
		return prodService.list();
	}
}
