package org.gestion.cr.metier;

import java.util.Date;
import java.util.List;

import org.gestion.cr.dao.ICrecheDAO;
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
import org.springframework.transaction.annotation.Transactional;

@Transactional

public class CrecheMetierImpl implements IAdminMetier

{

	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	private ICrecheDAO dao;
	
	
	public void setDao(ICrecheDAO dao) 
	{
		this.dao = dao;
	}


	@Override
	public CategorieClub getCategorieClub(Long idCategorieClub) {
	
		return dao.getCategorieClub(idCategorieClub);
	}

	@Override
	public long getNombreCategorieClubs() {
		
		return dao.getNombreCategorieClubs();
	}

	@Override
	public List<CategorieClub> listCategorieClubs() {
		
		return dao.listCategorieClubs();
	}

	@Override
	public List<CategorieClub> listCategorieClubs(int position,
			int nbrCategorieClubs) {
	
		return dao.listCategorieClubs(position, nbrCategorieClubs);
	}

	@Override
	public List<Club> clubsParNom(String nomClub) {
		
		return dao.clubsParNom(nomClub);
	}

	@Override
	public Club getClubs(Long idClubs) {
		
		return dao.getClubs(idClubs);
	}

	@Override
	public long getNombreClubs() {
	
		return dao.getNombreClubs();
	}

	@Override
	public List<Club> listClubs() {
		
		return dao.listClubs();
	}

	@Override
	public List<Club> listClubs(int position, int nbrClubs) {
		
		return dao.listClubs();
	}

	@Override
	public PlanningHorraires getPlanningHorraires(Long idPlanningHorraires) {
		
		return dao.getPlanningHorraires(idPlanningHorraires);
	}

	@Override
	public long getNombrePlanningHorraires() {
		
		return dao.getNombrePlanningHorraires();
	}

	@Override
	public List<PlanningHorraires> listPlanningHorraires() {
	
		return dao.listPlanningHorraires();
	}

	@Override
	public List<PlanningHorraires> listPlanningHorraires(int position,
			int nbrPlanningHorraires) {
	
		return dao.listPlanningHorraires(position, nbrPlanningHorraires);
	}

	/*@Override
	public List<Creche> crecheParNom(String nomCreche) {
		
		return dao.crecheParNom(nomCreche);
	}

	@Override
	public Creche getCreche(Long idCreche) {
		
		return dao.getCreche(idCreche);
	}

	@Override
	public long getNombreCreches() {
		
		return dao.getNombreCreches();
	}

	@Override
	public List<Creche> listCreches() {
		
		return dao.listCreches();
	}

	@Override
	public List<Creche> listCreches(int position, int nbrCreches) {
		
		return dao.listCreches(position, nbrCreches);
	}*/

	@Override
	public Classe getClasse(Long idClasse) {
		
		return dao.getClasse(idClasse);
	}



	@Override
	public long getNombreClasses() {
		
		return dao.getNombreClasses();
	}

	@Override
	public List<Classe> listClasse() {
		
		return dao.listClasse();
	}

	@Override
	public List<Classe> listClasse(int position, int nbrClasses) {
		
		return dao.listClasse(position, nbrClasses);
	}

	@Override
	public List<Enfant> getEnfantsByClasse(Long idClasse) {
		
		return dao.getEnfantsByClasse(idClasse);
	}

	@Override
	public List<EquipeSanitaire> equipeSanitaireParNom(String nom) {
	
		return dao.equipeSanitaireParNom(nom);
	}

	@Override
	public List<EquipeSanitaire> equipeSanitaireParFonction(Long idFonction) {
		
		return dao.equipeSanitaireParFonction(idFonction);
	}

	@Override
	public EquipeSanitaire getEquipeSanitaire(Long idEquipeSanitaire) {
		
		return dao.getEquipeSanitaire(idEquipeSanitaire);
	}

	@Override
	public long getNombreEquipesSan() {
		
		return dao.getNombreEquipesSan();
	}

	@Override
	public List<EquipeSanitaire> listEquipeSanitaires() {
		
		return dao.listEquipeSanitaires();
	}

	@Override
	public List<EquipeSanitaire> listEquipeSanitaires(int position,
			int nbrEquipesSan) {
		
		return dao.listEquipeSanitaires(position, nbrEquipesSan);
	}

	@Override
	public EquipeEducatif getEquipeEducatif(Long idEquipeEducatif) {
	
		return dao.getEquipeEducatif(idEquipeEducatif);
	}

	@Override
	public List<EquipeEducatif> equipeEducatifParNom(String nom) {
		
		return dao.equipeEducatifParNom(nom);
	}

	@Override
	public List<EquipeEducatif> equipeEducatifParFonction(Long idFonction) {
		
		return dao.equipeEducatifParFonction(idFonction);
	}

	@Override
	public long getNombreEquipesEdu() {
		
		return dao.getNombreEquipesEdu();
	}

