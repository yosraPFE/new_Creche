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
@RequestMapping(value="/adminAccomp")
public class AccompagnateurAjoutAdminController implements HandlerExceptionResolver
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
		model.addAttribute("accompagnateur", new Accompagnateur());
		
		
		return "xxxaccompagnateursAjout";
		
	}
	
	@RequestMapping(value="/ajouterAccompagnateur")
	public String ajouterAccompagnateur(@Valid Accompagnateur accomp,BindingResult bindingResult,
			Model model,MultipartFile file) throws IOException
	{
		
		
		
		if(bindingResult.hasErrors())
		{
			model.addAttribute("accompagnateur", new Accompagnateur());
			return("xxxaccompagnateursAjout");
		}
		
		
		
		if(!file.isEmpty())
		{
			
			
			String path = "C:/Users/YOSRA/Desktop/PFE/ImageAccompagnateurs";
			
			Long idAccompagnateur  = metier.ajouterAccompagnateur(accomp);
			file.transferTo(new File(path+"/"+"ACCOMPAGNATEUR_" + idAccompagnateur + "_" + file.getOriginalFilename()));//il peut construire le nouveau nom
			accomp.setNomPhoto(path+"/"+"ACCOMPAGNATEUR_" +idAccompagnateur + "_" + file.getOriginalFilename());//affecter le nom de la photo a l'acc precedement cree
			metier.modifierAccompagnateurs(accomp);
			
		}
		
	
		
		model.addAttribute("accompagnateurAjoute",metier.getAccompagnateur(accomp.getIdPerson()));
		
		model.addAttribute("accompagnateur", new Accompagnateur());
		
		
		
	
	return "xxxaccompagnateursAjout";
	}
	
	@RequestMapping(value="photoAccomp",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	
	public byte[]photoAccomp(Long idAccompagnateur) throws IOException
	{
		
		Accompagnateur accomp=metier.getAccompagnateur(idAccompagnateur);
		File f=new File(accomp.getNomPhoto()); 
		return IOUtils.toByteArray(new FileInputStream(f));
	}
	

    
	@Override
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object arg2, Exception ex) 
	{
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("accompagnateur", new Accompagnateur());
		
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("xxxaccompagnateursAjout");
		
		return mv;
	}
	


	

}
