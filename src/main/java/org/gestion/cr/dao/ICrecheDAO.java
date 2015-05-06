package org.gestion.cr.dao;

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
import org.gestion.cr.entities.HistoriqueClub;
import org.gestion.cr.entities.HistoriquePlaning;
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


public interface ICrecheDAO

{

	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	

	//Gestion des CategorieClubs 
	
		public Long ajouterCategorieClub(CategorieClub categorieClub); 
		public CategorieClub getCategorieClub(Long idCategorieClub); 
		public void supprimerCategorieClub(Long idCategorieClub); 
		public void modifierCategorieClub(CategorieClub categorieClub); 
		
		public long getNombreCategorieClubs();
		public List<CategorieClub> listCategorieClubs(); 
		public List<CategorieClub> listCategorieClubs(int position,int nbrCategorieClubs); 
		
		

		
		//Gestion des Clubs
		
		public Long ajouterClubs(Club club,Long idCtagorieClubs); 
		public List<Club> clubsParNom(String nomClub); 
		public Club getClubs(Long idClubs);
		public void supprimerClubs(Long idClubs); 
		public void modifierClubs(Club clubs); 
		
		
		
		public long getNombreClubs();
		public List<Club> listClubs(); 
		public List<Club> listClubs(int position,int nbrClubs); 

		//public List<Club> clubParcategorieClub(Long idCategorieClub);
		//public void ajouterClubPourInscription(Long idClubs,Long idInscription);
		//public List<Club> clubsParInscription(Long idInscription); 
		
		
		
		//Gestion des PlanningHorraires 
		
		public Long ajouterPlanningHorraires(PlanningHorraires planningHorraires); 
		public PlanningHorraires getPlanningHorraires(Long idPlanningHorraires); 
		public void supprimerPlanningHorraires(Long idPlanningHorraires); 
		public void modifierPlanningHorraires(PlanningHorraires planningHorraires); 
		
		
		
		public long getNombrePlanningHorraires();
		public List<PlanningHorraires> listPlanningHorraires(); 
		public List<PlanningHorraires> listPlanningHorraires(int position,int nbrPlanningHorraires); 
		
		
		
		//gestion des Creches    
		
		public Creche ajouterCreche(Creche creche,String annee); 
		
		public Creche getCreche(String annee); 
		
		public List<Creche> listCreches(); 
		
		/*
		public List<Creche> crecheParNom(String nomCreche);
		
		public void supprimerCreche(Long idCreche); 
		public void modifierCreche(Creche creche); 
		
		public long getNombreCreches();
		
		public List<Creche> listCreches(); 
		public List<Creche> listCreches(int position,int nbrCreches); */
		
		
		
		
		//Gestion des Classes 
		
		public Long ajouterClasse(Classe classe); 
		public Classe getClasse(Long idClasse); 
		public void supprimerClasse(Long idClasse); 
		public void modifierClasse(Classe classe); 
	
		
		
	
		
		public long getNombreClasses();
		public List<Classe> listClasse(); 
		public List<Classe> listClasse(int position,int nbrClasses); 
		
		public List<Enfant> getEnfantsByClasse(Long idClasse);
		
		//public List<Classe> classeParNom(String nom);  
		//public List<EquipeEducatif> getEquipeEducatifByClasse(Long idClasse);
		//public void ajouterEquipeEducatifPourClasse(Long idEquipeEducatif,Long idClasse);
		

		
		//Gestion des Equipes Sanitaire
		
		public Long ajouterEquipeSanitaire(EquipeSanitaire equipeSanitaire,Long idFonction); 
		public void supprimerEquipeSanitaire(Long idEquipeSanitaire); 
		public void modifierEquipeSanitaire(EquipeSanitaire equipeSanitaire); 
		public List<EquipeSanitaire> equipeSanitaireParNom(String nom);  
		public List<EquipeSanitaire> equipeSanitaireParFonction(Long idFonction); 
		public EquipeSanitaire getEquipeSanitaire(Long idEquipeSanitaire); 
		
		
		
		
		
	    public long getNombreEquipesSan();
	    public List<EquipeSanitaire> listEquipeSanitaires(); 
	    public List<EquipeSanitaire> listEquipeSanitaires(int position,int nbrEquipesSan); 
	    
	  //public List<EquipeSanitaire> equipeSanitaireParEnfant(Long idEnfants); 
		
		
		//Gestion des Equipes Educatifs 
		
