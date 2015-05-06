package org.gestion.cr.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.gestion.cr.entities.ClubEnfant;
import org.gestion.cr.entities.Enfant;
import org.gestion.cr.entities.PlanningEnfant;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/planningEnfList") 
public class PlanningsListeEnfants 
{
	@Autowired
	private IAdminMetier metier;
	
	
	
	@RequestMapping("/voirListEnfantParPlanning")
	public String voirListEnfantParPlanning(Long idPlanning, Model model) throws ParseException {
		
		

		//Avoir List des Enfants Actifs Par Planning
		
		
		
		
		
		List<PlanningEnfant> listPlanningActifsEnfant = metier.ListEnfantsActifsPlannings(idPlanning);
		
		
		//List<PlanningEnfant> listPlanningsEnfant = metier.EnfantParPlanningH(idPlanning);
		
		
		

		//remplissage Model
		
		model.addAttribute("planning", metier.getPlanningHorraires(idPlanning));
		model.addAttribute("listPlanningActifsEnfant", listPlanningActifsEnfant);
      
	
	
	
		return "planningsListeEnfants";
		

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
