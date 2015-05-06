package org.gestion.cr.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.gestion.cr.entities.Accompagnateur;
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
@RequestMapping(value = "/admin")
public class AccompagnateurListeAdminController implements HandlerExceptionResolver 
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
		
		model.addAttribute("accompagnateur", new Accompagnateur());
		model.addAttribute("accompagnateurs", metier.listAccompagnateurs());
		
		
		return "accompagnateursListe";

	}

	@RequestMapping(value = "/validerModificationAccomp")
	public String validerModificationAccomp(@Valid Accompagnateur accomp,
			BindingResult bindingResult, Model model, MultipartFile file)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			model.addAttribute("accompagnateurs", metier.listAccompagnateurs());
			return ("accompagnateursListe");
		}
		Long ref = accomp.getIdPerson();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			referrerAffiliateId = Long.toString(ref);
			if (file.isEmpty()) 
			{
				Accompagnateur accompa = metier.getAccompagnateur(accomp
						.getIdPerson());
				accomp.setNomPhoto(accompa.getNomPhoto());
			} 
			else 
			{
				String path = "C:/Users/YOSRA/Desktop/PFE/ImageAccompagnateurs";
				file.transferTo(new File(path + "/" + "ACCOMPAGNATEUR_"
						+ accomp.getIdPerson() + "_"
						+ file.getOriginalFilename()));
				accomp.setNomPhoto(path + "/" + "ACCOMPAGNATEUR_"
						+ accomp.getIdPerson() + "_"
						+ file.getOriginalFilename());
			}
			metier.modifierAccompagnateurs(accomp);
			model.addAttribute("accompagnateur", new Accompagnateur());
			model.addAttribute("accompagnateurs", metier.listAccompagnateurs());
		}
		return "accompagnateursListe";
	}

	@RequestMapping(value = "/modifierListeAccompagnateur")
	public String modifierListeAccompagnateur(Long idAccompagnateur, Model model) {
		Accompagnateur accomp = metier.getAccompagnateur(idAccompagnateur);
		model.addAttribute("accompagnateur", accomp);

		model.addAttribute("accompagnateurs", metier.listAccompagnateurs());

		return "accompagnateursListe";
	}

	// photo
	@RequestMapping(value = "photoAccomp", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoAccomp(Long idAccompagnateur) throws IOException {
		Accompagnateur accomp = metier.getAccompagnateur(idAccompagnateur);
		File f = new File(accomp.getNomPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));
	}

	@RequestMapping(value = "/supprimerListeAccompagnateur")
	public String supprimerListeAccompagnateur(Long idAccompagnateur,
			Model model) {

		
		metier.supprimerAccompagnateurs(idAccompagnateur);
		model.addAttribute("accompagnateur", new Accompagnateur());
		model.addAttribute("accompagnateurs", metier.listAccompagnateurs());

		return "accompagnateursListe";
	}

	

	

	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("accompagnateur", new Accompagnateur());
		mv.addObject("accompagnateurs", metier.listAccompagnateurs());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("accompagnateursListe");
		return mv;
	}

}