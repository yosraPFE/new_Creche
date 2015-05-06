package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Creche implements Serializable {
	
	
	@EmbeddedId
	private CrecheId id = new CrecheId();
	

	private String nom;

	private String adresse;

	private String email;

	private String ville;

	private String telephone;

	private String nomPhoto;
	
	
	private double tarifInscription;
	
	private double tarifAssurance;
	
	
	private double tarifParMois;
	
	

	


	public CrecheId getId() {
		return id;
	}

	public void setId(CrecheId id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getNomPhoto() {
		return nomPhoto;
	}

	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}
	
	
	
	

	public double getTarifInscription() {
		return tarifInscription;
	}

	public void setTarifInscription(double tarifInscription) {
		this.tarifInscription = tarifInscription;
	}

	public double getTarifAssurance() {
		return tarifAssurance;
	}

	public void setTarifAssurance(double tarifAssurance) {
		this.tarifAssurance = tarifAssurance;
	}

	public double getTarifParMois() {
		return tarifParMois;
	}

	public void setTarifParMois(double tarifParMois) {
		this.tarifParMois = tarifParMois;
	}

	


	

	public Creche(String nom, String adresse, String email, String ville,
			String telephone, String nomPhoto, double tarifInscription,
			double tarifAssurance, double tarifParMois) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.email = email;
		this.ville = ville;
		this.telephone = telephone;
		this.nomPhoto = nomPhoto;
		this.tarifInscription = tarifInscription;
		this.tarifAssurance = tarifAssurance;
		this.tarifParMois = tarifParMois;
	}

	public Creche() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	@Transient
	public String getAnnee() {
		return getId().getAnnee();
	}

	public void setAnnee(String annee) {
		getId().setAnnee(annee);
	}

	
}
