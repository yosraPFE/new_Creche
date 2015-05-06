package org.gestion.cr.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.gestion.cr.entities.Accompagnateur;
import org.gestion.cr.entities.CategorieClub;
import org.gestion.cr.entities.CategorieClubEquipeEducatif;
import org.gestion.cr.entities.CategorieClubEquipeEducatifId;
import org.gestion.cr.entities.Classe;
import org.gestion.cr.entities.ClasseEquipeEducatif;
import org.gestion.cr.entities.ClasseEquipeEducatifId;
import org.gestion.cr.entities.Club;
import org.gestion.cr.entities.ClubEnfant;
import org.gestion.cr.entities.ClubEnfantId;
import org.gestion.cr.entities.Consultation;
import org.gestion.cr.entities.ConsultationId;
import org.gestion.cr.entities.Creche;
import org.gestion.cr.entities.CrecheId;
import org.gestion.cr.entities.Enfant;
import org.gestion.cr.entities.Equipe;
import org.gestion.cr.entities.EquipeEducatif;
import org.gestion.cr.entities.EquipeSanitaire;
import org.gestion.cr.entities.Evenement;
import org.gestion.cr.entities.EvennementEnfant;
import org.gestion.cr.entities.EvennementEnfantId;
import org.gestion.cr.entities.Fonction;
import org.gestion.cr.entities.Fournisseur;
import org.gestion.cr.entities.HistoriqueClub;
import org.gestion.cr.entities.HistoriquePlaning;
import org.gestion.cr.entities.Inscription;
import org.gestion.cr.entities.InscriptionId;
import org.gestion.cr.entities.Materiel;
import org.gestion.cr.entities.MaterielSanitaireUtiliserId;
import org.gestion.cr.entities.MaterielUtiliserId;
import org.gestion.cr.entities.MatrielSanitaUtiliser;
import org.gestion.cr.entities.MatrielUtiliser;
import org.gestion.cr.entities.Parent;
import org.gestion.cr.entities.Payment;
import org.gestion.cr.entities.PaymentId;
import org.gestion.cr.entities.Personne;
import org.gestion.cr.entities.PlanningEnfant;
import org.gestion.cr.entities.PlanningEnfantId;
import org.gestion.cr.entities.PlanningHorraires;
import org.gestion.cr.entities.Stock;
import org.gestion.cr.entities.TypeMateriels;
import org.hibernate.SessionFactory;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;

public class CrecheDaoImpl implements ICrecheDAO
{

	/**
	 * 
	 * @author YOSRA
	 *
	 */

	
	@PersistenceContext
	private EntityManager em;
	
	
	//Gestion CategoriesClubs

		@Override
		public Long ajouterCategorieClub(CategorieClub categorieClub) {
			
			
				 em.persist(categorieClub);
				 return categorieClub.getIdCategorie();
			
		}

		@Override
		public CategorieClub getCategorieClub(Long idCategorieClub) {
		
			return em.find(CategorieClub.class, idCategorieClub);
		}

		@Override
		public void supprimerCategorieClub(Long idCategorieClub) {
		
			CategorieClub c=em.find(CategorieClub.class, idCategorieClub);
			em.remove(c);
			
		}

		@Override
		public void modifierCategorieClub(CategorieClub categorieClub) {
			
			em.merge(categorieClub);
			
		}

		@Override
		public long getNombreCategorieClubs() {
			Query req=em.createQuery("select count(categ) from CategorieClub categ ");
			return (Long)req.getResultList().get(0);
		}

		@Override
		public List<CategorieClub> listCategorieClubs() {
			
		    Query req=em.createQuery("select cat from CategorieClub cat order by cat.idCategorie desc");
			
			 return req.getResultList();
					
		}

		@Override
		public List<CategorieClub> listCategorieClubs(int position,
				int nbrCategorieClubs) {
			Query req=em.createQuery("select categ from CategorieClub categ order by categ.idCategorie desc");
			req.setFirstResult(position);
			req.setMaxResults(nbrCategorieClubs);
			return req.getResultList();
		}
		
		////////////////////////////////////////////////////////////////////
		
		//Gestion des Clubs

		@Override
		public Long ajouterClubs(Club club, Long idCtagorieClubs) {
			
	    CategorieClub cat=em.find(CategorieClub.class, idCtagorieClubs);
			
			club.setCategorieClub(cat);
			em.persist(club); 
			return club.getIdClub();
		}

		@Override
		public List<Club> clubsParNom(String nomClub) {
			Query req=em.createQuery("select cl from Club cl where cl.nom like :x ");
			req.setParameter("x", "%"+nomClub+"%"); 
			return req.getResultList();
		}

		@Override
		public Club getClubs(Long idClubs) {
			return em.find(Club.class, idClubs);
		}

		@Override
		public void supprimerClubs(Long idClubs) {
			
			Club cl=em.find(Club.class, idClubs);
			em.remove(cl);
			
			
		}

		@Override
		public void modifierClubs(Club clubs) {
			
			em.merge(clubs);
			
		}

		@Override
		public long getNombreClubs() {
			Query req=em.createQuery("select count(clu) from Club clu ");
			return (Long)req.getResultList().get(0);
		}

		@Override
		public List<Club> listClubs() {
			

			 Query req=em.createQuery("select cl from Club cl order by cl.idClub desc");
				
			 return req.getResultList();
		}

		@Override
		public List<Club> listClubs(int position, int nbrClubs) {
			Query req=em.createQuery("select clu from Club clu  ");
			req.setFirstResult(position);
			req.setMaxResults(nbrClubs);
			return req.getResultList();
		}
		
		///////////////////////////////////////////////////////////////////////
		
		//Gestion des Plannings

		@Override
		public Long ajouterPlanningHorraires(PlanningHorraires planningHorraires) {
			
			 em.persist(planningHorraires);
			 return planningHorraires.getIdPlanningH();
		}

		@Override
		public PlanningHorraires getPlanningHorraires(Long idPlanningHorraires) {
			
			return em.find(PlanningHorraires.class, idPlanningHorraires);
		}

		@Override
		public void supprimerPlanningHorraires(Long idPlanningHorraires) {
			
			PlanningHorraires p=em.find(PlanningHorraires.class, idPlanningHorraires);
			em.remove(p);
		}

		@Override
		public void modifierPlanningHorraires(PlanningHorraires planningHorraires) {
		
			em.merge(planningHorraires);
			
		}

		@Override
		public long getNombrePlanningHorraires() {
			
			Query req=em.createQuery("select count(plan) from PlanningHorraires plan ");
			return (Long)req.getResultList().get(0);
		}

		@Override
		public List<PlanningHorraires> listPlanningHorraires() {
			
	        Query req=em.createQuery("select pl from PlanningHorraires pl order by pl.idPlanningH desc");
			
			return req.getResultList();
			
		}

		@Override
		public List<PlanningHorraires> listPlanningHorraires(int position,
				int nbrPlanningHorraires) {
			Query req=em.createQuery("select plan from PlanningHorraires plan order by plan.idPlanningH desc");
			req.setFirstResult(position);
			req.setMaxResults(nbrPlanningHorraires);
			return req.getResultList();
		}
		
		//////////////////////////////////////////////////
		
		//Gestion des Creches
/*
		@Override
		public Long ajouterCreche(Creche creche) {
			
	        em.persist(creche);
			
			return creche.getIdCreche();
			
		}

		@Override
		public List<Creche> crecheParNom(String nomCreche) {

			 Query req=em.createQuery("select cr from Creche cr");
				
			 return req.getResultList();
		}

		@Override
		public Creche getCreche(Long idCreche) {
			return em.find(Creche.class, idCreche);
		}

		@Override
		public void supprimerCreche(Long idCreche) {
			Creche cr=em.find(Creche.class, idCreche);
			em.remove(cr);
			
		}

		@Override
		public void modifierCreche(Creche creche) {
			em.merge(creche);
			
		}

		@Override
		public long getNombreCreches() {
			Query req=em.createQuery("select count(cr) from Creche cr order by cr.idCreche desc");
			return (Long)req.getResultList().get(0);
		}

		@Override
		public List<Creche> listCreches() {
			Query req=em.createQuery("select cr from Creche cr order by cr.idCreche desc");
			
			 return req.getResultList();
		}

		@Override
		public List<Creche> listCreches(int position, int nbrCreches) {
			Query req=em.createQuery("select cr from Creche cr order by cr.idCreche desc ");
			req.setFirstResult(position);
			req.setMaxResults(nbrCreches);
			return req.getResultList();
		}
		*/
		
		
		//////////////////////////////////////////////////////////////////////
		
		//Gestion des Classes

		@Override
		public Long ajouterClasse(Classe classe) {
			
			
			 
			em.persist(classe); 
			return classe.getIdClasse();
		}

		@Override
		public Classe getClasse(Long idClasse) {
			return em.find(Classe.class, idClasse);
		}

		@Override
		public void supprimerClasse(Long idClasse) {
			Classe clas=em.find(Classe.class, idClasse);
			em.remove(clas);
			
		}

