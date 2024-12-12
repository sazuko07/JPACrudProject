package com.skilldistillery.metalbandsandawesomesongs.entities;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import static org.junit.jupiter.api.Assertions.*;

public class MetalBandTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private MetalBand metalBand;
	
	
	@BeforeAll
	static void setupBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("MetalBands");
	}
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
		
	}
	
	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		metalBand = em.find(MetalBand.class, 1);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		em.close();
		metalBand = null;
		
	}

	@Test
	void test_MetalBands_mappings() {
		assertNotNull(metalBand);
		assertEquals(1999, metalBand.getYearFounded());
		
	}

}

