package com.retaillite.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import org.apache.commons.dbcp.BasicDataSource;

public class TestDBConn {

	private static BasicDataSource dataSource = null;
	private Connection con= null;
	DbConn db;
	public TestDBConn()
	{
		DbConn db = new DbConn();
		try
		{
			dataSource =db.getDataSource();
		}catch(Exception e)
		{
			
		}
	}
	
	public void test()
	{
		ResultSet rs = null;
		Statement stmt = null;
		try {
			con =dataSource.getConnection();
			//db.printDataSourceStats(dataSource);
			stmt=con.createStatement();
			String Query = "select getdate()";
			rs = stmt.executeQuery(Query);
			while(rs.next())
			System.out.println("HIIII"+rs.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) {};
			try { if (stmt != null) stmt.close(); } catch (SQLException e) {};
			try { if (con != null) con.close(); } catch (SQLException e) {};
			}
		//db.printDataSourceStats(dataSource);
	}
	
	public static void main(String s[])
	{
		TestDBConn t = new TestDBConn();
		t.test();
		System.out.println("Success");
		
	}
}
