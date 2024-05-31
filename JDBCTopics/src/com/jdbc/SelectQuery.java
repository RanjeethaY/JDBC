package com.jdbc;

import java.sql.*;

public class SelectQuery {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet r=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adv","root","root");
			st=con.createStatement();
		r=st.executeQuery("select * from adv.stu");
			while(r.next()) {
				System.out.println(r.getInt(1)+" "+r.getString(2)+" "+r.getInt(3)+" "+r.getString(4));
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeResources(con, st, r);
		}

	}

	public static void closeResources(Connection con, Statement st, ResultSet r) {
		if(r!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(st!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
