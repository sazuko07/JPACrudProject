package com.skilldistillery.metalbandsandawesomesongs.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Year;
import java.util.List;

import com.skilldistillery.metalbandsandawesomesongs.entities.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost::3306/bandsdb";
	
	public DatabaseAccessorObject() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public MetalBand addNewBand(MetalBand metalBand ) {
		Connection conn = null;
		String name = "student";
		String pwd = "student";
		try {
			conn = DriverManager.getConnection(URL, name, pwd);
			conn.setAutoCommit(false);
			String sql = "INSERT INTO MetalBands (id, Name_Of_Band, Year_Founded, Popular_Song) VALUES (?,?,?,?) ";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, metalBand.getId());
			ps.setString(2, metalBand.getNameOfBand());
			ps.setInt(3, metalBand.getYearFounded());
			ps.setString(4, metalBand.getPopularSong());
			
			int updateCount = ps.executeUpdate();
			
			if(updateCount == 1) {
				ResultSet keys = ps.getGeneratedKeys();
				if (keys.next()) {
					int newBandId = keys.getInt(1);
					metalBand.setId(newBandId);
					System.out.println("You have successfully entered your band into the database!");
					conn.commit();
				} else {
						metalBand = null;
					}
					conn.close();
					}
				} catch (SQLException sqle) {
					sqle.printStackTrace();
					if (conn != null) {
						try {
							conn.rollback();
						} catch (SQLException sqle2) {
							System.err.println("Error trying to rollback");
						}
				}
			}
		return metalBand;
		
		
	}
	@Override
	public MetalBand findBandById(int Id) throws SQLException {
		
		return null;
	}
	@Override
	public boolean deleteMetalBand(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public MetalBand changeBandInfo(MetalBand metalBand) {
		// TODO Auto-generated method stub
		return null;
	}
}	