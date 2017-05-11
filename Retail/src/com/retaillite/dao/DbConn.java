package com.retaillite.dao;

import java.io.IOException;
import java.util.ResourceBundle;

import org.apache.commons.dbcp.BasicDataSource;

public class DbConn {
	private final int MaxConnection = 8;
	private final int MinConnection = 2;
	BasicDataSource bds = null;

	public BasicDataSource getDataSource() throws IOException {
		ResourceBundle rs = ResourceBundle.getBundle("com.retaillite.resources.DbConn");
		bds = new BasicDataSource();
		bds.setDriverClassName(rs.getString("Driver"));
		bds.setUrl(rs.getString("URL"));
		bds.setUsername(rs.getString("User"));
		bds.setPassword(rs.getString("Password"));
		bds.setMaxIdle(MaxConnection);
		bds.setMinIdle(MinConnection);
		return bds;
	}

	public void printDataSourceStats(BasicDataSource ds) {
		BasicDataSource bds1 = ds;
		System.out.println("NumActive: " + bds1.getNumActive());
		System.out.println("NumIdle: " + bds1.getNumIdle());
	}

}
