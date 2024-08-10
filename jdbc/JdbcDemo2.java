package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcDemo2 {

	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//step2
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		Statement st=con.createStatement();
		/*
		PreparedStatement pst=con.prepareStatement("insert into plan values(?,?)");
		System.out.println("enter 3 plan records , id,name");
		Scanner sc= new Scanner(System.in);
		for(int i=1;i<=3;i++) {
			pst.setInt(1, sc.nextInt());
			pst.setString(2, sc.next());
			pst.execute();
		}
		*/
		ResultSet rs=st.executeQuery("select * from plan ");
		ResultSetMetaData rsmd=rs.getMetaData();
		System.out.println(rsmd.getColumnCount());
		for(int i=1;i<=rsmd.getColumnCount();i++)
			System.out.print(rsmd.getColumnName(i)+"  ");
		System.out.println();
		System.out.println("=============================");
		while(rs.next()) {
			System.out.println(rs.getString(1)+"  "+rs.getString(2));
		}
		
		PreparedStatement pst=con.prepareStatement("update plan set name=? where pid=?");
		System.out.println("enter id for which name to update");
		Scanner sc= new Scanner(System.in);
		int id=sc.nextInt();
		String newName=sc.next();
		pst.setString(1, newName);
		pst.setInt(2, id);
		pst.execute();
		System.out.println(" after update ");
		PreparedStatement pst3=con.prepareStatement("delete from plan where pid=?");
		System.out.println("enter id  to delete");
		int id3=sc.nextInt();
		pst.setInt(1, id3);
		pst.execute();
		System.out.println(" after delete ");
		PreparedStatement pst2=con.prepareStatement("select * from plan where pid<?");
		System.out.println("enter id  to be displayed");
		int id1=sc.nextInt();
		pst2.setInt(1, id1);
		ResultSet rs1=pst2.executeQuery();
		System.out.println("=============================");
		while(rs1.next()) {
			System.out.println(rs1.getString(1)+"  "+rs1.getString(2));
		}
	}
}
