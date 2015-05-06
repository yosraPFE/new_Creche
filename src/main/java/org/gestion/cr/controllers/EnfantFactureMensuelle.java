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
@RequestMapping(value = "/factMensuel")
public class EnfantFactureMensuelle 
{
	@Autowired
	private IAdminMetier metier;

	@RequestMapping("/voirFacturMens")
	public String voirFacturMens(Model model, Long idEnf) 
	{
		/**
		 * 
		 * @author YOSRA
		 *
		 */
		
		
		
		
		//Avoir le fraix mois de la table creche
		
		Date da = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		String year = df.format(da);		
		

		//la creche pour cette annee 
		Creche crecheAnnee=metier.getCreche(year);
		
		
		System.out.println("crecheAnnee : " + crecheAnnee.getAnnee());
		
		
		//avoir la liste des clubs actifs
		
		List<ClubEnfant> listClubActifsEnfant = metier.ListClubActifsEnfant(idEnf);
		
		System.out.println("listClubActifsEnfant : " + listClubActifsEnfant.get(0).getClub().getNom());
		

		
		
		
		//avoir la liste des planning actifs
		
		List<PlanningEnfant> listPlanningActifsEnfant = metier.ListPlanningActifsEnfant(idEnf);
		System.out.println("listPlanningActifsEnfant : " + listPlanningActifsEnfant.get(0).getPlanningHorraires().getTypePlanning());

		
		//avoir remise et prix total de la table paiement
		
		
		Date danee = new Date();
		SimpleDateFormat dform = new SimpleDateFormat("yyyy-MM");
		String anneeMois = dform.format(danee);		
		
		
		String naturePaiement="mensuel";
		
		//un seul payement 
		List<Payment>listTousPay = metier.listPaymentEnfant(idEnf);
		Payment payementMensuel = listTousPay.get(listTousPay.size()-1);
		
		//Payment payementMensuel = metier.getPaymentMensuel(idEnf, anneeMois, naturePaiement);
		
	
		System.out.println("payementMensuel : " + payementMensuel.getMoisPayment());
		
		
		
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
		model.addAttribute("payementMensuel", payementMensuel);
		model.addAttribute("classeAnnee", classeAnnee);
		model.addAttribute("inscritAnnee", inscritAnnee);
		
		
	
		
	return "enfantFactureMensuelle";
	}

}
