package com.nour.cours.entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;



@Entity
public class Cours {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numC;
	@NotNull
	@Size (min = 3,max = 30)

	private String libC;
	@Min(value = 1)
	 @Max(value = 5)

	private int duree;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateC;
	
	@ManyToOne
	private Enseignant enseignant;
	
	public Cours() {
		super();
		
	}
	
	public Cours( String libC, int duree, Date dateC) {
		
		
		this.libC = libC;
		this.duree = duree;
		this.dateC = dateC;
	}

	public Long getNumC() {
		return numC;
	}
	public void setNumC(Long numC) {
		this.numC = numC;
	}
	public String getLibC() {
		return libC;
	}
	public void setLibC(String libC) {
		this.libC = libC;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public Date getDateC() {
		return dateC;
	}
	public void setDateC(Date dateC) {
		this.dateC = dateC;
	}
	

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	@Override
	public String toString() {
		return "Cours [numC=" + numC + ", libC=" + libC + ", duree=" + duree + ", dateC=" + dateC + "]";
	}
	

	
	


}
