package org.gestion.cr.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.gestion.cr.entities.TypeMateriels;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/adminTypM")
public class TypeMaterielsListeAdminController implements HandlerExceptionResolver 
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
		model.addAttribute("typeMateriel", new TypeMateriels());
		model.addAttribute("typeMateriels", metier.listTypeMateriels());
		
		
		return "typeMaterielsListe";

	}

	@RequestMapping(value = "/validerModificationtypeMat")
	public String validerModificationtypeMat(@Valid TypeMateriels tpMat,
			BindingResult bindingResult, Model model)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			model.addAttribute("typeMateriels", metier.listTypeMateriels());
			return ("typeMaterielsListe");
		}
		Long ref = tpMat.getIdTypeMateriels();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			referrerAffiliateId = Long.toString(ref);
			
			
			metier.modifierTypeMateriels(tpMat);
			model.addAttribute("typeMateriel", new TypeMateriels());
			model.addAttribute("typeMateriels", metier.listTypeMateriels());
		}
		return "typeMaterielsListe";
	}

	@RequestMapping(value = "/modifierListeTypeMateriels")
	public String modifierListeTypeMateriels(Long idTypeMateriels, Model model) {
		
		TypeMateriels tpMat = metier.getTypeMateriels(idTypeMateriels);
		model.addAttribute("typeMateriel", tpMat);

		model.addAttribute("typeMateriels", metier.listTypeMateriels());

		return "typeMaterielsListe";
	}

	

	@RequestMapping(value = "/supprimerListeTypeMateriels")
	public String supprimerListeTypeMateriels(Long idTypeMateriels,
			Model model) {

		
		metier.supprimerTypeMateriels(idTypeMateriels);
		model.addAttribute("typeMateriel", new TypeMateriels());
		model.addAttribute("typeMateriels", metier.listTypeMateriels());

		return "typeMaterielsListe";
	}

	

	

	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("typeMateriel", new TypeMateriels());
		mv.addObject("typeMateriels", metier.listTypeMateriels());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("typeMaterielsListe");
		return mv;
	}

}
