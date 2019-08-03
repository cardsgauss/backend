package com.scb.gauss.dao.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.scb.gauss.bean.Application;
import com.scb.gauss.bean.Customer;
import com.scb.gauss.dao.ApplicationDAO;
//import com.scb.gauss.dao.Impl.ApplicationDAOimpl.ApplicationMapper;

@Repository
public class ApplicationDAOImpl implements ApplicationDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	static {
		System.out.println("In dao");
	}

	@Override
	public int add(Customer application) {

		String query = "INSERT INTO applications(app_name,id) VALUES(?,?) where aadhaar=?";
		return jdbcTemplate.update(query,
				new Object[] { application.getName(), application.getId(), application.getAadhaar() });
	}

	@Override
	public List<Application> list() {
		String query = "SELECT * FROM applications";
		return jdbcTemplate.query(query, new ApplicationMapper());

	}

	public int delete(int id) {

		String query = "DELETE FROM applications WHERE id = ?";
		int row = jdbcTemplate.update(query, id);

		return row;

	}

	class ApplicationMapper implements RowMapper<Application> {

		public Application mapRow(ResultSet rs, int rowNum) throws SQLException {
			Application application = new Application();
			application.setAppId(rs.getInt("app_id"));
			application.setId(rs.getInt("id"));
			application.setAppName(rs.getString("app_name"));
			application.setStatus(rs.getString("app_status"));
			application.setHandledBy(rs.getString("app_handledby"));
			application.setAge(rs.getInt("app_age"));
			return application;
		}

	}

//public void create(int id,String name)
//{
//	String query = "INSERT INTO applications(app_id,app_name) VALUES(?,?)";
//	re jdbcTemplate.update(query, new Object[]{id,name
//	});
//	
//}

}
