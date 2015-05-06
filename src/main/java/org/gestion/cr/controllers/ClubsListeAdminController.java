package org.gestion.cr.controllers;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.gestion.cr.entities.Club;

import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/adminClubLi")
public class ClubsListeAdminController implements HandlerExceptionResolver 
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	

	@Autowired
	private IAdminMetier metier;

	
	
	// index
	@RequestMapping(value = "/index")
	public String index(Model model) {
		
		model.addAttribute("CategorieClubs",metier.listCategorieClubs());
		model.addAttribute("inscriptions",metier.listInscriptions());
		
		model.addAttribute("club", new Club());
		model.addAttribute("clubs", metier.listClubs());
		return "clubsListe";

	}

	@RequestMapping(value = "/validerModificationClub")
	public String validerModificationClub(@Valid Club club,
			BindingResult bindingResult, Model model)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			model.addAttribute("clubs", metier.listClubs());
			return ("clubsListe");
		}
		Long ref = club.getIdClub();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			referrerAffiliateId = Long.toString(ref);
			
			model.addAttribute("CategorieClubs",metier.listCategorieClubs());
			model.addAttribute("inscriptions",metier.listInscriptions());
			metier.modifierClubs(club);
			model.addAttribute("club", new Club());
			model.addAttribute("clubs", metier.listClubs());
		}
		return "clubsListe";
	}

	@RequestMapping(value = "/modifierListeClubs")
	public String modifierListeClubs(Long idClubs, Model model) {
		
		model.addAttribute("CategorieClubs",metier.listCategorieClubs());
		model.addAttribute("inscriptions",metier.listInscriptions());
		
		Club club = metier.getClubs(idClubs);
		model.addAttribute("club", club);

		model.addAttribute("clubs", metier.listClubs());

		return "clubsListe";
	}

	

	@RequestMapping(value = "/supprimerListeClubs")
	public String supprimerListeClubs(Long idClubs,
			Model model) {

		
		model.addAttribute("CategorieClubs",metier.listCategorieClubs());
		model.addAttribute("inscriptions",metier.listInscriptions());
		
		metier.supprimerClubs(idClubs);
		model.addAttribute("club", new Club());
		model.addAttribute("clubs", metier.listClubs());

		return "clubsListe";
	}


	

	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("club", new Club());
		mv.addObject("clubs", metier.listClubs());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("clubsListe");
		return mv;
	}


}
