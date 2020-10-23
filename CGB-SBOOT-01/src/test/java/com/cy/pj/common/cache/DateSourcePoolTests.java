package com.cy.pj.common.cache;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DateSourcePoolTests {
	@Autowired
	private DataSource datasource;
	
	@Test
	public void testConnection() throws SQLException {
		Connection connection = datasource.getConnection();
		String sql = "select * from tb_goods";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		ResultSet rs = prepareStatement.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t" + rs.getString(2) +"\t" + rs.getString(3) + "\t" + rs.getDate(4));
		}
	}
}
