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
@RequestMapping(value = "/adminSaMater")
public class EquipeSanitaireMaterielAdminController implements HandlerExceptionResolver
{
	/**
	 * 
	 * @author YOSRA
	 */


	@Autowired
	private IAdminMetier metier;

	
	
	
	

	
	// index
	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("fonctions",metier.listFonctions());
		model.addAttribute("equipeSanitaire", new EquipeSanitaire());
		model.addAttribute("equipeSanitaires", metier.listEquipeSanitaires());
		return "EquipeSanitaireMateriel";

	}

	@RequestMapping(value = "/validerModificationEqSan")
	public String validerModificationEqSan(@Valid EquipeSanitaire eqSa,
			BindingResult bindingResult, Model model, MultipartFile file)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			model.addAttribute("equipeSanitaires", metier.listEquipeSanitaires());
			return ("EquipeSanitaireMateriel");
		}
		Long ref = eqSa.getIdPerson();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			System.out.println("1");
			referrerAffiliateId = Long.toString(ref);
			
			if (file.isEmpty()) 
			{			System.out.println("2");
				EquipeSanitaire eqSau = metier.getEquipeSanitaire(eqSa
					.getIdPerson());
				
				eqSa.setNomPhoto(eqSau.getNomPhoto());
			} 
			else 
			{
				System.out.println("3");

				String path = "C:/Users/YOSRA/Desktop/PFE/ImagesEqSanitaires";
				file.transferTo(new File(path + "/" + "EqSANITAIR_"
						+ eqSa.getIdPerson() + "_"
						+ file.getOriginalFilename()));
				eqSa.setNomPhoto(path + "/" + "EqSANITAIR_"
						+ eqSa.getIdPerson() + "_"
						+ file.getOriginalFilename());
			}
			System.out.println(eqSa.getIdPerson());
			metier.modifierEquipeSanitaire(eqSa);
			
			
			
			
			model.addAttribute("fonctions",metier.listFonctions());
			model.addAttribute("equipeSanitaire", new EquipeSanitaire());
			model.addAttribute("equipeSanitaires", metier.listEquipeSanitaires());
		}
		return "EquipeSanitaireMateriel";
	}

	@RequestMapping(value = "/modifierListeEquipeSanitaire")
	public String modifierListeEquipeSanitaire(Long idEquipeSanitaire, Model model) {
		model.addAttribute("fonctions",metier.listFonctions());
		EquipeSanitaire eqSa = metier.getEquipeSanitaire(idEquipeSanitaire);
		model.addAttribute("equipeSanitaire", eqSa);

		model.addAttribute("equipeSanitaires", metier.listEquipeSanitaires());

		return "EquipeSanitaireMateriel";
	}

	// photo
	@RequestMapping(value = "photoEqSan", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoEqSan(Long idEquipeSanitaire) throws IOException {
		EquipeSanitaire eqSa = metier.getEquipeSanitaire(idEquipeSanitaire);
		File f = new File(eqSa.getNomPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));
	}

	@RequestMapping(value = "/supprimerListeEquipeSanitaire")
	public String supprimerListeEquipeSanitaire(Long idEquipeSanitaire,
			Model model) {

		
		metier.supprimerEquipeSanitaire(idEquipeSanitaire);
		model.addAttribute("fonctions",metier.listFonctions());
		model.addAttribute("equipeSanitaire", new EquipeSanitaire());
		model.addAttribute("equipeSanitaires", metier.listEquipeSanitaires());

		return "EquipeSanitaireMateriel";
	}

	

	

	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("equipeSanitaire", new EquipeSanitaire());
		mv.addObject("equipeSanitaires", metier.listEquipeSanitaires());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("EquipeSanitaireMateriel");
		return mv;
	}


}
