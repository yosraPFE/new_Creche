package org.gestion.cr.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.gestion.cr.entities.Enfant;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/AccompEnfList") 
public class AccompagnateurListEnfant 
{
	@Autowired
	private IAdminMetier metier;
	
	
	@RequestMapping("/voirListEnfantParAccomp")
	public String voirListEnfantParAccomp(Long idAccomp, Model model) throws ParseException {
		
		

		//Avoir List des Enfants Actifs Par Club
		
	
		
		List<Enfant> listEnfantsParAccompagnateur = metier.EnfantParAccompagnaeurt(idAccomp);
		
		
		//List<ClubEnfant> listEnfantsClubs=metier.EnfantParClub(idClub);
		
		
		

		

		//remplissage Model
		
		model.addAttribute("accompagnateur", metier.getAccompagnateur(idAccomp));
		model.addAttribute("listEnfantsParAccompagnateur", listEnfantsParAccompagnateur);
      
	
	
	
		return "accompagnateurListEnfant";
		

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
