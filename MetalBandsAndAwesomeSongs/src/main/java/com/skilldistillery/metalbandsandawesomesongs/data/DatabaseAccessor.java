package com.skilldistillery.metalbandsandawesomesongs.data;
import java.sql.SQLException;
import java.time.Year;
import java.util.List;

import com.skilldistillery.metalbandsandawesomesongs.entities.*;

public interface DatabaseAccessor  {
	public MetalBand findBandById(int Id) throws SQLException;
	public MetalBand addNewBand(MetalBand metalBand);
	public boolean deleteMetalBand(int id);
	public MetalBand changeBandInfo(MetalBand metalBand);
}
