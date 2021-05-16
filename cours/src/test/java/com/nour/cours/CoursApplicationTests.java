package com.nour.cours;


import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.nour.cours.entities.Cours;
import com.nour.cours.entities.Enseignant;
import com.nour.cours.repos.CoursRepository;
import com.nour.cours.service.CoursService;


@SpringBootTest
class CoursApplicationTests {
	@Autowired
	private CoursRepository coursRepository;
	@Autowired
	private CoursService coursService;


	@Test
	void testCreateCours() {
		//Cours cour = new Cours(1,"Francais",2,new Date());
		Cours cour = new Cours("java",2,new Date());
		coursRepository.save(cour);

	}
	 @Test
	 public void testFindCours()
	 {
		 
	 Cours p = coursRepository.findById(1L).get();
	 System.out.println(p);
	 }
	 
	 @Test
	 public void testUpdateCours()
	 {
	 Cours p = coursRepository.findById(1L).get();
	 p.setDuree(2);
	 coursRepository.save(p);
	 }
	 
	 @Test
	 public void testDeleteCours()
	 {
		 coursRepository.deleteById(1L);;
		 }
	 
		  
		 @Test
		 public void testListerTousCours()
		 {
		 List<Cours> prods = coursRepository.findAll();
		 for (Cours p : prods)
		 {
		 System.out.println(p);
		 }
		 }
		 
		 @Test
		 public void testFindByNomCourstContains()
		 {
		 Page<Cours> prods = coursService.getAllCoursParPage(0,2);
		 System.out.println(prods.getSize());
		 System.out.println(prods.getTotalElements());
		 System.out.println(prods.getTotalPages());
		 prods.getContent().forEach(p -> {System.out.println(p.toString());
		  });
		 /*ou bien
		 for (Produit p : prods)
		 {
		 System.out.println(p);
		 } */
		 }
		 
		 @Test
		 public void testFindBylibC()
		 {
		 List<Cours> prods = coursRepository.findBylibC("maths");
		 for (Cours p : prods)
		 {
		 System.out.println(p);
		 }
		 }
		 
		 
		 @Test
		 public void testFindBylibCContains ()
		 {
		 List<Cours> prods=coursRepository.findBylibCContains("maths");
		 for (Cours p : prods)
		 {
		 System.out.println(p);
		 } }
		 
		 @Test
		 public void testfindByduree()
		 {
		 List<Cours> prods = coursRepository.findByduree("bd", 1);
		 for (Cours p : prods)
		 {
		 System.out.println(p);
		 }
		 }
		 
		 @Test
		 public void testfindByEnseignant()
		 {
		 Enseignant cat = new Enseignant();
		 cat.setNumE(1L);
		 List<Cours> prods = coursRepository.findByEnseignant(cat);
		 for (Cours p : prods)
		 {
		 System.out.println(p);
		 }
		 }
		 
		 @Test
		 public void findByCategorieIdCat()
		 {
		 List<Cours> prods = coursRepository.findByEnseignantNumE(1L);
		 for (Cours p : prods)
		 {
		 System.out.println(p);
		 }
		  }
        
		 @Test
		 public void testfindByOrderByNomProduitAsc()
		 {
		 List<Cours> prods = 
				 coursRepository.findByOrderByLibCAsc();
		 for (Cours p : prods)
		 {
		 System.out.println(p);
		 }
		 }
		 
		 @Test
		 public void testTrierProduitsNomsPrix()
		 {
		 List<Cours> prods = coursRepository.trierCoursDuree();
		 for (Cours p : prods)
		 {
		 System.out.println(p);
		 }
		 }



}
