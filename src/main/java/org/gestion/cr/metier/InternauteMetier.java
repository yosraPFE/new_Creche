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

public interface InternauteMetier
{

	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	//Gestion des CategorieClubs 
	
	public CategorieClub getCategorieClub(Long idCategorieClub); 
	
	public long getNombreCategorieClubs();
	public List<CategorieClub> listCategorieClubs(); 
	public List<CategorieClub> listCategorieClubs(int position,int nbrCategorieClubs); 
	
	
	
	//Gestion des Clubs
	
	public List<Club> clubsParNom(String nomClub); 
	public Club getClubs(Long idClubs);
	
	
	
	public long getNombreClubs();
	public List<Club> listClubs(); 
	public List<Club> listClubs(int position,int nbrClubs); 

	
	
	
	
	
	//Gestion des PlanningHorraires 
	
	public PlanningHorraires getPlanningHorraires(Long idPlanningHorraires); 
	
	
	
	public long getNombrePlanningHorraires();
	public List<PlanningHorraires> listPlanningHorraires(); 
	public List<PlanningHorraires> listPlanningHorraires(int position,int nbrPlanningHorraires); 
	
	
	
	//gestion des Creches    
	
	/*public List<Creche> crecheParNom(String nomCreche);
	public Creche getCreche(Long idCreche); 
	
	public long getNombreCreches();
	public List<Creche> listCreches(); 
	public List<Creche> listCreches(int position,int nbrCreches); */
	
	
	
	
	//Gestion des Classes 
	
	public Classe getClasse(Long idClasse); 
	
	
	

	
	public long getNombreClasses();
	public List<Classe> listClasse(); 
	public List<Classe> listClasse(int position,int nbrClasses); 
	
	public List<Enfant> getEnfantsByClasse(Long idClasse);
	
	//public List<Classe> classeParNom(String nom);  
	//public List<EquipeEducatif> getEquipeEducatifByClasse(Long idClasse);
	//public void ajouterEquipeEducatifPourClasse(Long idEquipeEducatif,Long idClasse);
	

	
	//Gestion des Equipes Sanitaire
	
	public List<EquipeSanitaire> equipeSanitaireParNom(String nom);  
	public List<EquipeSanitaire> equipeSanitaireParFonction(Long idFonction); 
	public EquipeSanitaire getEquipeSanitaire(Long idEquipeSanitaire); 
	
	
	
	
	
    public long getNombreEquipesSan();
    public List<EquipeSanitaire> listEquipeSanitaires(); 
    public List<EquipeSanitaire> listEquipeSanitaires(int position,int nbrEquipesSan); 
    
  //public List<EquipeSanitaire> equipeSanitaireParEnfant(Long idEnfants); 
	
	
	//Gestion des Equipes Educatifs 
	
	public EquipeEducatif getEquipeEducatif(Long idEquipeEducatif); 
	public List<EquipeEducatif> equipeEducatifParNom(String nom); 
	public List<EquipeEducatif> equipeEducatifParFonction(Long idFonction); 
	
	

	public long getNombreEquipesEdu();
	public List<EquipeEducatif> listEquipeEducatif();  
	public List<EquipeEducatif> listEquipeEducatif(int position,int nbrEquipesEdu); 
	
	
	//public List<Classe> getClassesByEquipeEducatif(Long idEquipeEducatif); 
	//public void ajouterClassesPourEquipeEducatifs(Long idClasse,Long idEquipeEducatif);
	
	//Gestion des Fonctions 
	
	public Fonction getFonction(Long idFonction); 
	
	public long getNombreFonctions();
	public List<Fonction> listFonctions();  
	public List<Fonction> listFonctions(int position,int nbrFonctions); 
	
	/////////////////////////////////////////////////////////////////////
	
	//Gestion des Accompagnateurs 
	
	
	
    public List<Accompagnateur> accompagnateurParNom(String nom); 
	public Accompagnateur getAccompagnateur(Long idAccompagnateur); 
	
	
	public long getNombreAccompagnateurs();
	public List<Accompagnateur> listAccompagnateurs(); 
	public List<Accompagnateur> listAccompagnateurs(int position,int nbrAccompagnateurs); 
	
	
	
	public List<Enfant> getEnfantsByAccompagnateur(Long idAccompagnateur);
	public void ajouterEnfantsPourAccompagnateur(Long idEnfant,Long idAccompagnateur);
	
     /////////////////////////////////////////////////////////////////////
	
	
	
	//Gestion des Inscriptions 
	
	
	public Inscription getInscription(Long idEnf,Long idClas,String d);
	
