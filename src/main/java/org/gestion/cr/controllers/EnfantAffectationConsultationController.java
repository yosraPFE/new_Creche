package org.gestion.cr.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.gestion.cr.entities.Classe;
import org.gestion.cr.entities.Consultation;
import org.gestion.cr.entities.Enfant;
import org.gestion.cr.entities.EquipeSanitaire;
import org.gestion.cr.entities.Inscription;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/consultation") 

public class EnfantAffectationConsultationController
{
	
	
		@Autowired
		private IAdminMetier metier;
		@RequestMapping("/consultationEnfant")
		public String consultationenfant(Long idEqSani,Long idEnf,String description, Model model) throws ParseException {
			
			
			Consultation cons =new Consultation();
			
			
			//traitement Date
			Date dateI = new Date();
			SimpleDateFormat dateConsultationFormat = new SimpleDateFormat("yyyy-MM-dd");
			String dateConsultationString = dateConsultationFormat.format(dateI);			
			cons.setDate(dateConsultationString);	
			
			
			cons.setDescription(description);
			
			
			
			 //Long t = metier.getConsultationEnf(idEnf, dateConsultationString);
			 metier.ajouterConsultation(cons, idEnf, idEqSani);
				
				//model.addAttribute("enfants", metier.listEnfants());
				//return "redirect:/adminEnfConsult/indexReturn1?ConsuAjoute="+ajoute;
				
			//return "redirect:/adminEnf/indexReturnFromConsultation?ConsuAjoute="+ajoute;
				
				//return "redirect:affecterEnfantAEquipeSanitaire?idEnf="+idEnf;
				
			return "redirect:/DescripCons/voirConsul?idEnf="+idEnf;
			
		}
		
		@RequestMapping("/affecterEnfantAEquipeSanitaire")
		public String affecterEnfantAEquipeSanitaire(Model model, Long idEnf) {
			
			List<EquipeSanitaire> listEquipeSanitaires = metier.listEquipeSanitaires();
			
			
			model.addAttribute("listEquipeSanitaires", listEquipeSanitaires);
			
			model.addAttribute("enfant", metier.getEnfant(idEnf));
			
			
			return "affectEnfantConsultation";
			

		}
		
		
		@RequestMapping(value = "photoEqSan", produces = MediaType.IMAGE_JPEG_VALUE)
		@ResponseBody
		public byte[] photoEqSan(Long idEquipeSanitaire) throws IOException {
			EquipeSanitaire eqSa = metier.getEquipeSanitaire(idEquipeSanitaire);
			File f = new File(eqSa.getNomPhoto());
			return IOUtils.toByteArray(new FileInputStream(f));
		}
		
		
		
		@RequestMapping(value = "/photoEnfant", produces = MediaType.IMAGE_JPEG_VALUE)
		@ResponseBody
		public byte[] photoEnf(@RequestParam("idEnf") Long idEnf) throws Exception {
			Enfant ef = metier.getEnfant(idEnf);
			File f = new File(System.getProperty("java.io.tmpdir") + "/Enf_"
					+ idEnf + "_" + ef.getNomPhoto());
			return IOUtils.toByteArray(new FileInputStream(f));
		}


}
