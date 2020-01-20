package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.bean.Matiere;
import com.springboot.dao.DaoMatiere;

@Service
public class ServiceMatiere implements IServiceMatiere {

	@Autowired
	private DaoMatiere dao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Matiere> rechercheMatiere() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Matiere rechercheMatiereId( int id ) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void creerMatiere( Matiere pmatiere ) {
		dao.save( pmatiere );
	}

	@Override
	@Transactional
	public void modifierMatiere( Matiere pmatiere ) {
		dao.save( pmatiere );
	}

	@Override
	@Transactional
	public void supprimerMatiere( Matiere pmatiere ) {
		dao.deleteById( pmatiere.getId() );
	}

}
