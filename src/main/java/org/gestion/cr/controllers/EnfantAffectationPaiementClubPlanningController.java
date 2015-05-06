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
import org.gestion.cr.entities.Club;
import org.gestion.cr.entities.ClubEnfant;
import org.gestion.cr.entities.Creche;
import org.gestion.cr.entities.Enfant;
import org.gestion.cr.entities.Inscription;
import org.gestion.cr.entities.Payment;
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

@Controller
@RequestMapping(value = "/clubpai")
public class EnfantAffectationPaiementClubPlanningController {

	@Autowired
	private IAdminMetier metier;

	@RequestMapping("/affecterEnfantpaiemenAClub")
	public String affecterEnfantpaiemenAClub(Long idEnf, String checkedClubs,
			String checkedPlanning,float remise,double somme, Model model) throws ParseException {
		
		
		//recherche de l'inscription
		Date dai = new Date();
		SimpleDateFormat dfi = new SimpleDateFormat("yyyy");
		String yeari = dfi.format(dai);		
		

		Inscription derniereInscription=metier.getInscriptionEnfAnnee(idEnf, yeari);
		//derniereInscription.setRemise(remise);
		metier.modifierInscription(derniereInscription);
		

		// Calcul Date
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeAndDate = df.format(d);
		Date timeAndDateFormat = df.parse(timeAndDate);

		// Ancienne list des Ids clubs Enfant
		List<ClubEnfant> listClubActifsEnfant = metier
				.ListClubActifsEnfant(idEnf);
		List<Long> listIdClubActifEnfantA = new ArrayList<Long>(
				listClubActifsEnfant.size());

		// Avoir la liste des Id clubs
		for (int k = 0; k < listClubActifsEnfant.size(); k++) {
			listIdClubActifEnfantA.add(k, listClubActifsEnfant.get(k).getClub()
					.getIdClub());
		}

		// traitement des Clubs selectionnés
		if (checkedClubs != null) {
			String[] clubsSelectionnes = checkedClubs.split(",");
			List<Long> listIdClubChecked = new ArrayList<Long>(
					clubsSelectionnes.length);
			// convert String[] to List<Long>
			for (int i = 0; i < clubsSelectionnes.length; i++) {
				listIdClubChecked.add(i, Long.parseLong(clubsSelectionnes[i]));
			}

			for (int j = 0; j < listIdClubChecked.size(); j++)

			{
				// si l'ID selectionné n'existe pas déjà --> nouvellement cochet
				if (!listIdClubActifEnfantA.contains(listIdClubChecked.get(j))) {

					ClubEnfant clEnf = new ClubEnfant();
					metier.ajouterEnfantClub(clEnf, listIdClubChecked.get(j),
							idEnf, timeAndDateFormat);

				}

			}

			for (int f = 0; f < listIdClubActifEnfantA.size(); f++)

			{
				// si l'ancien ID n'existe pas dans les ID selectionnés -->
				// nouvellement décochet
				if (!listIdClubChecked.contains(listIdClubActifEnfantA.get(f))) {

					ClubEnfant clEnf = listClubActifsEnfant.get(f);

					clEnf.setDateFinInscriClub(timeAndDateFormat);
					metier.modifierEnfantClub(clEnf);

				}

			}
		} else {
			for (int f = 0; f < listIdClubActifEnfantA.size(); f++)

			{
				ClubEnfant clEnf = listClubActifsEnfant.get(f);
				clEnf.setDateFinInscriClub(timeAndDateFormat);
				metier.modifierEnfantClub(clEnf);
			}
		}

		/*
		 * 
		 * String[] planningSelectionnes = chekedPlanning.split(",");
		 * 
		 * Long planningSelectionne = null;
		 * 
		 * for (int k = 0; k < planningSelectionnes.length; k++) {
		 * 
		 * planningSelectionne = Long.parseLong(planningSelectionnes[k]);
		 * 
		 * PlanningEnfant plEnf = new PlanningEnfant();
		 * 
		 * //metier.ajouterEnfantPlanning(plEnf, idEnf,
		 * planningSelectionne,year);
		 * 
		 * }
		 */

		// Anciennes Liste des Id Plannings Jorraires
		List<PlanningEnfant> listPlanningActifsEnfant = metier
				.ListPlanningActifsEnfant(idEnf);
		List<Long> listIdPlanningActifEnfantA = new ArrayList<Long>(
				listPlanningActifsEnfant.size());

		// avoir la liste des id Planning

		for (int j = 0; j < listPlanningActifsEnfant.size(); j++) {
			listIdPlanningActifEnfantA.add(j, listPlanningActifsEnfant.get(j)
					.getPlanningHorraires().getIdPlanningH());
		}

		// traitement des Plannings selectionné

		if (checkedPlanning != null) {
			String[] planningsSelectionnes = checkedPlanning.split(",");
			List<Long> listIdPlanningChecked = new ArrayList<Long>(
					planningsSelectionnes.length);
			// convert String[] to List<Long>
			for (int l = 0; l < planningsSelectionnes.length; l++) {
				listIdPlanningChecked.add(l,
						Long.parseLong(planningsSelectionnes[l]));
			}

			for (int m = 0; m < listIdPlanningChecked.size(); m++)

			{
				// si l'ID selectionné n'existe pas déjà --> nouvellement cochet
				if (!listIdPlanningActifEnfantA.contains(listIdPlanningChecked
						.get(m))) {

					PlanningEnfant plEnf = new PlanningEnfant();

					metier.ajouterEnfantPlanning(plEnf, idEnf,
							listIdPlanningChecked.get(m), timeAndDateFormat);
				}

			}

			for (int h = 0; h < listIdPlanningActifEnfantA.size(); h++)

			{
				// si l'ancien ID n'existe pas dans les ID selectionnés -->
				// nouvellement décochet
				if (!listIdPlanningChecked.contains(listIdPlanningActifEnfantA
						.get(h))) {

					PlanningEnfant plEnf = listPlanningActifsEnfant.get(h);

					plEnf.setDateFinInscriFinPlanning(timeAndDateFormat);
					metier.modifierPlanningEnfant(plEnf);

				}

			}
		} else {
			for (int h = 0; h < listIdPlanningActifEnfantA.size(); h++)

			{
				PlanningEnfant plEnf = listPlanningActifsEnfant.get(h);
				plEnf.setDateFinInscriFinPlanning(timeAndDateFormat);
				metier.modifierPlanningEnfant(plEnf);
			}
		}
		
		Payment newPayment = new Payment();
				// Calcul Date payment ("year mounth" and "year mounth day")
				Date dp = new Date();
				SimpleDateFormat ymjF = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat ymF = new SimpleDateFormat("yyyy-MM");
				String yearMounthDayString = ymjF.format(dp);
				String yearMounthString = ymF.format(dp);
				Date yearMounthDay = ymjF.parse(yearMounthDayString);
				//Date yearMounth = ymF.parse(yearMounthString);
				
				//calcul montant avant remise
				double montantAvantRemise = somme / (1-(remise/100));
				montantAvantRemise = Math.round(montantAvantRemise*1000)/1000;
				
		newPayment.setDatePayement(yearMounthDay);
		newPayment.setRemise(remise);
		newPayment.setMontantAvantRemise(montantAvantRemise);
		newPayment.setMontantApresRemise(somme);
		newPayment.setNaturePayement("annuel");
		newPayment.setTypePayement("espece");
		newPayment.setNumeroFacture(1);
		metier.ajouterPayment(newPayment, idEnf, yearMounthString);

		return "redirect:/factAnnuel/voirFacturAnnuel?idEnf="+idEnf;	
		//choisirClubs(model,idEnf);

	}
	
	
	

