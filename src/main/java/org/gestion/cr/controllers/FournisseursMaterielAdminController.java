package org.gestion.cr.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.gestion.cr.entities.EquipeEducatif;
import org.gestion.cr.entities.EquipeSanitaire;
import org.gestion.cr.entities.Materiel;
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
@RequestMapping(value = "/adminFouurMater")
public class FournisseursMaterielAdminController implements HandlerExceptionResolver
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
		
		model.addAttribute("stocks",metier.listStock());
		model.addAttribute("typeMateriels",metier.listTypeMateriels());
		
		model.addAttribute("materiel", new Materiel());
		model.addAttribute("materiels", metier.listMateriels());
		
		return "MaterielFournisseurs";

	}

	@RequestMapping(value = "/validerModificationMateriel")
	public String validerModificationMateriel(@Valid Materiel mat,
			BindingResult bindingResult, Model model)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			model.addAttribute("materiels", metier.listMateriels());
			return ("MaterielFournisseurs");
		}
		Long ref = mat.getIdMateriel();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			referrerAffiliateId = Long.toString(ref);
			
			model.addAttribute("stocks",metier.listStock());
			model.addAttribute("typeMateriels",metier.listTypeMateriels());
			metier.modifierMateriels(mat);
			model.addAttribute("materiel", new Materiel());
			model.addAttribute("materiels", metier.listMateriels());
		}
		return "MaterielFournisseurs";
	}

	@RequestMapping(value = "/modifierListeMateriels")
	public String modifierListeMateriels(Long idMat, Model model) {
		
		model.addAttribute("stocks",metier.listStock());
		model.addAttribute("typeMateriels",metier.listTypeMateriels());
		
		Materiel mat = metier.getMateriels(idMat);
		model.addAttribute("materiel", mat);

		model.addAttribute("materiels", metier.listMateriels());
		return "MaterielFournisseurs";
	}

	

	@RequestMapping(value = "/supprimerListeMateriels")
	public String supprimerListeMateriels(Long idMat,
			Model model) {

		model.addAttribute("materiels", metier.listMateriels());
		model.addAttribute("stocks",metier.listStock());
		model.addAttribute("typeMateriels",metier.listTypeMateriels());
		
		metier.supprimerMateriels(idMat);
		model.addAttribute("materiel", new Materiel());
		model.addAttribute("materiels", metier.listMateriels());

		return "MaterielFournisseurs";
	}

	

	
	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("materiel", new Materiel());
		mv.addObject("materiels", metier.listMateriels());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("MaterielFournisseurs");
		return mv;
	}

}
