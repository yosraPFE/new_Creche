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
import org.gestion.cr.entities.CategorieClub;
import org.gestion.cr.entities.CategorieClubEquipeEducatif;
import org.gestion.cr.entities.Classe;
import org.gestion.cr.entities.ClasseEquipeEducatif;
import org.gestion.cr.entities.Club;
import org.gestion.cr.entities.ClubEnfant;
import org.gestion.cr.entities.Enfant;
import org.gestion.cr.entities.EquipeEducatif;
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
@RequestMapping(value = "/adminEqCateg")
public class EquipeEducatifAffectationCategoriesController 
{
	@Autowired
	private IAdminMetier metier;

	@RequestMapping("/affecterEquipeEducatifACategorie")
	public String affecterEquipeEducatifACategorie(Long idEquiEducatif, String checkedCategorie, Model model) throws ParseException {
		
		// Calcul Date
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeAndDate = df.format(d);
		Date timeAndDateFormat = df.parse(timeAndDate);
				
		// Ancienne list des Ids Categories Enfant
		List<CategorieClubEquipeEducatif> listCategoriesActifsEqEducatif = metier.ListCategorieClubActifsEquipeEducatif(idEquiEducatif);
		List<Long> listIdCategorieActifEqEducatifA = new ArrayList<Long>(
				listCategoriesActifsEqEducatif.size());

		// Avoir la liste des Id Categories
		for (int k = 0; k < listCategoriesActifsEqEducatif.size(); k++) {
			listIdCategorieActifEqEducatifA.add(k, listCategoriesActifsEqEducatif.get(k).getCategorieClub().getIdCategorie());
	    }

		// traitement des Categories selectionnés
		if (checkedCategorie != null) {
		String[] categoriesSelectionnes = checkedCategorie.split(",");
		List<Long> listIdCategorieChecked = new ArrayList<Long>(categoriesSelectionnes.length);
		// convert String[] to List<Long>
		for (int i = 0; i < categoriesSelectionnes.length; i++) {
			listIdCategorieChecked.add(i, Long.parseLong(categoriesSelectionnes[i]));
		}

		for (int j = 0; j < listIdCategorieChecked.size(); j++)

		{
		// si l'ID selectionné n'existe pas déjà --> nouvellement cochet
		if (!listIdCategorieActifEqEducatifA.contains(listIdCategorieChecked.get(j))) {

		CategorieClubEquipeEducatif catEqEdu = new CategorieClubEquipeEducatif();
		
		metier.ajouterCategorieClubEquipeEducatif(catEqEdu,  listIdCategorieChecked.get(j),idEquiEducatif, timeAndDateFormat);
		}

		}

		for (int f = 0; f < listIdCategorieActifEqEducatifA.size(); f++)

		{
		// si l'ancien ID n'existe pas dans les ID selectionnés -->
		// nouvellement décochet
		if (!listIdCategorieChecked.contains(listIdCategorieActifEqEducatifA.get(f))) {

		CategorieClubEquipeEducatif catEqEdu = listCategoriesActifsEqEducatif.get(f);

		catEqEdu.setDateFinAnimateCateg(timeAndDateFormat);
		metier.modifierCategorieClubEquipeEducatif(catEqEdu);

		}

		}
		} else {
		for (int f = 0; f < listIdCategorieActifEqEducatifA.size(); f++)

		{
		CategorieClubEquipeEducatif catEqEdu = listCategoriesActifsEqEducatif.get(f);
		catEqEdu.setDateFinAnimateCateg(timeAndDateFormat);
		metier.modifierCategorieClubEquipeEducatif(catEqEdu);
			}
		}
		
		return "affectEquipeEducatifCategorie";

	}

	@RequestMapping("/choisirCategorieClub")
	public String choisirCategorieClub(Model model, Long idEquiEducatif) {

		// Traittements Categories

		List<CategorieClub> listCategorieClubEqEducatif = metier.listCategorieClubs();

		model.addAttribute("listCategorieClubEqEducatif", listCategorieClubEqEducatif);

		model.addAttribute("equipeEducatif", metier.getEquipeEducatif(idEquiEducatif));
		
		
		//traitemetn des categories deja selectionné
		
		List<CategorieClubEquipeEducatif> listCategoriesActifsEqEducatif = metier
				.ListCategorieClubActifsEquipeEducatif(idEquiEducatif);

		List<Long> listIdCategorieActifEqEducatifA = new ArrayList<Long>(
				listCategoriesActifsEqEducatif.size());

		for (int k = 0; k < listCategoriesActifsEqEducatif.size(); k++) {
			listIdCategorieActifEqEducatifA.add(k, listCategoriesActifsEqEducatif.get(k).getCategorieClub()
					.getIdCategorie());

		}
		model.addAttribute("listIdCategorieActifEqEducatifA", listIdCategorieActifEqEducatifA);

		

		return "affectEquipeEducatifCategorie";

	}
	
	

	// photo
		@RequestMapping(value = "photoEqEdu", produces = MediaType.IMAGE_JPEG_VALUE)
		@ResponseBody
		public byte[] photoEqEdu(Long idEquipeEducatif) throws IOException {
			EquipeEducatif eqEd = metier.getEquipeEducatif(idEquipeEducatif);
			File f = new File(eqEd.getNomPhoto());
			return IOUtils.toByteArray(new FileInputStream(f));
		}
}
