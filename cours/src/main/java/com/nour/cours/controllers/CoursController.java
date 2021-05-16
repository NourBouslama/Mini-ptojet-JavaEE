package com.nour.cours.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.nour.cours.entities.Cours;
import com.nour.cours.entities.Enseignant;
import com.nour.cours.service.CoursService;

@Controller
public class CoursController {
	
	@Autowired
	CoursService coursService;
	
	
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
	modelMap.addAttribute("cours", new Cours());
	modelMap.addAttribute("mode", "new");
	return "formCours";
	}
	
	
	
	
	
	
	
	@RequestMapping("/saveCours")
	public String saveCours(@Valid Cours cour, BindingResult bindingResult)
	{
	if (bindingResult.hasErrors()) return "formCours";
	 
	coursService.saveCours(cour);
	return "formCours";
	}

	

	
	@RequestMapping("/ListeCours")
	public String listeCours(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "3") int size)
	{
	Page<Cours> prods = coursService.getAllCoursParPage(page, size);
	modelMap.addAttribute("cours", prods);
	 modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listeCours";
	}
	
	
	
	
	

	
	
	@RequestMapping("/supprimerCours")
	public String supprimerCours(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "3") int size)
	{
		coursService.deleteCoursById(id);
	Page<Cours> prods = coursService.getAllCoursParPage(page, 
	size);
	modelMap.addAttribute("cours", prods);
	modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeCours";
	}

	
	
	

	
	@RequestMapping("/modifierCours")
	public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Cours p= coursService.getCours(id);
	modelMap.addAttribute("cours", p);
	modelMap.addAttribute("mode", "edit");
	return "editerCours";
	}
	
	
	@RequestMapping("/updateCours")
	public String updateCours(@ModelAttribute("cour") Cours cour,@RequestParam("date") String date,ModelMap modelMap) 
			throws ParseException 
	{
		//conversion de la date 
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateCreation = dateformat.parse(String.valueOf(date));
		 cour.setDateC(dateCreation);
		 
		 coursService.updateCours(cour);
		 List<Cours> prods = coursService.getAllCours();
		 modelMap.addAttribute("cours", prods);
		return "listeCours";
		}
	
	@RequestMapping("/rechercheCours")
    public String rechercheCours(ModelMap modelMap,@RequestParam("motCle") Enseignant enseingnant)
	{
      List<Cours> prods = coursService.findByEnseignant(enseingnant);
	
	
     modelMap.addAttribute("cours", prods);
	return "listeCours";
	}


}