		@Override
		public void modifierClasse(Classe classe) {
			em.merge(classe);
			
		}

		

		@Override
		public long getNombreClasses() {
			Query req=em.createQuery("select count(clas) from Classe clas ");
			return (Long)req.getResultList().get(0);
		}

		@Override
		public List<Classe> listClasse() {
			 Query req=em.createQuery("select clas from Classe clas order by clas.idClasse desc");
				
			 return req.getResultList();
		}

		@Override
		public List<Classe> listClasse(int position, int nbrClasses) {
			Query req=em.createQuery("select clas from Classe clas  order by clas.idClasse desc");
			req.setFirstResult(position);
			req.setMaxResults(nbrClasses);
			return req.getResultList();
		}

		@Override
		public List<Enfant> getEnfantsByClasse(Long idClasse) {
			Query req=em.createQuery("select enf from Enfant enf join enf.Classe cl where cl.idClasse=:x");
			req.setParameter("x", idClasse);	
			return req.getResultList();
		}
		
		
		////////////////////////////////////////////////////
		
		//Gestion des Equipes Sanitaires

		@Override
		public Long ajouterEquipeSanitaire(EquipeSanitaire equipeSanitaire,
				Long idFonction) {
			
			Fonction fon=em.find(Fonction.class, idFonction);
			equipeSanitaire.setFonction(fon);
			em.persist(equipeSanitaire); 
			return equipeSanitaire.getIdPerson();
			
		}

		@Override
		public void supprimerEquipeSanitaire(Long idEquipeSanitaire) {
			
			EquipeSanitaire san=em.find(EquipeSanitaire.class, idEquipeSanitaire);
			em.remove(san);
			
		}

		@Override
		public void modifierEquipeSanitaire(EquipeSanitaire equipeSanitaire) {
			em.merge(equipeSanitaire);
			
		}

		@Override
		public List<EquipeSanitaire> equipeSanitaireParNom(String nom) {
			
			Query req=em.createQuery("select san from EquipeSanitaire san ");
			
			 return req.getResultList();
		}

		@Override
		public List<EquipeSanitaire> equipeSanitaireParFonction(Long idFonction) {
			Query req=em.createQuery("select san from EquipeSanitaire san join san.Fonction fon where fon.idFonction=:x");
			req.setParameter("x", idFonction);	
			return req.getResultList();
		}

		@Override
		public EquipeSanitaire getEquipeSanitaire(Long idEquipeSanitaire) {
			return em.find(EquipeSanitaire.class, idEquipeSanitaire);
		}

		@Override
		public long getNombreEquipesSan() {
			Query req=em.createQuery("select count(eqSa) from EquipeSanitaire eqSa ");
			return (Long)req.getResultList().get(0);
		}

		@Override
		public List<EquipeSanitaire> listEquipeSanitaires() {
			Query req=em.createQuery("select san from EquipeSanitaire san  order by san.idPerson desc");
			
			 return req.getResultList();
		}

		@Override
		public List<EquipeSanitaire> listEquipeSanitaires(int position,
				int nbrEquipesSan) {
			Query req=em.createQuery("select eqSa from EquipeSanitaire eqSa order by eqSa.idPerson desc ");
			req.setFirstResult(position);
			req.setMaxResults(nbrEquipesSan);
			return req.getResultList();
		}
		
		
		/////////////////////////////////////////////////////////////////////
		
		//Gestion des Equipes Educatifs

		@Override
		public Long ajouterEquipeEducatif(EquipeEducatif equipeEducatif,
				Long idFonction) {
			Fonction fon=em.find(Fonction.class, idFonction);
			equipeEducatif.setFonction(fon);
			em.persist(equipeEducatif); 
			return equipeEducatif.getIdPerson();
		}

		@Override
		public EquipeEducatif getEquipeEducatif(Long idEquipeEducatif) {
			return em.find(EquipeEducatif.class, idEquipeEducatif);
		}

		@Override
		public void supprimerEquipeEducatif(Long idEquipeEducatif) {
			//EquipeEducatif edu=getEquipeEducatif(idEquipeEducatif);
		//	em.remove(edu);
			

			EquipeEducatif edu=em.find(EquipeEducatif.class, idEquipeEducatif);
			em.remove(edu);
			
		}

		@Override
		public void modifierEquipeEducatif(EquipeEducatif equipeEducatif) {
			em.merge(equipeEducatif);
			
		}

		@Override
		public List<EquipeEducatif> equipeEducatifParNom(String nom) {
			Query req=em.createQuery("select edu from EquipeEducatif edu where edu.nom like :x or edu.prenom :x");
			req.setParameter("x", "%"+nom+"%"); 
			return req.getResultList();
		}

		@Override
		public List<EquipeEducatif> equipeEducatifParFonction(Long idFonction) {
			Query req=em.createQuery("select edu from EquipeEducatif edu join edu.Fonction fon where fon.idFonction=:x");
			req.setParameter("x", idFonction);	
			return req.getResultList();
		}

		@Override
		public long getNombreEquipesEdu() {
			Query req=em.createQuery("select count(eqEdu) from EquipeEducatif eqEdu ");
			return (Long)req.getResultList().get(0);
		}

		@Override
		public List<EquipeEducatif> listEquipeEducatif() {
			Query req=em.createQuery("select edu from EquipeEducatif edu order by edu.idPerson desc");
			
			 return req.getResultList();
		}

		@Override
		public List<EquipeEducatif> listEquipeEducatif(int position,
				int nbrEquipesEdu) {
			Query req=em.createQuery("select eqEdu from EquipeEducatif eqEdu order by eqEdu.idPerson desc ");
			req.setFirstResult(position);
			req.setMaxResults(nbrEquipesEdu);
			return req.getResultList();
		}
		
		
		///////////////////////////////////////////////////////////////
		
		//Gestion des Fonctions

		@Override
		public Long ajouterFonction(Fonction fonction) {
			 em.persist(fonction);
				
			return fonction.getIdFonction();
		}

		@Override
		public Fonction getFonction(Long idFonction) {
			return em.find(Fonction.class, idFonction);
		}

		@Override
		public void supprimerFonction(Long idFonction) {
			Fonction fon=em.find(Fonction.class, idFonction);
			em.remove(fon);
			
		}

		@Override
		public void modifierFonction(Fonction fonction) {


			em.merge(fonction);
			
			
		}

		@Override
		public long getNombreFonctions() {
			Query req=em.createQuery("select count(fon) from Fonction fon ");
			return (Long)req.getResultList().get(0);
		}

		@Override
		public List<Fonction> listFonctions() {
			
			Query req=em.createQuery("select fon from Fonction fon order by fon.idFonction desc");
			
			return req.getResultList();
		}

		@Override
		public List<Fonction> listFonctions(int position, int nbrFonctions) {
			Query req=em.createQuery("select fon from Fonction fon order by fon.idFonction desc");
			req.setFirstResult(position);
			req.setMaxResults(nbrFonctions);
			return req.getResultList();
		}
		
		/////////////////////////////////////////////////////////////////////
		
		//Gestion des Accompagnateurs

		@Override
		public Long ajouterAccompagnateur(Accompagnateur accompagnateur) {
			 em.persist(accompagnateur);
				
			return accompagnateur.getIdPerson();
		}

		@Override
		public List<Accompagnateur> accompagnateurParNom(String nom) {
			Query req=em.createQuery("select accomp from Accompagnateur accomp where accomp.nom like :x or accomp.prenom :x");
			req.setParameter("x", "%"+nom+"%"); 
			return req.getResultList();
		}

		@Override
		public Accompagnateur getAccompagnateur(Long idAccompagnateur) {
			
			return em.find(Accompagnateur.class, idAccompagnateur);
		}

		@Override
		public void supprimerAccompagnateurs(Long idAccompagnateur) {
			
			Accompagnateur acc=em.find(Accompagnateur.class, idAccompagnateur);
			em.remove(acc);
			
		}

		@Override
		public void modifierAccompagnateurs(Accompagnateur accompagnateur) {
			
			em.merge(accompagnateur);
			
		}

		@Override
		public long getNombreAccompagnateurs() {
			
			Query req=em.createQuery("select count(acc) from Accompagnateur acc ");
			return (Long)req.getResultList().get(0);
		}

		@Override
		public List<Accompagnateur> listAccompagnateurs() {
	        Query req=em.createQuery("select accomp from Accompagnateur accomp order by accomp.idPerson desc");
			
			return req.getResultList();
		}

		@Override
		public List<Accompagnateur> listAccompagnateurs(int position,
				int nbrAccompagnateurs) {
			
			Query req=em.createQuery("select accomp from Accompagnateur accomp order by accomp.idPerson desc ");
			req.setFirstResult(position);
			req.setMaxResults(nbrAccompagnateurs);
			return req.getResultList();
		}

		@Override
		public List<Enfant> getEnfantsByAccompagnateur(Long idAccompagnateur) {
			
			Query req=em.createQuery("select enf from Enfant enf join enf.Accompagnateur acc where acc.idPerson=:x");
			req.setParameter("x", idAccompagnateur);	
			return req.getResultList();
		}
		
		
		

