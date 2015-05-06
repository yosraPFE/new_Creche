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
@RequestMapping(value="/adminClub")
public class ClubsAjoutAdminController implements HandlerExceptionResolver
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
		model.addAttribute("CategorieClubs",metier.listCategorieClubs());
		
		
		model.addAttribute("club", new Club());
		
		
		return "clubsAjout";
		
	}
	
	
	
	@RequestMapping(value="/ajouterClub")
	public String ajouterClub(@Valid Club club,BindingResult bindingResult,
			Model model) throws IOException
	{
		
		
		
		if(bindingResult.hasErrors())
		{
			model.addAttribute("CategorieClubs",metier.listCategorieClubs());
			
			model.addAttribute("club", new Club());
			return("clubsAjout");
		}
		
		
		
		model.addAttribute("CategorieClubs",metier.listCategorieClubs());
	
		
		
		Long idClubs = metier.ajouterClubs(club, club.getCategorieClub().getIdCategorie());
		
		model.addAttribute("clubAjoute",metier.getClubs(idClubs));
		
		model.addAttribute("club", new Club());
		
	
	return "clubsAjout";
	}
	
	

    
	@Override
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object arg2, Exception ex) 
	{
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("club", new Club());
		
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("clubsAjout");
		
		return mv;
	}

}
