package org.gestion.cr.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.gestion.cr.entities.Classe;
import org.gestion.cr.entities.ClubEnfant;
import org.gestion.cr.entities.Enfant;
import org.gestion.cr.entities.Inscription;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/ClassEnfList") 
public class ClassEnfantList 
{
	@Autowired
	private IAdminMetier metier;
	
	
	
	@RequestMapping("/voirListEnfantParClass")
	public String voirListEnfantParClass(Long idClass, Model model) throws ParseException {
		
		

		//Avoir List des Enfants Actifs Par Classe
		
		
		/*Date di = new Date();
		SimpleDateFormat dfi = new SimpleDateFormat("yyyy");
		String yearIns = dfi.format(di);*/	
		
		
		
		List<Inscription> listInscr = metier.EnfantParClasse(idClass);
		//Classe classeAnnee = listInscr.getClasse();
	
		
		
		

		//remplissage Model
		
		model.addAttribute("classe", metier.getClasse(idClass));
		model.addAttribute("listInscr", listInscr);
      
	
	
	
		return "classEnfantList";
		

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
