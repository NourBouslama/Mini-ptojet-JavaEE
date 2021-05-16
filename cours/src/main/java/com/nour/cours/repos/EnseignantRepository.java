package com.nour.cours.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nour.cours.entities.Enseignant;
public interface EnseignantRepository  extends JpaRepository<Enseignant, Long> {

}