		public Long ajouterEquipeEducatif(EquipeEducatif equipeEducatif,Long idFonction); 
		public EquipeEducatif getEquipeEducatif(Long idEquipeEducatif); 
		public void supprimerEquipeEducatif(Long idEquipeEducatif); 
		public void modifierEquipeEducatif(EquipeEducatif equipeEducatif); 
		public List<EquipeEducatif> equipeEducatifParNom(String nom); 
		public List<EquipeEducatif> equipeEducatifParFonction(Long idFonction); 
		
		

		public long getNombreEquipesEdu();
		public List<EquipeEducatif> listEquipeEducatif();  
		public List<EquipeEducatif> listEquipeEducatif(int position,int nbrEquipesEdu); 
		
		
		//public List<Classe> getClassesByEquipeEducatif(Long idEquipeEducatif); 
		//public void ajouterClassesPourEquipeEducatifs(Long idClasse,Long idEquipeEducatif);
		
		//Gestion des Fonctions 
		
		public Long ajouterFonction(Fonction fonction); 
		public Fonction getFonction(Long idFonction); 
		public void supprimerFonction(Long idFonction); 
		public void modifierFonction(Fonction fonction); 
		
		public long getNombreFonctions();
		public List<Fonction> listFonctions();  
		public List<Fonction> listFonctions(int position,int nbrFonctions); 
		
		/////////////////////////////////////////////////////////////////////
		
		//Gestion des Accompagnateurs 
		
		
		
		public Long ajouterAccompagnateur(Accompagnateur accompagnateur); 
	    public List<Accompagnateur> accompagnateurParNom(String nom); 
		public Accompagnateur getAccompagnateur(Long idAccompagnateur); 
		public void supprimerAccompagnateurs(Long idAccompagnateur); 
		public void modifierAccompagnateurs(Accompagnateur accompagnateur); 
		
		
		public long getNombreAccompagnateurs();
		public List<Accompagnateur> listAccompagnateurs(); 
		public List<Accompagnateur> listAccompagnateurs(int position,int nbrAccompagnateurs); 
		
		
		
		public List<Enfant> getEnfantsByAccompagnateur(Long idAccompagnateur);
		public void ajouterEnfantsPourAccompagnateur(Long idEnfant,Long idAccompagnateur);
		
         /////////////////////////////////////////////////////////////////////
		
		
		
		//Gestion des Inscriptions 
		
		//public Inscription ajouterInscription(Inscription in,Long idEnf,Long idClass,String d);
		public Inscription ajouterInscription(Inscription i,Long idEnf,Long idClas);
		public Inscription getInscription(Long idEnf,Long idClas,String d);
		public void supprimerInscription(Long idEnf,Long idClas,String d);
		public void modifierInscription(Inscription i);
		public Long getInscriptionEnf(Long idEnf,String annee);
		public Inscription getLastInscriptionEnfant(Long idEnf);
		public Inscription getInscriptionEnfAnnee(Long idEnf, String d);
		
		
		
		public Consultation getConsultationEnfDate(Long idEnf, String date);
		
		
		//public Inscription getInscriptionClassAnnee(Long idEnf, String d);
		
		public List<Inscription> listInscriptionsParClassAnne(Long idClass); 
		
		
		public long getNombreInscriptions();
		public List<Inscription> listInscriptions(); 
		public List<Inscription> listInscriptions(int position,int nbrInscriptions); 
		
		
		 /////////////////////////////////////////////////////////////////////
		
		
		//Gestion des Consultations 
		
		//public Consultation ajouterConsulation(Consultation c,Long idEnf,Long idEqSan,String d);
		public Consultation ajouterConsultation(Consultation c,Long idEnf,Long idEqSani);
		public Consultation getConsulation( Long idEnf,Long idEqSan,String d);
		public void supprimerConsultation( Long idEnf,Long idEqSan,String d);
		public Long getConsultationEnf(Long idEnf,String d);
		public void modifierConsultation(Consultation c);
		
		
		public long getNombreConsultations();
		public List<Consultation> listConsultations(); 
		public List<Consultation> listConsultations(int position,int nbrConsultations); 
		
		//public List<Enfant> getEnfantByEqSanitaireyConsultation(Long idEquipeSanitaire,Long idConsultation);
		//public List<EquipeSanitaire> getEquipeSanitairesByEnfantbyConsultation(Long idEnfant,Long idConsultation);
		
