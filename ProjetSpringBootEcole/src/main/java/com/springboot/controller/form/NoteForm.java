package com.springboot.controller.form;

public class NoteForm {
	private Integer id;
	private String dateSaisie;
	private String eleve;
	private String classe;
	private String matiere;
	private String prof;
	private String trimestre;
	private String note;
	private String avis;
	private String avancement;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDateSaisie() {
		return dateSaisie;
	}
	public void setDateSaisie(String dateSaisie) {
		this.dateSaisie = dateSaisie;
	}
	public String getEleve() {
		return eleve;
	}
	public void setEleve(String eleve) {
		this.eleve = eleve;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public String getProf() {
		return prof;
	}
	public void setProf(String prof) {
		this.prof = prof;
	}
	public String getTrimestre() {
		return trimestre;
	}
	public void setTrimestre(String trimestre) {
		this.trimestre = trimestre;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getAvis() {
		return avis;
	}
	public void setAvis(String avis) {
		this.avis = avis;
	}
	public String getAvancement() {
		return avancement;
	}
	public void setAvancement(String avancement) {
		this.avancement = avancement;
	}
	@Override
	public String toString() {
		return "NoteForm [id=" + id + ", dateSaisie=" + dateSaisie + ", eleve=" + eleve + ", classe=" + classe
				+ ", matiere=" + matiere + ", prof=" + prof + ", trimestre=" + trimestre + ", note=" + note + ", avis="
				+ avis + ", avancement=" + avancement + "]";
	}

}
