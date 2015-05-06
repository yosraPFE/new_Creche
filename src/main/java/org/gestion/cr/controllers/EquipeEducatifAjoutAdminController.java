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
@RequestMapping(value="/adminEqEdu")
public class EquipeEducatifAjoutAdminController implements HandlerExceptionResolver
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
		model.addAttribute("equipeEducatif", new EquipeEducatif());
		
		
		return "equipesEduAjout";
		
	}
	
	@RequestMapping(value="/ajouterEquipeEducatif")
	public String ajouterEquipeEducatif(@Valid EquipeEducatif eqEdu,BindingResult bindingResult,
			Model model,MultipartFile file) throws IOException
	{
		
		
		
		if(bindingResult.hasErrors())
		{
			model.addAttribute("fonctions",metier.listFonctions());
			model.addAttribute("equipeEducatif", new EquipeEducatif());
			return("equipesEduAjout");
		}
		
		Long idEquipeEducatif  = metier.ajouterEquipeEducatif(eqEdu, eqEdu.getFonction().getIdFonction());
		
		if(!file.isEmpty())
		{
			
			
			String path = "C:/Users/YOSRA/Desktop/PFE/ImagesEqEducatifs";
			
			
			file.transferTo(new File(path+"/"+"EqEDUCATIF_" + idEquipeEducatif + "_" + file.getOriginalFilename()));//il peut construire le nouveau nom
			eqEdu.setNomPhoto(path+"/"+"EqEDUCATIF_" +idEquipeEducatif + "_" + file.getOriginalFilename());//affecter le nom de la photo a l'acc precedement cree
			metier.modifierEquipeEducatif(eqEdu);
			
		}
		
		
		
	
		model.addAttribute("fonctions",metier.listFonctions());
		model.addAttribute("equipeEducatifAjoute",metier.getEquipeEducatif(eqEdu.getIdPerson()));
		
		model.addAttribute("equipeEducatif", new EquipeEducatif());
		
	
	return "equipesEduAjout";
	}
	
	@RequestMapping(value="photoEqEdu",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	
	public byte[]photoEqEdu(Long idEquipeEducatif) throws IOException
	{
		
		EquipeEducatif eqEdu=metier.getEquipeEducatif(idEquipeEducatif);
		File f=new File(eqEdu.getNomPhoto()); 
		return IOUtils.toByteArray(new FileInputStream(f));
	}
	

    
	@Override
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object arg2, Exception ex) 
	{
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("equipeEducatif", new EquipeEducatif());
		
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("equipesEduAjout");
		
		return mv;
	}
	

}