		 /////////////////////////////////////////////////////////////////////
		
	    //Gestion des Parents 
		
		public Long ajouterParent(Parent parent); 
		public List<Parent> parentParNom(String nomParent); 
		public Parent getParent(Long idParent); 
		
		public Parent getParentbycin(String cin);
		//public List<Parent> listPere(String genre);
		//public List<Parent> listMere(String genre);
		public void supprimerParent(Long idParent); 
		public void modifierParent(Parent parent); 
		
		
		
		
		
		public List<Parent> listParents(int position,int nbrParents); 
		public List<Parent> listParents(); 
	    public long getNombreParents();
	    
	    
	    
	    public List<Parent> listParents2(int position,int nbrParents); 
		
	    public long getNombreParents2();
	    
	    
	    public List<Enfant> getEnfantByParent(Long idParent);
	    public void ajouterEnfantsPourParent(Long idEnfant,Long idParent);
	    
	    
	   
	    /////////////////////////////////////////////////////////////////////
		
		
		//Gestion des Evennements
		
		public Long ajouterEvennement(Evenement evennement); 
		public List<Evenement> evennementParNom(String nom); 
		public Evenement getEvennement(Long idEvennement); 
		public void supprimerEvennements(Long idEvennement); 
		public void modifierEvennements(Evenement evennement); 
			
		
		public long getNombreEvennements();
		public List<Evenement> listEvennements();
		public List<Evenement> listEvennements(int position,int nbrEvennements); 
		
		
		public List<Enfant> getEnfantsByEvennement(Long idEvennement);
		
		
		
		
		
		
        /////////////////////////////////////////////////////////////////////
		
		//Gestion des Enfants 
		
		public Long ajouterEnfant(Enfant enfant); 
		
		public List<Enfant> enfantParNom(String nom); 
		public Enfant getEnfant(Long idEnfant); 
		public List<Enfant> enfantCertife(); 
		public List<Enfant> enfantPhotoAutorise(); 
		public List<Enfant> EnfantParMotCle(String mc);
		public List<Enfant> EnfantParParent(Long idPar);
		public List<Inscription> EnfantParClasse(Long idClas);
		public List<ClubEnfant> EnfantParClub(Long idClub);
		public List<Enfant> EnfantParEvenement(Long idEve);
		public List<Enfant> EnfantParAccompagnaeurt(Long idAcc);
		public List<Enfant> EnfantParPlanningH(Long idPlan);
		public List<Enfant> EnfantSelectionnes();
		public void supprimerEnfant(Long idEnfant);
		public void modifierEnfant(Enfant enfant); 
		public List<Accompagnateur> getAccompagnateursByEnfant(Long idEnfant);
		public List<Evenement> getEvennementsByEnfant(Long idEnfant);
		public List<Parent> getParentsByEnfant(Long idEnfant);
		public void ajouterAccompagnateursPourEnfant(Long idAccompagnateur,Long idEnfant);
		
		public void ajouterParentsPourEnfant(Long idParent,Long idEnfant);
		public Long nbrEnfantClasse(Long idCla);	
		public void ajouterEnfantToParent(Long idEnf,Long idPar);
	
		public void ajouterEnfantToAccompagnteur(Long idEnf,Long idAcc);
		
		public void ajouterFournisseurToMateriel(Long idFour,Long idMat);
		
		
		public List<PlanningEnfant> EnfantParPlanning(Long idPlanning);
		
		
		
		public List<Enfant> listEnfants(int position,int nbrEnfants); 
		public List<Enfant> listEnfants();  
	    public long getNombreEnfants();
	    
	    
		
		
		//Gestion des Fournisseurs
		
		public Long ajouterFournisseur(Fournisseur fournisseur); 
		
		public List<Fournisseur> fournisseurParNom(String nom); 
		public Fournisseur getFournisseur(Long idFournisseur); 
		public void supprimerFournisseur(Long idFournisseur); 
		public void modifierFournisseur(Fournisseur fournisseur); 
		public List<Materiel> getMaterielsByFournisseur(Long idFournisseur);
		
		
		
	     public long getNombreFournisseurs();
	     public List<Fournisseur> listFournisseurs(); 
	     public List<Fournisseur> listFournisseurs(int position,int nbrFournisseurs); 
		
		//Gestion des Materiels
		
