package com.nour.cours.entities;
import org.springframework.data.rest.core.config.Projection;


@Projection(name = "libCour", types = { Cours.class })
public interface CoursProjection {
	public  String getLibC();

	

}
