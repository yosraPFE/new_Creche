package org.gestion.cr.controllers;



import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.gestion.cr.entities.Classe;

import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/adminClasLi")
public class ClasseListeAdminController implements HandlerExceptionResolver 
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
		
		
		model.addAttribute("classe", new Classe());
		
		
		model.addAttribute("classes", metier.listClasse());
		
		return "classesListe";

	}

	@RequestMapping(value = "/validerModificationClas")
	public String validerModificationClas(@Valid Classe cla,
			BindingResult bindingResult, Model model)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			model.addAttribute("classes", metier.listClasse());
			return ("classesListe");
		}
		Long ref = cla.getIdClasse();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			referrerAffiliateId = Long.toString(ref);
			
			
			metier.modifierClasse(cla);
			model.addAttribute("classe", new Classe());
			model.addAttribute("classes", metier.listClasse());
		}
		return "classesListe";
	}

	@RequestMapping(value = "/modifierListeClasse")
	public String modifierListeClasse(Long idClasse, Model model) {
		
		
		Classe cla = metier.getClasse(idClasse);
		model.addAttribute("classe", cla);
		model.addAttribute("classes", metier.listClasse());
		

		return "classesListe";
	}

	

	@RequestMapping(value = "/supprimerListeClasse")
	public String supprimerListeClasse(Long idClasse,
			Model model) {

		
		
		metier.supprimerClasse(idClasse);
		model.addAttribute("classe", new Classe());
		model.addAttribute("classes", metier.listClasse());

		return "classesListe";
	}

	


	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("classe", new Classe());
		mv.addObject("classes", metier.listClasse());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("classesListe");
		return mv;
	}


}
