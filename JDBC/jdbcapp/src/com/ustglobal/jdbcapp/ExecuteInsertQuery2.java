package com.ustglobal.jdbcapp;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class ExecuteInsertQuery2 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		FileReader reader = null;

		try {
			reader = new FileReader("db.properties");
			Properties prop = new Properties();
			prop.load(reader);
			
			Class.forName(prop.getProperty("driver-class-name"));
			
			String url = prop.getProperty("url");
			con = DriverManager.getConnection(url, prop);
			
			// Step 3 : Issue the SQL query
			String sql = prop.getProperty("insert-query1");
			pstmt = con.prepareStatement(sql);
			String eid = args[0];
			int id = Integer.parseInt(eid);
			pstmt.setInt(1, id);
			
			String name = args[1];
			pstmt.setString(2, name);
			
			String esal = args[2];
			int sal = Integer.parseInt(esal);
			pstmt.setInt(3, sal);
			
			String gender = args[3];
			pstmt.setString(4, gender);
			
			int count = pstmt.executeUpdate();
			
			// Step 4 : Read the Result 

			System.out.println(count+ " Row(s) inserted");

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			// Step 5 : Close all the JDBC Objects
			try {
				if(con!=null) {
					con.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
