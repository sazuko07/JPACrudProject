package com.skilldistillery.metalbandsandawesomesongs.data;
import java.sql.SQLException;
import java.time.Year;

import com.skilldistillery.metalbandsandawesomesongs.entities.*;

public interface DatabaseAccessor {
	public MetalBand findBandById(int Id) throws SQLException;
	public MetalBand enterNewBand(int id, String nameOfBand, Year yearFounded, String popularSong);
}
