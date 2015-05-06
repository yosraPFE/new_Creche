package org.gestion.cr.entities;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Parent extends Personne implements Serializable {
	private String cin;
	private String profession;
	private String adresseDomicile;
	private String telephoneDomicile;
	private String telephonePortable;
	private String email;
	private String lieuTravail;
	private String telephoneTravail;
	private String nomUtilisateur;

	private String motPasse;
	private String genre;

	@ManyToMany(mappedBy = "parent")
	private Set<Enfant> enfants = new HashSet<Enfant>();

	public Parent(String nom, String prenom, String nomPhoto) {
		super(nom, prenom, nomPhoto);
		// TODO Auto-generated constructor stub
	}

	public String getCin() {
		return cin;
	}

	public Parent(String nom, String prenom, String nomPhoto, 
			String cin, String profession, String adresseDomicile,
			String telephoneDomicile, String telephonePortable, String email,
			String lieuTravail, String telephoneTravail, String nomUtilisateur,
			String motPasse, String genre) {
		super(nom, prenom, nomPhoto);
		this.cin = cin;
		this.profession = profession;
		this.adresseDomicile = adresseDomicile;
		this.telephoneDomicile = telephoneDomicile;
		this.telephonePortable = telephonePortable;
		this.email = email;
		this.lieuTravail = lieuTravail;
		this.telephoneTravail = telephoneTravail;
		this.nomUtilisateur = nomUtilisateur;
		this.motPasse = motPasse;
		this.genre = genre;
	}

	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getAdresseDomicile() {
		return adresseDomicile;
	}

	public void setAdresseDomicile(String adresseDomicile) {
		this.adresseDomicile = adresseDomicile;
	}

	public String getTelephoneDomicile() {
		return telephoneDomicile;
	}

	public void setTelephoneDomicile(String telephoneDomicile) {
		this.telephoneDomicile = telephoneDomicile;
	}

	public String getTelephonePortable() {
		return telephonePortable;
	}

	public void setTelephonePortable(String telephonePortable) {
		this.telephonePortable = telephonePortable;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLieuTravail() {
		return lieuTravail;
	}

	public void setLieuTravail(String lieuTravail) {
		this.lieuTravail = lieuTravail;
	}

	public String getTelephoneTravail() {
		return telephoneTravail;
	}

	public void setTelephoneTravail(String telephoneTravail) {
		this.telephoneTravail = telephoneTravail;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getMotPasse() {
		return motPasse;
	}

	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Set<Enfant> getEnfants() {
		return enfants;
	}

	public void setEnfants(Set<Enfant> enfants) {
		this.enfants = enfants;
	}

}
