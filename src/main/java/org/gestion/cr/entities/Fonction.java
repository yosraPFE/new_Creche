package org.gestion.cr.entities;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Fonction implements Serializable {
	/**
	 * 
	 * @author YOSRA
	 *
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFonction;

	private String labelle;

	// generation du guetteurs et du setteurs
	public long getIdFonction() {
		return idFonction;
	}

	public void setIdFonction(long idFonction) {
		this.idFonction = idFonction;
	}

	public String getLabelle() {
		return labelle;
	}

	public void setLabelle(String labelle) {
		this.labelle = labelle;
	}

	@OneToMany(mappedBy = "fonction")
	private Set<EquipeEducatif> equipeEducatifs = new HashSet<EquipeEducatif>();

	@OneToMany(mappedBy = "fonction")
	private Set<EquipeSanitaire> equipeSanitaires = new HashSet<EquipeSanitaire>();

	// generation du constructeurs sans parametres
	public Fonction() {
		super();

	}

	// generation du constructeurs avec parametres
	public Fonction(String labelle) {
		super();
		this.labelle = labelle;
	}

	public Set<EquipeEducatif> getEquipeEducatifs() {
		return equipeEducatifs;
	}

	public void setEquipeEducatifs(Set<EquipeEducatif> equipeEducatifs) {
		this.equipeEducatifs = equipeEducatifs;
	}

	public Set<EquipeSanitaire> getEquipeSanitaires() {
		return equipeSanitaires;
	}

	public void setEquipeSanitaires(Set<EquipeSanitaire> equipeSanitaires) {
		this.equipeSanitaires = equipeSanitaires;
	}

}
