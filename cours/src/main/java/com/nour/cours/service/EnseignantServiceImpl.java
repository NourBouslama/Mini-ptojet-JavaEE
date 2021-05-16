package com.nour.cours.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


import com.nour.cours.entities.Enseignant;
import com.nour.cours.repos.EnseignantRepository;


@Service
public class EnseignantServiceImpl implements EnseignantService {
	
	@Autowired
	EnseignantRepository enseignantRepository;

	@Override
	public Enseignant saveEnseignant(Enseignant p) {
		
		return enseignantRepository.save(p);
	}

	@Override
	public Enseignant updateEnseignant(Enseignant p) {
		
		return enseignantRepository.save(p);
	}

	@Override
	public void deleteEnseignant(Enseignant p) {
		
		enseignantRepository.delete(p);
		
	}

	@Override
	public void deleteEnseignantById(Long id) {
		enseignantRepository.deleteById(id);
		
	}

	@Override
	public Enseignant getEnseignant(Long id) {
		
		return enseignantRepository.findById(id).get();
	}

	@Override
	public List<Enseignant> getAllEnseignants() {
		
		return enseignantRepository.findAll();
	}
	
	@Override
	public Page<Enseignant> getAllEnseignantsParPage(int page, int size) {
	return enseignantRepository.findAll(PageRequest.of(page, size));
	}


	

}
