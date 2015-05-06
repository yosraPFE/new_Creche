package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Entity;


@Entity
public class EquipeSanitaire extends Equipe implements Serializable {

	public EquipeSanitaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EquipeSanitaire(String nom, String prenom, String nomPhoto,
			String dateNaissance, String lieuNaissance,
			String sexe, String adresseDomicile, String nomUtilisateur,
			String motPasse) {
		super(nom, prenom, nomPhoto, dateNaissance, lieuNaissance, sexe,
				adresseDomicile, nomUtilisateur, motPasse);
		// TODO Auto-generated constructor stub
	}
	

	@ManyToOne
	@JoinColumn(name="idFonction")
		private Fonction fonction;
	
	
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.equipeSanitaire", cascade=CascadeType.ALL)
    private Set <Consultation> consultations =new HashSet<Consultation>();


	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.equipeSanitaire", cascade=CascadeType.ALL)
	private Set<MatrielSanitaUtiliser> materielEqSanitaire = new HashSet<MatrielSanitaUtiliser>(0);
	


	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	public Set<Consultation> getConsultations() {
		return consultations;
	}

	public void setConsultations(Set<Consultation> consultations) {
		this.consultations = consultations;
	}

	public Set<MatrielSanitaUtiliser> getMaterielEqSanitaire() {
		return materielEqSanitaire;
	}

	public void setMaterielEqSanitaire(
			Set<MatrielSanitaUtiliser> materielEqSanitaire) {
		this.materielEqSanitaire = materielEqSanitaire;
	}
	
	
	
	

	

}



/*
public class EquipeSanitaire extends Equipe implements Serializable 
{
	
	

	@ManyToOne
	@JoinColumn(name="idFonction")
	private Fonction fonction;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.eqSanitaire", cascade=CascadeType.ALL)
    private Set <Consultation> consultations =new HashSet<Consultation>();
	
	

	public EquipeSanitaire() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Fonction getFonction() {
		return fonction;
	}





	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}





	}
	
	

}*/
