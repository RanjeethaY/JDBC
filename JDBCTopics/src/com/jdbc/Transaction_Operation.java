package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Transaction_Operation {
static Connection con=null;
static PreparedStatement st=null;
static String query="update adv.dept set salary=salary+? where name=? ";

public static int balance(String name,int amt) throws SQLException {
	con.setAutoCommit(false);
	st=con.prepareStatement(query);
	st.setInt(1,amt);
	st.setString(2,name);
    return	st.executeUpdate();
}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the  sender name ");
		String s=sc.next();
		System.out.println("enter the  sender name ");
		String r=sc.next();
		System.out.println("enter the  amount ");
		int amt=sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adv","root","root");
					int sent=balance(s,-amt);
	                int recieved=balance(r,amt);
	if(sent==1 && recieved==1) {
		con.commit();
		System.out.println("Transaction done sucessfully");
	}
	else {
		con.rollback();
	}	
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		

	}

}