		@Override
		public void ajouterEnfantsPourAccompagnateur(Long idEnfant,
				Long idAccompagnateur) {
			
			Enfant e=em.find(Enfant.class, idEnfant);
			Accompagnateur acc=em.find(Accompagnateur.class, idAccompagnateur);
			e.getAccompagnateur().add(acc);
			acc.getEnfants().add(e);
		}
		
		
		///////////////////////////////////////////////////////////////////
		
		
		//Gestion des Inscriptions

		
		/*@Override
		public Inscription ajouterInscription(Inscription in,Long idEnf,Long idClass,String d) {
			
			if (idEnf != null && idClass != null) {
			
				Classe c = em.find(Classe.class, idClass);
				Enfant e = em.find(Enfant.class, idEnf);
				
				in.setEnfant(e);
				in.setClasse(c);
				in.setAnnee(d);
		}
			em.persist(in);
			return in;

		}*/
		
		@Override
		public Inscription getLastInscriptionEnfant(Long idEnf) 
		{
			/*Query req = em.createQuery("select i from Inscription i where i.id.enfant.idPerson=:x");
			req.setParameter("x",idEnf);
			List<Inscription> InscriptionList = req.getResultList()
			return req.getResultList();*/
			Enfant e=em.find(Enfant.class, idEnf);
			InscriptionId inscriptionId = new InscriptionId();
			inscriptionId.setEnfant(e);
			List<Inscription> listInscription =  (List<Inscription>) em.find(Inscription.class, inscriptionId);
			return listInscription.get(listInscription.size()-1);
		}

		@Override
		public Inscription getInscription(Long idEnf, Long idClas, String d) {
			Classe c=em.find(Classe.class, idClas);	
			Enfant e=em.find(Enfant.class, idEnf);
			InscriptionId inscriptionId = new InscriptionId();
			inscriptionId.setClasse(c);
			inscriptionId.setEnfant(e);
			inscriptionId.setAnnee(d);

			return em.find(Inscription.class, inscriptionId);

		}

		@Override
		public void supprimerInscription(Long idEnf, Long idClas, String d) {
			
			Classe c=em.find(Classe.class, idClas);	
			Enfant e=em.find(Enfant.class, idEnf);
			InscriptionId inscriptionId = new InscriptionId();
			inscriptionId.setClasse(c);
			inscriptionId.setEnfant(e);
			inscriptionId.setAnnee(d);
	       em.remove(inscriptionId);

			
		}

		@Override
		public void modifierInscription(Inscription i) {
			em.merge(i);

			
		}

		@Override
		public Long getInscriptionEnf(Long idEnf, String annee) {
			Query req = em.createQuery("select count(*) from Inscription i where i.id.enfant.idPerson=:x and i.id.annee=:y");
			req.setParameter("x",idEnf);
			req.setParameter("y",annee);
			
			
			Long count = (Long)req.getSingleResult();
			return count;

		}
		
		@Override
		public Inscription getInscriptionEnfAnnee(Long idEnf, String d) {
			Query req = em.createQuery("select i from Inscription i where i.id.enfant.idPerson=:x and i.id.annee=:y");
			req.setParameter("x",idEnf);
			req.setParameter("y",d);
			
			return (Inscription)req.getSingleResult();

		}

		@Override
		public long getNombreInscriptions() {
			
			Query req=em.createQuery("select count(ins) from Inscription ins ");
			return (Long)req.getResultList().get(0);
		}

		@Override
		public List<Inscription> listInscriptions() {
			Query req = em.createQuery("select i from Inscription i order by i.id desc");
			return req.getResultList();
		}

		@Override
		public List<Inscription> listInscriptions(int position, int nbrInscriptions) {
			Query req=em.createQuery("select ins from Inscription ins order by ins.id desc ");
			req.setFirstResult(position);
			req.setMaxResults(nbrInscriptions);
			return req.getResultList();
		}
		
		
		/////////////////////////////////////////////////////////////////
		
		//Gestion des Consultations

		

		@Override
		public Consultation getConsulation(Long idEnf, Long idEqSan, String d) {
			
		
		
		
			EquipeSanitaire m=em.find(EquipeSanitaire.class,idEqSan);	
			Enfant e=em.find(Enfant.class, idEnf);
			ConsultationId consultationId = new ConsultationId();
			consultationId.setEquipeSanitaire(m);
			consultationId.setEnfant(e);
			consultationId.setDate(d);

			return em.find(Consultation.class, consultationId);


		}
		@Override
		public void supprimerConsultation(Long idEnf, Long idEqSan, String d) {
			
			EquipeSanitaire eq=em.find(EquipeSanitaire.class, idEqSan);	
			Enfant e=em.find(Enfant.class, idEnf);
			ConsultationId consultationId = new ConsultationId();
			consultationId.setEquipeSanitaire(eq);
			consultationId.setEnfant(e);
			consultationId.setDate(d);
	        em.remove(consultationId);
			
			
		}

		@Override
		public void modifierConsultation(Consultation c) {
			em.merge(c);

			
		}

		@Override
		public long getNombreConsultations() {
			Query req=em.createQuery("select count(cons) from Consultation cons ");
			return (Long)req.getResultList().get(0);
			
		}
		
		
		

		@Override
		public List<Consultation> listConsultations() {
			 Query req=em.createQuery("select cons from Consultation cons  order by cons.id desc");
				
				return req.getResultList();

		}

		@Override
		public List<Consultation> listConsultations(int position,
				int nbrConsultations) {
			Query req=em.createQuery("select cons from Consultation cons order by cons.id desc ");
			req.setFirstResult(position);
			req.setMaxResults(nbrConsultations);
			return req.getResultList();
		}

		
		
		///////////////////////////////////////////////////////////////////////
		
		//Gestion des Parents

		@Override
		public Long ajouterParent(Parent parent) {

			 em.persist(parent);
				
			  return parent.getIdPerson();
					  
		}

		@Override
		public List<Parent> parentParNom(String nomParent) {
			Query req=em.createQuery("select par from Parent par where par.nom like :x or par.prenom :x");
			req.setParameter("x", "%"+nomParent+"%"); 
			return req.getResultList();
		}

		@Override
		public Parent getParent(Long idParent) {
			return em.find(Parent.class, idParent);
		}

		@Override
		public Parent getParentbycin(String cin) {
			return em.find(Parent.class, cin);

		}

		/*@Override
		public List<Parent> listPere(String genre) {
			Query req = em.createQuery("select p from Parent p where p.genre=:x");
			req.setParameter("x", genre);
			return req.getResultList();

		}*/

	/*	@Override
		public List<Parent> listMere(String genre) {
			Query req = em.createQuery("select p from Parent p where p.genre=:x");
			req.setParameter("x", genre);
			return req.getResultList();

		}*/

		@Override
		public void supprimerParent(Long idParent) {
			Parent par=em.find(Parent.class, idParent);
			em.remove(par);
			
		}

		@Override
		public void modifierParent(Parent parent) {
			em.merge(parent);
			
		}
		
		

		@Override
		public List<Parent> listParents(int position, int nbrParents) {

			Query req=em.createQuery("select par from Parent par order by par.idPerson desc ");
			req.setFirstResult(position);
			req.setMaxResults(nbrParents);
			return req.getResultList();
		}
		

		@Override
		public List<Parent> listParents() {
			Query req=em.createQuery("select par from Parent par  order by par.idPerson desc");
			
			 return req.getResultList();
		}

		@Override
		public long getNombreParents() {

			Query req=em.createQuery("select count(par) from Parent par ");
			return (Long)req.getResultList().get(0);
		}

		@Override
		public List<Enfant> getEnfantByParent(Long idParent) {
			Query req=em.createQuery("select enf from Enfant enf join enf.Parent pr where pr.idPerson=:x");
			req.setParameter("x", idParent);	
			return req.getResultList();
		}
		
		

		@Override
		public void ajouterEnfantsPourParent(Long idEnfant, Long idParent) {
			Enfant e=em.find(Enfant.class, idEnfant);
			Parent pr=em.find(Parent.class, idParent);
			e.getParent().add(pr);
			pr.getEnfants().add(e);
			
		}
		
		///////////////////////////////////////////////////////////////
		
		
		//Gestion des Evennements

		@Override
		public Long ajouterEvennement(Evenement evennement) {
	          em.persist(evennement);
			
			return evennement.getIdEvenement();
		}

		@Override
		public List<Evenement> evennementParNom(String nom) {
			
			Query req=em.createQuery("select even from Evenement even where even.nom like :x ");
			req.setParameter("x", "%"+nom+"%"); 
			return req.getResultList();
		}

		@Override
		public Evenement getEvennement(Long idEvennement) {
			return em.find(Evenement.class, idEvennement);
		}

		@Override
		public void supprimerEvennements(Long idEvennement) {
			Evenement even=em.find(Evenement.class, idEvennement);
			em.remove(even);
			
		}

		@Override
		public void modifierEvennements(Evenement evennement) {
			em.merge(evennement);
			
		}
		

		

