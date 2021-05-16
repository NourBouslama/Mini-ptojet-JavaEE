package com.nour.cours.controllers;

import java.text.ParseException;
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

import com.nour.cours.entities.Enseignant;
import com.nour.cours.service.EnseignantService;

@Controller
public class EnseignantController {

	@Autowired
	EnseignantService enseignantService;
	
	
	
	@RequestMapping("/showCreateEns")
	public String showCreate(ModelMap modelMap)
	{
	modelMap.addAttribute("enseignant", new Enseignant());
	modelMap.addAttribute("mode", "new");
	return "formEnseignant";
	}
	
	@RequestMapping("/saveEnseignant")
	public String saveEnseignants(@Valid Enseignant ens, BindingResult bindingResult)
	{
	if (bindingResult.hasErrors()) return "formCours";
	 
	enseignantService.saveEnseignant(ens);
	return "formEnseignant";
	}
	
	@RequestMapping("/ListeEnseignant")
	public String listeEnseignant(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "3") int size)
	{
	Page<Enseignant> prods = enseignantService.getAllEnseignantsParPage(page, size);
	modelMap.addAttribute("Enseignant", prods);
	 modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listeEnseignant";
	}
	
	
	
	
	@RequestMapping("/supprimerEnseignant")
	public String supprimerEnseignant(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "3") int size)
	{
		enseignantService.deleteEnseignantById(id);
	Page<Enseignant> prods = enseignantService.getAllEnseignantsParPage(page, size);
	modelMap.addAttribute("Enseignant", prods);
	modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeEnseignant";
	}
	
	
	
	
	
	@RequestMapping("/modifierEnseignant")
	public String editerEnseignant(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Enseignant p= enseignantService.getEnseignant(id);
	modelMap.addAttribute("Enseignant", p);
	modelMap.addAttribute("mode", "edit");
	return "editerEnseignant";
	}
	
	@RequestMapping("/updateEnseignant")
	public String updateEnseignant(@ModelAttribute("Enseignant") Enseignant enseignant,@RequestParam("date") String date,ModelMap modelMap) 
			throws ParseException 
	{
		//conversion de la date 
		/* SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateCreation = dateformat.parse(String.valueOf(date));
		 cour.setDateC(dateCreation);*/
		 
		 enseignantService.updateEnseignant(enseignant);
		 List<Enseignant> prods = enseignantService.getAllEnseignants();
		 modelMap.addAttribute("enseignant", prods);
		return "listeEnseignant";
		}
}