	@Override
	public List<EquipeEducatif> listEquipeEducatif() {
		
		return dao.listEquipeEducatif();
	}

	@Override
	public List<EquipeEducatif> listEquipeEducatif(int position,
			int nbrEquipesEdu) {
		
		return dao.listEquipeEducatif(position, nbrEquipesEdu);
	}

	@Override
	public Fonction getFonction(Long idFonction) {
		
		return dao.getFonction(idFonction);
	}

	@Override
	public long getNombreFonctions() {
		
		return dao.getNombreFonctions();
	}

	@Override
	public List<Fonction> listFonctions() {
		
		return dao.listFonctions();
	}

	@Override
	public List<Fonction> listFonctions(int position, int nbrFonctions) {
	
		return dao.listFonctions(position, nbrFonctions);
	}

	@Override
	public List<Accompagnateur> accompagnateurParNom(String nom) {
		
		return dao.accompagnateurParNom(nom);
	}

	@Override
	public Accompagnateur getAccompagnateur(Long idAccompagnateur) {
		
		return dao.getAccompagnateur(idAccompagnateur);
	}

	@Override
	public long getNombreAccompagnateurs() {
		
		return dao.getNombreAccompagnateurs();
	}

	@Override
	public List<Accompagnateur> listAccompagnateurs() {
		
		return dao.listAccompagnateurs();
	}

	@Override
	public List<Accompagnateur> listAccompagnateurs(int position,
			int nbrAccompagnateurs) {
		
		return dao.listAccompagnateurs(position, nbrAccompagnateurs);
	}

	@Override
	public List<Enfant> getEnfantsByAccompagnateur(Long idAccompagnateur) {
		
		return dao.getEnfantsByAccompagnateur(idAccompagnateur);
	}

	@Override
	public Inscription getInscription(Long idEnf, Long idClas, String d) {
		
		return dao.getInscription(idEnf, idClas, d);
	}

	@Override
	public Long getInscriptionEnf(Long idEnf, String annee) {
		
		return dao.getInscriptionEnf(idEnf, annee);
	}

	@Override
	public long getNombreInscriptions() {
		
		return getNombreInscriptions();
	}

	@Override
	public List<Inscription> listInscriptions() {
		
		return dao.listInscriptions();
	}

	@Override
	public List<Inscription> listInscriptions(int position, int nbrInscriptions) {
		
		return dao.listInscriptions(position, nbrInscriptions);
	}

	@Override
	public Consultation getConsulation(Long idEnf, Long idEqSan, String d) {
		
		return dao.getConsulation(idEnf, idEqSan, d);
	}

	@Override
	public long getNombreConsultations() {
	
		return dao.getNombreConsultations();
	}

	@Override
	public List<Consultation> listConsultations() {
		
		return dao.listConsultations();
	}

	@Override
	public List<Consultation> listConsultations(int position,
			int nbrConsultations) {
		
		return dao.listConsultations();
	}

	@Override
	public List<Parent> parentParNom(String nomParent) {
		
		return dao.parentParNom(nomParent);
	}

	@Override
	public Parent getParent(Long idParent) {
	
		return dao.getParent(idParent);
	}

	@Override
	public Parent getParentbycin(String cin) {
		
		return dao.getParentbycin(cin);
	}

	/*@Override
	public List<Parent> listPere(String genre) {
		
		return dao.listPere(genre);
	}
*/
	/*@Override
	public List<Parent> listMere(String genre) {
	
		return dao.listMere(genre);
	}*/

	@Override
	public List<Parent> listParents(int position, int nbrParents) {
		
		return dao.listParents();
	}

	@Override
	public List<Parent> listParents() {
		
		return dao.listParents();
	}

	@Override
	public long getNombreParents() {
		
		return dao.getNombreParents();
	}

	@Override
	public List<Enfant> getEnfantByParent(Long idParent) {
		
		return dao.getEnfantByParent(idParent);
	}

	@Override
	public void ajouterEnfantsPourParent(Long idEnfant, Long idParent) {
		
		dao.ajouterEnfantsPourParent(idEnfant, idParent);
		
	}

	@Override
	public List<Evenement> evennementParNom(String nom) {
		
		return dao.evennementParNom(nom);
	}

	@Override
	public Evenement getEvennement(Long idEvennement) {
		
		return dao.getEvennement(idEvennement);
	}

	@Override
	public long getNombreEvennements() {
	
		return dao.getNombreEvennements();
	}

	@Override
	public List<Evenement> listEvennements() {
		
		return dao.listEvennements();
	}

	@Override
	public List<Evenement> listEvennements(int position, int nbrEvennements) {
		
		return dao.listEvennements(position, nbrEvennements);
	}

	@Override
	public List<Enfant> getEnfantsByEvennement(Long idEvennement) {
		
		return dao.getEnfantsByEvennement(idEvennement);
	}

	@Override
	public List<Enfant> enfantParNom(String nom) {
		
		return dao.enfantParNom(nom);
	}

