package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchOpration {
	static String insertQuery="insert into adv.stu(`id`,`name`,`marks`,`dept`) values(?,?,?,?)";
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/adv";
		String un="root";
		String password="root";
		PreparedStatement st=null;
		int a[]=new int[100];
		System.out.println("insert the records");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,un,password);
			do {
			st = con.prepareStatement(insertQuery);
			st.setInt(1,sc.nextInt());
			st.setString(2,sc.next());
			st.setInt(3,sc.nextInt());
			st.setString(4,sc.next());
			st.executeBatch();
			st.addBatch();
			System.out.println("you want to insert one more record yes/no");
		} while(sc.next().equalsIgnoreCase("yes"));		
		a=st.executeBatch();
		for(int z:a) {
			System.out.println(z);
		}
		}
		catch (ClassNotFoundException | SQLException e) {		
			e.printStackTrace();
		}
	}

}
