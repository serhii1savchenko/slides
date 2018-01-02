package com.savchenko.slides.DAO;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class PresentationDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String SQL_INSERT = "INSERT INTO presentations (folderName, numberOfSlides) VALUES (?, ?)";
	
	public void insertData(String folderName, int n) {
		Connection conn = null;
	try {
		conn = jdbcTemplate.getDataSource().getConnection();
		PreparedStatement ps = conn.prepareStatement(SQL_INSERT);
		ps.setString(1, folderName);
		ps.setInt(2, n);
		ps.executeUpdate();
		ps.close();
	} catch (SQLException e) {
		throw new RuntimeException(e);
	} finally {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}
	}
		
}
