package org.gestion.cr.metier;

import java.util.Date;
import java.util.List;

import org.gestion.cr.entities.Accompagnateur;
import org.gestion.cr.entities.CategorieClub;
import org.gestion.cr.entities.CategorieClubEquipeEducatif;
import org.gestion.cr.entities.Classe;
import org.gestion.cr.entities.ClasseEquipeEducatif;
import org.gestion.cr.entities.Club;
import org.gestion.cr.entities.ClubEnfant;
import org.gestion.cr.entities.Consultation;
import org.gestion.cr.entities.Creche;
import org.gestion.cr.entities.Enfant;
import org.gestion.cr.entities.Equipe;
import org.gestion.cr.entities.EquipeEducatif;
import org.gestion.cr.entities.EquipeSanitaire;
import org.gestion.cr.entities.Evenement;
import org.gestion.cr.entities.EvennementEnfant;
import org.gestion.cr.entities.Fonction;
import org.gestion.cr.entities.Fournisseur;
import org.gestion.cr.entities.Inscription;
import org.gestion.cr.entities.Materiel;
import org.gestion.cr.entities.MatrielSanitaUtiliser;
import org.gestion.cr.entities.MatrielUtiliser;
import org.gestion.cr.entities.Parent;
import org.gestion.cr.entities.Payment;
import org.gestion.cr.entities.Personne;
import org.gestion.cr.entities.PlanningEnfant;
import org.gestion.cr.entities.PlanningHorraires;
import org.gestion.cr.entities.Stock;
import org.gestion.cr.entities.TypeMateriels;

public interface IAdminMetier extends InternauteMetier

{

	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	//Gestion des CategorieClubs 

		public Long ajouterCategorieClub(CategorieClub categorieClub); 
		public void supprimerCategorieClub(Long idCategorieClub); 
		public void modifierCategorieClub(CategorieClub categorieClub); 
		
		
		//Gestion des Clubs
		
		public Long ajouterClubs(Club club,Long idCtagorieClubs); 
		public void supprimerClubs(Long idClubs); 
		public void modifierClubs(Club clubs); 
		
		
		
		//Gestion des PlanningHorraires 
		
		public Long ajouterPlanningHorraires(PlanningHorraires planningHorraires); 
		public void supprimerPlanningHorraires(Long idPlanningHorraires); 
		public void modifierPlanningHorraires(PlanningHorraires planningHorraires); 
		
		
		
		
		//gestion des Creches    
		
		/*public Long ajouterCreche(Creche creche); 
		public void supprimerCreche(Long idCreche); 
		public void modifierCreche(Creche creche); */
		
		
		
		
		//Gestion des Classes 
		
		public Long ajouterClasse(Classe classe); 
		public void supprimerClasse(Long idClasse); 
		public void modifierClasse(Classe classe); 

		
		

		
		//Gestion des Equipes Sanitaire
		
		public Long ajouterEquipeSanitaire(EquipeSanitaire equipeSanitaire,Long idFonction); 
		public void supprimerEquipeSanitaire(Long idEquipeSanitaire); 
		public void modifierEquipeSanitaire(EquipeSanitaire equipeSanitaire); 
		
	 	
		
		//Gestion des Equipes Educatifs 
		
		public Long ajouterEquipeEducatif(EquipeEducatif equipeEducatif,Long idFonction); 
		public void supprimerEquipeEducatif(Long idEquipeEducatif); 
		public void modifierEquipeEducatif(EquipeEducatif equipeEducatif); 
		
		
		
		//Gestion des Fonctions 
		
		public Long ajouterFonction(Fonction fonction); 
		public void supprimerFonction(Long idFonction); 
		public void modifierFonction(Fonction fonction); 
		
		
		/////////////////////////////////////////////////////////////////////
		
		//Gestion des Accompagnateurs 
		
		
		
		public Long ajouterAccompagnateur(Accompagnateur accompagnateur); 
	    public void supprimerAccompagnateurs(Long idAccompagnateur); 
		public void modifierAccompagnateurs(Accompagnateur accompagnateur); 
	    public void ajouterEnfantsPourAccompagnateur(Long idEnfant,Long idAccompagnateur);
		
	     /////////////////////////////////////////////////////////////////////
		
		
		
		//Gestion des Inscriptions 
	//    public Inscription ajouterInscription(Inscription in,Long idEnf,Long idClass,String d);
		
		public Inscription ajouterInscription(Inscription i,Long idEnf,Long idClas);
		public void supprimerInscription(Long idEnf,Long idClas,String d);
		public void modifierInscription(Inscription i);
		public Inscription getLastInscriptionEnfant(Long idEnf);
		
		
		 /////////////////////////////////////////////////////////////////////
		
		
		//Gestion des Consultations 
		
		//public Consultation ajouterConsulation(Consultation c,Long idEnf,Long idEqSan,String d);
	    public void supprimerConsultation( Long idEnf,Long idEqSan,String d);
		public void modifierConsultation(Consultation c);
		public Consultation ajouterConsultation(Consultation c,Long idEnf,Long idEqSani);
		
		
		
		
		 /////////////////////////////////////////////////////////////////////
		
	    //Gestion des Parents 
		
		public Long ajouterParent(Parent parent); 
		public void supprimerParent(Long idParent); 
		public void modifierParent(Parent parent); 
		
		
	    
	   
	    /////////////////////////////////////////////////////////////////////
		
		
		//Gestion des Evennements
		
		public Long ajouterEvennement(Evenement evennement);
		public void supprimerEvennements(Long idEvennement); 
		public void modifierEvennements(Evenement evennement); 
		
		
		
		
		
		
	    /////////////////////////////////////////////////////////////////////
		
