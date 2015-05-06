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
import org.gestion.cr.entities.Enfant;
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
@RequestMapping(value="/inscription") 

public class EnfantAffectationInscriptionController
{
	
	@Autowired
	private IAdminMetier metier;
	@RequestMapping("/inscriptionEnfant")
	public String inscriptionenfant(Long idCla, Long idEnf, Model model) throws ParseException {
		
		
		Inscription insc =new Inscription();
		
		
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		String year = df.format(d);		
		insc.setAnnee(year);	
		
		Date dateI = new Date();
		SimpleDateFormat dateInscriptionFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateInscriptionString = dateInscriptionFormat.format(dateI);	
		Date dateInscription = dateInscriptionFormat.parse(dateInscriptionString);
		insc.setDateInscription(dateInscription);
		
		 
		 Long t = metier.getInscriptionEnf(idEnf, year);
		 Long ajoute = null;
		 
			if(t ==0)
		    {
				
				//insc.setTarifInscription(tarifInscri);
				//insc.setPrixAssurance(tarifAssurance);
				
				metier.ajouterInscription(insc ,idEnf,idCla);
				
				ajoute = new Long(1);
				
				
				
				//model.addAttribute("enfants", metier.listEnfants());
				
				List<Classe> listClasses = metier.listClasse();
				List<Long> listPlacesRestantes = new ArrayList<Long>(listClasses.size());
				
				for (int cptCl = 0; cptCl < listClasses.size(); cptCl++){
					
					Classe clEnCours = listClasses.get(cptCl);
					
					int nbrMaxInt = clEnCours.getNombrePlaces();
					
					Long nbrMaxLong = new Long(nbrMaxInt);
					
					System.out.println("1-1");
					Long nbrResv = metier.nbrEnfantClasse(clEnCours.getIdClasse());
					System.out.println("1-2 : " + nbrResv);
					
					Long placeRestantes = nbrMaxLong - nbrResv;
					System.out.println("1-3");
					listPlacesRestantes.add(cptCl, placeRestantes);
					System.out.println("1-4");
				}
				System.out.println("2");
				
				model.addAttribute("listClasses", listClasses);
				model.addAttribute("listPlacesRestantes",listPlacesRestantes);
				model.addAttribute("enfant", metier.getEnfant(idEnf));
				model.addAttribute("InscriAjoute", ajoute);
				
				return "affectEnfantClasse";
			  
		    }
			else
			{ 
				ajoute = new Long(0);
				
				//model.addAttribute("InscriAjoute", ajoute);
		        
				model.addAttribute("enfants", metier.listEnfants());
				
			}
			//model.addAttribute("InscriAjoute", ajoute);
			//model.addAttribute("enfant", new Enfant());

		
		       return "redirect:/adminEnf/indexReturn?InscriAjoute="+ajoute;
			 // return "redirect:/adminEnf/enfantsListe";
	}
	
	@RequestMapping("/affecterEnfantAClasse")
	public String affecterEnfantAClasse(Model model, Long idEnf) {
		
		List<Classe> listClasses = metier.listClasse();
		List<Long> listPlacesRestantes = new ArrayList<Long>(listClasses.size());
		
		for (int cptCl = 0; cptCl < listClasses.size(); cptCl++){
			
			Classe clEnCours = listClasses.get(cptCl);
			
			int nbrMaxInt = clEnCours.getNombrePlaces();
			
			Long nbrMaxLong = new Long(nbrMaxInt);
			
			System.out.println("1-1");
			Long nbrResv = metier.nbrEnfantClasse(clEnCours.getIdClasse());
			System.out.println("1-2 : " + nbrResv);
			
			Long placeRestantes = nbrMaxLong - nbrResv;
			System.out.println("1-3");
			listPlacesRestantes.add(cptCl, placeRestantes);
			System.out.println("1-4");
		}
		System.out.println("2");
		
		model.addAttribute("listClasses", listClasses);
		model.addAttribute("listPlacesRestantes",listPlacesRestantes);
		model.addAttribute("enfant", metier.getEnfant(idEnf));
		
		
		return "affectEnfantClasse";
		

	}
	
	
	@RequestMapping(value="/ajouterClasse")
	public String ajouterClasse(@Valid Classe cla,BindingResult bindingResult,
			Model model) throws IOException
	{
		
		
		
		if(bindingResult.hasErrors())
		{
			
			model.addAttribute("classe", new Classe());
			return("classesAjout");
		}
		
		
		//Long idClass = metier.ajouterClasse(cla, cla.getCreche().getIdCreche());
		
		//model.addAttribute("classeAjoute",metier.getClasse(idClass));
		
		model.addAttribute("classe", new Classe());
		
		
		
	
	return "classesAjout";
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
