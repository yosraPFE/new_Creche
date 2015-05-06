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
@RequestMapping(value = "/adminStoc")
public class StocksListeAdminController implements HandlerExceptionResolver 
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
		model.addAttribute("stock", new Stock());
		
		
		model.addAttribute("stocks", metier.listStock());
		return "stocksListe";

	}

	@RequestMapping(value = "/validerModificationStoc")
	public String validerModificationStoc(@Valid Stock stoc,
			BindingResult bindingResult, Model model)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			model.addAttribute("stocks", metier.listStock());
			return ("stocksListe");
		}
		Long ref = stoc.getIdStock();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			referrerAffiliateId = Long.toString(ref);
			
			
			metier.modifierStock(stoc);
			model.addAttribute("stock", new Stock());
			model.addAttribute("stocks", metier.listStock());
		}
		return "stocksListe";
	}

	@RequestMapping(value = "/modifierListeStock")
	public String modifierListeStock(Long idStock, Model model) {
		
		Stock stoc = metier.getStock(idStock);
		model.addAttribute("stock", stoc);

		model.addAttribute("stocks", metier.listStock());

		return "stocksListe";
	}

	

	@RequestMapping(value = "/supprimerListeStock")
	public String supprimerListeStock(Long idStock,
			Model model) {

		
		metier.supprimerStock(idStock);
		model.addAttribute("stock", new Stock());
		model.addAttribute("stocks", metier.listStock());

		return "stocksListe";
	}

	


	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("stock", new Stock());
		mv.addObject("stocks", metier.listStock());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("stocksListe");
		return mv;
	}

}
