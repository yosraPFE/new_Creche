package org.gestion.cr.entities;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Size;




@Entity

public class Enfant extends Personne implements Serializable   {
	
	private String sexe;
	
	private  String dateNaissance;
	
	private String lieuNaissance;
	
	private String langue;
	
	private Boolean certificatMedicale;
	@Size(min=4)
	private String antecedantsMedicaux;
	
	private String situationParentale;
	
	
	private Boolean autorisationPrisePhoto;
	
	private String datePreInscription;
	
	
	private String nomPrenomPediatre;
	
	private String telephonePortablePediatre;
	/*
	
	@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="Enfant_Evenement", 
                joinColumns={@JoinColumn(name="idEnfant")}, 
                inverseJoinColumns={@JoinColumn(name="idEvenement")})
private Set<Evenement> evenements = new HashSet<Evenement>();*/
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.enfant", cascade=CascadeType.ALL)
	 private Set <Payment> payments =new HashSet<Payment>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.enfant", cascade=CascadeType.ALL)
	private Set<ClubEnfant> clubEnfant = new HashSet<ClubEnfant>(0);
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.enfant", cascade=CascadeType.ALL)
	private Set<PlanningEnfant> planningEnfant = new HashSet<PlanningEnfant>(0);
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.enfant", cascade=CascadeType.ALL)
	private Set<EvennementEnfant> evennementEnfant = new HashSet<EvennementEnfant>(0);
	
	
	
	/*
	@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="Enfant_Club", 
                joinColumns={@JoinColumn(name="idEnfant")}, 
                inverseJoinColumns={@JoinColumn(name="idClub")})

	private Set<Club> clubs = new HashSet<Club>();*/
	
	@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="Enfant_Accompagnateur", 
                joinColumns={@JoinColumn(name="idEnfant")}, 
                inverseJoinColumns={@JoinColumn(name="idAccompagnateur")})
	private Set<Accompagnateur> accompagnateur = new HashSet<Accompagnateur>();
	
	/*
	@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="Enfant_Planing", 
                joinColumns={@JoinColumn(name="idEnfant")}, 
                inverseJoinColumns={@JoinColumn(name="idPlaning")})
private Set<PlanningHorraires> planningHorraires = new HashSet<PlanningHorraires>();*/

	@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="Enfant_Parent", 
                joinColumns={@JoinColumn(name="idEnfant")}, 
                inverseJoinColumns={@JoinColumn(name="idParent")})
	private Set<Parent> parent = new HashSet<Parent>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.enfant", cascade=CascadeType.ALL)
    private Set <Consultation> consultations =new HashSet<Consultation>();
    
    
    
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.enfant", cascade=CascadeType.ALL)
    private Set <Inscription> inscriptions =new HashSet<Inscription>();
	
	
	
	
	public Enfant() {
		// TODO Auto-generated constructor stub
	}
	
	



	public Enfant(String nom, String prenom, String nomPhoto, 
			String sexe, String dateNaissance, String lieuNaissance,
			String langue, Boolean certificatMedicale,
			String antecedantsMedicaux, String situationParentale,
			Boolean autorisationPrisePhoto, String nomPrenomPediatre,String datePreInscription,
			String telephonePortablePediatre) {
		super(nom, prenom, nomPhoto);
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.langue = langue;
		this.certificatMedicale = certificatMedicale;
		this.antecedantsMedicaux = antecedantsMedicaux;
		this.situationParentale = situationParentale;
		this.autorisationPrisePhoto = autorisationPrisePhoto;
		this.nomPrenomPediatre = nomPrenomPediatre;
		this.telephonePortablePediatre = telephonePortablePediatre;
		this.datePreInscription = datePreInscription;
	}









	









	public String getSexe() {
		return sexe;
	}





	public void setSexe(String sexe) {
		this.sexe = sexe;
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





	public String getDatePreInscription() {
		return datePreInscription;
	}





	public void setDatePreInscription(String datePreInscription) {
		this.datePreInscription = datePreInscription;
	}





	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}





	public String getLangue() {
		return langue;
	}





	public void setLangue(String langue) {
		this.langue = langue;
	}





	public Boolean getCertificatMedicale() {
		return certificatMedicale;
	}





	public void setCertificatMedicale(Boolean certificatMedicale) {
		this.certificatMedicale = certificatMedicale;
	}





	public String getAntecedantsMedicaux() {
		return antecedantsMedicaux;
	}





	public void setAntecedantsMedicaux(String antecedantsMedicaux) {
		this.antecedantsMedicaux = antecedantsMedicaux;
	}





	public String getSituationParentale() {
		return situationParentale;
	}





	public void setSituationParentale(String situationParentale) {
		this.situationParentale = situationParentale;
	}





	public Boolean getAutorisationPrisePhoto() {
		return autorisationPrisePhoto;
	}





	public void setAutorisationPrisePhoto(Boolean autorisationPrisePhoto) {
		this.autorisationPrisePhoto = autorisationPrisePhoto;
	}





	public String getNomPrenomPediatre() {
		return nomPrenomPediatre;
	}





	public void setNomPrenomPediatre(String nomPrenomPediatre) {
		this.nomPrenomPediatre = nomPrenomPediatre;
	}





	public String getTelephonePortablePediatre() {
		return telephonePortablePediatre;
	}





	public void setTelephonePortablePediatre(String telephonePortablePediatre) {
		this.telephonePortablePediatre = telephonePortablePediatre;
	}



/*

	public Set<PlanningHorraires> getPlanningHorraires() {
		return planningHorraires;
	}






	public void setPlanningHorraires(Set<PlanningHorraires> planningHorraires) {
		this.planningHorraires = planningHorraires;
	}*/





	public Set<Accompagnateur> getAccompagnateur() {
		return accompagnateur;
	}





	public void setAccompagnateur(Set<Accompagnateur> accompagnateur) {
		this.accompagnateur = accompagnateur;
	}





	public Set<Parent> getParent() {
		return parent;
	}





	public void setParent(Set<Parent> parent) {
		this.parent = parent;
	}





	public Set<Inscription> getInscriptions() {
		return inscriptions;
	}





	public void setInscriptions(Set<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}





	public Set<Consultation> getConsultations() {
		return consultations;
	}





	public void setConsultations(Set<Consultation> consultations) {
		this.consultations = consultations;
	}










	public Set<ClubEnfant> getClubEnfant() {
		return clubEnfant;
	}





	public void setClubEnfant(Set<ClubEnfant> clubEnfant) {
		this.clubEnfant = clubEnfant;
	}





	public Set<PlanningEnfant> getPlanningEnfant() {
		return planningEnfant;
	}





	public void setPlanningEnfant(Set<PlanningEnfant> planningEnfant) {
		this.planningEnfant = planningEnfant;
	}





	public Set<EvennementEnfant> getEvennementEnfant() {
		return evennementEnfant;
	}





	public void setEvennementEnfant(Set<EvennementEnfant> evennementEnfant) {
		this.evennementEnfant = evennementEnfant;
	}





	public Set<Payment> getPayments() {
		return payments;
	}





	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}





	
	





	}