	@Override
	public Enfant getEnfant(Long idEnfant) {
		
		return dao.getEnfant(idEnfant);
	}

	@Override
	public List<Enfant> enfantCertife() {
		
		return dao.enfantCertife();
	}

	@Override
	public List<Enfant> enfantPhotoAutorise() {
		
		return dao.enfantPhotoAutorise();
	}

	@Override
	public List<Enfant> EnfantParMotCle(String mc) {
	
		return dao.EnfantParMotCle(mc);
	}

	@Override
	public List<Enfant> EnfantParParent(Long idPar) {
		
		return dao.EnfantParParent(idPar);
	}

	@Override
	public List<Inscription> EnfantParClasse(Long idClas) {
		
		return dao.EnfantParClasse(idClas);
	}

	@Override
	public List<ClubEnfant> EnfantParClub(Long idClub) {
		
		return dao.EnfantParClub(idClub);
	}

	@Override
	public List<Enfant> EnfantParEvenement(Long idEve) {
		
		return dao.EnfantParEvenement(idEve);
	}

	@Override
	public List<Enfant> EnfantParAccompagnaeurt(Long idAcc) {
		
		return dao.EnfantParAccompagnaeurt(idAcc);
	}

	

	@Override
	public List<Enfant> EnfantSelectionnes() {
	
		return dao.EnfantSelectionnes();
	}

	@Override
	public List<Accompagnateur> getAccompagnateursByEnfant(Long idEnfant) {
		
		return dao.getAccompagnateursByEnfant(idEnfant);
	}

	@Override
	public List<Evenement> getEvennementsByEnfant(Long idEnfant) {
		
		return dao.getEvennementsByEnfant(idEnfant);
	}

	@Override
	public List<Parent> getParentsByEnfant(Long idEnfant) {
		
		return dao.getParentsByEnfant(idEnfant);
	}

	@Override
	public List<Enfant> listEnfants(int position, int nbrEnfants) {
		
		return dao.listEnfants(position, nbrEnfants);
	}

	@Override
	public List<Enfant> listEnfants() {
		
		return dao.listEnfants();
	}

	@Override
	public long getNombreEnfants() {
		
		return dao.getNombreEnfants();
	}

	@Override
	public List<Fournisseur> fournisseurParNom(String nom) {
	
		return dao.fournisseurParNom(nom);
	}

	@Override
	public Fournisseur getFournisseur(Long idFournisseur) {
		
		return dao.getFournisseur(idFournisseur);
	}

	@Override
	public List<Materiel> getMaterielsByFournisseur(Long idFournisseur) {
		
		return dao.getMaterielsByFournisseur(idFournisseur);
	}

	@Override
	public long getNombreFournisseurs() {
		
		return dao.getNombreFournisseurs();
	}

	@Override
	public List<Fournisseur> listFournisseurs() {
		
		return dao.listFournisseurs();
	}

	@Override
	public List<Fournisseur> listFournisseurs(int position, int nbrFournisseurs) {
		
		return dao.listFournisseurs(position, nbrFournisseurs);
	}

	@Override
	public List<Materiel> materielsParDesignation(String designation) {
		
		return dao.materielsParDesignation(designation);
	}

	@Override
	public Materiel getMateriels(Long idMateriels) {
		
		return dao.getMateriels(idMateriels);
	}

	@Override
	public List<Equipe> getEquipeByMateriels(Long idMateriels) {
		
		return dao.getEquipeByMateriels(idMateriels);
	}

	@Override
	public long getNombreMateriels() {
	
		return dao.getNombreMateriels();
	}

	@Override
	public List<Materiel> listMateriels() {
		
		return dao.listMateriels();
	}

	@Override
	public List<Materiel> listMateriels(int position, int nbrMateriels) {
	
		return dao.listMateriels(position, nbrMateriels);
	}

	@Override
	public TypeMateriels getTypeMateriels(Long idTypeMateriels) {
		
		return dao.getTypeMateriels(idTypeMateriels);
	}

	@Override
	public long getNombreTypesMateriels() {
		
		return dao.getNombreTypesMateriels();
	}

	@Override
	public List<TypeMateriels> listTypeMateriels() {
		
		return dao.listTypeMateriels();
	}

	@Override
	public List<TypeMateriels> listTypeMateriels(int position,
			int nbrTypesMateriels) {
		
		return dao.listTypeMateriels(position, nbrTypesMateriels);
	}

	@Override
	public Stock getStock(Long idStock) {
	
		return dao.getStock(idStock);
	}

	@Override
	public long getNombreStocks() {
		
		return dao.getNombreStocks();
	}

	@Override
	public List<Stock> listStock() {
	
		return dao.listStock();
	}

	@Override
	public List<Stock> listStock(int position, int nbrStocks) {
	
		return dao.listStock(position, nbrStocks);
	}

