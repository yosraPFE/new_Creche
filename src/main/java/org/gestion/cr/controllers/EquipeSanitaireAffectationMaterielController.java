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
import org.gestion.cr.entities.EquipeSanitaire;
import org.gestion.cr.entities.Evenement;
import org.gestion.cr.entities.EvennementEnfant;
import org.gestion.cr.entities.Inscription;
import org.gestion.cr.entities.Materiel;
import org.gestion.cr.entities.MatrielSanitaUtiliser;
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
@RequestMapping(value = "/adminEqSanMater")
public class EquipeSanitaireAffectationMaterielController 
{
	@Autowired
	private IAdminMetier metier;

	@RequestMapping("/affecterEquipeSanitaireAMateriel")
	public String affecterEquipeSanitaireAMateriel(String checkedMateriel,Long idEquiSanitaire , Model model) throws ParseException {
				
		// Calcul Date
		
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeAndDate = df.format(d);
		Date timeAndDateFormat = df.parse(timeAndDate);
									
		// Ancienne list des Ids Materiels Equipe Sanitaire
		List<MatrielSanitaUtiliser> listMaterielActifsEqSanitaire = metier.ListMaterielActifsEqSanitaire(idEquiSanitaire);
		List<Long> listIdMaterielActifEqSanitaireA = new ArrayList<Long>(
				listMaterielActifsEqSanitaire.size());

		// Avoir la liste des Id Materiel
		for (int k = 0; k < listMaterielActifsEqSanitaire.size(); k++) {
			listIdMaterielActifEqSanitaireA.add(k, listMaterielActifsEqSanitaire.get(k).getMateriel().getIdMateriel());
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
			if (!listIdMaterielActifEqSanitaireA.contains(listIdMaterielChecked.get(j))) {

				MatrielSanitaUtiliser matEqSan = new MatrielSanitaUtiliser();
							
				
		metier.ajouterMatrielSanitaireUtiliser(matEqSan, listIdMaterielChecked.get(j), idEquiSanitaire, timeAndDateFormat);
		}

		}

		for (int f = 0; f < listIdMaterielActifEqSanitaireA.size(); f++)

		{
		// si l'ancien ID n'existe pas dans les ID selectionnés -->
		// nouvellement décochet
		if (!listIdMaterielChecked.contains(listIdMaterielActifEqSanitaireA.get(f))) {

			MatrielSanitaUtiliser matEqSan = listMaterielActifsEqSanitaire.get(f);
				
			matEqSan.setDateFinUtilisation(timeAndDateFormat);
		    metier.modifierMatrielSanitaireUtiliser(matEqSan);
				    
		}

		}
		} else {
		for (int f = 0; f < listIdMaterielActifEqSanitaireA.size(); f++)

		 {
			MatrielSanitaUtiliser matEqSan = listMaterielActifsEqSanitaire.get(f);
					
			matEqSan.setDateFinUtilisation(timeAndDateFormat);
		    metier.modifierMatrielSanitaireUtiliser(matEqSan);
			}
			}
		
		return "affectEquipeSanitaireMaterils";

	}

	@RequestMapping("/choisirMateriles")
	public String choisirMateriles(Model model, Long idEquiSanitaire) {

		// Traittements materiels

		List<Materiel> listMaterielEqSanitaire = metier.listMateriels();

		model.addAttribute("listMaterielEqSanitaire", listMaterielEqSanitaire);

		model.addAttribute("equipeSanitaire", metier.getEquipeSanitaire(idEquiSanitaire));
		
		
		
		//traitemetn des Materiels deja selectionné
		
		List<MatrielSanitaUtiliser> listMaterielActifsEqSanitaire = metier
								.ListMaterielActifsEqSanitaire(idEquiSanitaire);

		List<Long> listIdMaterielActifEqSanitaireA = new ArrayList<Long>(
				listMaterielActifsEqSanitaire.size());

		for (int k = 0; k < listMaterielActifsEqSanitaire.size(); k++) {
			listIdMaterielActifEqSanitaireA.add(k, listMaterielActifsEqSanitaire.get(k).getMateriel()
							.getIdMateriel());

			}
		model.addAttribute("listIdMaterielActifEqSanitaireA", listIdMaterielActifEqSanitaireA);

				

		

		return "affectEquipeSanitaireMaterils";

	}
	
	

	// photo
		@RequestMapping(value = "photoEqSan", produces = MediaType.IMAGE_JPEG_VALUE)
		@ResponseBody
		public byte[] photoEqSan(Long idEquipeSanitaire) throws IOException {
			EquipeSanitaire eqSa = metier.getEquipeSanitaire(idEquipeSanitaire);
			File f = new File(eqSa.getNomPhoto());
			return IOUtils.toByteArray(new FileInputStream(f));
		}
}
