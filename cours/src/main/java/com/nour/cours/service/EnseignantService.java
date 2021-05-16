package com.nour.cours.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nour.cours.entities.Enseignant;

public interface EnseignantService {
	Enseignant saveEnseignant(Enseignant p);
	Enseignant updateEnseignant(Enseignant p);
	void deleteEnseignant(Enseignant p);
	 void deleteEnseignantById(Long id);
	 Enseignant getEnseignant(Long id);
	List<Enseignant> getAllEnseignants();
	Page<Enseignant> getAllEnseignantsParPage(int page, int size);


}
