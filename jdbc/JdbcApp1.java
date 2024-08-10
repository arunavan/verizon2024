package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JdbcApp1 {
	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		
		//step1
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//step2
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		
		System.out.println("connection success");
		
		Statement st=con.createStatement();
		
		//st.executeUpdate("create table plan(pid number primary key,name varchar(20))");
		
		//System.out.println("table create..");
//dml,ddl
	//	st.executeUpdate(" insert into plan values(5,'Friend5')");
	//	st.executeUpdate(" insert into plan values(2,'Family')");
	//	st.executeUpdate(" insert into plan values(3,'Team')");
	//	st.execute("delete from plan where pid=2");
	//	st.execute("update plan  set name='orgplan' where pid=3");
		
		System.out.println("done..");
		//select
		ResultSet rs=st.executeQuery("select * from plan where pid<=3");
		while(rs.next()) {
			System.out.println(rs.getString(1)+"  "+rs.getString(2));
		}
	}

}
