package org.gestion.cr.models;

import java.util.Collection;
import java.util.List;

import org.gestion.cr.entities.Accompagnateur;
import org.gestion.cr.entities.Classe;
import org.gestion.cr.entities.Enfant;
import org.gestion.cr.entities.Parent;


public class EnfantForm 
{
	
//  pere    //

	
	Long idpere;
	String cinpere ;
	String professionpere ;
	String adresseDomicilepere;
	String telephoneDomicilepere;
	String telephonePortablepere;
	String emailpere;
	String lieuTravailpere;
	String telephoneTravailpere;
	String nomUtilisateurpere;
	String motPasseepere;
	String genrepere;
	String nompere;
	String prenompere;
	String nomPhotopere;
	byte photopere;
	String genre;
	
	

	
//Mere          
	
	Long idmere;
	String cinmere ;
	String professionmere;
	String adresseDomicilemere;
	String telephoneDomicilemere;
	String telephonePortablemere;
	String emailmere;
	String lieuTravailmere;
	String telephoneTravailmere;
	String nomUtilisateurmere;
	String motPasseemere;
	String genremere;
	String nommere;
	String prenommere;
	String nomPhotomere;
	byte photomere;




 String genreTest;







//accompagnateur
	
	 Long idaccompagnateur;
     String nomaccompagnateur;
	 String prenomaccompagnateur;
     String cinaccompagnateur;
	 String telephonePortableaccompagnateur;
	 String description;
	 String nomPhotoaccompagnateur;
	 byte[] photoaccompagnateur;
	 
	 
	 
        //Enfant 
	 
	 Long idenfant;
	 String nomenfant;
	 String prenomenfant;
	 private String sexe;
	 private  String dateNaissance;
	 private String lieuNaissance;
	 private String langue;
	 private String antecedantsMedicaux;
	 private String situationParentale;
	 private boolean certificatMedicale;
	 private boolean autorisationPrisePhoto;
	 private String nomPrenomPediatre;
	 private String telephonePortablePediatre;
	 
	 String nomPhotoEnfant;
	 byte[] photoEnfant;
	 private Collection<Accompagnateur> accompagnateurs;
	 private Collection<Parent> parents;
	 private Enfant enfant;
	 
	 
	 
	 
	 //classe
	 
	 
	private String nomClasse;
	private int nombrePlacesClasse;
	long idClasse;
	private List<Classe> classesF;
	 
	 
	 //Constructeur sans parametres
	 

		public EnfantForm()
		{
			
			super();
			
		}
		
		//Generation des guetteurs et des setteurs

		public Long getIdpere() {
			return idpere;
		}

		public void setIdpere(Long idpere) {
			this.idpere = idpere;
		}

		public String getCinpere() {
			return cinpere;
		}

		public void setCinpere(String cinpere) {
			this.cinpere = cinpere;
		}

		public String getProfessionpere() {
			return professionpere;
		}

		public void setProfessionpere(String professionpere) {
			this.professionpere = professionpere;
		}

		public String getAdresseDomicilepere() {
			return adresseDomicilepere;
		}

		public void setAdresseDomicilepere(String adresseDomicilepere) {
			this.adresseDomicilepere = adresseDomicilepere;
		}

		public String getTelephoneDomicilepere() {
			return telephoneDomicilepere;
		}

		public void setTelephoneDomicilepere(String telephoneDomicilepere) {
			this.telephoneDomicilepere = telephoneDomicilepere;
		}

		public String getTelephonePortablepere() {
			return telephonePortablepere;
		}

		public void setTelephonePortablepere(String telephonePortablepere) {
			this.telephonePortablepere = telephonePortablepere;
		}

		public String getEmailpere() {
			return emailpere;
		}

		public void setEmailpere(String emailpere) {
			this.emailpere = emailpere;
		}

		public String getLieuTravailpere() {
			return lieuTravailpere;
		}

		public void setLieuTravailpere(String lieuTravailpere) {
			this.lieuTravailpere = lieuTravailpere;
		}

		public String getTelephoneTravailpere() {
			return telephoneTravailpere;
		}

		public void setTelephoneTravailpere(String telephoneTravailpere) {
			this.telephoneTravailpere = telephoneTravailpere;
		}