		@Override
		public long getNombreEvennements() {
			Query req=em.createQuery("select count(even) from Evenement even ");
			return (Long)req.getResultList().get(0);
		}

		@Override
		public List<Evenement> listEvennements() {
			 Query req=em.createQuery("select even from Evenement even order by even.idEvenement desc");
				
			return req.getResultList();
		}

		@Override
		public List<Evenement> listEvennements(int position, int nbrEvennements) {
			Query req=em.createQuery("select cons from Evenement cons order by cons.idEvenement desc ");
			req.setFirstResult(position);
			req.setMaxResults(nbrEvennements);
			return req.getResultList();
		}

		@Override
		public List<Enfant> getEnfantsByEvennement(Long idEvennement) {

			Query req=em.createQuery("select enf from Enfant enf join enf.Evenement even where even.idEvenement=:x");
			req.setParameter("x", idEvennement);	
			return req.getResultList();
		}
		
		///////////////////////////////////////////////////////////////////
		
		
		//Gestion des Enfants

		@Override
		public Long ajouterEnfant(Enfant enfant) {
	      em.persist(enfant); 
			
			return enfant.getIdPerson();
		}

		@Override
		public List<Enfant> enfantParNom(String nom) {
			Query req=em.createQuery("select enf from Enfant enf where enf.nom like :x or enf.prenom :x");
			req.setParameter("x", "%"+nom+"%"); 
			return req.getResultList();
		}

		@Override
		public Enfant getEnfant(Long idEnfant) {
			return em.find(Enfant.class, idEnfant);
		}

		@Override
		public List<Enfant> enfantCertife() {

	        Query req=em.createQuery("select enf from Enfant enf where enf.certificatMedicale=true");
			
			return req.getResultList();
		}

		@Override
		public List<Enfant> enfantPhotoAutorise() {
			 Query req=em.createQuery("select enf from Enfant enf where enf.autorisationPrisePhoto=true");
				
				return req.getResultList();
		}

		@Override
		public List<Enfant> EnfantParMotCle(String mc) {
			Query req = em
					.createQuery("select e from Enfant e where e.prenom like:x or e.nom like:x");
			req.setParameter("x", "%" + mc + "%");
			return req.getResultList();

		}

		@Override
		public List<Enfant> EnfantParParent(Long idPar) {
			Query req = em
					.createQuery("select e from Enfant e where e.parent.idPerson=:x");
			req.setParameter("x", idPar);
			return req.getResultList();

		}

		@Override
		public List<Inscription> EnfantParClasse(Long idClas) {
			Query req = em
					.createQuery("select i from Inscription i where i.id.classe.idClasse=:x");
			req.setParameter("x", idClas);
			return req.getResultList();

		}

		@Override
		public List<ClubEnfant> EnfantParClub(Long idClub) {
			Query req = em
					.createQuery("select e from ClubEnfant e where e.club.idClub=:x");
			req.setParameter("x", idClub);
			return req.getResultList();

		}

		@Override
		public List<Enfant> EnfantParEvenement(Long idEve) {
			Query req = em
					.createQuery("select e from Enfant e where e.evenement.idEvenement=:x");
			req.setParameter("x", idEve);
			return req.getResultList();
		}

		@Override
		public List<Enfant> EnfantParAccompagnaeurt(Long idAcc) {
			Query req = em
					.createQuery("select e from Enfant e where e.accompagnateur.idPerson=:x");
			req.setParameter("x", idAcc);
			return req.getResultList();

		}

		@Override
		public List<Enfant> EnfantParPlanningH(Long idPlan) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Enfant> EnfantSelectionnes() {
			Query req = em.createQuery("select e from Enfant e ");
			return req.getResultList();

		}

		@Override
		public void supprimerEnfant(Long idEnfant) {
			Enfant e = em.find(Enfant.class, idEnfant);
			em.remove(e);

			
		}

		@Override
		public void modifierEnfant(Enfant enfant) {
			em.merge(enfant);
			
		}

		@Override
		public List<Accompagnateur> getAccompagnateursByEnfant(Long idEnfant) {
			Query req=em.createQuery("select acc from Accompagnateur acc join acc.Enfant enf where enf.idPerson=:x");
			req.setParameter("x", idEnfant);	
			return req.getResultList();
		}

		@Override
		public List<Evenement> getEvennementsByEnfant(Long idEnfant) {
			Query req=em.createQuery("select even from Evenement even join even.Enfant enf where enf.idPerson=:x");
			req.setParameter("x", idEnfant);	
			return req.getResultList();
		}

		@Override
		public List<Parent> getParentsByEnfant(Long idEnfant) {

			Query req=em.createQuery("select par from Parent par join par.Enfant enf where enf.idPerson=:x");
			req.setParameter("x", idEnfant);	
			return req.getResultList();
		}

		@Override
		public void ajouterAccompagnateursPourEnfant(Long idAccompagnateur,
				Long idEnfant) {
			Accompagnateur acc=em.find(Accompagnateur.class, idAccompagnateur);
			Enfant e=em.find(Enfant.class, idEnfant);
			acc.getEnfants().add(e);
			e.getAccompagnateur().add(acc);
			
		}

		

		@Override
		public void ajouterParentsPourEnfant(Long idParent, Long idEnfant) {
			Parent pr=em.find(Parent.class, idParent);
			Enfant e=em.find(Enfant.class, idEnfant);
			pr.getEnfants().add(e);
			e.getParent().add(pr);
			
		}

		@Override
		public Long nbrEnfantClasse(Long idCla) {
			Query req = em.createQuery("select count(*) from Inscription i where i.id.classe.id=:x");
			req.setParameter("x", idCla);
			Long count = (Long)req.getSingleResult();
			return count;

		}

		@Override
		public void ajouterEnfantToParent(Long idEnf, Long idPar) {
			Enfant e = em.find(Enfant.class, idEnf);
			Parent p = em.find(Parent.class, idPar);
			e.getParent().add(p);
			p.getEnfants().add(e);
			
		}

		

		
		@Override
		public void ajouterEnfantToAccompagnteur(Long idEnf, Long idAcc) {
			Enfant e = em.find(Enfant.class, idEnf);
			Accompagnateur a = em.find(Accompagnateur.class, idAcc);
			e.getAccompagnateur().add(a);
			a.getEnfants().add(e);

			
		}

		

		@Override
		public void ajouterFournisseurToMateriel(Long idFour, Long idMat) {
			Fournisseur f = em.find(Fournisseur.class, idFour);
			Materiel m = em.find(Materiel.class, idMat);
			f.getMateriels().add(m);
			m.getFournisseurs().add(f);
			
		}

		@Override
		public List<Enfant> listEnfants(int position, int nbrEnfants) {
			Query req=em.createQuery("select enf from Enfant enf order by enf.idPerson desc ");
			req.setFirstResult(position);
			req.setMaxResults(nbrEnfants);
			return req.getResultList();
		}

		@Override
		public List<Enfant> listEnfants() {
			Query req=em.createQuery("select enf from Enfant enf order by enf.idPerson desc");
			
			 return req.getResultList();	
		}

		@Override
		public long getNombreEnfants() {
			
			Query req=em.createQuery("select count(enf) from Enfant enf ");
			return (Long)req.getResultList().get(0);
		}
		
		
		//////////////////////////////////////////////////////////////
		
		//Gestion des Fournisseurs

		@Override
		public Long ajouterFournisseur(Fournisseur fournisseur) {
			 em.persist(fournisseur);
			 
		     return fournisseur.getIdPerson();
		}

		@Override
		public List<Fournisseur> fournisseurParNom(String nom) {
		    Query req=em.createQuery("select four from Fournisseur four");
			
			return req.getResultList();
		}

		@Override
		public Fournisseur getFournisseur(Long idFournisseur) {
			return em.find(Fournisseur.class, idFournisseur);
		}

		@Override
		public void supprimerFournisseur(Long idFournisseur) {
			Fournisseur four=em.find(Fournisseur.class, idFournisseur);
			em.remove(four);
			
		}

		@Override
		public void modifierFournisseur(Fournisseur fournisseur) {
			em.merge(fournisseur);
			
		}

		@Override
		public List<Materiel> getMaterielsByFournisseur(Long idFournisseur) {
			Query req=em.createQuery("select mat from Materiels mat join mat.Fournisseur four where four.idPerson=:x");
			req.setParameter("x", idFournisseur);	
			return req.getResultList();
		}

		
		@Override
		public long getNombreFournisseurs() {
			Query req=em.createQuery("select count(four) from Fournisseur four ");
			return (Long)req.getResultList().get(0);
		}

		@Override
		public List<Fournisseur> listFournisseurs() {
			 Query req=em.createQuery("select four from Fournisseur four order by four.idPerson desc");
				
			return req.getResultList();
		}

		@Override
		public List<Fournisseur> listFournisseurs(int position, int nbrFournisseurs) {
			Query req=em.createQuery("select four from Fournisseur four order by four.idPerson desc ");
			req.setFirstResult(position);
			req.setMaxResults(nbrFournisseurs);
			return req.getResultList();
		}
		
		
		///////////////////////////////////////////////////////////////:
		
