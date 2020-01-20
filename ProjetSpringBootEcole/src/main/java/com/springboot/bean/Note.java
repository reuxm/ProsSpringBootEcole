package com.springboot.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name="t_notes" )

public class Note {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idnotes")
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@Column( name="date_saisie" )
	private Date dateSaisie;

	@ManyToOne
	@JoinColumn( name="ideleve", nullable=false )
	private Eleve eleve;

	@ManyToOne
	@JoinColumn( name="idclasse", nullable=false )
	private Classe classe;

	@ManyToOne
	@JoinColumn( name="idmatiere", nullable=false )
	private Matiere matiere;

	@ManyToOne
	@JoinColumn( name="idprof", nullable=false )
	private Professeur prof;

	@ManyToOne
	@JoinColumn( name="idtrimestre", nullable=false )
	private Trimestre trimestre;
	
	@Column( name="note", nullable=false )
	private Integer note;
	
	@Lob
	@Column( name="avis", columnDefinition="TEXT", nullable=false )
	private String avis;
	
	@Column( name="avancement", nullable=false)
	private float avancement;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateSaisie() {
		return dateSaisie;
	}

	public void setDateSaisie(Date dateSaisie) {
		this.dateSaisie = dateSaisie;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Professeur getProf() {
		return prof;
	}

	public void setProf(Professeur prof) {
		this.prof = prof;
	}

	public Trimestre getTrimestre() {
		return trimestre;
	}

	public void setTrimestre(Trimestre trimestre) {
		this.trimestre = trimestre;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public String getAvis() {
		return avis;
	}

	public void setAvis(String avis) {
		this.avis = avis;
	}

	public float getAvancement() {
		return avancement;
	}

	public void setAvancement(float avancement) {
		this.avancement = avancement;
	}

	
}
