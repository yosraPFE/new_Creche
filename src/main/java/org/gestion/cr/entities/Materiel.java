package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Materiel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMateriel;

	private String designation;
	private String description;
	private double prix;

	@ManyToMany(mappedBy = "materiels")
	private Set<Fournisseur> fournisseurs = new HashSet<Fournisseur>();

	@ManyToOne
	@JoinColumn(name = "idStock")
	private Stock stock;

	@ManyToOne
	@JoinColumn(name = "idTypeMateriels")
	private TypeMateriels typeMateriels;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.materiel", cascade = CascadeType.ALL)
	private Set<MatrielUtiliser> materielEqEducatif = new HashSet<MatrielUtiliser>(
			0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.materiel", cascade = CascadeType.ALL)
	private Set<MatrielSanitaUtiliser> materielEqSanitaire = new HashSet<MatrielSanitaUtiliser>(
			0);

	public Set<MatrielUtiliser> getMaterielEqEducatif() {
		return materielEqEducatif;
	}

	public void setMaterielEqEducatif(Set<MatrielUtiliser> materielEqEducatif) {
		this.materielEqEducatif = materielEqEducatif;
	}

	public Set<MatrielSanitaUtiliser> getMaterielEqSanitaire() {
		return materielEqSanitaire;
	}

	public void setMaterielEqSanitaire(
			Set<MatrielSanitaUtiliser> materielEqSanitaire) {
		this.materielEqSanitaire = materielEqSanitaire;
	}

	public long getIdMateriel() {
		return idMateriel;
	}

	public void setIdMateriel(long idMateriel) {
		this.idMateriel = idMateriel;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public TypeMateriels getTypeMateriels() {
		return typeMateriels;
	}

	public void setTypeMateriels(TypeMateriels typeMateriels) {
		this.typeMateriels = typeMateriels;
	}

	public Materiel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Materiel(String designation, String description, double prix) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Set<Fournisseur> getFournisseurs() {
		return fournisseurs;
	}

	public void setFournisseurs(Set<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}

}
