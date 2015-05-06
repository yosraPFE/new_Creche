package org.gestion.cr.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.gestion.cr.entities.EquipeEducatif;
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
@RequestMapping(value = "/adminEduClass")
public class EquipeEducatifClasseAdminController implements HandlerExceptionResolver
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
		model.addAttribute("fonctions",metier.listFonctions());
		
		
		model.addAttribute("equipeEducatifs", metier.listEquipeEducatif());
		return "EquipeEducatifClasse";

	}

	@RequestMapping(value = "/validerModificationEqEdu")
	public String validerModificationEqEdu(@Valid EquipeEducatif eqEd,
			BindingResult bindingResult, Model model, MultipartFile file)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			model.addAttribute("equipeEducatifs", metier.listEquipeEducatif());
			return ("EquipeEducatifClasse");
		}
		Long ref = eqEd.getIdPerson();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			referrerAffiliateId = Long.toString(ref);
			if (file.isEmpty()) 
			{
				EquipeEducatif eqEdu = metier.getEquipeEducatif(eqEd
						.getIdPerson());
				eqEd.setNomPhoto(eqEdu.getNomPhoto());
			} 
			else 
			{
				String path = "C:/Users/YOSRA/Desktop/PFE/ImagesEqEducatifs";
				file.transferTo(new File(path + "/" + "EqEDUCATIF_"
						+ eqEd.getIdPerson() + "_"
						+ file.getOriginalFilename()));
				eqEd.setNomPhoto(path + "/" + "EqEDUCATIF_"
						+ eqEd.getIdPerson() + "_"
						+ file.getOriginalFilename());
			}
			metier.modifierEquipeEducatif(eqEd);
			
			

			
			model.addAttribute("fonctions",metier.listFonctions());
			model.addAttribute("equipeEducatif", new EquipeEducatif());
			model.addAttribute("equipeEducatifs", metier.listEquipeEducatif());
		}
		return "EquipeEducatifClasse";
	}

	@RequestMapping(value = "/modifierListeEquipeEducatif")
	public String modifierListeEquipeEducatif(Long idEquipeEducatif, Model model) {
		model.addAttribute("fonctions",metier.listFonctions());
		EquipeEducatif eqEd = metier.getEquipeEducatif(idEquipeEducatif);
		model.addAttribute("equipeEducatif", eqEd);

		model.addAttribute("equipeEducatifs", metier.listEquipeEducatif());

		return "EquipeEducatifClasse";
	}

	// photo
	@RequestMapping(value = "photoEqEdu", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoEqEdu(Long idEquipeEducatif) throws IOException {
		EquipeEducatif eqEd = metier.getEquipeEducatif(idEquipeEducatif);
		File f = new File(eqEd.getNomPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));
	}

	
	
	@RequestMapping(value = "/supprimerListeEquipeEducatif")
	public String supprimerListeEquipeEducatif(Long idEquipeEducatif,
			Model model) {

		
		
		model.addAttribute("fonctions",metier.listFonctions());
		metier.supprimerEquipeEducatif(idEquipeEducatif);
		
		model.addAttribute("equipeEducatif", new EquipeEducatif());
		model.addAttribute("equipeEducatifs", metier.listEquipeEducatif());

		return "EquipeEducatifClasse";
	}

	

	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("equipeEducatif", new EquipeEducatif());
		mv.addObject("equipeEducatifs", metier.listEquipeEducatif());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("EquipeEducatifClasse");
		return mv;
	}

}
