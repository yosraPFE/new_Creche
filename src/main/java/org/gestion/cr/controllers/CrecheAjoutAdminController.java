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
@RequestMapping(value="/adminCrech")
public class CrecheAjoutAdminController implements HandlerExceptionResolver
{
	/**
	 * 
	 * @author YOSRA
	 *
	 *//*
	
	@Autowired
	private IAdminMetier metier;
	
	
	
	@RequestMapping(value="/index")
	public String index(Model model)
	{
		model.addAttribute("creche", new Creche());
		
		
		return "crechesAjout";
		
	}
	
	@RequestMapping(value="/ajouterCreche")
	public String ajouterCreche(@Valid Creche crech,BindingResult bindingResult,
			Model model,MultipartFile file) throws IOException
	{
		
		
		
		if(bindingResult.hasErrors())
		{
			model.addAttribute("creche", new Creche());
			return("crechesAjout");
		}
		
		//Long idCreche  = metier.ajouterCreche(crech);
		
		if(!file.isEmpty())
		{
			
			
			String path = "C:/Users/YOSRA/Desktop/PFE/ImagesCreches";
			
			
			file.transferTo(new File(path+"/"+"CRECH_" + idCreche + "_" + file.getOriginalFilename()));
		    crech.setNomPhoto(path+"/"+"CRECH_" +idCreche + "_" + file.getOriginalFilename());
			metier.modifierCreche(crech);
			
		}
		
		
		
	
		
		model.addAttribute("crecheAjoute",metier.getCreche(crech.getIdCreche()));
		
		model.addAttribute("creche", new Creche());
		
		
		
	
	return "crechesAjout";
	}
	
	@RequestMapping(value="photoCrech",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	
	public byte[]photoCrech(Long idCreche) throws IOException
	{
		
		Creche crech=metier.getCreche(idCreche);
		File f=new File(crech.getNomPhoto()); 
		return IOUtils.toByteArray(new FileInputStream(f));
	}
	

    
	@Override
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object arg2, Exception ex) 
	{
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("creche", new Creche());
		
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("crechesAjout");
		
		return mv;
	}
	



}*/