	@Override
	public Long ajouterCategorieClub(CategorieClub categorieClub) {
		
		return dao.ajouterCategorieClub(categorieClub);
	}

	@Override
	public void supprimerCategorieClub(Long idCategorieClub) {
		dao.supprimerCategorieClub(idCategorieClub);
		
	}

	@Override
	public void modifierCategorieClub(CategorieClub categorieClub) {
		dao.modifierCategorieClub(categorieClub);
		
	}

	@Override
	public Long ajouterClubs(Club club, Long idCtagorieClubs) {
		
		return dao.ajouterClubs(club, idCtagorieClubs);
	}

	@Override
	public void supprimerClubs(Long idClubs) {
		
		dao.supprimerClubs(idClubs);
		
	}

	@Override
	public void modifierClubs(Club clubs) {
		dao.modifierClubs(clubs);
		
	}

	@Override
	public Long ajouterPlanningHorraires(PlanningHorraires planningHorraires) {
		
		return dao.ajouterPlanningHorraires(planningHorraires);
	}

	@Override
	public void supprimerPlanningHorraires(Long idPlanningHorraires) {
		
		dao.supprimerPlanningHorraires(idPlanningHorraires);
		
	}

	@Override
	public void modifierPlanningHorraires(PlanningHorraires planningHorraires) {
		
		dao.modifierPlanningHorraires(planningHorraires);
		
	}

/*	@Override
	public Long ajouterCreche(Creche creche) {
		
		return dao.ajouterCreche(creche);
	}

	@Override
	public void supprimerCreche(Long idCreche) {
	
		dao.supprimerCreche(idCreche);
		
	}

	@Override
	public void modifierCreche(Creche creche) {
		
		dao.modifierCreche(creche);
		
	}*/

	@Override
	public Long ajouterClasse(Classe classe) {
		
		return dao.ajouterClasse(classe);
	}

	@Override
	public void supprimerClasse(Long idClasse) {
		
		dao.supprimerClasse(idClasse);
		
	}

	@Override
	public void modifierClasse(Classe classe) {
		
		dao.modifierClasse(classe);
		
	}

	@Override
	public Long ajouterEquipeSanitaire(EquipeSanitaire equipeSanitaire,
			Long idFonction) {
		
		return dao.ajouterEquipeSanitaire(equipeSanitaire, idFonction);
	}

	@Override
	public void supprimerEquipeSanitaire(Long idEquipeSanitaire) {
	
		dao.supprimerEquipeSanitaire(idEquipeSanitaire);
		
	}

	@Override
	public void modifierEquipeSanitaire(EquipeSanitaire equipeSanitaire) {
	
		dao.modifierEquipeSanitaire(equipeSanitaire);
		
	}

	@Override
	public Long ajouterEquipeEducatif(EquipeEducatif equipeEducatif,
			Long idFonction) {
		
		return dao.ajouterEquipeEducatif(equipeEducatif, idFonction);
	}

	@Override
	public void supprimerEquipeEducatif(Long idEquipeEducatif) {
	
		dao.supprimerEquipeEducatif(idEquipeEducatif);
		
	}

	@Override
	public void modifierEquipeEducatif(EquipeEducatif equipeEducatif) {
		
		dao.modifierEquipeEducatif(equipeEducatif);
		
	}

	@Override
	public Long ajouterFonction(Fonction fonction) {
		
		return dao.ajouterFonction(fonction);
	}

	@Override
	public void supprimerFonction(Long idFonction) {
		
		dao.supprimerFonction(idFonction);
		
	}

	@Override
	public void modifierFonction(Fonction fonction) {
		
		dao.modifierFonction(fonction);
		
	}

	@Override
	public Long ajouterAccompagnateur(Accompagnateur accompagnateur) {
		
		return dao.ajouterAccompagnateur(accompagnateur);
	}

	@Override
	public void supprimerAccompagnateurs(Long idAccompagnateur) {
		
		dao.supprimerAccompagnateurs(idAccompagnateur);
		
	}

	@Override
	public void modifierAccompagnateurs(Accompagnateur accompagnateur) {
	
		dao.modifierAccompagnateurs(accompagnateur);
	}

	@Override
	public void ajouterEnfantsPourAccompagnateur(Long idEnfant,
			Long idAccompagnateur) {
		
		dao.ajouterEnfantsPourAccompagnateur(idEnfant, idAccompagnateur);
		
	}

	
	@Override
	public void supprimerInscription(Long idEnf, Long idClas, String d) {
		
		dao.supprimerInscription(idEnf, idClas, d);
		
	}

	@Override
	public void modifierInscription(Inscription i) {
		
		dao.modifierInscription(i);
	}

	

	@Override
	public void supprimerConsultation(Long idEnf, Long idEqSan, String d) {
		
		dao.supprimerConsultation(idEnf, idEqSan, d);
		
	}

	@Override
	public void modifierConsultation(Consultation c) {
		
		dao.modifierConsultation(c);
		
	}

