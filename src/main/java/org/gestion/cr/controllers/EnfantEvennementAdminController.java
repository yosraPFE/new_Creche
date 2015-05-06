package org.gestion.cr.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.gestion.cr.entities.Enfant;
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
@RequestMapping(value = "/adminEnfEven")
public class EnfantEvennementAdminController implements HandlerExceptionResolver
{

	@Autowired
	private IAdminMetier metier;
	
	
	@Autowired 
	private HttpServletRequest request;

	
	

	// index
	@RequestMapping(value = "/index")
	public String index(Model model) {
		
		model.addAttribute("enfant", new Enfant());
		
		model.addAttribute("enfants", metier.listEnfants());
		
		return "enfantsEvennement";

	}
	// index
		@RequestMapping(value = "/indexReturn")
		public String indexReturn(Model model, Long InscriAjoute) {
			
			model.addAttribute("InscriAjoute", InscriAjoute);
			model.addAttribute("enfant", new Enfant());
			
			model.addAttribute("enfants", metier.listEnfants());
			return "enfantsEvennement";

		}
		
	

	// photo
	@RequestMapping(value = "photoEnf", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoEnf(Long idEnfant) throws IOException {
		Enfant enf = metier.getEnfant(idEnfant);
		File f = new File(enf.getNomPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));
	}
	
	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("enfant", new Enfant());
		mv.addObject("enfants", metier.listEnfants());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("enfantsEvennement");
		return mv;
	}

}
