package com.savchenko.slides.DAO;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class PresentationDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT = "INSERT INTO presentations (folderName, numberOfSlides) VALUES (?, ?)";
	private final String SQL_GET_NUMBER_OF_SLIDES = "SELECT numberOfSlides FROM presentations WHERE folderName = ? LIMIT 1";
	
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

	public int getNumberOfSlidesByFolderName(String folderName) {
		int result = 0;
		Connection conn = null;
		try {
			conn = jdbcTemplate.getDataSource().getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_GET_NUMBER_OF_SLIDES);
			ps.setString(1, folderName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				result = rs.getInt("numberOfSlides");
			}
			rs.close();
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
		System.out.println(result);
		return result;
	}

}