	@Override
	public Long ajouterParent(Parent parent) {
		
		return dao.ajouterParent(parent);
	}

	@Override
	public void supprimerParent(Long idParent) {
		
		dao.supprimerParent(idParent);
		
	}

	@Override
	public void modifierParent(Parent parent) {
		
		dao.modifierParent(parent);
		
	}

	@Override
	public Long ajouterEvennement(Evenement evennement) {
	
		return dao.ajouterEvennement(evennement);
	}

	@Override
	public void supprimerEvennements(Long idEvennement) {
		
		dao.supprimerEvennements(idEvennement);
		
	}

	@Override
	public void modifierEvennements(Evenement evennement) {
		
		dao.modifierEvennements(evennement);
		
	}

	
	@Override
	public Long ajouterEnfant(Enfant enfant) {
		
		return dao.ajouterEnfant(enfant);
	}

	@Override
	public void supprimerEnfant(Long idEnfant) {
		
		dao.supprimerEnfant(idEnfant);
		
	}

	@Override
	public void modifierEnfant(Enfant enfant) {
		
		dao.modifierEnfant(enfant);
		
	}

	@Override
	public void ajouterAccompagnateursPourEnfant(Long idAccompagnateur,
			Long idEnfant) {
		
		dao.ajouterAccompagnateursPourEnfant(idAccompagnateur, idEnfant);
		
	}

	

	@Override
	public void ajouterParentsPourEnfant(Long idParent, Long idEnfant) {
		
		dao.ajouterParentsPourEnfant(idParent, idEnfant);
		
	}

	@Override
	public Long nbrEnfantClasse(Long idCla) {
	
		return dao.nbrEnfantClasse(idCla);
	}

	@Override
	public void ajouterEnfantToParent(Long idEnf, Long idPar) {
	
		dao.ajouterEnfantToParent(idEnf, idPar);
		
	}

	
	
	@Override
	public void ajouterEnfantToAccompagnteur(Long idEnf, Long idAcc) {
	
		dao.ajouterEnfantToAccompagnteur(idEnf, idAcc);
		
	}

	

	@Override
	public void ajouterFournisseurToMateriel(Long idFour, Long idMat) {
		
		dao.ajouterFournisseurToMateriel(idFour, idMat);
		
	}

	@Override
	public Long ajouterFournisseur(Fournisseur fournisseur) {
		
		return dao.ajouterFournisseur(fournisseur);
	}

	@Override
	public void supprimerFournisseur(Long idFournisseur) {
		
		dao.supprimerFournisseur(idFournisseur);
		
	}

	@Override
	public void modifierFournisseur(Fournisseur fournisseur) {
		
		dao.modifierFournisseur(fournisseur);
		
	}

	@Override
	public Long ajouterMateriels(Materiel materiels, Long idTypeMateriels,
			Long idStock) {
		
		return dao.ajouterMateriels(materiels, idTypeMateriels, idStock);
	}

	@Override
	public void supprimerMateriels(Long idMateriels) {
	
		dao.supprimerMateriels(idMateriels);
		
	}

	@Override
	public void modifierMateriels(Materiel materiels) {
		
		dao.modifierMateriels(materiels);
		
	}

	@Override
	public Long ajouterTypeMateriel(TypeMateriels typeMateriels) {
		
		return dao.ajouterTypeMateriel(typeMateriels);
	}

	@Override
	public void supprimerTypeMateriels(Long idTypeMateriels) {
	
		dao.supprimerTypeMateriels(idTypeMateriels);
		
	}

	@Override
	public void modifierTypeMateriels(TypeMateriels typeMateriels) {
		
		dao.modifierTypeMateriels(typeMateriels);
		
	}

	@Override
	public Long ajouterStock(Stock stock) {
		
		return dao.ajouterStock(stock);
	}

	@Override
	public void supprimerStock(Long idStock) {
	
		dao.supprimerStock(idStock);
		
	}

	@Override
	public void modifierStock(Stock stock) {
		
		dao.modifierStock(stock);
		
	}


	@Override
	public List<MatrielUtiliser> listMatrielUtiliser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MatrielUtiliser getMatrielUtiliser(Long idMat, 
			Long idEqTech, Date d) {
		
		return dao.getMatrielUtiliser(idMat,  idEqTech, d);
	}



	@Override
	public MatrielUtiliser ajouterMatrielUtiliser(MatrielUtiliser m,
			Long idMat,  Long idEqTech, Date d) {
		
		return dao.ajouterMatrielUtiliser(m, idMat, idEqTech, d);
	}

	@Override
	public void supprimerMatrielUtiliser(Long idMat ,Long idEqTech,Date d){
		
		dao.supprimerMatrielUtiliser(idMat,idEqTech, d);
		
	}

	@Override
	public void modifierMatrielUtiliser(MatrielUtiliser m) {
		
		dao.modifierMatrielUtiliser(m);
		
		
	}

