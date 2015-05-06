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
@RequestMapping(value="/adminClas")
public class ClasseAjoutAdminController implements HandlerExceptionResolver
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
		
		model.addAttribute("classe", new Classe());
		
		
		return "classesAjout";
		
		
		
	}
	
	@RequestMapping(value="/ajouterClasse")
	public String ajouterClasse(@Valid Classe cla,BindingResult bindingResult,
			Model model) throws IOException
	{
		
		
		
		if(bindingResult.hasErrors())
		{
			
			model.addAttribute("classe", new Classe());
			return("classesAjout");
		}
		
	
		Long idClass = metier.ajouterClasse(cla);
		
		model.addAttribute("classeAjoute",metier.getClasse(idClass));
		
		model.addAttribute("classe", new Classe());
		
		
		
	
	return "classesAjout";
	}
	
	
	
	
	

    
	@Override
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object arg2, Exception ex) 
	{
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("classe", new Classe());
		
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("Classe");
		
		return mv;
	}

}
