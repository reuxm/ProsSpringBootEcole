package com.springboot.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name="t_trimestre" )

public class Trimestre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idtrimestre")
	private Integer id;
	
	@Column(name="nom", nullable=false)
	private Integer nom;
	
	@Temporal(TemporalType.DATE)
	@Column( name="date" )
	private Date date;
	
	@OneToMany(mappedBy="trimestre", fetch=FetchType.LAZY)
	private List<Note> notes = new ArrayList<Note>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNom() {
		return nom;
	}

	public void setNom(Integer nom) {
		this.nom = nom;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

}