		public String getNomUtilisateurpere() {
			return nomUtilisateurpere;
		}

		public void setNomUtilisateurpere(String nomUtilisateurpere) {
			this.nomUtilisateurpere = nomUtilisateurpere;
		}

		public String getMotPasseepere() {
			return motPasseepere;
		}

		public void setMotPasseepere(String motPasseepere) {
			this.motPasseepere = motPasseepere;
		}

		public String getGenrepere() {
			return genrepere;
		}

		public void setGenrepere(String genrepere) {
			this.genrepere = genrepere;
		}

		public String getNompere() {
			return nompere;
		}

		public void setNompere(String nompere) {
			this.nompere = nompere;
		}

		public String getPrenompere() {
			return prenompere;
		}

		public void setPrenompere(String prenompere) {
			this.prenompere = prenompere;
		}

		public String getNomPhotopere() {
			return nomPhotopere;
		}

		public void setNomPhotopere(String nomPhotopere) {
			this.nomPhotopere = nomPhotopere;
		}

		public byte getPhotopere() {
			return photopere;
		}

		public void setPhotopere(byte photopere) {
			this.photopere = photopere;
		}

		public Long getIdmere() {
			return idmere;
		}

		public void setIdmere(Long idmere) {
			this.idmere = idmere;
		}

		public String getCinmere() {
			return cinmere;
		}

		public void setCinmere(String cinmere) {
			this.cinmere = cinmere;
		}

		public String getProfessionmere() {
			return professionmere;
		}

		public void setProfessionmere(String professionmere) {
			this.professionmere = professionmere;
		}

		public String getAdresseDomicilemere() {
			return adresseDomicilemere;
		}

		public void setAdresseDomicilemere(String adresseDomicilemere) {
			this.adresseDomicilemere = adresseDomicilemere;
		}

		public String getTelephoneDomicilemere() {
			return telephoneDomicilemere;
		}

		public void setTelephoneDomicilemere(String telephoneDomicilemere) {
			this.telephoneDomicilemere = telephoneDomicilemere;
		}

		public String getTelephonePortablemere() {
			return telephonePortablemere;
		}

		public void setTelephonePortablemere(String telephonePortablemere) {
			this.telephonePortablemere = telephonePortablemere;
		}

		public String getEmailmere() {
			return emailmere;
		}

		public void setEmailmere(String emailmere) {
			this.emailmere = emailmere;
		}

		public String getLieuTravailmere() {
			return lieuTravailmere;
		}

		public void setLieuTravailmere(String lieuTravailmere) {
			this.lieuTravailmere = lieuTravailmere;
		}

		public String getTelephoneTravailmere() {
			return telephoneTravailmere;
		}

		public void setTelephoneTravailmere(String telephoneTravailmere) {
			this.telephoneTravailmere = telephoneTravailmere;
		}

		public String getNomUtilisateurmere() {
			return nomUtilisateurmere;
		}

		public void setNomUtilisateurmere(String nomUtilisateurmere) {
			this.nomUtilisateurmere = nomUtilisateurmere;
		}

		public String getMotPasseemere() {
			return motPasseemere;
		}

		public void setMotPasseemere(String motPasseemere) {
			this.motPasseemere = motPasseemere;
		}

		public String getGenremere() {
			return genremere;
		}

		public void setGenremere(String genremere) {
			this.genremere = genremere;
		}

		public String getNommere() {
			return nommere;
		}

		public void setNommere(String nommere) {
			this.nommere = nommere;
		}

		public String getPrenommere() {
			return prenommere;
		}

		public void setPrenommere(String prenommere) {
			this.prenommere = prenommere;
		}

		public String getNomPhotomere() {
			return nomPhotomere;
		}

		public void setNomPhotomere(String nomPhotomere) {
			this.nomPhotomere = nomPhotomere;
		}

		public byte getPhotomere() {
			return photomere;
		}

		public void setPhotomere(byte photomere) {
			this.photomere = photomere;
		}

		public String getNomaccompagnateur() {
			return nomaccompagnateur;
		}

		public void setNomaccompagnateur(String nomaccompagnateur) {
			this.nomaccompagnateur = nomaccompagnateur;
		}

		public String getPrenomaccompagnateur() {
			return prenomaccompagnateur;
		}

