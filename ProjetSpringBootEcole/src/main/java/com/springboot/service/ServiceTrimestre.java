package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.bean.Trimestre;
import com.springboot.dao.DaoTrimestre;

@Service
public class ServiceTrimestre implements IServiceTrimestre {

	@Autowired
	private DaoTrimestre dao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Trimestre> rechercheTrimestre() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Trimestre rechercheTrimestreId(int id) {
		return dao.findById( id ).get();
	}

	@Override
	@Transactional
	public void creerTrimestre(Trimestre trim) {
		dao.save( trim );
	}

	@Override
	@Transactional
	public void modifierTrimestre(Trimestre trim) {
		dao.save( trim );
	}

	@Override
	@Transactional
	public void supprimerTrimestre(Trimestre trim) {
		dao.deleteById( trim.getId() );
	}

}