		public Long ajouterMateriels(Materiel materiels,Long idTypeMateriels,Long idStock); 
		public List<Materiel> materielsParDesignation(String designation); 
		public Materiel getMateriels(Long idMateriels); 
		public void supprimerMateriels(Long idMateriels); 
		public void modifierMateriels(Materiel materiels); 
		
		public List<Equipe> getEquipeByMateriels(Long idMateriels);
		
		public void ajouterFournisseurPourMateriel(Long idFournisseur,Long idMateriel);
		
		public void ajouterMaterielPourFournisseur(Long idMateriel,Long idFournisseur);
		
		
		
		
	//	public List<EquipeSanitaire> materielsParEquipeSanitaire(Long idEquipeSanitaire);
	//	public List<EquipeEducatif> materielsParEquipeEducatif(Long idEquipeEducatif);
		
		
		
		public long getNombreMateriels();
		public List<Materiel> listMateriels();  
		public List<Materiel> listMateriels(int position,int nbrMateriels); 
		
		
		
		
		//Gestion des typesMateriels
		
		public Long ajouterTypeMateriel(TypeMateriels typeMateriels); 
	  
		public TypeMateriels getTypeMateriels(Long idTypeMateriels);
		public void supprimerTypeMateriels(Long idTypeMateriels); 
		public void modifierTypeMateriels(TypeMateriels typeMateriels); 
		
		public long getNombreTypesMateriels();
		public List<TypeMateriels> listTypeMateriels(); 
		public List<TypeMateriels> listTypeMateriels(int position,int nbrTypesMateriels); 
		
		
		
		//Gestion des stocks materiels
		
		public Long ajouterStock(Stock stock); 
		public Stock getStock(Long idStock);
		public void supprimerStock(Long idStock); 
		public void modifierStock(Stock stock); 
		
		public long getNombreStocks();
		public List<Stock> listStock(); 
		public List<Stock> listStock(int position,int nbrStocks); 
		
		
		//Gestion Matriel utilisé
		
		
		public MatrielUtiliser ajouterMatrielUtiliser(MatrielUtiliser m,Long idMat,Long idEqEducat,Date d);
		public List<MatrielUtiliser> listMatrielUtiliser();
		public MatrielUtiliser getMatrielUtiliser(Long idMat,Long idEsEducatif,Date d);
		public void supprimerMatrielUtiliser(Long idMat ,Long idEqEducatif,Date d);
		public void modifierMatrielUtiliser(MatrielUtiliser m);
		
		
		public List <MatrielUtiliser>  ListMaterielActifsEqEducatif (Long idEqEducatif);
		
		
		
		//Gestion Matriel Sanitaire  utilisé
		
		
	   public MatrielSanitaUtiliser ajouterMatrielSanitaireUtiliser(MatrielSanitaUtiliser m,Long idMat,Long idSani,Date dateDebutUtilisation);
	   public List<MatrielSanitaUtiliser> listMatrielSanitaireUtiliser();
	   public MatrielSanitaUtiliser getMatrielSanitaireUtiliser(Long idMat,Long idSani,Date d);
	   public void supprimerMatrielSanitaireUtiliser(Long idMat ,Long idEqSani,Date d);
	   public void modifierMatrielSanitaireUtiliser(MatrielSanitaUtiliser me);
	   
	   
	   public List <MatrielSanitaUtiliser>  ListMaterielActifsEqSanitaire (Long idSanitaire);
	   
	   

		//Gestion Enfant_Club
		
		
		
	   public ClubEnfant ajouterEnfantClub(ClubEnfant m,Long idClub,Long idEnf,Date dateDebutInscription);
	   public List<ClubEnfant> listEnfantClub();
	   public ClubEnfant getEnfantClub(Long idClub,Long idEnf,Date dateDebutUtilisation);
	   public void supprimerEnfantClub(Long idClub ,Long idEnf,Date dateDebutUtilisation);
	   public void modifierEnfantClub(ClubEnfant me);
	   
	   public List <ClubEnfant>  ListClubActifsEnfant (Long idEnf);
	   public List <ClubEnfant>  ListClubEnfantParAnnee (Long idEnf,Date dateClub);
	   
	   public List <ClubEnfant>  ListEnfantsActifsClubs (Long idClub);
	

