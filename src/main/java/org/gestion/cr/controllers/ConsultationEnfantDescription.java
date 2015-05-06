package org.gestion.cr.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.gestion.cr.entities.Classe;
import org.gestion.cr.entities.ClubEnfant;
import org.gestion.cr.entities.Consultation;
import org.gestion.cr.entities.Creche;
import org.gestion.cr.entities.EquipeSanitaire;
import org.gestion.cr.entities.Inscription;
import org.gestion.cr.entities.Payment;
import org.gestion.cr.entities.PlanningEnfant;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/DescripCons")
public class ConsultationEnfantDescription
{
	@Autowired
	private IAdminMetier metier;
	
	
	@RequestMapping("/voirConsul")
	public String voirConsul(Model model, Long idEnf) throws ParseException 
	{
		/**
		 * 
		 * @author YOSRA
		 *
		 */
		
		
	
		
		//Avoir toutes les information de la table Consultation
		
	
		
		
		
		Date dateI = new Date();
		SimpleDateFormat dateConsultationFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateConsultationString = dateConsultationFormat.format(dateI);	
		
		
			
		
		Consultation derniereConsultation = metier.getConsultationEnfDate(idEnf, dateConsultationString);
		
		EquipeSanitaire eqSanConsultation = derniereConsultation.getEquipeSanitaire();
		

		//System.out.println("payementAnnuelle : " + payementAnnuelle.getMoisPayment());
		
		
	
		//remplissage Model
		
		model.addAttribute("enfant", metier.getEnfant(idEnf));
		model.addAttribute("eqSanConsultation", eqSanConsultation);
		model.addAttribute("derniereConsultation", derniereConsultation);
		
		
	
		
	return "descriptionConsultationEnfant";
	}


}
