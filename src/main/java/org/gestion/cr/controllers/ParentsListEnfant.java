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
@RequestMapping(value = "/ParenEnfList") 
public class ParentsListEnfant
{
	@Autowired
	private IAdminMetier metier;
	
	
	
	@RequestMapping("/voirListEnfantParParents")
	public String voirListEnfantParParents(Long idPar, Model model) throws ParseException {
		
		

		//Avoir List des Enfants Actifs Par Club
		
	
		
		List<Enfant> listEnfantsParParent = metier.EnfantParParent(idPar);
		
		
		//List<ClubEnfant> listEnfantsClubs=metier.EnfantParClub(idClub);
		
		
		

		//remplissage Model
		
		model.addAttribute("parent", metier.getParent(idPar));
		model.addAttribute("listEnfantsParParent", listEnfantsParParent);
      
	
	
	
		return "parentsListEnfant";
		

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