	@RequestMapping("/choisirClubspaiem")
	public String choisirClubspaiem(Model model, Long idEnf) {

		// Traittements Clubs

		List<Club> listClubEnfant = metier.listClubs();

		// //////////////

		List<PlanningHorraires> listPlanningEnfant = metier
				.listPlanningHorraires();

		model.addAttribute("listPlanningEnfant", listPlanningEnfant);

		model.addAttribute("listClubEnfant", listClubEnfant);

		model.addAttribute("enfant", metier.getEnfant(idEnf));
		
		
		Date da = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		String year = df.format(da);		
		

		Creche crecheAnnee=metier.getCreche(year);
		
		
		model.addAttribute("crecheAnnee", crecheAnnee);
		

		//traitement clubs
		
		
		List<ClubEnfant> listClubActifsEnfant = metier
				.ListClubActifsEnfant(idEnf);

		List<Long> listIdClubActifEnfantA = new ArrayList<Long>(
				listClubActifsEnfant.size());

		for (int k = 0; k < listClubActifsEnfant.size(); k++) {
			listIdClubActifEnfantA.add(k, listClubActifsEnfant.get(k).getClub()
					.getIdClub());

		}
		
		//traitement Planning

		List<PlanningEnfant> listPlanningActifsEnfant = metier.ListPlanningActifsEnfant(idEnf);

		List<Long> listIdPlanningActifEnfantA = new ArrayList<Long>(
				listPlanningActifsEnfant.size());

		for (int d = 0; d < listPlanningActifsEnfant.size(); d++) {
			listIdPlanningActifEnfantA.add(d, listPlanningActifsEnfant.get(d).getPlanningHorraires()
					.getIdPlanningH());

		}
		
		
		

		model.addAttribute("listIdClubActifEnfantA", listIdClubActifEnfantA);
		
		model.addAttribute("listIdPlanningActifEnfantA", listIdPlanningActifEnfantA);

		return "affectEnfantPaiementClubPlanning";

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
		
	
		Long idClass = metier.ajouterClasse(cla);
		
		model.addAttribute("classeAjoute",metier.getClasse(idClass));
		
		model.addAttribute("classe", new Classe());
		
		
		
	
	return "affectEnfantPaiementClubPlanning";
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
