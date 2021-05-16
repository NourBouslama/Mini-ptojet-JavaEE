package com.nour.cours.repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nour.cours.entities.Cours;
import com.nour.cours.entities.Enseignant;

@RepositoryRestResource(path = "rest")
public interface CoursRepository  extends JpaRepository<Cours,Long>{
	List<Cours> findBylibC(String libC);
	List<Cours> findBylibCContains(String nom); 
	
	
	@Query("select p from Cours p where p.libC like %:nom and p.duree > :dure")
	List<Cours> findByduree(@Param("nom") String nom,@Param("dure") int dure);
    
	@Query("select p from Cours p where p.enseignant = ?1")
	List<Cours> findByEnseignant (Enseignant enseignant);
	
	List<Cours> findByEnseignantNumE(Long id);
    
	
	List<Cours> findByOrderByLibCAsc();
	
	@Query("select p from Cours p order by p.libC ASC, p.duree DESC")
	List<Cours> trierCoursDuree ();




}
