package org.gestion.cr.controllers;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.gestion.cr.entities.Classe;
import org.gestion.cr.entities.ClubEnfant;
import org.gestion.cr.entities.Consultation;
import org.gestion.cr.entities.EquipeSanitaire;
import org.gestion.cr.entities.EvennementEnfant;
import org.gestion.cr.entities.Inscription;
import org.gestion.cr.entities.PlanningEnfant;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/adminDetail")
public class DetailsEnfantsParAnnee
{

	/**
	 * 
	 * @author YOSRA
	 *
	 */
	@Autowired
	private IAdminMetier metier;
	
	@RequestMapping(value = "/detailEnfant")
	public String detailEnfant(Model model,Long idEnf) 
	{
		
		//avoir la liste des Clubs Actifs par annee
		
		
		
		model.addAttribute("enfant", metier.getEnfant(idEnf));
		
		List<ClubEnfant> listClubActifsEnfant = metier.ListClubActifsEnfant(idEnf);
		model.addAttribute("listClubActifsEnfant", listClubActifsEnfant);
		
		
		//avoir la liste des Plannings actifs par annee
		
		List<PlanningEnfant> listPlanningActifsEnfant = metier.ListPlanningActifsEnfant(idEnf);
		model.addAttribute("listPlanningActifsEnfant", listPlanningActifsEnfant);
		
		//avoir la liste des Parents
		
		
		//avoir la liste des accompagnateur
		
		
		
		//avoir l'inscription et la classe
		
		Date di = new Date();
		SimpleDateFormat dfi = new SimpleDateFormat("yyyy");
		String yearIns = dfi.format(di);	
		
		Inscription inscritAnnee = metier.getInscriptionEnfAnnee(idEnf, yearIns);
		Classe classeAnnee = inscritAnnee.getClasse();
		model.addAttribute("classeAnnee", classeAnnee);
		model.addAttribute("inscritAnnee", inscritAnnee);
		
		
		
		//avoir la liste des eevennements
		
		List<EvennementEnfant> listEvenementActifsEnfant = metier.ListEvennementActifsEnfant(idEnf);
		model.addAttribute("listEvenementActifsEnfant", listEvenementActifsEnfant);
		
		//avoir la liste des consultation et equipe sanitaire
		
		/*
		Date dfii = new Date();
		SimpleDateFormat dfiii = new SimpleDateFormat("yyyy-MM-dd");
		String jourCons = dfiii.format(dfii);	
		
		Consultation consjour = metier.getConsultationEnfDate(idEnf, jourCons);
		EquipeSanitaire equipeSanitaireJour = consjour.getEquipeSanitaire();
		model.addAttribute("equipeSanitaireJour", equipeSanitaireJour);
		model.addAttribute("consjour", consjour);*/
		
		
		//avoir la liste des paiements
		
		
		
		
		return "detailsEnfantsParAnnee";

	}

}
