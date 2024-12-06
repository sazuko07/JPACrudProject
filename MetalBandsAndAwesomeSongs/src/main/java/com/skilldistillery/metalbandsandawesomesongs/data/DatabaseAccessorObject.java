package com.skilldistillery.metalbandsandawesomesongs.data;
import java.sql.SQLException;
import java.time.Year;
import java.util.List;

import com.skilldistillery.metalbandsandawesomesongs.entities.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/bandsdb";
	MetalBand newBand = new MetalBand();
	MetalBand findBand = new MetalBand();
	public DatabaseAccessorObject() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Transactional 
	public MetalBand enterNewBand(int id, String nameOfBand, Year yearFounded, String popularSong) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MetalBands");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(newBand);
		em.flush();
		em.getTransaction().commit();
		return newBand;
		
		
		
		
	}

	@Override
	public MetalBand findBandById(int Id) throws SQLException {
		
		return findBand;
	}
}