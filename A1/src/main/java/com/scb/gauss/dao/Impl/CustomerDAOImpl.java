package com.scb.gauss.dao.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.scb.gauss.bean.Customer;
import com.scb.gauss.dao.ApplicationDAO;
import com.scb.gauss.dao.CustomerDAO;
import com.scb.gauss.dao.Impl.CustomerDAOImpl.Delay;
import com.scb.gauss.dao.Impl.CustomerDAOImpl.Delay.RemindTask;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private ApplicationDAO appdao;

	static {
		System.out.println("In dao");
	}

	@Override
	public int add(Customer customer) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO customers(email,name,mobile,product,aadhaar,address,income,profile,ran) VALUES(?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(query,
				new Object[] { customer.getEmail(), customer.getName(), customer.getMobile(), customer.getProduct(),
						customer.getAadhaar(), customer.getAddress(), customer.getIncome(), customer.getProfile(),
						ThreadLocalRandom.current().nextInt(500, 900) });
//		int id=gettid(customer.getAadhaar());
//		appdao.create(id,customer.getName());
		String query1 = "INSERT INTO applications(app_name,id) select name,id from customers where aadhaar=?";
		//String query1= "INSERT INTO applications(app_name,id) select name=? from customers where aadhaar=?";
		jdbcTemplate.update(query1, new Object[] { customer.getAadhaar() });
		String query2 = "INSERT INTO products(name,id,prod_type) select name,id,product from customers where aadhaar=?";//String query1= "INSERT INTO applications(app_name,id) select name=? from customers where aadhaar=?";
		jdbcTemplate.update(query2, new Object[] { customer.getAadhaar() });
		return 1;
	}

	@Override
	public int appeal(Customer customer) {
		String query = "UPDATE customers SET reason=? WHERE id=?";
		int row = jdbcTemplate.update(query, customer.getReason(), customer.getId());

		return row;
	}

	@Override
	public List<Customer> list() {
		String query = "SELECT * FROM customers";
		return jdbcTemplate.query(query, new CustomerMapper());

	}

	class CustomerMapper implements RowMapper<Customer> {

		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer customer = new Customer();
			customer.setId(rs.getInt("id"));
			customer.setEmail(rs.getString("email"));
			customer.setName(rs.getString("name"));
			customer.setMobile(rs.getString("mobile"));
			customer.setProduct(rs.getString("product"));
			customer.setAadhaar(rs.getLong("aadhaar"));
			customer.setAddress(rs.getString("address"));
			customer.setIncome(rs.getString("income"));
			customer.setProfile(rs.getString("profile"));
			customer.setReason(rs.getString("reason"));
			customer.setStatus(rs.getString("status"));
			customer.setScore(rs.getInt("ran"));
			customer.setSup_verification(rs.getString("sup_verification"));

			return customer;
		}

	}

	@Override
	public int delete(int id) {
		String query = "DELETE FROM customers WHERE ID = ?";
		int row = jdbcTemplate.update(query, id);

		return row;
	}

	@Override
	public Customer get(int id) {
		String query = "SELECT * FROM customers WHERE ID = ?";
		return jdbcTemplate.queryForObject(query, new Object[] { id }, new CustomerMapper());
	}

	@Override
	public int update(Customer customer) {
		String query = "UPDATE customers SET name = ?,email = ? ,mobile= ?,product= ?,aadhaar= ?,address= ?,income=? WHERE id=?";
		int row = jdbcTemplate.update(query, customer.getName(), customer.getEmail(), customer.getMobile(),
				customer.getProduct(), customer.getAadhaar(), customer.getAddress(), customer.getIncome(),
				customer.getId());

		return row;
	}
//	@Override
//	public int update(Customer customer,int aadhaar) {
//		String query = "UPDATE customers SET name = ?,email = ? ,mobile= ?,product= ?,address= ?,income=? WHERE aadhaar=?";
//		int row = jdbcTemplate.update(query, customer.getName(), customer.getEmail(), customer.getMobile(), customer.getProduct(),  customer.getAddress(), customer.getIncome(), customer.getAadhaar());
//
//		return row;
//	}


	@Override
	public int isaadhar(long aadhar) {
		int id;
		String sql = "select id from customers where aadhaar=?";
		try {
			// id=jdbcTemplate.update(sql,aadhar);
			// return id;
			id = jdbcTemplate.queryForObject(sql, new Object[] { aadhar }, Integer.class);
//        	int id1=Integer.parseInt(id);
			return id;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}
//@Override
//public void status(Customer c) {
//	// TODO Auto-generated method stub
//	 new Delay(10, c);
//}

	@Override
	public void appealStatus(Customer c) {
		// TODO Auto-generated method stub
		new Delay(10,c,2);
	}

	@Override
	public void docStatus(Customer c) {
		// TODO Auto-generated method stub
		new Delay(10,c,1);

	}
	

	class Delay {
		Customer co;
		int opt;
		Timer timer;
		String[] options = { "Declined", "approved" };

		public Delay(int seconds, Customer c,int op) {
			timer = new Timer();
			co = c;
			opt=op;
			timer.schedule(new RemindTask(), seconds * 1000);
		}

		class RemindTask extends TimerTask {
			public void run() {
				String query = "Update customers SET name=? where id=?";
				String query1= "Update applications SET status=? where id=?";	
				int index = (int) (Math.random() * 2);
				try {
					
					if(opt==1)
					exec(query, index, co);
					if(opt==2)
					exec(query1,index,co);	
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(options[index]);

				timer.cancel();
			}
		}

		void exec(String sql, int ind, Customer co) throws ClassNotFoundException {

			try {
				jdbcTemplate.update(sql, options[ind],co.getId());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	
	

}
