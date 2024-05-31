package com.jdbc;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class StoredProcedure {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adv","root","root");
            CallableStatement st=con.prepareCall("{call  department(?,?)}");
            st.setInt(1,sc.nextInt());
            st.registerOutParameter(2,Types.INTEGER);
            st.execute();
            int out=st.getInt(2);
            System.out.println(out);
		} 
		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
