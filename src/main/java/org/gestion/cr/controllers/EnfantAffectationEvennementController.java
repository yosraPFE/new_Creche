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
import org.gestion.cr.entities.Club;
import org.gestion.cr.entities.ClubEnfant;
import org.gestion.cr.entities.Enfant;
import org.gestion.cr.entities.Evenement;
import org.gestion.cr.entities.EvennementEnfant;
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
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/adminEf")
public class EnfantAffectationEvennementController 
{
	@Autowired
	private IAdminMetier metier;

	@RequestMapping("/affecterEnfantAEvennem")
	public String affecterEnfantAEvennem(Long idEnf, String checkedEvennement, Model model) throws ParseException {
		
	  // Calcul Date
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeAndDate = df.format(d);
		Date timeAndDateFormat = df.parse(timeAndDate);

		// Ancienne list des Ids Evennements Enfant
		List<EvennementEnfant> listEvenementActifsEnfant = metier.ListEvennementActifsEnfant(idEnf);
		List<Long> listIdEvenementActifEnfantA = new ArrayList<Long>(listEvenementActifsEnfant.size());

	   // Avoir la liste des Id Evennements
		for (int k = 0; k < listEvenementActifsEnfant.size(); k++) {
		listIdEvenementActifEnfantA.add(k, listEvenementActifsEnfant.get(k).getEvenement().getIdEvenement());
		}

		// traitement des Evennements selectionnés
		if (checkedEvennement != null) {
		String[] evennementsSelectionnes = checkedEvennement.split(",");
		List<Long> listIdEvennementChecked = new ArrayList<Long>(evennementsSelectionnes.length);
		// convert String[] to List<Long>
		for (int i = 0; i < evennementsSelectionnes.length; i++) {
		listIdEvennementChecked.add(i, Long.parseLong(evennementsSelectionnes[i]));
		}

		for (int j = 0; j < listIdEvennementChecked.size(); j++)

		{
		// si l'ID selectionné n'existe pas déjà --> nouvellement cochet
		if (!listIdEvenementActifEnfantA.contains(listIdEvennementChecked.get(j))) {

		EvennementEnfant evenEnf = new EvennementEnfant();
							
							
		metier.ajouterEvennementEnfant(evenEnf, idEnf, listIdEvennementChecked.get(j), timeAndDateFormat);
		
	
						

		}

		}

		for (int f = 0; f < listIdEvenementActifEnfantA.size(); f++)

		{
		// si l'ancien ID n'existe pas dans les ID selectionnés -->
		// nouvellement décochet
		if (!listIdEvennementChecked.contains(listIdEvenementActifEnfantA.get(f))) {

		EvennementEnfant evenEnf = listEvenementActifsEnfant.get(f);
							
		evenEnf.setDateFinInscriptionEvennement(timeAndDateFormat);
		metier.modifierEvennementEnfant(evenEnf);
		}

		}
	    } else {
		for (int f = 0; f < listIdEvenementActifEnfantA.size(); f++)

		{
		EvennementEnfant evenEnf = listEvenementActifsEnfant.get(f);
		evenEnf.setDateFinInscriptionEvennement(timeAndDateFormat);
		metier.modifierEvennementEnfant(evenEnf);
		}
		}
	
	//	return "affectEnfantEvennement";
		
		return "redirect:choisirEvennements?idEnf="+idEnf;

	}

	@RequestMapping("/choisirEvennements")
	public String choisirEvennements(Model model, Long idEnf) {

		// Traittements Evennements

		List<Evenement> listEvenementEnfant = metier.listEvennements();

		model.addAttribute("listEvenementEnfant", listEvenementEnfant);

		model.addAttribute("enfant", metier.getEnfant(idEnf));

		
		
		//traitement Evennements
		
		
				List<EvennementEnfant> listEvenementActifsEnfant = metier.ListEvennementActifsEnfant(idEnf);
								

				List<Long> listIdEvenementActifEnfantA = new ArrayList<Long>(
								listEvenementActifsEnfant.size());

				for (int k = 0; k < listEvenementActifsEnfant.size(); k++) {
				listIdEvenementActifEnfantA.add(k, listEvenementActifsEnfant.get(k).getEvenement().getIdEvenement());

				}
						
				model.addAttribute("listIdEvenementActifEnfantA", listIdEvenementActifEnfantA);
				

		
		
		return "affectEnfantEvennement";

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
