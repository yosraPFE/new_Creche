package org.gestion.cr.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.gestion.cr.entities.Inscription;
import org.gestion.cr.entities.InscriptionId;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/adminInsc")
public class InscriptionsListeAdminController implements HandlerExceptionResolver
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	private int page = 0;
	private int nbrLignesInscriptions = 5;
	private int nbrPages;

	@Autowired
	private IAdminMetier metier;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}


	public int getNbrLignesInscriptions() {
		return nbrLignesInscriptions;
	}

	public void setNbrLignesInscriptions(int nbrLignesInscriptions) {
		this.nbrLignesInscriptions = nbrLignesInscriptions;
	}

	public int getNbrPages() {
		return nbrPages;
	}

	public void setNbrPages(int nbrPages) {
		this.nbrPages = nbrPages;
	}
	

	// index
	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("inscription", new Inscription());
		chargerModel(model);
		return "inscriptionsListe";

	}

	@RequestMapping(value = "/validerModificationInscr")
	public String validerModificationInscr(@Valid Inscription insc,
			BindingResult bindingResult, Model model)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			chargerModel(model);
			return ("inscriptionsListe");
		}
		//long ref = insc.getId();
		String referrerAffiliateId = null;
		//if (ref != null) 
		{
			//referrerAffiliateId = Long.toString(ref);
			
			
			//metier.modifierInscriptions(insc);
			model.addAttribute("inscription", new Inscription());
			chargerModel(model);
		}
		return "inscriptionsListe";
	}

	@RequestMapping(value = "/modifierListeInscription")
	public String modifierListeInscription(Long idInscription, Model model) {
		
	//	Inscription insc = metier.getInscription(idInscription);
		//model.addAttribute("inscription", insc);

		chargerModel(model);

		return "inscriptionsListe";
	}

	

	@RequestMapping(value = "/supprimerListeInscription")
	public String supprimerListeInscription(Long idInscription,
			Model model) {

		setPage(page);
		//metier.supprimerInscriptions(idInscription);
		model.addAttribute("inscription", new Inscription());
		chargerModel(model);

		return "inscriptionsListe";
	}

	@RequestMapping(value = "chargerModel")
	public void chargerModel(Model model) {

		int pos = getNbrLignesInscriptions() * getPage();
		long nbAc = metier.getNombreInscriptions();
		setNbrPages((int) (nbAc / getNbrLignesInscriptions()) + 1);

		model.addAttribute("nbrPages", getNbrPages());
		model.addAttribute("page", getPage());
		model.addAttribute("inscriptions",
				metier.listInscriptions(pos, getNbrLignesInscriptions()));

	}

	@RequestMapping(value = "/indexPage")
	public String changerPage(Model model, int page) {
		setPage(page);
		model.addAttribute("inscription", new Inscription());
		chargerModel(model);
		return "inscriptionsListe";
	}

	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("inscription", new Inscription());
		mv.addObject("inscriptions", metier.listInscriptions(0, 5));
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("inscriptionsListe");
		return mv;
	}


}
