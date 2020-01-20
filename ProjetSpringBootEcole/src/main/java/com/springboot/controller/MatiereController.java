package com.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.bean.Matiere;
import com.springboot.controller.form.MatiereForm;
import com.springboot.service.IServiceMatiere;

@Controller
public class MatiereController {
	
	@Autowired
	private IServiceMatiere service;
	
	private Matiere convertForm(MatiereForm classeform) throws Exception {
		Matiere pmatiere = new Matiere();
		pmatiere.setId(classeform.getId());
		pmatiere.setNom(classeform.getNom());
		return pmatiere;
	}
	
	@GetMapping("/afficherCreerMatiere")
	public String getAffiche(Model pmodel) {
		List<Matiere> lm = service.rechercheMatiere();
		pmodel.addAttribute("listematieres", lm);
		pmodel.addAttribute("action", "CreerMatiere");
		
		if(pmodel.containsAttribute("matiereform") == false) {
			MatiereForm matiereform = new MatiereForm();
			matiereform.setId(0);
			pmodel.addAttribute("matiereform",matiereform);
		}
		
		return "matieres";
	}
	
	@PostMapping("/CreerMatiere")
	public String ajoutMatiere( @Valid @ModelAttribute(name = "matiereform") MatiereForm matiereform, BindingResult presult, Model pmodel) {
		if( !presult.hasErrors() ) {
			try {
				Matiere pmatiere = convertForm(matiereform);
				service.creerMatiere( pmatiere );
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}
	
	@GetMapping("/SupprimerMatiere/{id}")
	public String getSupprimer(@PathVariable final Integer id,Model pmodel) {
		Matiere pmatiere = service.rechercheMatiereId(id);
		if(pmatiere != null) {
			service.supprimerMatiere(pmatiere);;
		}
		return this.getAffiche(pmodel);
	}

	@PostMapping("/ModifierMatiere")
	public String modifieMatiere( 
			@Valid @ModelAttribute(name = "matiereform") MatiereForm matiereform,
			 BindingResult presult,
			Model pmodel)
	{
		if(!presult.hasErrors()) {
			try
			{
				Matiere pmatiere = convertForm(matiereform);
				service.creerMatiere(pmatiere);
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}
	
	@GetMapping("/afficherModifierMatiere/{id}")
	public String getAfficheMod(@PathVariable final Integer id,Model pmodel) {
		Matiere pmatiere = service.rechercheMatiereId(id);
		pmodel.addAttribute("listematiere", null);
		pmodel.addAttribute("action", "ModifierMatiere");
		if(pmodel.containsAttribute("matiereform") == false) {
			MatiereForm matiereform = new MatiereForm();
			matiereform.setId(pmatiere.getId());
			matiereform.setNom(pmatiere.getNom());
			
			pmodel.addAttribute("matiereform", matiereform);
		}
		return "matieres";
	}

}
