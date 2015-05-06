package org.gestion.cr.entities;

import java.io.Serializable;
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
public class Evenement implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEvenement;

	private String nom;
	private String type;
	private double fraix;
	private String lieu;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private String date;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.evenement", cascade = CascadeType.ALL)
	private Set<EvennementEnfant> evennementEnfant = new HashSet<EvennementEnfant>(
			0);

	public Evenement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdEvenement() {
		return idEvenement;
	}

	public void setIdEvenement(Long idEvenement) {
		this.idEvenement = idEvenement;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getFraix() {
		return fraix;
	}

	public void setFraix(double fraix) {
		this.fraix = fraix;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Set<EvennementEnfant> getEvennementEnfant() {
		return evennementEnfant;
	}

	public void setEvennementEnfant(Set<EvennementEnfant> evennementEnfant) {
		this.evennementEnfant = evennementEnfant;
	}

	public Evenement(String nom, String type, double fraix, String lieu,
			String date) {
		super();
		this.nom = nom;

		this.type = type;
		this.fraix = fraix;
		this.lieu = lieu;
		this.date = date;
	}

}