		//Gestion des Materiels

		@Override
		public Long ajouterMateriels(Materiel materiels, Long idTypeMateriels,
				Long idStock) {
			TypeMateriels typ=em.find(TypeMateriels.class, idTypeMateriels);
			Stock st=em.find(Stock.class, idStock);
			
			materiels.setTypeMateriels(typ);
			materiels.setStock(st);
			
			em.persist(materiels); 
			
			return materiels.getIdMateriel();
		}

		@Override
		public List<Materiel> materielsParDesignation(String designation) {
			Query req=em.createQuery("select mat from Materiel mat where mat.designation like :x ");
			req.setParameter("x", "%"+designation+"%");
			return req.getResultList();
		}

		@Override
		public Materiel getMateriels(Long idMateriels) {
			return em.find(Materiel.class, idMateriels);
		}

		@Override
		public void supprimerMateriels(Long idMateriels) {
			Materiel mat=em.find(Materiel.class, idMateriels);
			em.remove(mat);
			
		}

		@Override
		public void modifierMateriels(Materiel materiels) {
			em.merge(materiels);
			
		}

		

		@Override
		public List<Equipe> getEquipeByMateriels(Long idMateriels) {
			Query req=em.createQuery("select four from Fournisseur four join four.Materiel mat where mat.idMateriel=:x");
			req.setParameter("x", idMateriels);	
			return req.getResultList();
		}

		

		
		


		

		@Override
		public long getNombreMateriels() {
			
		   Query req=em.createQuery("select count(mat) from Materiel mat ");
			return (Long)req.getResultList().get(0);
		}
		
		@Override

		public List<Materiel> listMateriels() {
			 Query req=em.createQuery("select four from Materiel four order by four.idMateriel desc");
				
				return req.getResultList();
		}

		@Override
		public List<Materiel> listMateriels(int position, int nbrMateriels) {
			Query req=em.createQuery("select mat from Materiel mat order by mat.idMateriel desc ");
			req.setFirstResult(position);
			req.setMaxResults(nbrMateriels);
			return req.getResultList();
		}

		
		
		
		///////////////////////////////////////////////////////////////////
		
		
		//Gestion des Types Materiels

		@Override
		public Long ajouterTypeMateriel(TypeMateriels typeMateriels) {
	        em.persist(typeMateriels);
			
			return typeMateriels.getIdTypeMateriels();
		}

		
		@Override
		public TypeMateriels getTypeMateriels(Long idTypeMateriels) {
			return em.find(TypeMateriels.class,idTypeMateriels);
		}

		@Override
		public void supprimerTypeMateriels(Long idTypeMateriels) {

			TypeMateriels ty=em.find(TypeMateriels.class, idTypeMateriels);
			em.remove(ty);
			
		}

		@Override
		public void modifierTypeMateriels(TypeMateriels typeMateriels) {
			em.merge(typeMateriels);
			
		}

		@Override
		public long getNombreTypesMateriels() {
			Query req=em.createQuery("select count(typM) from TypeMateriels typM ");
			return (Long)req.getResultList().get(0);
		}

		@Override
		public List<TypeMateriels> listTypeMateriels() {
	Query req=em.createQuery("select typ from TypeMateriels typ order by typ.idTypeMateriels desc");
			
			return req.getResultList();
		}

		@Override
		public List<TypeMateriels> listTypeMateriels(int position,
				int nbrTypesMateriels) {
			Query req=em.createQuery("select typM from TypeMateriels typM order by typM.idTypeMateriels desc");
			req.setFirstResult(position);
			req.setMaxResults(nbrTypesMateriels);
			return req.getResultList();
		}
		
		//////////////////////////////////////////////////////////////////////
		
		//gestion Stocks

		@Override
		public Long ajouterStock(Stock stock) {
			 em.persist(stock);
				
				return stock.getIdStock();
		}

		@Override
		public Stock getStock(Long idStock) {
			return em.find(Stock.class, idStock);
			
		}

		@Override
		public void supprimerStock(Long idStock) {
			Stock sto=em.find(Stock.class, idStock);
			em.remove(sto);
			
		}

		@Override
		public void modifierStock(Stock stock) {
			em.merge(stock);
			
		}

		@Override
		public long getNombreStocks() {
			Query req=em.createQuery("select count(stoc) from Stock stoc ");
			return (Long)req.getResultList().get(0);
		}

		@Override
		public List<Stock> listStock() {
			  Query req=em.createQuery("select st from Stock st  order by st.idStock desc");
				
				return req.getResultList();
		}

		@Override
		public List<Stock> listStock(int position, int nbrStocks) {
			Query req=em.createQuery("select stoc from Stock stoc order by stoc.idStock desc ");
			req.setFirstResult(position);
			req.setMaxResults(nbrStocks);
			return req.getResultList();
		}

		@Override
		public MatrielUtiliser ajouterMatrielUtiliser(MatrielUtiliser m,
				Long idMat, Long idEqTech, Date d) {
			
		
				if ( idEqTech != null && idMat != null) {
					EquipeEducatif a = em.find(EquipeEducatif.class, idEqTech);
					
					Materiel ma = em.find(Materiel.class, idMat);
					m.setEquipeEducatif(a);
					
					m.setMateriel(ma);
	       	        m.setDateDebutUtilisationMateriel(d);
				}
				em.persist(m);
				return m;
			}


		

		@Override
		public List<MatrielUtiliser> listMatrielUtiliser() {
			Query req = em.createQuery("select m from MatrielUtiliser m");
			return req.getResultList();

		}

		@Override
		public MatrielUtiliser getMatrielUtiliser(Long idMat, 
				Long idEqTech, Date d) {
			
				Materiel m=em.find(Materiel.class, idMat);	
				EquipeEducatif a = em.find(EquipeEducatif.class, idEqTech);
				
				MaterielUtiliserId materielUtiliserId = new MaterielUtiliserId();
				materielUtiliserId.setMateriel(m);
				materielUtiliserId.setEquipeEducatif(a);
				
				System.out.print(materielUtiliserId.getMateriel().getDescription());

	          return em.find(MatrielUtiliser.class, materielUtiliserId);


		}

		@Override
		public void supprimerMatrielUtiliser(Long idMat,Long idEqTech, Date d) {
			
			if(idEqTech!=null && idMat!=null)
			{
				Materiel m=em.find(Materiel.class, idMat);	
				EquipeEducatif a = em.find(EquipeEducatif.class, idEqTech);
				
			MaterielUtiliserId materielUtiliserId = new MaterielUtiliserId();
			materielUtiliserId.setMateriel(m);
			materielUtiliserId.setEquipeEducatif(a);
			
			materielUtiliserId.setDateDebutUtilisationMateriel(d);
			MatrielUtiliser ma=em.find(MatrielUtiliser.class, materielUtiliserId);
			em.remove(ma);
		}
			}
			


		@Override
		public void modifierMatrielUtiliser(MatrielUtiliser m) {
			em.merge(m);

			
		}
		
		@Override

		public void modifierMatrielSanitaireUtiliser(MatrielSanitaUtiliser me) {
			em.merge(me);
			
			
		}

		@Override
		public MatrielSanitaUtiliser ajouterMatrielSanitaireUtiliser(MatrielSanitaUtiliser m,
				Long idMat, Long idSani, Date d) {
			if ( idSani != null && idMat != null) {
				EquipeSanitaire a = em.find(EquipeSanitaire.class, idSani);
				
				Materiel ma = em.find(Materiel.class, idMat);
				m.setEquipeSanitaire(a);
				m.setMateriel(ma);
	   	        m.setDateDebutUtilisation(d);
			}
			em.persist(m);
			return m;
		}
		

		@Override
		public List<MatrielSanitaUtiliser> listMatrielSanitaireUtiliser() {
			Query req = em.createQuery("select m from MatrielSanitaUtiliser m");
			return req.getResultList();
		}

		@Override
		public MatrielSanitaUtiliser getMatrielSanitaireUtiliser(Long idMat, Long idSani,
				Date d) {
			Materiel m=em.find(Materiel.class, idMat);	
			EquipeSanitaire a = em.find(EquipeSanitaire.class, idSani);
			
			MaterielSanitaireUtiliserId materielSanitaireUtiliserId = new MaterielSanitaireUtiliserId();
			materielSanitaireUtiliserId.setMateriel(m);
			materielSanitaireUtiliserId.setEquipeSanitaire(a);
			
			System.out.print(materielSanitaireUtiliserId.getMateriel().getDescription());

	      return em.find(MatrielSanitaUtiliser.class, materielSanitaireUtiliserId);
		}

