package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Club implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClub;

	private String nom;
	private int nombreMaxPart;

	@ManyToOne
	@JoinColumn(name = "idcategorieClub")
	private CategorieClub categorieClub;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.club", cascade = CascadeType.ALL)
	private Set<ClubEnfant> clubEnfant = new HashSet<ClubEnfant>(0);

	public Club() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Club(String nom, int nombreMaxPart) {
		super();
		this.nom = nom;
		this.nombreMaxPart = nombreMaxPart;

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNombreMaxPart() {
		return nombreMaxPart;
	}

	public void setNombreMaxPart(int nombreMaxPart) {
		this.nombreMaxPart = nombreMaxPart;
	}

	public CategorieClub getCategorieClub() {
		return categorieClub;
	}

	public void setCategorieClub(CategorieClub categorieClub) {
		this.categorieClub = categorieClub;
	}

	public Long getIdClub() {
		return idClub;
	}

	public void setIdClub(Long idClub) {
		this.idClub = idClub;
	}

	public Set<ClubEnfant> getClubEnfant() {
		return clubEnfant;
	}

	public void setClubEnfant(Set<ClubEnfant> clubEnfant) {
		this.clubEnfant = clubEnfant;
	}

}
