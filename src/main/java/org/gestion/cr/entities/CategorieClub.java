package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class CategorieClub implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategorie;
	private String labelle;

	private double prix;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private String date;

	/*
	@ManyToMany(mappedBy = "categorieClubs")
	private Set<EquipeEducatif> equipeEducatifs = new HashSet<EquipeEducatif>();*/

	@OneToMany(mappedBy = "categorieClub")
	private Set<Club> clubs = new HashSet<Club>();
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.categorieClub", cascade = CascadeType.ALL)
	private Set<CategorieClubEquipeEducatif> categorieClubEquipeEducatif = new HashSet<CategorieClubEquipeEducatif>(
			0);

	public CategorieClub(String labelle, double prix, String date) {
		super();
		this.labelle = labelle;
		this.prix = prix;
		this.date = date;
	}

	public CategorieClub() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getLabelle() {
		return labelle;
	}

	public void setLabelle(String labelle) {
		this.labelle = labelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Set<Club> getClubs() {
		return clubs;
	}

	public void setClubs(Set<Club> clubs) {
		this.clubs = clubs;
	}

	public Set<CategorieClubEquipeEducatif> getCategorieClubEquipeEducatif() {
		return categorieClubEquipeEducatif;
	}

	public void setCategorieClubEquipeEducatif(
			Set<CategorieClubEquipeEducatif> categorieClubEquipeEducatif) {
		this.categorieClubEquipeEducatif = categorieClubEquipeEducatif;
	}

	/*
	public Set<EquipeEducatif> getEquipeEducatifs() {
		return equipeEducatifs;
	}

	public void setEquipeEducatifs(Set<EquipeEducatif> equipeEducatifs) {
		this.equipeEducatifs = equipeEducatifs;
	}*/
	
	
	
	

}