		@Override
		public void supprimerMatrielSanitaireUtiliser(Long idMat, Long idEqSani,
				Date d) {
			if(idEqSani!=null && idMat!=null)
			{
				Materiel m=em.find(Materiel.class, idMat);	
				EquipeSanitaire a = em.find(EquipeSanitaire.class, idEqSani);
				
			MaterielSanitaireUtiliserId materielSanitaireUtiliserId = new MaterielSanitaireUtiliserId();
			materielSanitaireUtiliserId.setMateriel(m);
			materielSanitaireUtiliserId.setEquipeSanitaire(a);
			
			materielSanitaireUtiliserId.setDateDebutUtilisation(d);
			
			MatrielSanitaUtiliser ma=em.find(MatrielSanitaUtiliser.class, materielSanitaireUtiliserId);
			em.remove(ma);
		}
			}



		@Override
		public ClubEnfant ajouterEnfantClub(ClubEnfant m, Long idClub,
				Long idEnf,Date dateDebutInscription) {
			
			if ( idEnf != null && idClub != null) {
				Enfant en= em.find(Enfant.class, idEnf);
				
				Club cl= em.find(Club.class, idClub);
				m.setClub(cl);
				
				m.setEnfant(en);
				m.setDateDebutInscriClub(dateDebutInscription);
       	       
			}
			em.persist(m);
			return m;
			
		
		}

		@Override
		public List<ClubEnfant> listEnfantClub() {
			Query req = em.createQuery("select m from ClubEnfant m");
			return req.getResultList();
		}

		@Override
		public ClubEnfant getEnfantClub(Long idClub, Long idEnf ,Date dateDebutInscription) {

			Enfant e=em.find(Enfant.class, idEnf);	
			Club cl = em.find(Club.class, idClub);
			
			ClubEnfantId clubEnfantId = new ClubEnfantId();
			clubEnfantId.setEnfant(e);
			clubEnfantId.setClub(cl);
			clubEnfantId.setDateDebutInscriClub(dateDebutInscription);
			
			
			System.out.print(clubEnfantId.getEnfant().getNom());

          return em.find(ClubEnfant.class, clubEnfantId);

		}

		@Override
		public void supprimerEnfantClub(Long idClub, Long idEnf ,Date dateDebutInscription) {
			
			if(idEnf!=null && idClub!=null)
			{
				Enfant en=em.find(Enfant.class, idEnf);	
				Club cl = em.find(Club.class, idClub);
				
				ClubEnfantId clubEnfantId = new ClubEnfantId();
				clubEnfantId.setEnfant(en);
				clubEnfantId.setClub(cl);
				clubEnfantId.setDateDebutInscriClub(dateDebutInscription);
			
				
			
				ClubEnfant ma=em.find(ClubEnfant.class, clubEnfantId);
			em.remove(ma);
		}
			
		}

		@Override
		public void modifierEnfantClub(ClubEnfant me) {
			em.merge(me);
			
		}

		@Override
		public PlanningEnfant ajouterEnfantPlanning(PlanningEnfant m,
				Long idEnf, Long idPlan ,Date dateDebutInscription) {
			
			if ( idEnf != null && idPlan != null) {
				Enfant en= em.find(Enfant.class, idEnf);
				
				PlanningHorraires pl= em.find(PlanningHorraires.class, idPlan);
				m.setPlanningHorraires(pl);
				
				m.setEnfant(en);
				m.setDateDebutInscriPlannings(dateDebutInscription);
       	       
			}
			em.persist(m);
			return m;
		}

		@Override
		public List<PlanningEnfant> listPlanningEnfant() {
			Query req = em.createQuery("select m from PlanningEnfant m");
			return req.getResultList();
		}

		@Override
		public PlanningEnfant getPlanningEnfant(Long idEnf, Long idPlan
				,Date dateDebutInscription) {

			Enfant e=em.find(Enfant.class, idEnf);	
			PlanningHorraires pl = em.find(PlanningHorraires.class, idPlan);
			
			PlanningEnfantId planningEnfantId = new PlanningEnfantId();
			planningEnfantId.setEnfant(e);
			planningEnfantId.setPlanningHorraires(pl);
			planningEnfantId.setDateDebutInscriPlannings(dateDebutInscription);
			
			
			System.out.print(planningEnfantId.getEnfant().getNom());

          return em.find( PlanningEnfant.class, planningEnfantId);

		}

		@Override
		public void supprimerPlanningEnfant(Long idEnf,
				Long idPlan ,Date dateDebutInscription) {
			
			if(idEnf!=null && idPlan!=null)
			{
				Enfant en=em.find(Enfant.class, idEnf);	
				PlanningHorraires pl = em.find(PlanningHorraires.class, idPlan);
				
				PlanningEnfantId planningEnfantId = new PlanningEnfantId();
				planningEnfantId.setEnfant(en);
				planningEnfantId.setPlanningHorraires(pl);
				planningEnfantId.setDateDebutInscriPlannings(dateDebutInscription);
			
				
			
				PlanningEnfant ma=em.find(PlanningEnfant.class, planningEnfantId);
			em.remove(ma);
		}
			
		}

		@Override
		public void modifierPlanningEnfant(PlanningEnfant me) {
			em.merge(me);
			
		}

		@Override
		 public EvennementEnfant ajouterEvennementEnfant(EvennementEnfant m,Long idEnf,Long idEvene,Date dateDebutInscription) {
			
			if ( idEnf != null && idEvene != null) {
				Enfant en= em.find(Enfant.class, idEnf);
				
				Evenement ev = em.find(Evenement.class, idEvene);
				m.setEvenement(ev);
				
				m.setEnfant(en);
       	        m.setDateDebuInscription(dateDebutInscription);
			}
			em.persist(m);
			return m;
		}

		@Override
		public List<EvennementEnfant> listEvennementEnfant() {
			Query req = em.createQuery("select m from EvennementEnfant m");
			return req.getResultList();
		}

		@Override
		 public EvennementEnfant getEvennementEnfant(Long idEnf,Long idEvene,Date dateDebutInscription) {

			Enfant e=em.find(Enfant.class, idEnf);	
			Evenement pl = em.find(Evenement.class, idEvene);
			
			EvennementEnfantId evennementEnfantId = new EvennementEnfantId();
			evennementEnfantId.setEnfant(e);
			evennementEnfantId.setEvenement(pl);
			evennementEnfantId.setDateDebuInscription(dateDebutInscription);
			
			System.out.print(evennementEnfantId.getEnfant().getNom());

          return em.find( EvennementEnfant.class, evennementEnfantId);
		}

		@Override
		 public void supprimerEvennementEnfant(Long idEnf ,Long idEvene,Date dateDebutInscription) {
			if(idEnf!=null && idEvene!=null)
			{
				Enfant en=em.find(Enfant.class, idEnf);	
				Evenement ad = em.find(Evenement.class, idEvene);
				
			EvennementEnfantId evennementEnfantId = new EvennementEnfantId();
			evennementEnfantId.setEnfant(en);
			evennementEnfantId.setEvenement(ad);
			
			evennementEnfantId.setDateDebuInscription(dateDebutInscription);
			
			EvennementEnfant ma=em.find(EvennementEnfant.class, evennementEnfantId);
			em.remove(ma);
		}
			
		}

		@Override
		public void modifierEvennementEnfant(EvennementEnfant me) {
			em.merge(me);
			
		}

		@Override
		public Inscription ajouterInscription(Inscription i, Long idEnf,
				Long idClas) {
			if (idEnf != null && idClas != null) {
				Classe c = em.find(Classe.class, idClas);
				Enfant e = em.find(Enfant.class, idEnf);
				//InscriptionId id=new InscriptionId();
				i.setClasse(c);
				i.setEnfant(e);
				//i.setAnnee("2014/2015");
			}
			em.persist(i);
			return i;


	

	

		}

		@Override
		public List<Parent> listParents2(int position, int nbrParents) {
		
			
				Query req=em.createQuery("select p from parent p order by p.idPerson desc ");
				req.setFirstResult(position);
				req.setMaxResults(nbrParents);
				return req.getResultList();
			}
		

		@Override
		public long getNombreParents2() {
			Query req=em.createQuery("select count(p) from parent p ");
			return (Long)req.getResultList().get(0);
		}
		
		
		
		

		
		public List <ClubEnfant>  ListClubActifsEnfant (Long idEnf) {
			Query req = em.createQuery("select clEnf from ClubEnfant clEnf where clEnf.id.enfant.idPerson=:x and  clEnf.dateFinInscriClub is NULL");
			req.setParameter("x",idEnf);
			
			return req.getResultList();

		}

		
		
           public Long getConsultationEnf(Long idEnf, String d) {
			Query req = em.createQuery("select count(*) from Consultation c where c.id.enfant.idPerson=:x and c.id.date=:y");
			req.setParameter("x",idEnf);
			req.setParameter("y",d);
			
			
			Long count = (Long)req.getSingleResult();
			return count;

		}

		@Override
		public Consultation ajouterConsultation(Consultation c, Long idEnf,
				Long idEqSani) {
			if (idEnf != null && idEqSani != null) {
				EquipeSanitaire eqSan = em.find(EquipeSanitaire.class, idEqSani);
				Enfant e = em.find(Enfant.class, idEnf);
				//InscriptionId id=new InscriptionId();
				
				c.setEquipeSanitaire(eqSan);
				c.setEnfant(e);
				//i.setAnnee("2014/2015");
			}
			em.persist(c);
			return c;
		
		
	
		}

