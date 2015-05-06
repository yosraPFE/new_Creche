package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Classe implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClasse;
	private String nom;
	private int nombrePlaces;
	
	/*
	@ManyToMany(mappedBy = "classes")
	private Set<EquipeEducatif> equipeEducatifs = new HashSet<EquipeEducatif>();*/

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.classe", cascade = CascadeType.ALL)
	private Set<Inscription> inscriptions = new HashSet<Inscription>();
	
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.classe", cascade = CascadeType.ALL)
	private Set<ClasseEquipeEducatif> classeEquipeEducatif = new HashSet<ClasseEquipeEducatif>(
			0);

	public Classe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(Long idClasse) {
		this.idClasse = idClasse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNombrePlaces() {
		return nombrePlaces;
	}

	public void setNombrePlaces(int nombrePlaces) {
		this.nombrePlaces = nombrePlaces;
	}

	
	public Set<ClasseEquipeEducatif> getClasseEquipeEducatif() {
		return classeEquipeEducatif;
	}

	public void setClasseEquipeEducatif(
			Set<ClasseEquipeEducatif> classeEquipeEducatif) {
		this.classeEquipeEducatif = classeEquipeEducatif;
	}

	public Set<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(Set<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public Classe(String nom, int nombrePlaces) {
		super();
		this.nom = nom;
		this.nombrePlaces = nombrePlaces;
	}

	
	
	
	

}

/*
 * @ManyToOne
 * 
 * @JoinColumn(name="idCreche") private Creche creche;
 * 
 * 
 * @OneToMany(fetch = FetchType.LAZY, mappedBy
 * ="id.class",cascade=CascadeType.ALL) private Set <Inscription> inscriptions
 * =new HashSet<Inscription>();
 * 
 * 
 * @ManyToMany(cascade = {CascadeType.ALL})
 * 
 * @JoinTable(name="Classe_EqEduc", joinColumns={@JoinColumn(name="idClasse")},
 * inverseJoinColumns={@JoinColumn(name="idEqEducatif")}) private
 * Set<EquipeEducatif> equipeEducatifs = new HashSet<EquipeEducatif>();
 */
/*
 * 
 * 
 * 
 * public Classe() { }
 * 
 * } public Long getIdClass() { return idClass; }
 * 
 * public void setIdClass(Long idClass) { this.idClass = idClass; }
 * 
 * public String getNom() { return nom; } public void setNom(String nom) {
 * this.nom = nom; }
 * 
 * public int getNombrePlaces() { return nombrePlaces; }
 * 
 * public void setNombrePlaces(int nombrePlaces) { this.nombrePlaces =
 * nombrePlaces; }
 * 
 * public Creche getCreche() { return creche; }
 * 
 * public void setCreche(Creche creche) { this.creche = creche; }
 * 
 * 
 * public Set<EquipeEducatif> getEquipeEducatifs() { return equipeEducatifs; }
 * 
 * 
 * public void setEquipeEducatifs(Set<EquipeEducatif> equipeEducatifs) {
 * this.equipeEducatifs = equipeEducatifs; }
 * 
 * 
 * 
 * }
 */