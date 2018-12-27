package com.Pshop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
	
	public static final String DRIVERNAME="com.mysql.jdbc.Driver";
	public static final String URL="jdbc:mysql://localhost:3306/dpshop?useUnicode=true&characterEncoding=UTF-8";
    public static final String USERNAME="root";
    public static final String PASSWORD="";


	public static Connection getConnection() {
		Connection con=null; 
    	try {
			Class.forName(DRIVERNAME);
			 con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (Exception e) {	
			e.printStackTrace();
		}
		return con;
    }
	
	public static void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) {
		try {
    		if(rs!=null) {  
    			rs.close();
    		}
		 if(ps!=null) {
			 ps.close();
		 }
		 if(conn!=null) {
			 conn.close();
		 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