	@Override
	public List<MatrielSanitaUtiliser> listMatrielSanitaireUtiliser() {
		
		return dao.listMatrielSanitaireUtiliser();
	}

	@Override
	public MatrielSanitaUtiliser getMatrielSanitaireUtiliser(Long idMat,
			Long idSani, Date d) {
		
		return dao.getMatrielSanitaireUtiliser(idMat, idSani, d);
	}

	@Override
	public MatrielSanitaUtiliser ajouterMatrielSanitaireUtiliser(
			MatrielSanitaUtiliser m, Long idMat, Long idSani, Date d) {
		
		return dao.ajouterMatrielSanitaireUtiliser(m, idMat, idSani, d);
	}

	@Override
	public void supprimerMatrielSanitaireUtiliser(Long idMat, Long idEqSani,
			Date d) {
		
		dao.supprimerMatrielSanitaireUtiliser(idMat, idEqSani, d);
		
	}

	@Override
	public void modifierMatrielSanitaireUtiliser(MatrielSanitaUtiliser me) {
		dao.modifierMatrielSanitaireUtiliser(me);
		
	}


	

	@Override
	public PlanningEnfant getPlanningEnfant(Long idEnf, Long idPlan,Date dateDebutInscription) {
	
		return dao.getPlanningEnfant(idEnf, idPlan, dateDebutInscription);
	}


	@Override
	public List<EvennementEnfant> listEvennementEnfant() {
		 return dao.listEvennementEnfant();
	}


	
	@Override
	public ClubEnfant ajouterEnfantClub(ClubEnfant m, Long idClub, Long idEnf,Date dateDebutInscription) {
		
		return dao.ajouterEnfantClub(m, idClub, idEnf, dateDebutInscription);
	}


	@Override
	public void supprimerEnfantClub(Long idClub, Long idEnf,Date dateDebutInscription) {
	
		dao.supprimerEnfantClub(idClub, idEnf, dateDebutInscription );
		
	}


	@Override
	public void modifierEnfantClub(ClubEnfant me) {
	
		dao.modifierEnfantClub(me);
		
		
	}


	@Override
	public PlanningEnfant ajouterEnfantPlanning(PlanningEnfant m, Long idEnf,
			Long idPlan ,Date dateDebutInscription) {
	
		return dao.ajouterEnfantPlanning(m, idEnf, idPlan,dateDebutInscription);
	}


	@Override
	public void supprimerPlanningEnfant(Long idEnf,
			Long idPlan,Date dateDebutInscription) {
	
		dao.supprimerPlanningEnfant(idEnf, idPlan,dateDebutInscription);
		
	}


	@Override
	public void modifierPlanningEnfant(PlanningEnfant me) {
		
		
		dao.modifierPlanningEnfant(me);
		
	}


	


	@Override
	public void modifierEvennementEnfant(EvennementEnfant me) {
	
		dao.modifierEvennementEnfant(me);
		
		
	}


	@Override
	public List<ClubEnfant> listEnfantClub() {
		
		return dao.listEnfantClub();
	}


	@Override
	public ClubEnfant getEnfantClub(Long idClub, Long idEnf,Date dateDebutInscription) {
		
		return dao.getEnfantClub(idClub, idEnf,dateDebutInscription);
	}


	@Override
	public List<PlanningEnfant> listPlanningEnfant() {
		
		return dao.listPlanningEnfant();
	}


	@Override
	public Inscription ajouterInscription(Inscription i, Long idEnf, Long idClas) {
		
	 return	dao.ajouterInscription(i, idEnf, idClas);
	}


	@Override
	public List<Parent> listParents2(int position, int nbrParents) {
		
		return dao.listParents2(position, nbrParents);
	}


	@Override
	public long getNombreParents2() {
		
		return dao.getNombreParents2();
	}


	@Override
	public Inscription getLastInscriptionEnfant(Long idEnf) {
		
		return dao.getLastInscriptionEnfant(idEnf);
	}


	@Override
	public List<ClubEnfant> ListClubActifsEnfant(Long idEnf) {
		
		return dao.ListClubActifsEnfant(idEnf);
	}


	@Override
	public Long getConsultationEnf(Long idEnf, String d) {
		
		return dao.getConsultationEnf(idEnf, d);
	}


	@Override
	public Consultation ajouterConsultation(Consultation c, Long idEnf,
			Long idEqSani) {
		
		return dao.ajouterConsultation(c, idEnf, idEqSani);
	}


	@Override
	public EvennementEnfant getEvennementEnfant(Long idEnf, Long idEvene, Date a) {
		
		return dao.getEvennementEnfant(idEnf, idEvene, a);
	}


	@Override
	public EvennementEnfant ajouterEvennementEnfant(EvennementEnfant m,
			Long idEnf, Long idEvene, Date a) {
		
		return dao.ajouterEvennementEnfant(m, idEnf, idEvene, a);
	}


