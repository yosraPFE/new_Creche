/*package org.gestion.cr.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.commons.io.IOUtils;
import org.gestion.cr.entities.Creche;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/adminCr")
public class CrecheListeAdminController implements HandlerExceptionResolver 
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
/*
	@Autowired
	private IAdminMetier metier;

	

	// index
	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("creche", new Creche());
		model.addAttribute("creches", metier.listCreches());
		return "crechesListe";

	}

	@RequestMapping(value = "/validerModificationCrech")
	public String validerModificationCrech(@Valid Creche crech,
			BindingResult bindingResult, Model model, MultipartFile file)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			model.addAttribute("creches", metier.listCreches());
			return ("crechesListe");
		}
		Long ref = crech.getId();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			referrerAffiliateId = Long.toString(ref);
			if (file.isEmpty()) 
			{
				//Creche creche = metier.getCreche(crech.getIdCreche());
				crech.setNomPhoto(creche.getNomPhoto());
			} 
			else 
			{
				String path = "C:/Users/YOSRA/Desktop/PFE/ImagesCreches";
				file.transferTo(new File(path + "/" + "CRECH_"
						+ crech.getIdCreche() + "_"
						+ file.getOriginalFilename()));
				crech.setNomPhoto(path + "/" + "CRECH_"
						+ crech.getIdCreche() + "_"
						+ file.getOriginalFilename());
			}
			metier.modifierCreche(crech);
			model.addAttribute("creche", new Creche());
			model.addAttribute("creches", metier.listCreches());
		}
		return "crechesListe";
	}

	@RequestMapping(value = "/modifierListeCreche")
	public String modifierListeCreche(Long idCreche, Model model) {
		Creche crech = metier.getCreche(idCreche);
		model.addAttribute("creche", crech);

		model.addAttribute("creches", metier.listCreches());

		return "crechesListe";
	}

	// photo
	@RequestMapping(value = "photoCrech", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoCrech(Long idCreche) throws IOException {
		Creche crech = metier.getCreche(idCreche);
		File f = new File(crech.getNomPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));
	}

	@RequestMapping(value = "/supprimerListeCreche")
	public String supprimerListeCreche(Long idCreche,
			Model model) {

	
		metier.supprimerCreche(idCreche);
		model.addAttribute("creche", new Creche());
		model.addAttribute("creches", metier.listCreches());

		return "crechesListe";
	}

	

	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("creche", new Creche());
		mv.addObject("creches", metier.listCreches());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("crechesListe");
		return mv;
	}


}*/