		@Override
		public List<PlanningEnfant> ListPlanningActifsEnfant(Long idEnf) {
			
			Query req = em.createQuery("select PlaningEnf from PlanningEnfant PlaningEnf where PlaningEnf.id.enfant.idPerson=:x and  PlaningEnf.dateFinInscriFinPlanning is NULL");
			req.setParameter("x",idEnf);
			
			return req.getResultList();
		}

		/*
		@Override
		public List<EvennementEnfant> ListEvennementActifsEnfant(Long idEnf) {
			
			Query req = em.createQuery("select EvenEnf from EvennementEnfant EvenEnf where EvenEnf.id.enfant.idPerson=:x and  EvenEnf.date is NUll");
			req.setParameter("x",idEnf);
			
			return req.getResultList();

		}*/

		@Override
		 public ClasseEquipeEducatif ajouterEquipeEducatifClasse(ClasseEquipeEducatif m,Long idClass,Long idEquipeEducatif,Date dateDebutInscrClass) {
			

			if ( idEquipeEducatif != null && idClass != null) {
				
				EquipeEducatif eqEdu=em.find(EquipeEducatif.class, idEquipeEducatif);	
				Classe cl = em.find(Classe.class, idClass);
				m.setEquipeEducatif(eqEdu);
				
				m.setClasse(cl);
				m.setDateDebutEneseignementClas(dateDebutInscrClass);
       	       
			}
			em.persist(m);
			return m;
		}

		@Override
		public List<ClasseEquipeEducatif> listEquipeEducatifClasse() {
			
			Query req = em.createQuery("select m from ClasseEquipeEducatif m");
			return req.getResultList();
		}

		@Override
		public ClasseEquipeEducatif getEquipeEducatifClasse(Long idClass,Long idEquipEducatif,Date dateDebutInscrClass) 
		
		{
			EquipeEducatif eqEdu=em.find(EquipeEducatif.class, idEquipEducatif);	
			Classe cl = em.find(Classe.class, idClass);
			
			ClasseEquipeEducatifId classeEquipeEducatifId = new ClasseEquipeEducatifId();
			classeEquipeEducatifId.setEquipeEducatif(eqEdu);
			classeEquipeEducatifId.setClasse(cl);
			classeEquipeEducatifId.setDateDebutEneseignementClas(dateDebutInscrClass);
			
			
			System.out.print(classeEquipeEducatifId.getEquipeEducatif().getNom());

          return em.find(ClasseEquipeEducatif.class, classeEquipeEducatifId);

		}

		@Override
		public void supprimerEquipeEducatifClasse(Long idClass ,Long idEquipEducatif,Date dateDebutInscrClass) {
			
			if(idEquipEducatif!=null && idClass!=null)
			{
				EquipeEducatif eqEdu=em.find(EquipeEducatif.class, idEquipEducatif);	
				Classe cl = em.find(Classe.class, idClass);
				
				ClasseEquipeEducatifId classeEquipeEducatifId = new ClasseEquipeEducatifId();
				classeEquipeEducatifId.setEquipeEducatif(eqEdu);
				classeEquipeEducatifId.setClasse(cl);
				classeEquipeEducatifId.setDateDebutEneseignementClas(dateDebutInscrClass);
			
				
			
				ClasseEquipeEducatif clEquip=em.find(ClasseEquipeEducatif.class, classeEquipeEducatifId);
			em.remove(clEquip);
			}
			
		}

		@Override
		public void modifierEquipeEducatifClasse(ClasseEquipeEducatif cl) {
			em.merge(cl);
			
		}

		
		@Override
		public CategorieClubEquipeEducatif ajouterCategorieClubEquipeEducatif(CategorieClubEquipeEducatif m,Long idCateg,Long idEquipeEducatif,Date dateDebutInscrClub) {
			

			if ( idEquipeEducatif != null && idCateg != null) {
				EquipeEducatif equipEd= em.find(EquipeEducatif.class, idEquipeEducatif);
				
				CategorieClub categ= em.find(CategorieClub.class, idCateg);
				m.setCategorieClub(categ);
				
				m.setEquipeEducatif(equipEd);
				m.setDateDebutAnimationCategori(dateDebutInscrClub);
       	       
			}
			em.persist(m);
			return m;
		}

		@Override
		public List<CategorieClubEquipeEducatif> listCategorieClubEquipeEducatif() {
			
			Query req = em.createQuery("select m from CategorieClubEquipeEducatif m");
			return req.getResultList();
		}

		@Override
		public CategorieClubEquipeEducatif getCategorieClubEquipeEducatif(Long idCateg,Long idEqEdu,Date dateDebutInscrClub) {
			
			EquipeEducatif equipEdu=em.find(EquipeEducatif.class, idEqEdu);	
			CategorieClub categ = em.find(CategorieClub.class, idCateg);
			
			CategorieClubEquipeEducatifId categorieClubEquipeEducatifId = new CategorieClubEquipeEducatifId();
			categorieClubEquipeEducatifId.setEquipeEducatif(equipEdu);
			categorieClubEquipeEducatifId.setCategorieClub(categ);
			categorieClubEquipeEducatifId.setDateDebutAnimationCategori(dateDebutInscrClub);
			
			
			System.out.print(categorieClubEquipeEducatifId.getEquipeEducatif().getNom());

          return em.find(CategorieClubEquipeEducatif.class, categorieClubEquipeEducatifId);

		}

		@Override
		public void supprimerCategorieClubEquipeEducatif(Long idCateg ,Long idEquipeEducatif,Date dateDebutInscrClubString ) {
			
			if(idEquipeEducatif!=null && idCateg!=null)
			{
				EquipeEducatif equipEdu=em.find(EquipeEducatif.class, idEquipeEducatif);	
				CategorieClub categ = em.find(CategorieClub.class, idCateg);
				
				CategorieClubEquipeEducatifId categorieClubEquipeEducatifId = new CategorieClubEquipeEducatifId();
				categorieClubEquipeEducatifId.setCategorieClub(categ);
				categorieClubEquipeEducatifId.setEquipeEducatif(equipEdu);
				categorieClubEquipeEducatifId.setDateDebutAnimationCategori(dateDebutInscrClubString);
			
				
			
				CategorieClubEquipeEducatif categEdu=em.find(CategorieClubEquipeEducatif.class, categorieClubEquipeEducatifId);
			em.remove(categEdu);
			}
			
		}

		@Override
		public void modifierCategorieClubEquipeEducatif(CategorieClubEquipeEducatif cat) 
		{
			
			
			em.merge(cat);
			
		}
		/*

		@Override
		public List<ClasseEquipeEducatif> ListClasseActifsEquEducatif(Long idEqEducatif) {
			Query req = em.createQuery("select eqEduClass from ClasseEquipeEducatif eqEduClass where eqEduClass.id.equipeEducatif.idPerson=:x and  eqEducCateg.annee is NULL");
			req.setParameter("x",idEqEducatif);
			
			return req.getResultList();
		}
		/*

		@Override
		public List<CategorieClubEquipeEducatif> ListCategorieClubActifsEquipeEducatif(Long idEqEduc) {
			Query req = em.createQuery("select eqEducCateg from CategorieClubEquipeEducatif eqEducCateg where eqEducCateg.id.equipeEducatif.idPerson=:x and  eqEducCateg.annee is NULL");
			req.setParameter("x",idEqEduc);
			
			return req.getResultList();

		}*/

		@Override
		public void ajouterFournisseurPourMateriel(Long idFournisseur,Long idMateriel) {
			
			
			Fournisseur four=em.find(Fournisseur.class, idFournisseur);
			Materiel mat=em.find(Materiel.class, idMateriel);
			four.getMateriels().add(mat);
			mat.getFournisseurs().add(four);
			
		}

		@Override
		public void ajouterMaterielPourFournisseur(Long idMateriel,Long idFournisseur) {
			
			Materiel mat=em.find(Materiel.class, idMateriel);
			Fournisseur four=em.find(Fournisseur.class, idFournisseur);
			mat.getFournisseurs().add(four);
			four.getMateriels().add(mat);
		}

		@Override
		public List<MatrielUtiliser> ListMaterielActifsEqEducatif(Long idEqEducatif) {
			Query req = em.createQuery("select matEq from MatrielUtiliser matEq where matEq.id.equipeEducatif.idPerson=:x and  matEq.dateFinUtilisation is NULL");
			req.setParameter("x",idEqEducatif);
			
			return req.getResultList();
		}

		@Override
		public List<MatrielSanitaUtiliser> ListMaterielActifsEqSanitaire(Long idSanitaire) {
			Query req = em.createQuery("select matEqSan from MatrielSanitaUtiliser matEqSan where matEqSan.id.equipeSanitaire.idPerson=:x and  matEqSan.dateFinUtilisation is NULL");
			req.setParameter("x",idSanitaire);
			
			return req.getResultList();
		}