	@Override
	public void supprimerEvennementEnfant(Long idEnf, Long idEvene, Date a) {
	dao.supprimerEvennementEnfant(idEnf, idEvene, a);
		
	}


	@Override
	public List<PlanningEnfant> ListPlanningActifsEnfant(Long idEnf) {
		
		return dao.ListPlanningActifsEnfant(idEnf);
	}

	/*

	@Override
	public List<EvennementEnfant> ListEvennementActifsEnfant(Long idEnf) {
		
		return dao.ListEvennementActifsEnfant(idEnf);
	}*/


	@Override
	public List<ClasseEquipeEducatif> listEquipeEducatifClasse() {
		
		return dao.listEquipeEducatifClasse();
	}


	


	/*
	@Override
	public List<ClasseEquipeEducatif> ListClasseActifsEquEducatif(
			Long idEqEducatif) {
		
		return dao.ListClasseActifsEquEducatif(idEqEducatif);
	}*/


	@Override
	public List<CategorieClubEquipeEducatif> listCategorieClubEquipeEducatif() {
		
		return dao.listCategorieClubEquipeEducatif();
	}




	/*
	@Override
	public List<CategorieClubEquipeEducatif> ListCategorieClubActifsEquipeEducatif(
			Long idEqEduc) {
	
		return dao.ListCategorieClubActifsEquipeEducatif(idEqEduc);
	}*/


	



	@Override
	public void modifierEquipeEducatifClasse(ClasseEquipeEducatif cl) {
		
		dao.modifierEquipeEducatifClasse(cl);
		
	}


	


	


	@Override
	public void modifierCategorieClubEquipeEducatif(
			CategorieClubEquipeEducatif cat) {
		
		dao.modifierCategorieClubEquipeEducatif(cat);
		
	}


	@Override
	public void ajouterFournisseurPourMateriel(Long idFournisseur,Long idMateriel) 
	{
		dao.ajouterFournisseurPourMateriel(idFournisseur, idMateriel);
		
		
	}


	@Override
	public void ajouterMaterielPourFournisseur(Long idMateriel,Long idFournisseur) {
		
		dao.ajouterMaterielPourFournisseur(idMateriel, idFournisseur);
		
		
	}




	@Override
	public List<EvennementEnfant> ListEvennementActifsEnfant(Long idEnf) {
		
		return dao.ListEvennementActifsEnfant(idEnf);
	}


	@Override
	public ClasseEquipeEducatif getEquipeEducatifClasse(Long idClass,
			Long idEquipEducatif, Date dateDebutInscrClass) {
		
		return dao.getEquipeEducatifClasse(idClass, idEquipEducatif, dateDebutInscrClass);
	}


	@Override
	public List<ClasseEquipeEducatif> ListClasseActifsEquEducatif(
			Long idEqEducatif) {
		
		return dao.ListClasseActifsEquEducatif(idEqEducatif);
	}


	@Override
	public CategorieClubEquipeEducatif getCategorieClubEquipeEducatif(
			Long idCateg, Long idEqEdu, Date dateDebutInscrClub) {
		
		return dao.getCategorieClubEquipeEducatif(idCateg, idEqEdu, dateDebutInscrClub);
	}


	@Override
	public List<CategorieClubEquipeEducatif> ListCategorieClubActifsEquipeEducatif(
			Long idEqEduc) {
		
		return dao.ListCategorieClubActifsEquipeEducatif(idEqEduc);
	}


	@Override
	public ClasseEquipeEducatif ajouterEquipeEducatifClasse(
			ClasseEquipeEducatif m, Long idClass, Long idEquipeEducatif,
			Date dateDebutInscrClass) {
		
		return dao.ajouterEquipeEducatifClasse(m, idClass, idEquipeEducatif, dateDebutInscrClass);
	}


	@Override
	public void supprimerEquipeEducatifClasse(Long idClass,
			Long idEquipEducatif, Date dateDebutInscrClass) {
		dao.supprimerEquipeEducatifClasse(idClass, idEquipEducatif, dateDebutInscrClass);
		
	}


	@Override
	public CategorieClubEquipeEducatif ajouterCategorieClubEquipeEducatif(
			CategorieClubEquipeEducatif m, Long idCateg, Long idEquipeEducatif,
			Date dateDebutInscrClub) {
	
		return dao.ajouterCategorieClubEquipeEducatif(m, idCateg, idEquipeEducatif, dateDebutInscrClub);
	}


	@Override
	public void supprimerCategorieClubEquipeEducatif(Long idCateg,
			Long idEquipeEducatif, Date dateDebutInscrClubString) {
		
		dao.supprimerCategorieClubEquipeEducatif(idCateg, idEquipeEducatif, dateDebutInscrClubString);
		
		
	}


	@Override
	public List<MatrielUtiliser> ListMaterielActifsEqEducatif(Long idEqEducatif) {
		
		return dao.ListMaterielActifsEqEducatif(idEqEducatif);
	}


