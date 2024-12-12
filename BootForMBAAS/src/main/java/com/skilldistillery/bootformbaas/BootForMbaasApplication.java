package com.skilldistillery.bootformbaas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.skilldistillery.metalbandsandawesomesongs")
public class BootForMbaasApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootForMbaasApplication.class, args);
	}

}
