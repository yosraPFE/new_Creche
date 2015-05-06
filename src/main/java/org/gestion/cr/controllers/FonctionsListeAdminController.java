package org.gestion.cr.controllers;


import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.gestion.cr.entities.Fonction;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/adminFonc")
public class FonctionsListeAdminController implements HandlerExceptionResolver 
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
		model.addAttribute("fonction", new Fonction());
		model.addAttribute("fonctions", metier.listFonctions());
		
		model.addAttribute("fonctions", metier.listFonctions());
		return "fonctionsListe";

	}

	@RequestMapping(value = "/validerModificationFonct")
	public String validerModificationFonct(@Valid Fonction fonc,
			BindingResult bindingResult, Model model)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			model.addAttribute("fonctions", metier.listFonctions());
			return ("fonctionsListe");
		}
		Long ref = fonc.getIdFonction();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			referrerAffiliateId = Long.toString(ref);
			
			
			metier.modifierFonction(fonc);
			model.addAttribute("fonction", new Fonction());
			model.addAttribute("fonctions", metier.listFonctions());
		}
		return "fonctionsListe";
	}

	@RequestMapping(value = "/modifierListeFonction")
	public String modifierListeFonction(Long idFonction, Model model) {
		
		Fonction fonc = metier.getFonction(idFonction);
		model.addAttribute("fonction", fonc);

		model.addAttribute("fonctions", metier.listFonctions());

		return "fonctionsListe";
	}

	

	@RequestMapping(value = "/supprimerListeFonction")
	public String supprimerListeFonction(Long idFonction,
			Model model) {

		
		metier.supprimerFonction(idFonction);
		model.addAttribute("fonction", new Fonction());
		model.addAttribute("fonctions", metier.listFonctions());

		return "fonctionsListe";
	}

	


	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("fonction", new Fonction());
		mv.addObject("fonctions", metier.listFonctions());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("fonctionsListe");
		return mv;
	}

}
