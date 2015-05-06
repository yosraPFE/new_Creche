package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Fournisseur extends Personne implements Serializable {
	private String cin;

	private String adresseSociete;

	private String telephoneSociete;

	private String telephonePortable;

	private String email;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "Fournisseur_Materiel", joinColumns = { @JoinColumn(name = "idFournisseur") }, inverseJoinColumns = { @JoinColumn(name = "idMateriel") })
	private Set<Materiel> materiels = new HashSet<Materiel>();

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getAdresseSociete() {
		return adresseSociete;
	}

	public void setAdresseSociete(String adresseSociete) {
		this.adresseSociete = adresseSociete;
	}

	public String getTelephoneSociete() {
		return telephoneSociete;
	}

	public void setTelephoneSociete(String telephoneSociete) {
		this.telephoneSociete = telephoneSociete;
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

	public Fournisseur(String nom, String prenom, String nomPhoto,
			 String cin, String adresseSociete,
			String telephoneSociete, String telephonePortable, String email) {
		super(nom, prenom, nomPhoto);
		this.cin = cin;
		this.adresseSociete = adresseSociete;
		this.telephoneSociete = telephoneSociete;
		this.telephonePortable = telephonePortable;
		this.email = email;
	}

	public Fournisseur(String nom, String prenom, String nomPhoto) {
		super(nom, prenom, nomPhoto);
		// TODO Auto-generated constructor stub
	}

	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Set<Materiel> getMateriels() {
		return materiels;
	}

	public void setMateriels(Set<Materiel> materiels) {
		this.materiels = materiels;
	}

}
