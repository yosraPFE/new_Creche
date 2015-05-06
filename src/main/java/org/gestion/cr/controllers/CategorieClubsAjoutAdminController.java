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
@RequestMapping(value="/adminCateg")
public class CategorieClubsAjoutAdminController implements HandlerExceptionResolver
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
		model.addAttribute("categorieClub", new CategorieClub());
		
		
		return "categorieClubsAjout";
		
	}
	
	@RequestMapping(value="/ajouterCategorieClub")
	public String ajouterCategorieClub(@Valid CategorieClub categ,BindingResult bindingResult,
			Model model) throws IOException
	{
		
		
		
		if(bindingResult.hasErrors())
		{
			model.addAttribute("categorieClub", new CategorieClub());
			return("categorieClubsAjout");
		}
		
		
		Long idCategorieClubAjoutee = metier.ajouterCategorieClub(categ);
		
		model.addAttribute("categorieClubAjoute",metier.getCategorieClub(idCategorieClubAjoutee));
		
		model.addAttribute("categorieClub", new CategorieClub());
		
		
		
	
	return "categorieClubsAjout";
	}
	
	

    
	@Override
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object arg2, Exception ex) 
	{
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("categorieClub", new CategorieClub());
		
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("categorieClubsAjout");
		
		return mv;
	}


}