		//Gestion des Enfants 
		
		public Long ajouterEnfant(Enfant enfant); 
		public void supprimerEnfant(Long idEnfant);
		public void modifierEnfant(Enfant enfant); 
		public void ajouterAccompagnateursPourEnfant(Long idAccompagnateur,Long idEnfant);
		
		public void ajouterParentsPourEnfant(Long idParent,Long idEnfant);
		public Long nbrEnfantClasse(Long idCla);	
		public void ajouterEnfantToParent(Long idEnf,Long idPar);
		
		
		public void ajouterEnfantToAccompagnteur(Long idEnf,Long idAcc);
		
		public void ajouterFournisseurToMateriel(Long idFour,Long idMat);
		
		
		
		
		
		//Gestion des Fournisseurs
		
		public Long ajouterFournisseur(Fournisseur fournisseur); 
		public void supprimerFournisseur(Long idFournisseur); 
		public void modifierFournisseur(Fournisseur fournisseur); 
		
		
		
		
		
		//Gestion des Materiels
		
		public Long ajouterMateriels(Materiel materiels,Long idTypeMateriels,Long idStock); 
		public void supprimerMateriels(Long idMateriels); 
		public void modifierMateriels(Materiel materiels); 
		
		public void ajouterFournisseurPourMateriel(Long idFournisseur,Long idMateriel);
		
		public void ajouterMaterielPourFournisseur(Long idMateriel,Long idFournisseur);
		
		
		
		
		
		
		//Gestion des typesMateriels
		
		public Long ajouterTypeMateriel(TypeMateriels typeMateriels); 
	    public void supprimerTypeMateriels(Long idTypeMateriels); 
		public void modifierTypeMateriels(TypeMateriels typeMateriels); 
		
		
		
		
		
		//Gestion des stocks materiels
		
		public Long ajouterStock(Stock stock); 
		public void supprimerStock(Long idStock); 
		public void modifierStock(Stock stock); 
		
		
		
		//Gestion Matriel utilisé
		
		
				public MatrielUtiliser ajouterMatrielUtiliser(MatrielUtiliser m,Long idMat,Long idEqEducat,Date d);
				public void supprimerMatrielUtiliser(Long idMat ,Long idEqEducatif,Date d);
				public void modifierMatrielUtiliser(MatrielUtiliser m);
				
				
				
				
				
				//Gestion Matriel Sanitaire  utilisé
				
				
			   public MatrielSanitaUtiliser ajouterMatrielSanitaireUtiliser(MatrielSanitaUtiliser m,Long idMat,Long idSani,Date dateDebutUtilisation);
			   public void supprimerMatrielSanitaireUtiliser(Long idMat ,Long idEqSani,Date d);
			   public void modifierMatrielSanitaireUtiliser(MatrielSanitaUtiliser me);
			   
			   
			   
			   

				//Gestion Enfant_Club
				
				
				
			   public ClubEnfant ajouterEnfantClub(ClubEnfant m,Long idClub,Long idEnf,Date dateDebutInscription);
			   public void supprimerEnfantClub(Long idClub ,Long idEnf,Date dateDebutUtilisation);
			   public void modifierEnfantClub(ClubEnfant me);
			   
				

				//Gestion Enfant_Planning
				
				
			   public PlanningEnfant ajouterEnfantPlanning(PlanningEnfant m,Long idEnf,Long idPlan,Date dateDebutInscription);
			   public void supprimerPlanningEnfant(Long idEnf ,Long idPlan,Date dateDebutInscription);
			   public void modifierPlanningEnfant(PlanningEnfant me);
			   
			
			   
			   
			   

				//Gestion Enfant_Evennement
				
				
			   public EvennementEnfant ajouterEvennementEnfant(EvennementEnfant m,Long idEnf,Long idEvene,Date dateDebutInscription);
			   public void supprimerEvennementEnfant(Long idEnf ,Long idEvene,Date dateDebutInscription);
			   public void modifierEvennementEnfant(EvennementEnfant me);
			   
			   
			   
			 //Gestion Equipeeducatif_Classes
				
				
				
			   public ClasseEquipeEducatif ajouterEquipeEducatifClasse(ClasseEquipeEducatif m,Long idClass,Long idEquipeEducatif,Date dateDebutInscrClass);
			   public void supprimerEquipeEducatifClasse(Long idClass ,Long idEquipEducatif,Date dateDebutInscrClass);
			   public void modifierEquipeEducatifClasse(ClasseEquipeEducatif cl);
			   
			   
			   
			   
			   //Gestion Equipeeducatif_Categories
				
				
				
			   public CategorieClubEquipeEducatif ajouterCategorieClubEquipeEducatif(CategorieClubEquipeEducatif m,Long idCateg,Long idEquipeEducatif,Date dateDebutInscrClub);
			   public void supprimerCategorieClubEquipeEducatif(Long idCateg ,Long idEquipeEducatif,Date dateDebutInscrClubString );
			   public void modifierCategorieClubEquipeEducatif(CategorieClubEquipeEducatif cat);
			   
			  
			

			   	//gestion Payment
	
			   public Payment getPayementMoisCourant(Long idEnfant, String moisPayment);
			   public List<Payment> listPayments();
			   public Payment ajouterPayment(Payment p, Long idEnfant, String moisPayment) ;
			   public Payment ajouterPayment(Payment p);
			   public void modifierPayment(Payment p);
			   public List<Payment> listPaymentEnfant(Long idEnf);
			   public Payment getPaymentAnnuelle(Long idEnf,String annee,String naturePaiement);
			   
			   public Payment getPaymentMensuel(Long idEnf,String anneeMois,String naturePaiement);
}
	

