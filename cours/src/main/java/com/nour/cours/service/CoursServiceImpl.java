package com.nour.cours.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nour.cours.entities.Cours;
import com.nour.cours.entities.Enseignant;
import com.nour.cours.repos.CoursRepository;

@Service
public class CoursServiceImpl implements CoursService {
	

	@Autowired
	CoursRepository CoursRepository;
	@Override
	public Cours saveCours(Cours p) {
	return CoursRepository.save(p);
	}
	@Override
	public Cours updateCours(Cours p) {
	return CoursRepository.save(p);
	}
	@Override
	public void deleteCours(Cours p) {
		CoursRepository.delete(p);
	}
	 @Override
	public void deleteCoursById(Long id) {
		 CoursRepository.deleteById(id);
	}
	@Override
	public Cours getCours(Long id) {
	return CoursRepository.findById(id).get();
	}
	@Override
	public List<Cours> getAllCours() {
	return CoursRepository.findAll();
	}
	
	
	@Override
	public Page<Cours> getAllCoursParPage(int page, int size) {
	return CoursRepository.findAll(PageRequest.of(page, size));
	}
	
	
	@Override
	public List<Cours> findBylibC(String libC) {
		
		return CoursRepository.findBylibC(libC);
	}
	@Override
	public List<Cours> findBylibCContains(String nom) {
		
		return CoursRepository.findBylibCContains(nom) ;
	}
	@Override
	public List<Cours> findByduree(String nom, int dure) {
		
		return CoursRepository.findByduree(nom, dure);
	}
	@Override
	public List<Cours> findByEnseignant(Enseignant enseignant) {
		
		return CoursRepository.findByEnseignant(enseignant);
	}
	@Override
	public List<Cours> findByEnseignantNumE(Long id) {
		
		return CoursRepository.findByEnseignantNumE(id);
	}
	@Override
	public List<Cours> findByOrderByLibCAsc() {
	
		return CoursRepository.findByOrderByLibCAsc();
	}
	@Override
	public List<Cours> trierCoursDuree() {
		
		return CoursRepository.trierCoursDuree();
	}


}
