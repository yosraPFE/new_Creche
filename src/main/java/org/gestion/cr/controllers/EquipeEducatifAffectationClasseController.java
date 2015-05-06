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
@RequestMapping(value = "/adminEqCla")
public class EquipeEducatifAffectationClasseController 
{
	@Autowired
	private IAdminMetier metier;

	@RequestMapping("/affecterEquipeEducatifAClass")
	public String affecterEquipeEducatifAClass(Long idEquiEducatif, String checkedClass, Model model) throws ParseException {
		
	// Calcul Date
				
	Date d = new Date();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String timeAndDate = df.format(d);
	Date timeAndDateFormat = df.parse(timeAndDate);
						
	// Ancienne list des Ids Classes Enfant
	List<ClasseEquipeEducatif> listClasseActifsEqEducatif = metier.ListClasseActifsEquEducatif(idEquiEducatif);
	List<Long> listIdClasseActifEqEducatifA = new ArrayList<Long>(
			listClasseActifsEqEducatif.size());

	// Avoir la liste des Id Classes
	for (int k = 0; k < listClasseActifsEqEducatif.size(); k++) {
		listIdClasseActifEqEducatifA.add(k, listClasseActifsEqEducatif.get(k).getClasse().getIdClasse());
	}

	// traitement des Classes selectionnés
	if (checkedClass != null) {
	String[] classesSelectionnes = checkedClass.split(",");
	List<Long> listIdClasseChecked = new ArrayList<Long>(classesSelectionnes.length);
	// convert String[] to List<Long>
	for (int i = 0; i < classesSelectionnes.length; i++) {
		listIdClasseChecked.add(i, Long.parseLong(classesSelectionnes[i]));
	}

	for (int j = 0; j < listIdClasseChecked.size(); j++)

	{
    // si l'ID selectionné n'existe pas déjà --> nouvellement cochet
	if (!listIdClasseActifEqEducatifA.contains(listIdClasseChecked.get(j))) {

		ClasseEquipeEducatif classEqEdu = new ClasseEquipeEducatif();
				
	metier.ajouterEquipeEducatifClasse(classEqEdu, listIdClasseChecked.get(j), idEquiEducatif, timeAndDateFormat);
	}

	}

	for (int f = 0; f < listIdClasseActifEqEducatifA.size(); f++)

	{
	// si l'ancien ID n'existe pas dans les ID selectionnés -->
	// nouvellement décochet
	if (!listIdClasseChecked.contains(listIdClasseActifEqEducatifA.get(f))) {

		ClasseEquipeEducatif classEqEdu = listClasseActifsEqEducatif.get(f);
	
		classEqEdu.setDateFinEnseignementClas(timeAndDateFormat);
	     metier.modifierEquipeEducatifClasse(classEqEdu);

	}

	}
	} else {
	for (int f = 0; f < listIdClasseActifEqEducatifA.size(); f++)

	{
		ClasseEquipeEducatif classEqEdu = listClasseActifsEqEducatif.get(f);
		classEqEdu.setDateFinEnseignementClas(timeAndDateFormat);
	     metier.modifierEquipeEducatifClasse(classEqEdu);
	}
		}
		return "affectEquipeEducatifClasse";

	}
	

	@RequestMapping("/choisirClasses")
	public String choisirClasses(Model model, Long idEquiEducatif) {

	   // Traittements Classes

		List<Classe> listClasseEqEducatif = metier.listClasse();

		model.addAttribute("listClasseEqEducatif", listClasseEqEducatif);

		model.addAttribute("equipeEducatif", metier.getEquipeEducatif(idEquiEducatif));
		
		
		
		
		//traitemetn des classes deja selectionné
		
		List<ClasseEquipeEducatif> listClasseActifsEqEducatif = metier
						.ListClasseActifsEquEducatif(idEquiEducatif);

		List<Long> listIdClasseActifEqEducatifA = new ArrayList<Long>(
				listClasseActifsEqEducatif.size());

		for (int k = 0; k < listClasseActifsEqEducatif.size(); k++) {
			listIdClasseActifEqEducatifA.add(k, listClasseActifsEqEducatif.get(k).getClasse()
					.getIdClasse());

			}
		model.addAttribute("listIdClasseActifEqEducatifA", listIdClasseActifEqEducatifA);

		

		return "affectEquipeEducatifClasse";

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
