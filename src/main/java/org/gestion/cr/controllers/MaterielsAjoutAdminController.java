package org.gestion.cr.controllers;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.gestion.cr.entities.Materiel;

import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/adminMater")
public class MaterielsAjoutAdminController implements HandlerExceptionResolver
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
		model.addAttribute("stocks",metier.listStock());
		model.addAttribute("typeMateriels",metier.listTypeMateriels());
		
		model.addAttribute("materiel", new Materiel());
		
		
		return "materielsAjout";
		
	}
	
	
	
	@RequestMapping(value="/ajouterMateriel")
	public String ajouterMateriel(@Valid Materiel mat,BindingResult bindingResult,
			Model model) throws IOException
	{
		
		
		
		if(bindingResult.hasErrors())
		{
			model.addAttribute("stocks",metier.listStock());
			model.addAttribute("typeMateriels",metier.listTypeMateriels());
			
			model.addAttribute("materiel", new Materiel());
			return("materielsAjout");
		}
		
		model.addAttribute("stocks",metier.listStock());
		model.addAttribute("typeMateriels",metier.listTypeMateriels());
		
		Long idMateriels = metier.ajouterMateriels(mat, mat.getStock().getIdStock(), mat.getTypeMateriels().getIdTypeMateriels());
		
		model.addAttribute("materielAjoute",metier.getMateriels(idMateriels));
		
		model.addAttribute("materiel", new Materiel());
		
	
	return "materielsAjout";
	}
	
	

    
	@Override
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object arg2, Exception ex) 
	{
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("materiel", new Materiel());
		
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("materielsAjout");
		
		return mv;
	}


}
