package com.skilldistillery.bootformbaas.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.metalbandsandawesomesongs.entities.MetalBand;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Service
public class MetalDAOImpl implements MetalDAO {
	@PersistenceContext
	private EntityManager em;
	
	MetalBand newBand = new MetalBand();
	MetalBand findBand = new MetalBand();

	public void DatabaseAccessorObject() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MetalBand> allMetalBands() {

		List<MetalBand> metalBands = new ArrayList<>();
		String jpql = "SELECT metalBands FROM MetalBand metalBands";
		metalBands = em.createQuery(jpql, MetalBand.class).getResultList();
		return metalBands;
	}

	@Override
	public MetalBand addNewBand(MetalBand metalBand) {
		
		em.persist(metalBand);
		newBand = em.find(MetalBand.class, metalBand.getId());
		return newBand;

	}

	@Override
	public MetalBand findBandById(int id) {

		MetalBand metalBand = em.find(MetalBand.class, id);

		em.close();
		return metalBand;
	}

	@Override
	public boolean deleteMetalBand(int id) {

		boolean wasDeleted = false;

		MetalBand metalBand = em.find(MetalBand.class, id);
		if (metalBand != null) {
			em.remove(metalBand);
			wasDeleted = true;
		}
		wasDeleted = !em.contains(metalBand);
		return wasDeleted;
	}

	@Override
	public MetalBand updateBandInfo(MetalBand metalBand, int id) {

		newBand = null;
		String jpql = "UPDATE MetalBands metalBand " + "SET MetalBands.nameofband = :nameofband "
				+ "  MetalBands.yearfounded = :yearfounded " + " MetalBands.popularsong = :popularsong";

		if (id > 0 || metalBand.getId() == 0) {
			metalBand.setId(id);
		}
		MetalBand originalBand = em.find(MetalBand.class, metalBand.getId());

		if (metalBand.getNameOfBand() == null) {
			metalBand.setNameOfBand(originalBand.getNameOfBand());
		}
		if (metalBand.getYearFounded() == 0) {
			metalBand.setYearFounded(originalBand.getYearFounded());
		}
		if (metalBand.getPopularSong() == null) {
			metalBand.setPopularSong(originalBand.getPopularSong());
		}

		int updateColumns = em.createQuery(jpql).setParameter("nameOfBand", metalBand.getNameOfBand())
				.setParameter("yearFounded", metalBand.getYearFounded())
				.setParameter("popularSong", metalBand.getPopularSong()).executeUpdate();

		if (updateColumns > 0) {
			return metalBand;
		} else {
			return newBand;
		}

	}

}
