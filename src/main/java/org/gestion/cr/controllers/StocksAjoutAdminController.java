package org.gestion.cr.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.gestion.cr.entities.Stock;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/adminStocAj")
public class StocksAjoutAdminController implements HandlerExceptionResolver
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
		model.addAttribute("stock", new Stock());
		
		
		return "stocksAjout";
		
	}
	
	@RequestMapping(value="/ajouterStock")
	public String ajouterStock(@Valid Stock stoc,BindingResult bindingResult,
			Model model) throws IOException
	{
		
		
		
		if(bindingResult.hasErrors())
		{
			model.addAttribute("stock", new Stock());
			return("stocksAjout");
		}
		
		
		Long idStockAjoutee = metier.ajouterStock(stoc);
		
		model.addAttribute("stockAjoute",metier.getStock(idStockAjoutee));
		
		model.addAttribute("stock", new Stock());
	
	return "stocksAjout";
	}
	
	

    
	@Override
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object arg2, Exception ex) 
	{
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("stock", new Stock());
		
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("stocksAjout");
		
		return mv;
	}

}
