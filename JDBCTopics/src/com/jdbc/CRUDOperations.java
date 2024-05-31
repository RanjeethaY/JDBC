package com.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class CRUDOperations {
static String insertQuery="insert into adv.stu(`id`,`name`,`marks`,`dept`) values(?,?,?,?)";
static String updateQuery="update adv.stu set marks=? where id=?";
static String deleteQuery="delete from adv.stu where id=?";
static int res=0;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/adv";
		String userName="root";
		String password="root";
		Connection con=null;
		PreparedStatement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,userName,password);
			insert_Query(sc, con);
			update_Query(sc, con);
			delete_Query(sc, con);
			if(res==1) {
				System.out.println("Query executed Perfectly ");
			}
			else {
				System.out.println("Query not executed check once again while giving inputs try it!! ");
			}
		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			closing_Resouces(con, st);}
	}
	public static void closing_Resouces(Connection con, PreparedStatement st) {
		if(st!=null) {
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
if(con!=null) {
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	public static int delete_Query(Scanner sc, Connection con)  {
		PreparedStatement st;
		try {
			st=con.prepareStatement(deleteQuery);
			st.setInt(1,sc.nextInt());
			res=st.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	public static int update_Query(Scanner sc, Connection con)  {
		PreparedStatement st;
		try {
			st=con.prepareStatement(updateQuery);
			st.setInt(1,sc.nextInt());
			st.setInt(2,sc.nextInt());
			res=st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	public static int insert_Query(Scanner sc, Connection con) {
		PreparedStatement st;
		try {
			st=con.prepareStatement(insertQuery);
			st.setInt(1,sc.nextInt());
			st.setString(2,sc.next());
			st.setInt(3,sc.nextInt());
			st.setString(4,sc.next());
		res=st.executeUpdate();
		System.out.println(res);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}