		@Override
		public List<EvennementEnfant> ListEvennementActifsEnfant(Long idEnf) {
			Query req = em.createQuery("select evenEnf from EvennementEnfant evenEnf where evenEnf.id.enfant.idPerson=:x and  evenEnf.dateFinInscriptionEvennement is NULL");
			req.setParameter("x",idEnf);
			
			return req.getResultList();
		}

		@Override
		public List<ClasseEquipeEducatif> ListClasseActifsEquEducatif(Long idEqEducatif) {
			Query req = em.createQuery("select clEqEdu from ClasseEquipeEducatif clEqEdu where clEqEdu.id.equipeEducatif.idPerson=:x and  clEqEdu.dateFinEnseignementClas is NULL");
			req.setParameter("x",idEqEducatif);
			
			return req.getResultList();
		}

		@Override
		public List<CategorieClubEquipeEducatif> ListCategorieClubActifsEquipeEducatif(Long idEqEduc) {
			Query req = em.createQuery("select clEqEdu from CategorieClubEquipeEducatif clEqEdu where clEqEdu.id.equipeEducatif.idPerson=:x and  clEqEdu.dateFinAnimateCateg is NULL");
			req.setParameter("x",idEqEduc);
			
			return req.getResultList();
		}

		@Override
		public Payment ajouterPayment(Payment p) {
			em.persist(p);
			return p ;
		}

		@Override
		public void modifierPayment(Payment p) {
			em.merge(p);
		}

		@Override
		public List<Payment> listPaymentEnfant(Long idEnf) {
			Query req = em.createQuery("select p from Payment p where p.id.enfant.idPerson=:x");
			req.setParameter("x", idEnf);
			return req.getResultList();
		}

		@Override
		public HistoriquePlaning ajouterPlanningHistor(HistoriquePlaning h,
				Long idPla) {
			
				PlanningHorraires pl = getPlanningHorraires(idPla);
				h.setPlaning(pl);
				em.persist(h);
				
				return h;
		}

		@Override
		public List<HistoriquePlaning> listPlanningHistor(Long idPla) {
			// TODO Auto-generated method stub
			Query req = em.createQuery("select h from HistoriquePlaning h where h.planing.idPlanningH=:x");
			req.setParameter("x",idPla);
			return  req.getResultList();
		}

		@Override
		public HistoriquePlaning countPlaning(Long idPla) {
			Query req = em.createQuery("select h from HistoriquePlaning h where h.planing.idPlanningH=:x and h.dateFin=null");
			req.setParameter("x",idPla);
			
			
			return (HistoriquePlaning) req.getSingleResult();
		}

		@Override
		public void modifierHistoriquePl(HistoriquePlaning h) {
			em.merge(h);
			
		}

		@Override
		public HistoriqueClub ajouterClubHistor(HistoriqueClub h, Long idClub) {
			Club cl = getClubs(idClub);
			h.setClub(cl);
			em.persist(h);
			return h;
		}

		@Override
		public List<HistoriqueClub> listClubHistor(Long idClub) {
			Query req = em.createQuery("select h from HistoriqueClub h where h.club.idClub=:x");
			req.setParameter("x",idClub);
			return  req.getResultList();
		}

		@Override
		public HistoriqueClub countClub(Long idClub) {
			Query req = em.createQuery("select h from HistoriqueClub h where h.club.idClub=:x and h.dateFin=null");
			req.setParameter("x",idClub);
			return (HistoriqueClub) req.getSingleResult();
		}

		@Override
		public void modifierHistoriqueCl(HistoriqueClub h) {
			em.merge(h);
			
		}

		@Override
		public Payment ajouterPayment(Payment p, Long idEnfant, String moisPayment) {
			
			if ( idEnfant != null) {
				Enfant en= em.find(Enfant.class, idEnfant);
				
				
				p.setMoisPayment(moisPayment);
				
				p.setEnfant(en);
				
       	       
			}
			em.persist(p);
			return p;
		}

		@Override
		public List<Payment> listPayments() {

			Query req = em.createQuery("select p from Payment p");
			return req.getResultList();
		}
		
		

		@Override
		public Payment getPayementMoisCourant(Long idEnfant, String moisPayment) {

			Enfant en=em.find(Enfant.class, idEnfant);	
			
			
			PaymentId paymentId = new PaymentId();
			
			
			paymentId.setMoisPayment(moisPayment);
			paymentId.setEnfant(en);
			
			
			System.out.print(paymentId.getEnfant().getNom());

          return em.find(Payment.class, paymentId);
		}

		@Override
		public Creche ajouterCreche(Creche creche, String annee) {
			
			
				
				
				
				creche.setAnnee(annee);
				
       	       
			
			em.persist(creche);
			return creche;
		}

		@Override
		public Creche getCreche(String annee) {

			
			
			CrecheId crecheId = new CrecheId();
			
			
			
			crecheId.setAnnee(annee);
			
			
		

          return em.find(Creche.class, crecheId);
		}

		@Override
		public List<Creche> listCreches() {
			Query req=em.createQuery("select cr from Creche cr");
			
			 return req.getResultList();
		}
		
		
		
		////////////////////////////////////////////mouch kol

		@Override
		public Payment getPaymentAnnuelle(Long idEnf,String annee,String naturePaiement) {
		
			Query req = em.createQuery("select payAnn from Payment payAnn where payAnn.id.enfant.idPerson=:x and payAnn.id.moisPayment like :y and  payAnn.naturePayement like :z");
			req.setParameter("x",idEnf);
			req.setParameter("y","%"+annee+"%");
			req.setParameter("z","%"+naturePaiement+"%");
			
			return (Payment)req.getSingleResult();
			
			
			
		

		}

		@Override
		public Inscription getInscriAnnuelle(Long idEnf, Long idClass,String annee) {
			
			Query req = em.createQuery("select ins from Inscription ins where ins.id.enfant.idPerson=:x and ins.id.classe.idClasse=:y and  ins.annee like :z");
			req.setParameter("x",idEnf);
			req.setParameter("y",idClass);
			req.setParameter("z","%"+annee+"%");
			
			return (Inscription)req.getSingleResult();
			
		}

		@Override
		public Payment getPaymentMensuel(Long idEnf, String anneeMois,String naturePaiement) {
			
			Query req = em.createQuery("select payAnn from Payment payAnn where payAnn.id.enfant.idPerson=:x and payAnn.id.moisPayment like :y and  payAnn.naturePayement like :z");
			req.setParameter("x",idEnf);
			req.setParameter("y","%"+anneeMois+"%");
			req.setParameter("z","%"+naturePaiement+"%");
			
			return (Payment)req.getSingleResult();
		}

		@Override
		public List<ClubEnfant> ListClubEnfantParAnnee(Long idEnf, Date dateClub) {
			
			Query req = em.createQuery("select clEnf from ClubEnfant clEnf where clEnf.id.enfant.idPerson=:x and  clEnf.dateFinInscriClub is NULL and clEnf.id.dateDebutInscriClub like :y");
			req.setParameter("x",idEnf);
			req.setParameter("y","%"+dateClub+"%");
			
			return req.getResultList();
		}

		@Override
		public List<ClubEnfant> ListEnfantsActifsClubs(Long idClub) {
			
			Query req = em.createQuery("select clEnf from ClubEnfant clEnf where clEnf.id.club.idClub=:x and  clEnf.dateFinInscriClub is NULL");
			req.setParameter("x",idClub);
			
			return req.getResultList();
		}

		@Override
		public List<PlanningEnfant> ListEnfantsActifsPlannings(Long idPlannings) {
			
			Query req = em.createQuery("select plan from PlanningEnfant plan where plan.id.planningHorraires.idPlanningH=:x and  plan.dateFinInscriFinPlanning is NULL");
			req.setParameter("x",idPlannings);
			
			return req.getResultList();
	
}

		@Override
		public List<Inscription> listInscriptionsParClassAnne(Long idClass) {
		
			Query req = em.createQuery("select ins from Inscription ins where ins.id.classe.idClasse=:x");
			req.setParameter("x",idClass);
			
			return req.getResultList();
		}

		@Override
		public List<PlanningEnfant> EnfantParPlanning(Long idPlanning) {
			
			
				Query req = em
						.createQuery("select enf from PlanningEnfant enf where enf.id.planningHorraires.idPlanningH=:x");
				req.setParameter("x", idPlanning);
				return req.getResultList();
				
				

			}

		@Override
		public List<EvennementEnfant> EnfantParEvennement(Long idEvenne) {
			
			Query req = em
					.createQuery("select enf from EvennementEnfant enf where enf.id.evenement.idEvenement=:x");
			req.setParameter("x", idEvenne);
			return req.getResultList();

		}

		@Override
		public Consultation getConsultationEnfDate(Long idEnf, String date) {
			
			Query req = em.createQuery("select cons from Consultation cons where cons.id.enfant.idPerson=:x and cons.id.date=:y");
			req.setParameter("x",idEnf);
			req.setParameter("y",date);
			
			return (Consultation)req.getSingleResult();
		}
		
		
		}
	
	

	
	

