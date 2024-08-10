package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;
public class CallableStatementDemo {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//step2
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		CallableStatement cst=con.prepareCall("{ CALL square123(?,?) }");
		System.out.println("enter a number");
		Scanner sc= new Scanner(System.in);
		int a=sc.nextInt();
		cst.setInt(1,a);
		cst.registerOutParameter(2, Types.INTEGER);
		cst.execute();
		System.out.println("Result from db is :"+cst.getInt(2));
	}
}
/*
SQL> create or replace procedure square123(a in number,b out number) as
2  begin
3  b:=a*a;
4  end;
5  /
*/
