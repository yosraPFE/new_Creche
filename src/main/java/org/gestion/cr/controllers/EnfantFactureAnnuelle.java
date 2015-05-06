package org.gestion.cr.controllers;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.gestion.cr.entities.Classe;
import org.gestion.cr.entities.ClubEnfant;
import org.gestion.cr.entities.Creche;
import org.gestion.cr.entities.Inscription;
import org.gestion.cr.entities.Payment;
import org.gestion.cr.entities.PlanningEnfant;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/factAnnuel")
public class EnfantFactureAnnuelle 
{
	@Autowired
	private IAdminMetier metier;
	
	
	@RequestMapping("/voirFacturAnnuel")
	public String voirFacturAnnuel(Model model, Long idEnf) 
	{
		/**
		 * 
		 * @author YOSRA
		 *
		 */
		
		
	
		
		//Avoir Tarif Inscription,Tarif Assurance et fraix mois de la table creche
		
		Date da = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		String year = df.format(da);		
		

		//la creche pour cette annee OK
		Creche crecheAnnee=metier.getCreche(year);
		
		
		//System.out.println("crecheAnnee : " + crecheAnnee.getAnnee());
		
		
		//avoir la liste des clubs actifs
		
		List<ClubEnfant> listClubActifsEnfant = metier.ListClubActifsEnfant(idEnf);
		
		//System.out.println("listClubActifsEnfant : " + listClubActifsEnfant.get(0).getClub().getNom());
		

		
		
		
		//avoir la liste des planning actifs
		
		List<PlanningEnfant> listPlanningActifsEnfant = metier.ListPlanningActifsEnfant(idEnf);
		//System.out.println("listPlanningActifsEnfant : " + listPlanningActifsEnfant.get(0).getPlanningHorraires().getTypePlanning());

		
		//avoir remise et prix total de la table paiement
		
		
		Date danee = new Date();
		SimpleDateFormat dform = new SimpleDateFormat("yyyy");
		String anneeFact = dform.format(danee);		
		
		
		String naturePaiement="annuel";
		
		//un seul payement annuel 
		Payment payementAnnuelle = metier.getPaymentAnnuelle(idEnf, anneeFact, naturePaiement);
		
	
		//System.out.println("payementAnnuelle : " + payementAnnuelle.getMoisPayment());
		
		
		
		//Information Inscription et classe par annee
		
		Date di = new Date();
		SimpleDateFormat dfi = new SimpleDateFormat("yyyy");
		String yearIns = dfi.format(di);	
		
		Inscription inscritAnnee = metier.getInscriptionEnfAnnee(idEnf, yearIns);
		Classe classeAnnee = inscritAnnee.getClasse();
		

		//remplissage Model
		
		model.addAttribute("enfant", metier.getEnfant(idEnf));
		model.addAttribute("crecheAnnee", crecheAnnee);
        model.addAttribute("listClubActifsEnfant", listClubActifsEnfant);
		model.addAttribute("listPlanningActifsEnfant", listPlanningActifsEnfant);
		model.addAttribute("payementAnnuelle", payementAnnuelle);
		model.addAttribute("classeAnnee", classeAnnee);
		model.addAttribute("inscritAnnee", inscritAnnee);
		
		
	
		
	return "enfantFactureAnnuelle";
	}

}