	@Override
	public List<MatrielSanitaUtiliser> ListMaterielActifsEqSanitaire(
			Long idSanitaire) {
		
		return dao.ListMaterielActifsEqSanitaire(idSanitaire);
	}


	@Override
	public Inscription getInscriptionEnfAnnee(Long idEnf, String d) {
		
		return dao.getInscriptionEnfAnnee(idEnf, d);
	}


/*	@Override
	public Long ajouterPayment(Payment p) {
		
		return dao.ajouterPayment(p);
	}


	@Override
	public List<Payment> listPayments() {
		
		return dao.listPayments();
	}


	@Override
	public List<Payment> EnfantParPayment(Long idEnf) {
		
		return dao.EnfantParPayment(idEnf);
	}
*/

	@Override
	public HistoriquePlaning ajouterPlanningHistor(HistoriquePlaning h,
			Long idPla) {
		
		return dao.ajouterPlanningHistor(h, idPla);
	}


	@Override
	public List<HistoriquePlaning> listPlanningHistor(Long idPla) {
	
		return dao.listPlanningHistor(idPla);
	}


	@Override
	public HistoriquePlaning countPlaning(Long idPla) {
		
		return dao.countPlaning(idPla);
	}


	@Override
	public void modifierHistoriquePl(HistoriquePlaning h) {
		
		dao.modifierHistoriquePl(h);
		
	}


	@Override
	public HistoriqueClub ajouterClubHistor(HistoriqueClub h, Long idClub) {
		
		return dao.ajouterClubHistor(h, idClub);
	}


	@Override
	public List<HistoriqueClub> listClubHistor(Long idClub) {
		
		return dao.listClubHistor(idClub);
	}


	@Override
	public HistoriqueClub countClub(Long idClub) {
	
		return dao.countClub(idClub);
	}


	@Override
	public void modifierHistoriqueCl(HistoriqueClub h) {
		
		dao.modifierHistoriqueCl(h);
		
	}


	@Override
	public Payment ajouterPayment(Payment p, Long idEnfant, String moisPayment) {
		
		return dao.ajouterPayment(p, idEnfant, moisPayment);
	}


	@Override
	public List<Payment> listPayments() {
		
		return dao.listPayments();
	}


	@Override
	public Payment getPayementMoisCourant(Long idEnfant, String moisPayment) {
	
		return dao.getPayementMoisCourant(idEnfant, moisPayment);
	}


	@Override
	public Creche ajouterCreche(Creche creche, String annee) {
		
		return dao.ajouterCreche(creche, annee);
	}


	@Override
	public Creche getCreche(String annee) {
		
		return dao.getCreche(annee);
	}


	@Override
	public List<Creche> listCreches() {
		
		return dao.listCreches();
	}


	


	@Override
	public List<Payment> listPaymentEnfant(Long idEnf) {
		
		return dao.listPaymentEnfant(idEnf);
	}


	@Override
	public Payment ajouterPayment(Payment p) {
		
		return dao.ajouterPayment(p);
	}


	@Override
	public void modifierPayment(Payment p) {
		dao.modifierPayment(p);		
	}


	@Override
	public Payment getPaymentAnnuelle(Long idEnf, String annee,String naturePaiement) {
	
		return dao.getPaymentAnnuelle(idEnf, annee, naturePaiement);
	}


	@Override
	public Inscription getInscriAnnuelle(Long idEnf, Long idClass,String annee) {
		
		return dao.getInscriAnnuelle(idEnf, idClass, annee);
	}


	@Override
	public Payment getPaymentMensuel(Long idEnf, String anneeMois,String naturePaiement) 
	{
		
		return dao.getPaymentMensuel(idEnf, anneeMois,naturePaiement);
		
	}


	@Override
	public List<ClubEnfant> ListClubEnfantParAnnee(Long idEnf, Date dateClub) {
		
		return dao.ListClubEnfantParAnnee(idEnf, dateClub);
	}


	@Override
	public List<ClubEnfant> ListEnfantsActifsClubs(Long idClub) {
		
		return dao.ListEnfantsActifsClubs(idClub);
	}


	@Override
	public List<PlanningEnfant> ListEnfantsActifsPlannings(Long idPlannings) {
		
		return dao.ListEnfantsActifsPlannings(idPlannings);
	}


	@Override
	public List<Inscription> listInscriptionsParClassAnne(Long idClass) {
	
		return dao.listInscriptions();
	}


	@Override
	public List<PlanningEnfant> EnfantParPlanningH(Long idPlan) {
	
		return dao.EnfantParPlanning(idPlan);
	}


	@Override
	public List<EvennementEnfant> EnfantParEvennement(Long idEvenne) {
		
		return dao.EnfantParEvennement(idEvenne);
	}


	@Override
	public Consultation getConsultationEnfDate(Long idEnf, String date) {
		
		return dao.getConsultationEnfDate(idEnf, date);
	}


	



	
		
	}


	

	
	
