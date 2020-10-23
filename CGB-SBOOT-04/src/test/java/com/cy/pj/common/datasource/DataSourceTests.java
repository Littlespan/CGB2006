package com.cy.pj.common.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataSourceTests {

	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testGetConnection() throws SQLException {
		Connection conn = dataSource.getConnection();
		String sql="select * from tb_goods";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2)+"\t" + rs.getString(3) + "\t" + rs.getDate(4));
		}
		System.out.println(conn);
	}
	
}
