package org.gestion.cr.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.gestion.cr.entities.ClubEnfant;
import org.gestion.cr.entities.Creche;
import org.gestion.cr.entities.Payment;
import org.gestion.cr.entities.PlanningEnfant;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/adminPay")
public class PaymentController {
	
	@Autowired
	private IAdminMetier metier;

	@RequestMapping("/loadPayments")
	public String loadPayments(Model model, Long idEnf) {
		
		
		//avoir String date mois-annee
		Date dp = new Date();
		SimpleDateFormat ymF = new SimpleDateFormat("yyyy-MM");
		String yearMounthString = ymF.format(dp);
		
		Payment paymentMoisEnCours = metier.getPayementMoisCourant(idEnf, yearMounthString);
		
		
		if(paymentMoisEnCours == null){
			System.out.println("si pas de payment pour cet mois --> creer un paiment");
			// si pas de payment pour cet mois --> creer un paiment
			
					//avoir String date mois-annee
					Date da = new Date();
					SimpleDateFormat df = new SimpleDateFormat("yyyy");
					String year = df.format(da);
					//avoir le dernier payment de l'enfant pour avoir le remise
					List<Payment> listDesPaymentPourEnf = metier.listPaymentEnfant(idEnf);
					Payment dernierPayment = listDesPaymentPourEnf.get(listDesPaymentPourEnf.size()-1);
					float remise = dernierPayment.getRemise();
					
					//Tarif : list de club Actif pour enfant
					double sommeTarifClub = 0;
					List<ClubEnfant> listClubActifsEnfant = metier.ListClubActifsEnfant(idEnf);				
					for (int k = 0; k < listClubActifsEnfant.size(); k++) {
						sommeTarifClub += listClubActifsEnfant.get(k).getClub().getCategorieClub().getPrix();					
					}
					
					//Tarif : list Planing Actif Enfant
					double sommeTarifPlanning = 0;
					List<PlanningEnfant> listPlanningActifsEnfant = metier.ListPlanningActifsEnfant(idEnf);
					for (int d = 0; d < listPlanningActifsEnfant.size(); d++) {					
						sommeTarifPlanning += listPlanningActifsEnfant.get(d).getPlanningHorraires().getPrixPlanning();					
					}
					
					// Tarif : mois creche
					Creche crecheAnnee = metier.getCreche(year);
					
					double montantAvantRemise = sommeTarifClub + sommeTarifPlanning + crecheAnnee.getTarifParMois();
					
					
					double somme = montantAvantRemise - montantAvantRemise * (remise / 100);
					
					
					// construire un payment
					Payment newPayment = new Payment();
					//newPayment.setDatePayement(yearMounthDay);
					newPayment.setRemise(remise);
					newPayment.setMontantAvantRemise(montantAvantRemise);
					newPayment.setMontantApresRemise(somme);
					newPayment.setNaturePayement("mensuel");
					newPayment.setTypePayement("espece");
					newPayment.setNumeroFacture(1);
			
			metier.ajouterPayment(newPayment, idEnf, yearMounthString);
			
			
		}else if (paymentMoisEnCours.getDatePayement() != null){
			System.out.println("paiment de cet mois payé --> creer ou non le payment du mois suivant");
			// paiment de cet mois payé --> creer ou non le payment du mois suivant
			String nextYearMounthString = null;
			String[] yearMounthStringTab = yearMounthString.split("-");
			int monthToIncrement = Integer.parseInt(yearMounthStringTab[1]);
			int yearToIncrement = Integer.parseInt(yearMounthStringTab[0]);
			
			if (monthToIncrement == 12){				
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
			if(prochainPayment == null){
				System.out.println("prochain payment n'existe pas --> creer payment pour moi suivant");
				//prochain payment n'existe pas --> creer payment pour moi suivant
				
						//avoir String date mois-annee
						Date da = new Date();
						SimpleDateFormat df = new SimpleDateFormat("yyyy");
						String year = df.format(da);
						
						//avoir le dernier payment de l'enfant pour avoir le remise
						List<Payment> listDesPaymentPourEnf = metier.listPaymentEnfant(idEnf);
						Payment dernierPayment = listDesPaymentPourEnf.get(listDesPaymentPourEnf.size()-1);
						float remise = dernierPayment.getRemise();
						
						//Tarif : list de club Actif pour enfant
						double sommeTarifClub = 0;
						List<ClubEnfant> listClubActifsEnfant = metier.ListClubActifsEnfant(idEnf);				
						for (int k = 0; k < listClubActifsEnfant.size(); k++) {
							sommeTarifClub += listClubActifsEnfant.get(k).getClub().getCategorieClub().getPrix();					
						}
						
						//Tarif : list Planing Actif Enfant
						double sommeTarifPlanning = 0;
						List<PlanningEnfant> listPlanningActifsEnfant = metier.ListPlanningActifsEnfant(idEnf);
						for (int d = 0; d < listPlanningActifsEnfant.size(); d++) {					
							sommeTarifPlanning += listPlanningActifsEnfant.get(d).getPlanningHorraires().getPrixPlanning();					
						}
						
						// Tarif : mois creche
						Creche crecheAnnee = metier.getCreche(year);
						
						double montantAvantRemise = sommeTarifClub + sommeTarifPlanning + crecheAnnee.getTarifParMois();
						
						
						double somme = montantAvantRemise - montantAvantRemise * (remise / 100);
						
						
						// construire un payment
						Payment newPayment = new Payment();
						//newPayment.setDatePayement(yearMounthDay);
						newPayment.setRemise(remise);
						newPayment.setMontantAvantRemise(montantAvantRemise);
						newPayment.setMontantApresRemise(somme);
						newPayment.setNaturePayement("mensuel");
						newPayment.setTypePayement("espece");
						newPayment.setNumeroFacture(1);
						
			metier.ajouterPayment(newPayment, idEnf, nextYearMounthString);
			
			}
				
			
		}



		
		model.addAttribute("listPayments", metier.listPaymentEnfant(idEnf));		
		model.addAttribute("enfant", metier.getEnfant(idEnf));	
		
		return "paymentPourEnfantList";
		
}
	
	
	@RequestMapping("/doPayments")
	public String doPayments(Model model, Long idEnf,String mois, double montantApresRemiseHidden,float remise) throws ParseException {

		
		// avoir le paiment a payer
		Payment paymentAPayer = metier.getPayementMoisCourant(idEnf, mois);
		
		//creation date de paiement
		Date dp = new Date();
		SimpleDateFormat ymjF = new SimpleDateFormat("yyyy-MM-dd");
		String yearMounthDayString = ymjF.format(dp);
		Date yearMounthDay = ymjF.parse(yearMounthDayString);
		
		
		paymentAPayer.setDatePayement(yearMounthDay);
		paymentAPayer.setRemise(remise);
		paymentAPayer.setMontantApresRemise(montantApresRemiseHidden);
		
		metier.modifierPayment(paymentAPayer);
		
		return "redirect:/factMensuel/voirFacturMens?idEnf="+idEnf;
	}
	
}
