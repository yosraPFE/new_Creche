package org.gestion.cr.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.gestion.cr.entities.PlanningHorraires;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/adminPlanLi")
public class PlanningHorrairesListeAdminController implements HandlerExceptionResolver
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
		
		
		model.addAttribute("planningHorraire", new PlanningHorraires());
		
		model.addAttribute("planningHorraires", metier.listPlanningHorraires());
		
		return "planningHorrairesListe";

	}

	@RequestMapping(value = "/validerModificationPlanHor")
	public String validerModificationPlanHor(@Valid PlanningHorraires plHor,
			BindingResult bindingResult, Model model)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			model.addAttribute("planningHorraires", metier.listPlanningHorraires());
			return ("planningHorrairesListe");
		}
		Long ref = plHor.getIdPlanningH();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			referrerAffiliateId = Long.toString(ref);
		
			metier.modifierPlanningHorraires(plHor);
			model.addAttribute("planningHorraire", new PlanningHorraires());
			model.addAttribute("planningHorraires", metier.listPlanningHorraires());
		}
		return "planningHorrairesListe";
	}

	@RequestMapping(value = "/modifierListePlanningHorraires")
	public String modifierListePlanningHorraires(Long idPlanningHo, Model model) {
		
		
		PlanningHorraires plHor = metier.getPlanningHorraires(idPlanningHo);
		model.addAttribute("planningHorraire", plHor);

		model.addAttribute("planningHorraires", metier.listPlanningHorraires());

		return "planningHorrairesListe";
	}

	

	@RequestMapping(value = "/supprimerListePlanningHorraires")
	public String supprimerListePlanningHorraires(Long idPlanningHo,
			Model model) {

		
		metier.supprimerPlanningHorraires(idPlanningHo);
		model.addAttribute("planningHorraire", new PlanningHorraires());
		model.addAttribute("planningHorraires", metier.listPlanningHorraires());

		return "planningHorrairesListe";
	}

	

	
	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("planningHorraire", new PlanningHorraires());
		mv.addObject("planningHorraires", metier.listPlanningHorraires());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("planningHorrairesListe");
		return mv;
	}


}
