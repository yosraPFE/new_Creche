package org.gestion.cr.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Personne implements Serializable {

	private static final long serialVersionUID = 1L;

	// @SequenceGenerator(allocationSize=1, schema="contact", initialValue=1,
	// sequenceName="seq_contact_id", name="seq_contact_id")
	@Id
	@GenericGenerator(name = "seq_contact_idPerson", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "initial_value", value = "50"),
			@Parameter(name = "increment_size", value = "1") })
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_contact_idPerson")
	private Long idPerson;
	String nom;
	String prenom;
	private String nomPhoto;
	
	public Personne(String nom, String prenom, String nomPhoto) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.nomPhoto = nomPhoto;
		
	}

	public Personne() {
		// TODO Auto-generated constructor stub
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

	public Long getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Long idPerson) {
		this.idPerson = idPerson;
	}

	public String getNomPhoto() {
		return nomPhoto;
	}

	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}

	

}
