package com.skilldistillery.bootformbaas.data;

import java.util.List;

import com.skilldistillery.metalbandsandawesomesongs.entities.MetalBand;

public interface MetalDAO {
	MetalBand updateBandInfo(MetalBand metalBand, int id);
	MetalBand findBandById(int id);
	MetalBand addNewBand(MetalBand metalBand);
	boolean deleteMetalBand(int id);
	List<MetalBand> allMetalBands();

	
}