		public void setPrenomaccompagnateur(String prenomaccompagnateur) {
			this.prenomaccompagnateur = prenomaccompagnateur;
		}

		public String getCinaccompagnateur() {
			return cinaccompagnateur;
		}

		public void setCinaccompagnateur(String cinaccompagnateur) {
			this.cinaccompagnateur = cinaccompagnateur;
		}

		

		public String getTelephonePortableaccompagnateur() {
			return telephonePortableaccompagnateur;
		}

		public void setTelephonePortableaccompagnateur(
				String telephonePortableaccompagnateur) {
			this.telephonePortableaccompagnateur = telephonePortableaccompagnateur;
		}

		public String getNomPhotoaccompagnateur() {
			return nomPhotoaccompagnateur;
		}

		public void setNomPhotoaccompagnateur(String nomPhotoaccompagnateur) {
			this.nomPhotoaccompagnateur = nomPhotoaccompagnateur;
		}

		public Long getIdenfant() {
			return idenfant;
		}

		public void setIdenfant(Long idenfant) {
			this.idenfant = idenfant;
		}

		public String getNomenfant() {
			return nomenfant;
		}

		public void setNomenfant(String nomenfant) {
			this.nomenfant = nomenfant;
		}

		public String getPrenomenfant() {
			return prenomenfant;
		}

		public void setPrenomenfant(String prenomenfant) {
			this.prenomenfant = prenomenfant;
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

		public void setLieuNaissance(String lieuNaissance) {
			this.lieuNaissance = lieuNaissance;
		}

		public String getLangue() {
			return langue;
		}

		public void setLangue(String langue) {
			this.langue = langue;
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

		public boolean isCertificatMedicale() {
			return certificatMedicale;
		}

		public void setCertificatMedicale(boolean certificatMedicale) {
			this.certificatMedicale = certificatMedicale;
		}

		public boolean isAutorisationPrisePhoto() {
			return autorisationPrisePhoto;
		}

		public void setAutorisationPrisePhoto(boolean autorisationPrisePhoto) {
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

		

		public String getNomPhotoEnfant() {
			return nomPhotoEnfant;
		}

		public void setNomPhotoEnfant(String nomPhotoEnfant) {
			this.nomPhotoEnfant = nomPhotoEnfant;
		}

		public byte[] getPhotoEnfant() {
			return photoEnfant;
		}

		public void setPhotoEnfant(byte[] photoEnfant) {
			this.photoEnfant = photoEnfant;
		}

		public Long getIdaccompagnateur() {
			return idaccompagnateur;
		}

		public void setIdaccompagnateur(Long idaccompagnateur) {
			this.idaccompagnateur = idaccompagnateur;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public byte[] getPhotoaccompagnateur() {
			return photoaccompagnateur;
		}

		public void setPhotoaccompagnateur(byte[] photoaccompagnateur) {
			this.photoaccompagnateur = photoaccompagnateur;
		}

		public Collection<Accompagnateur> getAccompagnateurs() {
			return accompagnateurs;
		}

		public void setAccompagnateurs(Collection<Accompagnateur> accompagnateurs) {
			this.accompagnateurs = accompagnateurs;
		}

		public Collection<Parent> getParents() {
			return parents;
		}

		public void setParents(Collection<Parent> parents) {
			this.parents = parents;
		}

		public Enfant getEnfant() {
			return enfant;
		}

		public void setEnfant(Enfant enfant) {
			this.enfant = enfant;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public String getGenreTest() {
			return genreTest;
		}

		public void setGenreTest(String genreTest) {
			this.genreTest = genreTest;
		}

		public String getNomClasse() {
			return nomClasse;
		}

		public void setNomClasse(String nomClasse) {
			this.nomClasse = nomClasse;
		}

		public int getNombrePlacesClasse() {
			return nombrePlacesClasse;
		}

		public void setNombrePlacesClasse(int nombrePlacesClasse) {
			this.nombrePlacesClasse = nombrePlacesClasse;
		}

		public long getIdClasse() {
			return idClasse;
		}

		public void setIdClasse(long idClasse) {
			this.idClasse = idClasse;
		}

		public List<Classe> getClassesF() {
			return classesF;
		}

		public void setClassesF(List<Classe> classesF) {
			this.classesF = classesF;
		}

		
		
		
		

		
		
}