	public Long getInscriptionEnf(Long idEnf,String annee); 
	public Inscription getInscriptionEnfAnnee(Long idEnf, String d);
	
	
	
	public long getNombreInscriptions();
	public List<Inscription> listInscriptions(); 
	public List<Inscription> listInscriptions(int position,int nbrInscriptions); 
	
	
	 /////////////////////////////////////////////////////////////////////
	
	
	//Gestion des Consultations 
	
	
	public Consultation getConsulation( Long idEnf,Long idEqSan,String d);
	
	
	public Long getConsultationEnf(Long idEnf,String d);
	public long getNombreConsultations();
	public List<Consultation> listConsultations(); 
	public List<Consultation> listConsultations(int position,int nbrConsultations); 
	
	//public List<Enfant> getEnfantByEqSanitaireyConsultation(Long idEquipeSanitaire,Long idConsultation);
	//public List<EquipeSanitaire> getEquipeSanitairesByEnfantbyConsultation(Long idEnfant,Long idConsultation);
	
	 /////////////////////////////////////////////////////////////////////
	
    //Gestion des Parents 
	

	public List<Parent> parentParNom(String nomParent); 
	public Parent getParent(Long idParent); 
	public Parent getParentbycin(String cin);
	//public List<Parent> listPere(String genre);
	//public List<Parent> listMere(String genre);

	
	 public List<Parent> listParents2(int position,int nbrParents); 
		
	 public long getNombreParents2();
	
	public List<Parent> listParents(int position,int nbrParents); 
	public List<Parent> listParents(); 
    public long getNombreParents();
    
    
    public List<Enfant> getEnfantByParent(Long idParent);
    public void ajouterEnfantsPourParent(Long idEnfant,Long idParent);
    
    
   
    /////////////////////////////////////////////////////////////////////
	
	
	//Gestion des Evennements
	
	
	public List<Evenement> evennementParNom(String nom); 
	public Evenement getEvennement(Long idEvennement); 
	
	
	
	
	
	
	public long getNombreEvennements();
	public List<Evenement> listEvennements();
	public List<Evenement> listEvennements(int position,int nbrEvennements); 
	
	
	public List<Enfant> getEnfantsByEvennement(Long idEvennement);
	
	
	
	
	
	
    /////////////////////////////////////////////////////////////////////
	
	//Gestion des Enfants 
	

	
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
	public List<PlanningEnfant> EnfantParPlanningH(Long idPlan);
	public List<Enfant> EnfantSelectionnes();
	
	public List<Accompagnateur> getAccompagnateursByEnfant(Long idEnfant);
	public List<Evenement> getEvennementsByEnfant(Long idEnfant);
	public List<Parent> getParentsByEnfant(Long idEnfant);
	
	
	
	public Long nbrEnfantClasse(Long idCla);	
	
	
	
	
	
	public List<Enfant> listEnfants(int position,int nbrEnfants); 
	public List<Enfant> listEnfants();  
    public long getNombreEnfants();
    
    
	
	
	//Gestion des Fournisseurs
	
	
	
	public List<Fournisseur> fournisseurParNom(String nom); 
	public Fournisseur getFournisseur(Long idFournisseur); 

	public List<Materiel> getMaterielsByFournisseur(Long idFournisseur);
	
	
	
     public long getNombreFournisseurs();
     public List<Fournisseur> listFournisseurs(); 
     public List<Fournisseur> listFournisseurs(int position,int nbrFournisseurs); 
	
	//Gestion des Materiels
	
	public List<Materiel> materielsParDesignation(String designation); 
	public Materiel getMateriels(Long idMateriels); 
	
	public List<Equipe> getEquipeByMateriels(Long idMateriels);
	
	
	
	
//	public List<EquipeSanitaire> materielsParEquipeSanitaire(Long idEquipeSanitaire);
//	public List<EquipeEducatif> materielsParEquipeEducatif(Long idEquipeEducatif);
	
	
	
	public long getNombreMateriels();
	public List<Materiel> listMateriels();  
	public List<Materiel> listMateriels(int position,int nbrMateriels); 
	
	
	
	
	//Gestion des typesMateriels
	
	
  
	public TypeMateriels getTypeMateriels(Long idTypeMateriels);
	
	
	public long getNombreTypesMateriels();
	public List<TypeMateriels> listTypeMateriels(); 
	public List<TypeMateriels> listTypeMateriels(int position,int nbrTypesMateriels); 
	
	
	
