package com.nour.cours;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.nour.cours.entities.Cours;



@SpringBootApplication
public class CoursApplication implements CommandLineRunner{
	
	/*@Autowired
    CoursService coursService;*/
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(CoursApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	repositoryRestConfiguration.exposeIdsFor(Cours.class);
	}

/*	@Override
	public void run(String... args) throws Exception {
		coursService.saveCours(new Cours("bd", 1, new Date()));
		coursService.saveCours(new Cours("python", 3, new Date()));
		coursService.saveCours(new Cours("php", 2, new Date()));
	}*/


}
