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
import org.gestion.cr.entities.Evenement;
import org.gestion.cr.entities.EvennementEnfant;
import org.gestion.cr.entities.Inscription;
import org.gestion.cr.entities.Materiel;
import org.gestion.cr.entities.MatrielUtiliser;
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
@RequestMapping(value = "/adminEqMater")
public class EquipeEducatifAffectationMaterielController 
{
	@Autowired
	private IAdminMetier metier;

	@RequestMapping("/affecterEquipeEducatifAMateriel")
	public String affecterEquipeEducatifAMateriel(Long idEquiEducatif, String checkedMateriel, Model model) throws ParseException {
		
		// Calcul Date
		
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeAndDate = df.format(d);
		Date timeAndDateFormat = df.parse(timeAndDate);
							
		// Ancienne list des Ids Materiels Enfant
		List<MatrielUtiliser> listMaterielActifsEqEducatif = metier.ListMaterielActifsEqEducatif(idEquiEducatif);
		List<Long> listIdMaterielActifEqEducatifA = new ArrayList<Long>(
				listMaterielActifsEqEducatif.size());

		// Avoir la liste des Id Materiel
		for (int k = 0; k < listMaterielActifsEqEducatif.size(); k++) {
			listIdMaterielActifEqEducatifA.add(k, listMaterielActifsEqEducatif.get(k).getMateriel().getIdMateriel());
		}

		// traitement des Materiel selectionnés
		if (checkedMateriel != null) {
		String[] materielSelectionnes = checkedMateriel.split(",");
		List<Long> listIdMaterielChecked = new ArrayList<Long>(materielSelectionnes.length);
		// convert String[] to List<Long>
		for (int i = 0; i < materielSelectionnes.length; i++) {
			listIdMaterielChecked.add(i, Long.parseLong(materielSelectionnes[i]));
		}

		for (int j = 0; j < listIdMaterielChecked.size(); j++)

		{
	    // si l'ID selectionné n'existe pas déjà --> nouvellement cochet
		if (!listIdMaterielActifEqEducatifA.contains(listIdMaterielChecked.get(j))) {

			MatrielUtiliser matEqEdu = new MatrielUtiliser();
					
		
		metier.ajouterMatrielUtiliser(matEqEdu, listIdMaterielChecked.get(j), idEquiEducatif, timeAndDateFormat);
		}

		}

		for (int f = 0; f < listIdMaterielActifEqEducatifA.size(); f++)

		{
		// si l'ancien ID n'existe pas dans les ID selectionnés -->
		// nouvellement décochet
		if (!listIdMaterielChecked.contains(listIdMaterielActifEqEducatifA.get(f))) {

			MatrielUtiliser matEqEdu = listMaterielActifsEqEducatif.get(f);
		
			matEqEdu.setDateFinUtilisation(timeAndDateFormat);
		    metier.modifierMatrielUtiliser(matEqEdu);

		}

		}
		} else {
		for (int f = 0; f < listIdMaterielActifEqEducatifA.size(); f++)

		{
			MatrielUtiliser matEqEdu = listMaterielActifsEqEducatif.get(f);
			
			matEqEdu.setDateFinUtilisation(timeAndDateFormat);
		    metier.modifierMatrielUtiliser(matEqEdu);
		}
			}
		
		return "affectEquipeEducatifMaterils";

	}

	@RequestMapping("/choisirMateriles")
	public String choisirMateriles(Model model, Long idEquiEducatif) {

		// Traittements Materiels

		List<Materiel> listMaterielEqEducatif = metier.listMateriels();

		model.addAttribute("listMaterielEqEducatif", listMaterielEqEducatif);

		model.addAttribute("equipeEducatif", metier.getEquipeEducatif(idEquiEducatif));


		//traitemetn des Materiels deja selectionné
		
		List<MatrielUtiliser> listMaterielActifsEqEducatif = metier
						.ListMaterielActifsEqEducatif(idEquiEducatif);

		List<Long> listIdMaterielActifEqEducatifA = new ArrayList<Long>(
				listMaterielActifsEqEducatif.size());

		for (int k = 0; k < listMaterielActifsEqEducatif.size(); k++) {
			listIdMaterielActifEqEducatifA.add(k, listMaterielActifsEqEducatif.get(k).getMateriel()
					.getIdMateriel());

			}
		model.addAttribute("listIdMaterielActifEqEducatifA", listIdMaterielActifEqEducatifA);

		

		return "affectEquipeEducatifMaterils";

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
