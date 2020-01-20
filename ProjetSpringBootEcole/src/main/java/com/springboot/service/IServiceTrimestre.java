package com.springboot.service;

import java.util.List;

import com.springboot.bean.Trimestre;

public interface IServiceTrimestre {
	public List<Trimestre> rechercheTrimestre();
	public Trimestre rechercheTrimestreId(final int id);
	public void creerTrimestre(final Trimestre trim);
	public void modifierTrimestre(final Trimestre trim);
	public void supprimerTrimestre(final Trimestre trim);

}
