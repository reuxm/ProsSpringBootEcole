package com.springboot.controller;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.bean.Note;
import com.springboot.controller.form.MatiereForm;
import com.springboot.controller.form.NoteForm;
import com.springboot.service.IServiceMatiere;
import com.springboot.service.IServiceNote;
import com.springboot.service.IServiceTrimestre;
import com.springboot.service.iServiceClasse;
import com.springboot.service.iServiceEleve;
import com.springboot.service.iServiceProfesseur;

@Controller
public class NoteController {
	
	@Autowired
	private IServiceNote service;
	
	@Autowired
	private IServiceMatiere mService;
	
	@Autowired
	private iServiceProfesseur pService;
	
	@Autowired
	private IServiceTrimestre tService;
	
	@Autowired
	private iServiceEleve eService;
	
	@Autowired
	private iServiceClasse cService;

	@GetMapping("/ReadNotes")
	public String readNotes( Model pmodel ) {
		pmodel.addAttribute( "action", "creer" );
		return ( print(pmodel) );
	}
	
	@PostMapping("/creerNote")
	public String addNote( Model pmodel, @Valid @ModelAttribute(name = "noteform") NoteForm noteform ){
		
		try {
			BufferedWriter bw = new BufferedWriter( new FileWriter("/tmp/log.spring") );
			bw.write( noteform.toString() );
			bw.close();
		} catch (IOException e1) {}
		
		try{
			service.creerNote( parseForm( noteform ) );
		}
		catch (NumberFormatException|ParseException e) { //bad data -> abort
			return "Parse Exception"+e.getMessage();
		}
		
		pmodel.addAttribute( "action", "creer" );
		return ( print(pmodel) );
	}
	
	private String print( Model pmodel ) {
		pmodel.addAttribute( "listenote", service.rechercheNote() );
		pmodel.addAttribute( "listMatiere", mService.rechercheMatiere() );
		pmodel.addAttribute( "listProf", pService.rechercheProf() );
		pmodel.addAttribute( "listTrim", tService.rechercheTrimestre() );
		pmodel.addAttribute( "listEleve", eService.rechercheEleve() );
		pmodel.addAttribute( "listClasse", cService.rechercheClasse() );
		
		if( !pmodel.containsAttribute("noteform") ) {
			NoteForm noteform = new NoteForm();
			noteform.setId(0);
			pmodel.addAttribute("noteform", noteform);
		}
		
		return "notes";
	}
	
	private Note parseForm( NoteForm form ) throws NumberFormatException, ParseException {
		Note n = new Note();
		n.setId( form.getId());
		n.setAvancement( Float.parseFloat(form.getAvancement() ) );
		n.setAvis( form.getAvis() );
		n.setClasse( cService.rechercheClasseId( 
				Integer.parseInt( form.getClasse() )
		) );
		n.setDateSaisie( 
				new SimpleDateFormat("yyyy-MM-dd").parse( form.getDateSaisie() ) 
		);
		n.setEleve( eService.rechercheEleveId(
				Integer.parseInt( form.getEleve() )
		));
		n.setMatiere(mService.rechercheMatiereId(
				Integer.parseInt( form.getMatiere() )
		));
		n.setNote( Integer.parseInt( form.getNote() ) );
		n.setProf( pService.rechercheProfId(
				Integer.parseInt( form.getProf() )
		));
		n.setTrimestre( tService.rechercheTrimestreId(
				Integer.parseInt( form.getTrimestre() )
		));
		return n;
	}
	
}
