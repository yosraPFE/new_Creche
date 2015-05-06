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
import org.gestion.cr.entities.ClubEnfant;
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
@RequestMapping(value = "/ClubEnfList") 

public class ClubListeEnfants 
{
	
	
		@Autowired
		private IAdminMetier metier;
		
		
		
		@RequestMapping("/voirListEnfantParClubs")
		public String voirListEnfantParClubs(Long idClub, Model model) throws ParseException {
			
			

			//Avoir List des Enfants Actifs Par Club
			
		
			
			List<ClubEnfant> listEnfantsActifsClubs = metier.ListEnfantsActifsClubs(idClub);
			
			
			System.out.println("listEnfantsActifsClubs : " + listEnfantsActifsClubs.get(0).getEnfant().getNom());
			
			
			//List<ClubEnfant> listEnfantsClubs=metier.EnfantParClub(idClub);
			
			
			

			

			//remplissage Model
			
			model.addAttribute("club", metier.getClubs(idClub));
			model.addAttribute("listEnfantsActifsClubs", listEnfantsActifsClubs);
	      
		
		
		
			return "clubListeEnfants";
			

		}
		
		
		
		
		// photo Enfant
		@RequestMapping(value = "photoEnf", produces = MediaType.IMAGE_JPEG_VALUE)
		@ResponseBody
		public byte[] photoEnf(Long idEnfant) throws IOException {
			Enfant enf = metier.getEnfant(idEnfant);
			File f = new File(enf.getNomPhoto());
			return IOUtils.toByteArray(new FileInputStream(f));
		}



}