	//Gestion des stocks materiels
	
	
	public Stock getStock(Long idStock);
	
	
	public long getNombreStocks();
	public List<Stock> listStock(); 
	public List<Stock> listStock(int position,int nbrStocks); 
	
	
	//Gestion Matriel utilisé
	
	
			public List<MatrielUtiliser> listMatrielUtiliser();
			public MatrielUtiliser getMatrielUtiliser(Long idMat,Long idEsEducatif,Date d);
			
			
			public List <MatrielUtiliser>  ListMaterielActifsEqEducatif (Long idEqEducatif);
			
			
			
			//Gestion Matriel Sanitaire  utilisé
			
			
		   public List<MatrielSanitaUtiliser> listMatrielSanitaireUtiliser();
		   public MatrielSanitaUtiliser getMatrielSanitaireUtiliser(Long idMat,Long idSani,Date d);
		   
		   
		   public List <MatrielSanitaUtiliser>  ListMaterielActifsEqSanitaire (Long idSanitaire);
		   
		   

			//Gestion Enfant_Club
			
			
			
		   public List<ClubEnfant> listEnfantClub();
		   public ClubEnfant getEnfantClub(Long idClub,Long idEnf,Date dateDebutUtilisation);
		   
		   public List <ClubEnfant>  ListClubActifsEnfant (Long idEnf);
			

			//Gestion Enfant_Planning
			
			
		   public List<PlanningEnfant> listPlanningEnfant();
		   public PlanningEnfant getPlanningEnfant(Long idEnf,Long idPlan,Date dateDebutInscription);

		
		   public List <PlanningEnfant>  ListPlanningActifsEnfant (Long idEnf);
		   
		   
		   

			//Gestion Enfant_Evennement
			
			
		   public List<EvennementEnfant> listEvennementEnfant();
		   public EvennementEnfant getEvennementEnfant(Long idEnf,Long idEvene,Date dateDebutInscription);
		   
		   public List <EvennementEnfant>  ListEvennementActifsEnfant (Long idEnf);
		   
		   
		 //Gestion Equipeeducatif_Classes
			
			
			
		   public List<ClasseEquipeEducatif> listEquipeEducatifClasse();
		   public ClasseEquipeEducatif getEquipeEducatifClasse(Long idClass,Long idEquipEducatif,Date dateDebutInscrClass);
		   
		   public List <ClasseEquipeEducatif>  ListClasseActifsEquEducatif (Long idEqEducatif);
		   
		   
		   
		   //Gestion Equipeeducatif_Categories
			
			
			
		   public List<CategorieClubEquipeEducatif> listCategorieClubEquipeEducatif();
		   public CategorieClubEquipeEducatif getCategorieClubEquipeEducatif(Long idCateg,Long idEqEdu,Date dateDebutInscrClub);
		   
		   public List <CategorieClubEquipeEducatif>  ListCategorieClubActifsEquipeEducatif (Long idEqEduc);
		  
		
   
	   
	   //////////////////////////////////////////////////
		  /* 
		    public Long ajouterPayment(Payment p);
			public List<Payment>listPayments();
			public List<Payment> EnfantParPayment(Long idEnf);*/
		   
		   

		    public Payment ajouterPayment(Payment p,Long idEnfant,String moisPayment);
			public List<Payment>listPayments();
			public Payment getPayementMoisCourant(Long idEnfant,String moisPayment);
			


		    public HistoriquePlaning ajouterPlanningHistor(HistoriquePlaning h,Long idPla);
			public List<HistoriquePlaning> listPlanningHistor(Long idPla);
			public HistoriquePlaning countPlaning(Long idPla);
			public void modifierHistoriquePl(HistoriquePlaning h);





		    public HistoriqueClub ajouterClubHistor(HistoriqueClub h,Long idClub);
			public List<HistoriqueClub> listClubHistor(Long idClub);
			public HistoriqueClub countClub(Long idClub);
			public void modifierHistoriqueCl(HistoriqueClub h);
	 
	
	
	
			public Creche ajouterCreche(Creche creche,String annee); 
			
			public Creche getCreche(String annee); 
			
			public List<Creche> listCreches(); 
			public Inscription getInscriAnnuelle(Long idEnf,Long idClass,String annee);
			
			
			 public List <ClubEnfant>  ListClubEnfantParAnnee (Long idEnf,Date dateClub);
	
			 
			 public List <ClubEnfant>  ListEnfantsActifsClubs (Long idClub);
			 
			 
			 public List<PlanningEnfant> ListEnfantsActifsPlannings(Long idPlannings);
			 
			 public List<Inscription> listInscriptionsParClassAnne(Long idClass);
			 
			 public List<EvennementEnfant> EnfantParEvennement(Long idEvenne);
			 
			 public Consultation getConsultationEnfDate(Long idEnf, String date);
	
}

