package com.nour.cours.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.nour.cours.entities.Cours;
import com.nour.cours.service.CoursService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class CoursRESTController {
	@Autowired
	CoursService coursService;
	@RequestMapping(method = RequestMethod.GET)
	public List<Cours> getAllProduits() {
	return coursService.getAllCours();
	}
    
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Cours getCoursById(@PathVariable("id") Long id) {
	return coursService.getCours(id);
	 }
	
	@RequestMapping(method = RequestMethod.POST)
	public Cours createCours(@RequestBody Cours cours) {
	return coursService.saveCours(cours);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Cours updateCours(@RequestBody Cours cours) {
	return coursService.updateCours(cours);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteCours(@PathVariable("id") Long id)
	{
		coursService.deleteCoursById(id);
	}
	
	@RequestMapping(value="/coursEns/{numE}",method = RequestMethod.GET)
	public List<Cours> getCoursByCatId(@PathVariable("numE") Long numE) {
	return coursService.findByEnseignantNumE(numE);
	}

}
