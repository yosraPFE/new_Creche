package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class EquipeEducatif extends Equipe implements Serializable {

	public EquipeEducatif() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EquipeEducatif(String nom, String prenom, String nomPhoto,
			 String dateNaissance, String lieuNaissance,
			String sexe, String adresseDomicile, String nomUtilisateur,
			String motPasse) {
		super(nom, prenom, nomPhoto,  dateNaissance, lieuNaissance, sexe,
				adresseDomicile, nomUtilisateur, motPasse);
		// TODO Auto-generated constructor stub
	}
	

	/*
	@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="EqEducatif_CategorieClub", 
                joinColumns={@JoinColumn(name="idEqEducatif")}, 
                inverseJoinColumns={@JoinColumn(name="idCategorie")})
	private Set<CategorieClub> categorieClubs = new HashSet<CategorieClub>();*/
   
	
	
/*
	@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="EqEducatif_Classe", 
                joinColumns={@JoinColumn(name="idEqEducatif")}, 
                inverseJoinColumns={@JoinColumn(name="idClasse")})
    private Set<Classe> classes = new HashSet<Classe>();*/
	
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.equipeEducatif", cascade=CascadeType.ALL)
	private Set<MatrielUtiliser> materielEqEducatif = new HashSet<MatrielUtiliser>(0);
	
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.equipeEducatif", cascade=CascadeType.ALL)
	private Set<ClasseEquipeEducatif> classeEquipeEducatif = new HashSet<ClasseEquipeEducatif>(0);
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.equipeEducatif", cascade=CascadeType.ALL)
	private Set<CategorieClubEquipeEducatif> categorieClubEquipeEducatif = new HashSet<CategorieClubEquipeEducatif>(0);




	@ManyToOne
	@JoinColumn(name="idFonction")
		private Fonction fonction;


	

	public Set<ClasseEquipeEducatif> getClasseEquipeEducatif() {
		return classeEquipeEducatif;
	}

	public void setClasseEquipeEducatif(
			Set<ClasseEquipeEducatif> classeEquipeEducatif) {
		this.classeEquipeEducatif = classeEquipeEducatif;
	}

	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	public Set<MatrielUtiliser> getMaterielEqEducatif() {
		return materielEqEducatif;
	}

	public void setMaterielEqEducatif(Set<MatrielUtiliser> materielEqEducatif) {
		this.materielEqEducatif = materielEqEducatif;
	}

	public Set<CategorieClubEquipeEducatif> getCategorieClubEquipeEducatif() {
		return categorieClubEquipeEducatif;
	}

	public void setCategorieClubEquipeEducatif(
			Set<CategorieClubEquipeEducatif> categorieClubEquipeEducatif) {
		this.categorieClubEquipeEducatif = categorieClubEquipeEducatif;
	}

	
	

	

}
