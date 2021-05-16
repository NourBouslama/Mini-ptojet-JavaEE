package com.nour.cours.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Enseignant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numE;
	private String prenom;
	private String nom;
	private Long telf;
	
	@JsonIgnore
	@OneToMany(mappedBy = "enseignant")
	private List<Cours> cours;
	
	//public Enseignant(){}
	
	
    public Enseignant(String prenom, String nom, Long telf, List<Cours> cours) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.telf = telf;
		this.cours = cours;
	}


	@Override
	public String toString() {
		return "Enseignant [numE=" + numE + ", prenom=" + prenom + ", nom=" + nom + ", telf=" + telf + ", cours="
				+ cours + "]";
	}

	public Long getNumE() {
		return numE;
	}

	public void setNumE(Long numE) {
		this.numE = numE;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Long getTelf() {
		return telf;
	}

	public void setTelf(Long telf) {
		this.telf = telf;
	}

	public List<Cours> getCours() {
		return cours;
	}

	public void setCours(List<Cours> cours) {
		this.cours = cours;
	}
	
	

	
	

}
