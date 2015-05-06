package org.gestion.cr;

import static org.junit.Assert.assertTrue;








import java.util.Date;
import java.util.List;






import org.gestion.cr.entities.Accompagnateur;
import org.gestion.cr.entities.CategorieClub;
import org.gestion.cr.entities.Classe;
import org.gestion.cr.entities.Club;
import org.gestion.cr.entities.Creche;
import org.gestion.cr.entities.Enfant;
import org.gestion.cr.entities.EquipeEducatif;
import org.gestion.cr.entities.EquipeSanitaire;
import org.gestion.cr.entities.Evenement;
import org.gestion.cr.entities.Fonction;
import org.gestion.cr.entities.Fournisseur;
import org.gestion.cr.entities.Materiel;
import org.gestion.cr.entities.Parent;
import org.gestion.cr.entities.PlanningEnfant;
import org.gestion.cr.entities.PlanningHorraires;
import org.gestion.cr.entities.Stock;
import org.gestion.cr.entities.TypeMateriels;
import org.gestion.cr.metier.IAdminMetier;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJPA {

	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	@Test
	public void test132() 
	{
		//Test pour la configuration de la base des données
		try
		     {
			
		        ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});

		       
		       
		        IAdminMetier metier=(IAdminMetier) context.getBean("metier");
		        
		        

				   List<CategorieClub> listCategorieClub1=metier.listCategorieClubs();
				   metier.ajouterCategorieClub(new CategorieClub("Musique", 20.0, "2015-05-30T13:30"));
				   metier.ajouterCategorieClub(new CategorieClub("Theatre", 25.0, "2015-05-29T12:30"));
				   metier.ajouterCategorieClub(new CategorieClub("Dance", 20.0, "2015-05-13T12:30"));
				   metier.ajouterCategorieClub(new CategorieClub("Informatique", 20.0, "2015-05-24T17:00"));
				   metier.ajouterCategorieClub(new CategorieClub("Peinture", 15.0, "2015-05-10T13:30"));
				   List<CategorieClub> listCategorieClub2=metier.listCategorieClubs();
				   
				   assertTrue(listCategorieClub1.size()+5==listCategorieClub2.size());
				   
				   
				   List<Fonction> listFonction1=metier.listFonctions();
				   metier.ajouterFonction(new Fonction("Assistante Maternelle"));
				   metier.ajouterFonction(new Fonction("Educatrice"));
				   metier.ajouterFonction(new Fonction("Pediatre"));
				   metier.ajouterFonction(new Fonction("Infermier(e)"));
				   metier.ajouterFonction(new Fonction("Animatrice"));
				   List<Fonction> listFonction12=metier.listFonctions();
				    
				   assertTrue(listFonction1.size()+5==listFonction12.size());
				   
				   

				   List<Accompagnateur> listAccompagnateur1=metier.listAccompagnateurs(0,5);
				   metier.ajouterAccompagnateur(new Accompagnateur("Wassim", "hedi", "",  "06925113S", "Voisin", "54144604", true));
				   metier.ajouterAccompagnateur(new Accompagnateur("yosra", "sakly", "",  "06925113S", "Oncle", "45678912", true));
				   metier.ajouterAccompagnateur(new Accompagnateur("wiem", "fourati", "", "06925113S", "Oncle", "45678912", true));
				   List<Accompagnateur> listAccompagnateur2=metier.listAccompagnateurs(0,5);
				        
				   assertTrue(listAccompagnateur1.size()+3==listAccompagnateur2.size());	
				   
                   List<Fournisseur> listFournisseur1=metier.listFournisseurs();
				   
				   metier.ajouterFournisseur(new Fournisseur("Najib", "Mehrzi", "",  "07700801", "rue janoub Sousse", "73543399", "98400900", "Najib@yahoo.fr"));
				   metier.ajouterFournisseur(new Fournisseur("Nozha", "Sakly", "",  "07700801", "rue janoub Sousse", "73543399", "98400900", "Najib@yahoo.fr"));
				   metier.ajouterFournisseur(new Fournisseur("Farid", "lazreg", "", "07700801", "rue janoub Sousse", "73543399", "98400900", "Najib@yahoo.fr"));
				   
	               List<Fournisseur> listFournisseurr2=metier.listFournisseurs();
				        
				   assertTrue(listFournisseur1.size()+3==listFournisseurr2.size());
				   
				   
				   List<TypeMateriels> listTypeMateriels1=metier.listTypeMateriels();
				   metier.ajouterTypeMateriel(new TypeMateriels("Tableau"));
				   metier.ajouterTypeMateriel(new TypeMateriels("Stylo"));
				   metier.ajouterTypeMateriel(new TypeMateriels("Ordinateur"));
				   metier.ajouterTypeMateriel(new TypeMateriels("stethoscope"));
				   metier.ajouterTypeMateriel(new TypeMateriels("Balance impédancemètre"));
				   metier.ajouterTypeMateriel(new TypeMateriels("Thermomètre "));
				   List<TypeMateriels> listTypeMateriels2=metier.listTypeMateriels();
				   
				   assertTrue(listTypeMateriels1.size()+6==listTypeMateriels2.size());
				   
				   
				   List<Stock> listStock1=metier.listStock();
				   metier.ajouterStock(new Stock((float) 30.4));
				   metier.ajouterStock(new Stock( (float) 50));
				   metier.ajouterStock(new Stock( (float) 40));
				   List<Stock> listStock2=metier.listStock();
				   
				   assertTrue(listStock1.size()+3==listStock2.size());
				   
				   
				   
				   List<Materiel> listMateriels1=metier.listMateriels();
				   metier.ajouterMateriels(new Materiel("tableau", "", 54.30), 1L, 1L);
				   metier.ajouterMateriels(new Materiel("ordinateur", "", 54.30),2L, 1L);
				   List<Materiel> listMateriels2=metier.listMateriels();
				   
				   assertTrue(listMateriels1.size()+2==listMateriels2.size());
				   
				   
				   List<EquipeEducatif> listEqEducatif1=metier.listEquipeEducatif();
				    metier.ajouterEquipeEducatif(new EquipeEducatif("Nadia", "Seddik", "",  "O6925114", "1980-10-04", "Monastir", "Femme", "Monastir", ""), 1L);
				    metier.ajouterEquipeEducatif(new EquipeEducatif("Sakly", "Yosra", "",  "O6925114", "1980-10-04", "Monastir", "Homme", "Monastir", ""), 1L);
				    List<EquipeEducatif> listEqEducatif2=metier.listEquipeEducatif();
				      
				    assertTrue(listEqEducatif1.size()+2==listEqEducatif2.size());
				    
				    
				    List<EquipeSanitaire> listEqSanitaire1=metier.listEquipeSanitaires();
				    metier.ajouterEquipeSanitaire(new EquipeSanitaire("Dalila", "Chouchen", "",  "", "1977-01-12", "Sousse", "Femme", "Sousse 4001", "") , 3L);
				    metier.ajouterEquipeSanitaire(new EquipeSanitaire("Dalila", "Chouchen", "",  "", "1977-01-12", "Sousse", "Femme", "Sousse 4001", "") , 3L);
				    List<EquipeSanitaire> listEqSanitaire2=metier.listEquipeSanitaires();
				      
				    assertTrue(listEqSanitaire1.size()+2==listEqSanitaire2.size());
				   
				    List<Creche> listCreche1=metier.listCreches();
					   
					   metier.ajouterCreche(new Creche("Excellence", "Monastir 5011", "Excellence@hotmail.fr", "Monastir", "73400908", "", 54.30, 54.30, 54.30),"2015");

					  
					   List<Creche> listCreche2=metier.listCreches();
					   
					   assertTrue(listCreche1.size()+1==listCreche2.size());
					
					   
					   List<Classe> listClasses1=metier.listClasse();
					   metier.ajouterClasse(new Classe("Mon bébé (Petite Section)", 20));
					   metier.ajouterClasse(new Classe("Mon Petit (Moyenne Section)", 20));
					   metier.ajouterClasse(new Classe("Barem (Petite Section)", 30));
					   metier.ajouterClasse(new Classe("Coccinelle (Moyenne Section)", 30));
					   metier.ajouterClasse(new Classe("Les Grands(Grande Section : classe Préparatoire)", 3));
					   List<Classe> listClasses2=metier.listClasse();
					   
					   
					   assertTrue(listClasses1.size()+5==listClasses2.size());
					   
					 
				   
					   
					  
					   
					   
					   List<PlanningHorraires> listPlanningHorraires1=metier.listPlanningHorraires();
					  
					   metier.ajouterPlanningHorraires(new PlanningHorraires("Garde entre 16h30 et 18h", 10.0));
					   metier.ajouterPlanningHorraires(new PlanningHorraires("Garde entre 7h et 8h30", 10.0));
					   metier.ajouterPlanningHorraires(new PlanningHorraires("Garde Samedi", 20.0));
					   metier.ajouterPlanningHorraires(new PlanningHorraires("Menu Integré", 15.0));
					  
					   List<PlanningHorraires> listPlanningHorraires2=metier.listPlanningHorraires();
					   
					   assertTrue(listPlanningHorraires1.size()+4==listPlanningHorraires2.size());
					   
					   
					   
					   List<Club> listClub1=metier.listClubs();
					   metier.ajouterClubs(new Club("club 1", 50), 1L);
					   metier.ajouterClubs(new Club("club 2", 12), 2L);
					   metier.ajouterClubs(new Club("club 3", 17), 3L);
					   metier.ajouterClubs(new Club("club 4", 20), 2L);
					   List<Club> listClub2=metier.listClubs();
					   
					   assertTrue(listClub1.size()+4==listClub2.size());
					   
					   
					   
					   
					   List<Parent> listParent1=metier.listParents();
					    metier.ajouterParent(new Parent("sakly", "yosra", "", "06925113", "", "", "", "", "", "", "", "", "", ""));
					    metier.ajouterParent(new Parent("sakly", "wiem", "", "06925113", "", "", "", "", "", "", "", "", "", ""));
					    metier.ajouterParent(new Parent("sakly", "yosra", "",  "06925113", "", "", "", "", "", "", "", "", "", ""));
					    metier.ajouterParent(new Parent("sakly", "wiem", "",  "06925113", "", "", "", "", "", "", "", "", "", ""));
					    metier.ajouterParent(new Parent("sakly", "yosra", "", "06925113", "", "", "", "", "", "", "", "", "", ""));
					    metier.ajouterParent(new Parent("sakly", "wiem", "",  "06925113", "", "", "", "", "", "", "", "", "", ""));
					    
		               List<Parent> listParent2=metier.listParents();
					   
					   assertTrue(listParent1.size()+6==listParent2.size());
					   
					   
					   
					   List<Evenement> listEvennement1=metier.listEvennements();
					   metier.ajouterEvennement(new Evenement("fete de maman", "", 40.6, "", ""));
					   metier.ajouterEvennement(new Evenement("fete de republique", "", 40.6, "", ""));
					   List<Evenement> listEvennement2=metier.listEvennements();
						  
					   assertTrue(listEvennement1.size()+2==listEvennement2.size());
					   
					   
					   
					    List<Enfant> listEnfant1=metier.listEnfants();
					    metier.ajouterEnfant(new Enfant("sakly", "yosra", "", "homme", "", "", "", true, "alergie medicale", "", true, "", "",""));
					    metier.ajouterEnfant(new Enfant("hamdi", "wiem", "",  "homme", "", "", "", true, "alergie medicale", "", true, "", "",""));
					    metier.ajouterEnfant(new Enfant("ahmed", "ben afia", "", "homme", "", "", "", true, "alergie medicale", "", true, "", "",""));
					   
					   
		                List<Enfant> listEnfant2=metier.listEnfants();
					       
					    assertTrue(listEnfant1.size()+3==listEnfant2.size());
					    /*
					    
					    List<Inscription> listins1=metier.listInscriptions();
					    
					    metier.ajouterInscription(new Inscription(40.5, new Date(), (float) 30.4),62L, 1L,"2014-2015");
					    List<Inscription> listins2=metier.listInscriptions();
					    
					    assertTrue(listins1.size()+1==listins2.size());*/
					   
					    
					    /*
					    List<Consultation> listcons1=metier.listConsultations();
					    
					    metier.ajouterConsulation(new Consultation( 30.4, 30.4, "ennn", "eeeee"), 62L, 58L, "dddd");
					    List<Consultation> listcons2=metier.listConsultations();
					    
					    assertTrue(listcons1.size()+1==listcons2.size());*/
					    
					    /*
					    List<Enfant> enf=metier.EnfantParMotCle("yosra");
					    for(Enfant en:enf)
					    {
					    	System.out.println("***********");
					    	System.out.println(en.getNom());
					    }
					    /*
					    
					    
					    List<MatrielUtiliser> listc1=metier.listMatrielUtiliser();
					    
					    
					    metier.ajouterMatrielUtiliser(new MatrielUtiliser(30), 1L, 56L, new Date());


					    List<MatrielUtiliser> listc2=metier.listMatrielUtiliser();
					    
					    assertTrue(listcons1.size()+1==listcons2.size());*/
					    
					    /*
					    
					    List<MatrielSanitaUtiliser> listd1=metier.listMatrielSanitaireUtiliser();
					   
	                   metier.ajouterMatrielSanitaireUtiliser(new MatrielSanitaUtiliser(12), 2L, 58L, new Date());
		              
	                    List<MatrielSanitaUtiliser> listd2=metier.listMatrielSanitaireUtiliser();
					    
					    assertTrue(listd1.size()+1==listd2.size());*/
		
			   
		     }    
		catch(Exception e)
		     {
		      assertTrue(e.getMessage(),false);
	         }

	}
}