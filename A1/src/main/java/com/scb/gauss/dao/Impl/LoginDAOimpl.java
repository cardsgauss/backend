package com.scb.gauss.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.scb.gauss.bean.Login;
import com.scb.gauss.dao.LoginDAO;

@Repository
public class LoginDAOimpl implements LoginDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	class Usermapper implements RowMapper<Login>
	{
	@Override
	public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
		Login user = new Login();
		
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));			
		return user;
	}
	}
	
	@Override
	public int login(Login a) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM login WHERE username=? AND password=?";
		try {
			jdbcTemplate.queryForObject(query, new Object[] { a.getUsername(), a.getPassword() }, new Usermapper());
			/*System.out.println("here");
			System.out.println(jdbcTemplate.queryForObject(query, new Object[] { loginDetails.getUsername(), loginDetails.getPassword() }, new UserMapper()).getUserId());
			System.out.println(loggedUserId);
			return loggedUserId;*/
			return 1;
		} catch (EmptyResultDataAccessException e) {
			
			e.printStackTrace();
			return 0;
		}
		
		
	}
	
}
