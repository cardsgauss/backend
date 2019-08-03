package com.scb.gauss.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.scb.gauss.bean.Product;
import com.scb.gauss.dao.ProductDAO;

@Repository
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<Product> list(){
	
	String query = "SELECT * FROM products";
	return jdbcTemplate.query(query, new ProductMapper());
	}
	
		class ProductMapper implements RowMapper<Product> {

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setProd_type(rs.getString("prod_type"));
				
				return product;
			}

		}

	}

