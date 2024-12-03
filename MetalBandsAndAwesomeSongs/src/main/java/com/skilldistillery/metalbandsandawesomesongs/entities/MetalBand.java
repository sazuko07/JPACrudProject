package com.skilldistillery.metalbandsandawesomesongs.entities;

import java.time.Year;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class MetalBand {
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Name_Of_Band")
	private String nameOfBand;
	
	@Column(name="Year_Founded") 
	private Year yearFounded;
	
	@Column(name="Popular_Song")
	private String popularSong;
	
	@Override
	public String toString() {
		return "MetalBands [id=" + id + ", nameOfBand=" + nameOfBand + ", yearFounded=" + yearFounded + ", popularSong="
				+ popularSong + "]";
	}

	public MetalBand() {
		super();
	}
	

	public MetalBand(int id, String nameOfBand, Year yearFounded, String popularSong) {
		super();
		this.id = id;
		this.nameOfBand = nameOfBand;
		this.yearFounded = yearFounded;
		this.popularSong = popularSong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nameOfBand, popularSong, yearFounded);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MetalBand other = (MetalBand) obj;
		return id == other.id && Objects.equals(nameOfBand, other.nameOfBand)
				&& Objects.equals(popularSong, other.popularSong) && Objects.equals(yearFounded, other.yearFounded);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameOfBand() {
		return nameOfBand;
	}

	public void setNameOfBand(String nameOfBand) {
		this.nameOfBand = nameOfBand;
	}

	public Year getYearFounded() {
		return yearFounded;
	}

	public void setYearFounded(Year yearFounded) {
		this.yearFounded = yearFounded;
	}

	public String getPopularSong() {
		return popularSong;
	}

	public void setPopularSong(String popularSong) {
		this.popularSong = popularSong;
	}


}
