package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.bean.Note;
import com.springboot.dao.DaoNote;

@Service
public class ServiceNote implements IServiceNote {

	@Autowired
	private DaoNote dao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Note> rechercheNote() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Note rechercheNoteId(int id) {
		return dao.findById( id ).get();
	}

	@Override
	@Transactional
	public void creerNote(Note pnote) {
		dao.save( pnote );
	}

	@Override
	@Transactional
	public void modifierNote(Note pnote) {
		dao.save( pnote );
	}

	@Override
	@Transactional
	public void supprimerNote(Note pnote) {
		dao.deleteById( pnote.getId() );
	}

}
