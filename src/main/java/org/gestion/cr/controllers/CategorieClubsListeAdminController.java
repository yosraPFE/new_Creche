package org.gestion.cr.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.gestion.cr.entities.CategorieClub;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/adminCategC")
public class CategorieClubsListeAdminController implements HandlerExceptionResolver 
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
		model.addAttribute("categorieClub", new CategorieClub());
		
		model.addAttribute("CategorieClubs", metier.listCategorieClubs());
		return "categoriesClubsListe";

	}

	@RequestMapping(value = "/validerModificationCateg")
	public String validerModificationCateg(@Valid CategorieClub categ,
			BindingResult bindingResult, Model model)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			model.addAttribute("CategorieClubs", metier.listCategorieClubs());
			return ("categoriesClubsListe");
		}
		Long ref = categ.getIdCategorie();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			referrerAffiliateId = Long.toString(ref);
			
			
			metier.modifierCategorieClub(categ);
			model.addAttribute("categorieClub", new CategorieClub());
			model.addAttribute("CategorieClubs", metier.listCategorieClubs());
		}
		return "categoriesClubsListe";
	}

	@RequestMapping(value = "/modifierListeCategorieClub")
	public String modifierListeCategorieClub(Long idCategorieClub, Model model) {
		
		CategorieClub categ = metier.getCategorieClub(idCategorieClub);
		model.addAttribute("categorieClub", categ);

		model.addAttribute("CategorieClubs", metier.listCategorieClubs());

		return "categoriesClubsListe";
	}

	

	@RequestMapping(value = "/supprimerListeCategorieClub")
	public String supprimerListeCategorieClub(Long idCategorieClub,
			Model model) {

		
		metier.supprimerCategorieClub(idCategorieClub);
		model.addAttribute("categorieClub", new CategorieClub());
		model.addAttribute("CategorieClubs", metier.listCategorieClubs());

		return "categoriesClubsListe";
	}


	
	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("categorieClub", new CategorieClub());
		mv.addObject("CategorieClubs", metier.listCategorieClubs());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("categoriesClubsListe");
		return mv;
	}

}
