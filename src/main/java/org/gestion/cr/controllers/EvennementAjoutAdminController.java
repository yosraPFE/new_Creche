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
@RequestMapping(value="/adminEvenAj")
public class EvennementAjoutAdminController implements HandlerExceptionResolver
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
		model.addAttribute("evennement", new Evenement());
		
		
		return "evennementsAjout";
		
	}
	
	@RequestMapping(value="/ajouterEvennement")
	public String ajouterEvennement(@Valid Evenement even,BindingResult bindingResult,
			Model model) throws IOException
	{
		
		
		
		if(bindingResult.hasErrors())
		{
			model.addAttribute("evennement", new Evenement());
			return("evennementsAjout");
		}
		
		
		Long idEvennementAjoutee = metier.ajouterEvennement(even);
		
		model.addAttribute("evennementAjoute",metier.getEvennement(idEvennementAjoutee));
		
		model.addAttribute("evennement", new Evenement());
		
		
		
	
	return "evennementsAjout";
	}
	
	

    
	@Override
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object arg2, Exception ex) 
	{
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("evennement", new Evenement());
		
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("evennementsAjout");
		
		return mv;
	}

}
