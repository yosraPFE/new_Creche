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
@RequestMapping(value="/admintypAj")
public class TypeMaterielsAjoutAdminController implements HandlerExceptionResolver
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
		model.addAttribute("typeMateriel", new TypeMateriels());
		
		
		return "typeMaterielsAjout";
		
	}
	
	@RequestMapping(value="/ajouterTypeMateriels")
	public String ajouterTypeMateriels(@Valid TypeMateriels typM,BindingResult bindingResult,
			Model model) throws IOException
	{
		
		
		
		if(bindingResult.hasErrors())
		{
			model.addAttribute("typeMateriel", new TypeMateriels());
			return("typeMaterielsAjout");
		}
		
		
		
		Long idTypeMaterielAjoute = metier.ajouterTypeMateriel(typM);
		
		
		model.addAttribute("typeMaterielAjoute",metier.getTypeMateriels(idTypeMaterielAjoute));
		
		model.addAttribute("typeMateriel", new TypeMateriels());
		
		
		
	
	return "typeMaterielsAjout";
	}
	
	

    
	@Override
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object arg2, Exception ex) 
	{
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("typeMateriel", new TypeMateriels());
		
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("typeMaterielsAjout");
		
		return mv;
	}


}
