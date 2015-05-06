package org.gestion.cr.controllers;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.commons.io.IOUtils;
import org.gestion.cr.entities.Fournisseur;
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
@RequestMapping(value = "/adminFou")
public class FournisseurListeAdminController implements HandlerExceptionResolver


{
	@Autowired
	private IAdminMetier metier;

	
	
	


	// index
	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("fournisseur", new Fournisseur());
		
		model.addAttribute("fournisseurs", metier.listFournisseurs());
		return "fournisseursListe";

	}

	@RequestMapping(value = "/validerModificationFourn")
	public String validerModificationFourn(@Valid Fournisseur four,
			BindingResult bindingResult, Model model, MultipartFile file)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			model.addAttribute("fournisseurs", metier.listFournisseurs());
			return ("fournisseursListe");
		}
		Long ref = four.getIdPerson();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			referrerAffiliateId = Long.toString(ref);
			if (file.isEmpty()) 
			{
				Fournisseur fourn = metier.getFournisseur(four
						.getIdPerson());
				four.setNomPhoto(fourn.getNomPhoto());
			} 
			else 
			{
				String path = "C:/Users/YOSRA/Desktop/PFE/ImagesFournisseurs";
				file.transferTo(new File(path + "/" + "FOURNISSEUR_"
						+ four.getIdPerson() + "_"
						+ file.getOriginalFilename()));
				four.setNomPhoto(path + "/" + "FOURNISSEUR_"
						+ four.getIdPerson() + "_"
						+ file.getOriginalFilename());
			}
			metier.modifierFournisseur(four);
			model.addAttribute("fournisseur", new Fournisseur());
			model.addAttribute("fournisseurs", metier.listFournisseurs());
		}
		return "fournisseursListe";
	}

	@RequestMapping(value = "/modifierListeFournisseur")
	public String modifierListeFournisseur(Long idFournisseur, Model model) {
		Fournisseur four = metier.getFournisseur(idFournisseur);
		model.addAttribute("fournisseur", four);

		model.addAttribute("fournisseurs", metier.listFournisseurs());

		return "fournisseursListe";
	}

	// photo
	@RequestMapping(value = "photoFourn", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoFourn(Long idFournisseur) throws IOException {
		Fournisseur four = metier.getFournisseur(idFournisseur);
		File f = new File(four.getNomPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));
	}

	@RequestMapping(value = "/supprimerListeFournisseur")
	public String supprimerListeFournisseur(Long idFournisseur,
			Model model) {

		
		metier.supprimerFournisseur(idFournisseur);
		model.addAttribute("fournisseur", new Fournisseur());
		model.addAttribute("fournisseurs", metier.listFournisseurs());

		return "fournisseursListe";
	}

	

	

	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("fournisseur", new Fournisseur());
		mv.addObject("fournisseurs", metier.listFournisseurs());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("fournisseursListe");
		return mv;
	}


}
