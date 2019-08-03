package com.scb.gauss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.scb.gauss.bean.Login;
import com.scb.gauss.dao.LoginDAO;
import com.scb.gauss.service.LoginService;

@Repository
public class LoginServiceimpl implements LoginService {

	
	@Autowired
	private LoginDAO logindao;
	
	
	@Override
	public int verify(Login a) {
	 return	logindao.login(a);
		
		
		
		
					
		
	}
	
	
	
	
	
	
  
}
