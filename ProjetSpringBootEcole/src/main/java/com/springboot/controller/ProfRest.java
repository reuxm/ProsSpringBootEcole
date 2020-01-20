package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bean.Professeur;
import com.springboot.service.iServiceProfesseur;

@RestController
@RequestMapping("/Rest/")
public class ProfRest {
	@Autowired
	private iServiceProfesseur serviceprof;
	
	@GetMapping("/Profs")
	public List<Professeur> getProfs() {
		
		return serviceprof.rechercheProf();
	}
	
	@GetMapping("/Profs/{id}")
	public Professeur getProf(@PathVariable("id") int id) {
		
		return serviceprof.rechercheProfId(id);
	}
	
	@DeleteMapping("/Profs/{id}")
	public Professeur deleteProf( @PathVariable("id") int id ) {
		Professeur prof = serviceprof.rechercheProfId( id );
		serviceprof.supprimerProf( prof );
		return prof;
	}
	
	@PutMapping("/Profs/{id}")
	public Professeur updateProf( @PathVariable("id") int id, @RequestBody Professeur pprof ) {
		Professeur prof = serviceprof.rechercheProfId( id );
		if( prof != null )
			serviceprof.modifierProf( pprof );
		return pprof;
	}
	
	@PostMapping("/Profs")
	public Professeur createProf( @RequestBody Professeur prof ) {
		serviceprof.creerProf( prof );
		return prof;
	}
	
}
