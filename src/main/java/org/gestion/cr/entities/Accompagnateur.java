package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import javax.validation.constraints.Size;

@Entity
public class Accompagnateur extends Personne implements Serializable {

	private String cin;

	@Size(min = 5)
	private String description;

	private String telephonePortable;

	private boolean active;

	private String sexe;

	@ManyToMany(mappedBy = "accompagnateur")
	private Set<Enfant> enfants = new HashSet<Enfant>();

	public Accompagnateur(String nom, String prenom, String nomPhoto,
			 String cin, String description,
			String telephonePortable, boolean active) {
		super(nom, prenom, nomPhoto);
		this.cin = cin;
		this.description = description;
		this.telephonePortable = telephonePortable;
		this.active = active;
	}

	public Accompagnateur() {
		// TODO Auto-generated constructor stub
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getTelephonePortable() {
		return telephonePortable;
	}

	public void setTelephonePortable(String telephonePortable) {
		this.telephonePortable = telephonePortable;
	}

	public Set<Enfant> getEnfants() {
		return enfants;
	}

	public void setEnfants(Set<Enfant> enfants) {
		this.enfants = enfants;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

}
