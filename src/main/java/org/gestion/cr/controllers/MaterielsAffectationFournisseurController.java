package org.gestion.cr.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.gestion.cr.entities.Classe;
import org.gestion.cr.entities.ClasseEquipeEducatif;
import org.gestion.cr.entities.Club;
import org.gestion.cr.entities.ClubEnfant;
import org.gestion.cr.entities.Enfant;
import org.gestion.cr.entities.EquipeEducatif;
import org.gestion.cr.entities.Fournisseur;
import org.gestion.cr.entities.Inscription;
import org.gestion.cr.entities.PlanningEnfant;
import org.gestion.cr.entities.PlanningHorraires;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/FournMateriel")
public class MaterielsAffectationFournisseurController {

	/**
	 * 
	 * @author YOSRA
	 *
	 */
	

	@Autowired
	private IAdminMetier metier;

	@RequestMapping("/affecterFournisseurAMateriel")
	public String affecterFournisseurAMateriel(Long idMateriel, String checkedFournisseur, Model model) throws ParseException {
		
		
		
		
	

		String[] fournisseurSelectionnes = checkedFournisseur.split(",");

		Long fournisseurSelectionne = null;

		for (int k = 0; k < fournisseurSelectionnes.length; k++) 
		{

			fournisseurSelectionne = Long.parseLong(fournisseurSelectionnes[k]);
			
			

			
			metier.ajouterMaterielPourFournisseur(idMateriel, fournisseurSelectionne);
		

		}
		
		return "affectFournisseursMateriels";

	}

	@RequestMapping("/choisirFournisseurs")
	public String choisirFournisseurs(Model model, Long idMateriel) {

		// Traittements Fournisseurs

		List<Fournisseur> listFournisseursMateriels = metier.listFournisseurs();

		model.addAttribute("listFournisseursMateriels", listFournisseursMateriels);

		model.addAttribute("materiel", metier.getMateriels(idMateriel));

		

		return "affectFournisseursMateriels";

	}
	
	

	

	

}