		//Gestion Enfant_Planning
		
		
	   public PlanningEnfant ajouterEnfantPlanning(PlanningEnfant m,Long idEnf,Long idPlan,Date dateDebutInscription);
	   public List<PlanningEnfant> listPlanningEnfant();
	   public PlanningEnfant getPlanningEnfant(Long idEnf,Long idPlan,Date dateDebutInscription);
	   public void supprimerPlanningEnfant(Long idEnf ,Long idPlan,Date dateDebutInscription);
	   public void modifierPlanningEnfant(PlanningEnfant me);

	
	   public List <PlanningEnfant>  ListPlanningActifsEnfant (Long idEnf);
	   
	   
	   public List <PlanningEnfant>  ListEnfantsActifsPlannings (Long idPlannings);
	   
	   
	   

		//Gestion Enfant_Evennement
		
		
	   public EvennementEnfant ajouterEvennementEnfant(EvennementEnfant m,Long idEnf,Long idEvene,Date dateDebutInscription);
	   public List<EvennementEnfant> listEvennementEnfant();
	   public EvennementEnfant getEvennementEnfant(Long idEnf,Long idEvene,Date dateDebutInscription);
	   public void supprimerEvennementEnfant(Long idEnf ,Long idEvene,Date dateDebutInscription);
	   public void modifierEvennementEnfant(EvennementEnfant me);
	   
	   public List <EvennementEnfant>  ListEvennementActifsEnfant (Long idEnf);
	   
	   
	 //Gestion Equipeeducatif_Classes
		
		
		
	   public ClasseEquipeEducatif ajouterEquipeEducatifClasse(ClasseEquipeEducatif m,Long idClass,Long idEquipeEducatif,Date dateDebutInscrClass);
	   public List<ClasseEquipeEducatif> listEquipeEducatifClasse();
	   public ClasseEquipeEducatif getEquipeEducatifClasse(Long idClass,Long idEquipEducatif,Date dateDebutInscrClass);
	   public void supprimerEquipeEducatifClasse(Long idClass ,Long idEquipEducatif,Date dateDebutInscrClass);
	   public void modifierEquipeEducatifClasse(ClasseEquipeEducatif cl);
	   
	   public List <ClasseEquipeEducatif>  ListClasseActifsEquEducatif (Long idEqEducatif);
	   
	   
	   
	   //Gestion Equipeeducatif_Categories
		
		
		
	   public CategorieClubEquipeEducatif ajouterCategorieClubEquipeEducatif(CategorieClubEquipeEducatif m,Long idCateg,Long idEquipeEducatif,Date dateDebutInscrClub);
	   public List<CategorieClubEquipeEducatif> listCategorieClubEquipeEducatif();
	   public CategorieClubEquipeEducatif getCategorieClubEquipeEducatif(Long idCateg,Long idEqEdu,Date dateDebutInscrClub);
	   public void supprimerCategorieClubEquipeEducatif(Long idCateg ,Long idEquipeEducatif,Date dateDebutInscrClubString );
	   public void modifierCategorieClubEquipeEducatif(CategorieClubEquipeEducatif cat);
	   
	   public List <CategorieClubEquipeEducatif>  ListCategorieClubActifsEquipeEducatif (Long idEqEduc);
	  
	
	   //////////////////////////////////////////////:
	   
	   
	   
	   
	  


	    public HistoriquePlaning ajouterPlanningHistor(HistoriquePlaning h,Long idPla);
		public List<HistoriquePlaning> listPlanningHistor(Long idPla);
		public HistoriquePlaning countPlaning(Long idPla);
		public void modifierHistoriquePl(HistoriquePlaning h);





	    public HistoriqueClub ajouterClubHistor(HistoriqueClub h,Long idClub);
		public List<HistoriqueClub> listClubHistor(Long idClub);
		public HistoriqueClub countClub(Long idClub);
		public void modifierHistoriqueCl(HistoriqueClub h);
		
		  public Payment getPayementMoisCourant(Long idEnfant, String moisPayment);
		   public List<Payment> listPayments();
		   public Payment ajouterPayment(Payment p, Long idEnfant, String moisPayment) ;
		   public Payment ajouterPayment(Payment p);
		   public void modifierPayment(Payment p);
		   public List<Payment> listPaymentEnfant(Long idEnf);
		   
		   public Payment getPaymentAnnuelle(Long idEnf,String annee,String naturePaiement);
		   public Inscription getInscriAnnuelle(Long idEnf,Long idClass,String annee);
		   
		   public Payment getPaymentMensuel(Long idEnf,String anneeMois,String naturePaiement);
		   
		   
		   public List<EvennementEnfant> EnfantParEvennement(Long idEvenne);

		   
		  
	
	
}
	