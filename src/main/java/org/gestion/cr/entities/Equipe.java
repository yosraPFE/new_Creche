package org.gestion.cr.entities;

import java.io.Serializable;

import javax.persistence.Entity;


import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;





@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Equipe extends Personne implements Serializable {
	
	
	
	
    private String dateNaissance;
	
	private String lieuNaissance;
	
	
	private String sexe;
	
	private String adresseDomicile;
	
	private String nomUtilisateur;
	private String motPasse;
	
	
	
	
	
	
	public Equipe() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	public Equipe(String nom, String prenom, String nomPhoto, 
			String dateNaissance, String lieuNaissance, String sexe,
			String adresseDomicile, String nomUtilisateur, String motPasse) {
		super(nom, prenom, nomPhoto);
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.sexe = sexe;
		this.adresseDomicile = adresseDomicile;
		this.nomUtilisateur = nomUtilisateur;
		this.motPasse = motPasse;
	}






	public String getDateNaissance() {
		return dateNaissance;
	}






	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}






	public String getLieuNaissance() {
		return lieuNaissance;
	}






	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}






	public String getSexe() {
		return sexe;
	}






	public void setSexe(String sexe) {
		this.sexe = sexe;
	}






	public String getAdresseDomicile() {
		return adresseDomicile;
	}






	public void setAdresseDomicile(String adresseDomicile) {
		this.adresseDomicile = adresseDomicile;
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
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	



}	

