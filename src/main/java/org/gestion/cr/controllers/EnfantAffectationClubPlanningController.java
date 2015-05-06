package org.gestion.cr.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/club")
public class EnfantAffectationClubPlanningController {

	@Autowired
	private IAdminMetier metier;

	@RequestMapping("/affecterEnfantAClub")
	public String affecterEnfantAClub(Long idEnf, String checkedClubs,
			String checkedPlanning, float remise,double somme,Model model) throws ParseException {
		
		
		
		//recherche de l'inscription
				Date dai = new Date();
				SimpleDateFormat dfi = new SimpleDateFormat("yyyy");
				String yeari = dfi.format(dai);		
				

				Inscription derniereInscription=metier.getInscriptionEnfAnnee(idEnf, yeari);
			//	derniereInscription.setRemise(remise);
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
		
		//avoir String date mois-annee
		Date dp = new Date();
		SimpleDateFormat ymF = new SimpleDateFormat("yyyy-MM");
		String yearMounthString = ymF.format(dp);
		
		
		
		
		
		
		//calcul montant avant remise
		double montantAvantRemise = somme / (1-(remise/100));
		montantAvantRemise = Math.round(montantAvantRemise*1000)/1000;
		// construire un payment
		Payment newPayment = new Payment();
		//newPayment.setDatePayement(yearMounthDay);
		newPayment.setRemise(remise);
		newPayment.setMontantAvantRemise(montantAvantRemise);
		newPayment.setMontantApresRemise(somme);
		newPayment.setNaturePayement("mensuel");
		newPayment.setTypePayement("espece");
		newPayment.setNumeroFacture(1);
		
		
		//avoir le dernier payment du mois en cours
		Payment dernierPayment = metier.getPayementMoisCourant(idEnf, yearMounthString);
		
		if( dernierPayment == null){
			System.out.println("pas de paiement creer cet mois");
			//pas de paiement creer cet mois
			metier.ajouterPayment(newPayment, idEnf, yearMounthString);
			
		}else if (dernierPayment.getDatePayement() == null){
			System.out.println("payment creer non paye --> mise à jour");
			//payment creer non paye --> mise à jour
			newPayment.setEnfant(metier.getEnfant(idEnf));
			newPayment.setMoisPayment(yearMounthString);			
			metier.modifierPayment(newPayment);
			
			
		}else{
			System.out.println("payment cree et payé --> creer le payment du mois suivant");
			//payment cree et payé --> creer le payment du mois suivant
			
			//construction du mois suivant
			String nextYearMounthString = null;
			String[] yearMounthStringTab = yearMounthString.split("-");
			int monthToIncrement = Integer.parseInt(yearMounthStringTab[1]);
			int yearToIncrement = Integer.parseInt(yearMounthStringTab[0]);
			if (monthToIncrement==12){
				
				monthToIncrement = 1;
				yearToIncrement ++;
			}else{
				
				monthToIncrement ++;
			}
			
			if(monthToIncrement>9){
				nextYearMounthString = yearToIncrement + "-" + monthToIncrement ;
			}else{
				nextYearMounthString = yearToIncrement + "-0" + monthToIncrement ;
			}
			//avoir le payment du mois suivant
			Payment prochainPayment = metier.getPayementMoisCourant(idEnf, nextYearMounthString);
			if( prochainPayment == null){
				//prochain payment n'existe pas
				metier.ajouterPayment(newPayment, idEnf, nextYearMounthString);	
			}else{
				newPayment.setEnfant(metier.getEnfant(idEnf));
				newPayment.setMoisPayment(nextYearMounthString);			
				metier.modifierPayment(newPayment);
				
			}
				
			
		}
		

		return "redirect:choisirClubs?idEnf="+idEnf;

	}
	
	
	

	@RequestMapping("/choisirClubs")
	public String choisirClubs(Model model, Long idEnf) {

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
		
		//avoir le dernier payment de l'enfant pour avoir le remise
		List<Payment> listDesPaymentPourEnf = metier.listPaymentEnfant(idEnf);
		Payment dernierPayment = listDesPaymentPourEnf.get(listDesPaymentPourEnf.size()-1);
		model.addAttribute("dernierPayment", dernierPayment);
		
		//avoir l'etat de la creche cette annee pour avoir le tarif par mois
		Creche crecheAnnee = metier.getCreche(year); 
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

		return "affectEnfantClubPlanning";

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
