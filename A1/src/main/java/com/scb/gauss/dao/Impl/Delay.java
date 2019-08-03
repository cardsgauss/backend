






package com.scb.gauss.dao.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class Delay {
	@Autowired
	private JdbcTemplate jdbcTemplate;
       

       Timer timer;
       static Connection con = null;
       static PreparedStatement p=null;
       String[] options = { "Declined", "approved" };

       public Delay(int seconds) {
             timer = new Timer();
             timer.schedule(new RemindTask(), seconds * 1000);
       }

       class RemindTask extends TimerTask {
             public void run() {
                    String query = "Update INTO customers(sup_verification) values(?) where id=1";

                    int index = (int) (Math.random() * 2);
                    System.out.println(options[index]);
                    try {
                          exec(query,index);
                    } catch (ClassNotFoundException e) {
                          // TODO Auto-generated catch block
                          e.printStackTrace();
                    }    
                    System.out.println(options[index]);

                    timer.cancel();
             }
       }
       
       void exec(String sql,int ind) throws ClassNotFoundException
       {

             try {
//                    Class.forName("org.postgresql.Driver");
//                    con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            	 jdbcTemplate.update(sql,options[ind]);
                    //System.out.println(options);
//                    p.setString(1, options[ind]);
//                    p.execute();
            	 
                    System.out.println("Inserted Successfully");
             } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    System.out.println("Hello");
             }
       }

//       public static void main(String args[]) {
//             
//             System.out.println("pending.....");
//             new Delay(7);
//       }

}

