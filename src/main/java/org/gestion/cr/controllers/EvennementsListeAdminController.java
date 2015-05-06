package org.gestion.cr.controllers;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.gestion.cr.entities.Evenement;

import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/adminEv")
public class EvennementsListeAdminController implements HandlerExceptionResolver
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
		model.addAttribute("evennement", new Evenement());
		
		model.addAttribute("evennements", metier.listEvennements());
		
		return "evennementsListe";

	}

	@RequestMapping(value = "/validerModificationEven")
	public String validerModificationEven(@Valid Evenement even,
			BindingResult bindingResult, Model model)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			model.addAttribute("evennements", metier.listEvennements());
			return ("evennementsListe");
		}
		Long ref = even.getIdEvenement();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			referrerAffiliateId = Long.toString(ref);
			
			
			metier.modifierEvennements(even);
			model.addAttribute("evennement", new Evenement());
			model.addAttribute("evennements", metier.listEvennements());
		}
		return "evennementsListe";
	}

	@RequestMapping(value = "/modifierListeEvennement")
	public String modifierListeEvennement(Long idEvennement, Model model) {
		
		Evenement even = metier.getEvennement(idEvennement);
		model.addAttribute("evennement", even);

		model.addAttribute("evennements", metier.listEvennements());

		return "evennementsListe";
	}

	

	@RequestMapping(value = "/supprimerListeEvennement")
	public String supprimerListeEvennement(Long idEvennement,
			Model model) {

		
		metier.supprimerEvennements(idEvennement);
		model.addAttribute("evennement", new Evenement());
		model.addAttribute("evennements", metier.listEvennements());

		return "evennementsListe";
	}

	

	

	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("evennement", new Evenement());
		mv.addObject("evennements", metier.listEvennements());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("evennementsListe");
		return mv;
	}


}
