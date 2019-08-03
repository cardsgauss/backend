package com.scb.gauss.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scb.gauss.bean.Application;
import com.scb.gauss.bean.Customer;
import com.scb.gauss.service.ApplicationService;
//import com.scb.gauss.service.ApplicationService;

@RestController
@RequestMapping("/app")
public class ApplicationController {

	@Autowired
	private ApplicationService appService;

	static {
		System.out.println("In Controller");
	}

	/* Adding a resource */
	@PostMapping("/add")
	private int add(@RequestBody Customer a) {

		return appService.add(a);
	}

	@GetMapping("/")
	private Collection<Application> list() {
		return appService.list();
	}

	@DeleteMapping("/delete/{id}")
	private int del(@PathVariable int id) {
		return appService.delete(id);
	}

	static {
		System.out.println("In Controller");
	}

}
