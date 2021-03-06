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
@RequestMapping(value="/adminPlan")
public class PlanningHorrairesAjoutAdminController  implements HandlerExceptionResolver
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	@Autowired
	private IAdminMetier metier;
	
	
	
	@RequestMapping(value="/index")
	public String index(Model model)
	{
	
		model.addAttribute("planningHorraire", new PlanningHorraires());
		
		
		return "planningHorrairesAjout";
		
	}
	
	@RequestMapping(value="/ajouterPlanningHorraire")
	public String ajouterPlanningHorraire(@Valid PlanningHorraires plHo,BindingResult bindingResult,
			Model model) throws IOException
	{
		
		
		
		if(bindingResult.hasErrors())
		{
			
			model.addAttribute("planningHorraire", new PlanningHorraires());
			return("planningHorrairesAjout");
		}
		
		
		Long idPlanningHorraire = metier.ajouterPlanningHorraires(plHo);
		
		model.addAttribute("planningHorraireAjoute",metier.getPlanningHorraires(idPlanningHorraire));
		
		model.addAttribute("planningHorraire", new PlanningHorraires());
		
		
		
	
	return "planningHorrairesAjout";
	}
	
	

    
	@Override
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object arg2, Exception ex) 
	{
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("planningHorraire", new PlanningHorraires());
		
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("planningHorrairesAjout");
		
		return mv;
	}


}
