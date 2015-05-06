package org.gestion.cr.controllers;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.commons.io.IOUtils;
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
@RequestMapping(value="/adminEqSan")
public class EquipeSanitaireAjoutAdminController implements HandlerExceptionResolver
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
		model.addAttribute("fonctions",metier.listFonctions());
		model.addAttribute("equipeSanitaire", new EquipeSanitaire());
		
		
		return "equipesSanAjout";
		
	}
	
	@RequestMapping(value="/ajouterEquipeSanitaire")
	public String ajouterEquipeSanitaire(@Valid EquipeSanitaire eqSan,BindingResult bindingResult,
			Model model,MultipartFile file) throws IOException
	{
		
		
		
		if(bindingResult.hasErrors())
		{
			model.addAttribute("fonctions",metier.listFonctions());
			model.addAttribute("equipeSanitaire", new EquipeSanitaire());
			return("equipesSanAjout");
		}
		
		Long idEquipeSanitaire  = metier.ajouterEquipeSanitaire(eqSan, eqSan.getFonction().getIdFonction());
		
		if(!file.isEmpty())
		{
			
			
			String path = "C:/Users/YOSRA/Desktop/PFE/ImagesEqSanitaires";
			
			
			file.transferTo(new File(path+"/"+"EqSANITAIR_" + idEquipeSanitaire + "_" + file.getOriginalFilename()));
			eqSan.setNomPhoto(path+"/"+"EqSANITAIR_" +idEquipeSanitaire + "_" + file.getOriginalFilename());
			metier.modifierEquipeSanitaire(eqSan);
			
		}
		
		if(eqSan.getSexe().equals("Homme"))
		{
			model.addAttribute("equipes",metier.listEquipeSanitaires(0, 4));
		}
		else if(eqSan.getSexe().equals("Femme"))
		{
			model.addAttribute("equipes",metier.listEquipeSanitaires(0, 4));
		}
		
	
		model.addAttribute("fonctions",metier.listFonctions());
		model.addAttribute("equipeSanitaireAjoute",metier.getEquipeSanitaire(eqSan.getIdPerson()));
		
		model.addAttribute("equipeEducatif", new EquipeSanitaire());
		
	
	return "equipesSanAjout";
	}
	
	@RequestMapping(value="photoEqSan",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	
	public byte[]photoEqSan(Long idEquipeSanitaire) throws IOException
	{
		
		EquipeSanitaire eqSan=metier.getEquipeSanitaire(idEquipeSanitaire);
		File f=new File(eqSan.getNomPhoto()); 
		return IOUtils.toByteArray(new FileInputStream(f));
	}
	

    
	@Override
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object arg2, Exception ex) 
	{
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("equipeSanitaire", new EquipeSanitaire());
		
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("equipesSanAjout");
		
		return mv;
	}
	

}
