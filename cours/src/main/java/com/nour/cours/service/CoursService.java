package com.nour.cours.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.nour.cours.entities.Cours;
import com.nour.cours.entities.Enseignant;

public interface CoursService {
	
		Cours saveCours(Cours p);
		Cours updateCours(Cours p);
		void deleteCours(Cours p);
		 void deleteCoursById(Long id);
		 Cours getCours(Long id);
		List<Cours> getAllCours();
		
		List<Cours> findBylibC(String libC);
		List<Cours> findBylibCContains(String nom); 
		List<Cours> findByduree(String nom, int dure);
		List<Cours> findByEnseignant (Enseignant enseignant);
		
		List<Cours> findByEnseignantNumE(Long id);
	    
		
		List<Cours> findByOrderByLibCAsc();
		List<Cours> trierCoursDuree ();
		
		Page<Cours> getAllCoursParPage(int page, int size);



}



