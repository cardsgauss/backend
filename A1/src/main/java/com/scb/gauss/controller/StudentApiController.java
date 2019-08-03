package com.scb.gauss.controller;

import java.awt.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scb.gauss.bean.Login;
import com.scb.gauss.service.LoginService;



@RestController
//
//@RequestMapping("student")
public class StudentApiController {

	
	
	
	
	@Autowired
	private LoginService logserv;

		
	@PostMapping("/student/login")
	public int login(@RequestBody Login a)
	{
		return logserv.verify(a);
	}
}
