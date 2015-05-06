package org.gestion.cr.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.gestion.cr.entities.Accompagnateur;
import org.gestion.cr.entities.Enfant;
import org.gestion.cr.entities.Parent;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;





@Controller
@RequestMapping(value="/adminEF2")

public class EnfantAjoutParentAccompagnateurAdminController   implements HandlerExceptionResolver
{
	
	@Autowired
	private IAdminMetier metier;
	
	private int cas = 0;
	private Enfant unEnfant;
	private MultipartFile enfFile;
	
	private Parent firstParent;
	
	private Parent secondParent;
	
	





	@RequestMapping(value="/index")
	public String index(Model model)
	{
		
		model.addAttribute("enfant",new Enfant());
		setCas(0);
		model.addAttribute("cas", getCas());
		
		return "enfantsAjoutValidator";
		
	}
	
	
	@RequestMapping(value="/verifierParentUn")
	public String verifierParentUn(@Valid @ModelAttribute("parentUn") Parent parentUn,BindingResult bindingResult,Model model, MultipartFile filep, @RequestParam("btnChoisi") String btnChoisi) throws IOException
	{
		
		
		if(bindingResult.hasErrors())
		{
			model.addAttribute("cas", getCas());
			model.addAttribute("enfant", getUnEnfant());
			model.addAttribute("parentUn", parentUn);
			model.addAttribute("parentUns", metier.listParents());
			return("enfantsAjoutValidator");
		}

		setFirstParent(parentUn);
		//setFirstParentFile(filep);
		//System.out.println("Parent File "+filep.getOriginalFilename());
		//System.out.println("Parent Enfant "+getEnfFile().getOriginalFilename());
		Long idFirstParent = addParent(parentUn,filep);
		System.out.println("idFirstParent "+idFirstParent);
		
		Long idEnfant = addEnfant(getUnEnfant(),getEnfFile());
		System.out.println("idEnfant "+idEnfant);
		
		
		metier.ajouterParentsPourEnfant(idFirstParent, idEnfant);
		
		if(btnChoisi.equals("Valider")){
			System.out.println("Valider ");
			model.addAttribute("enfant",new Enfant());
			

			model.addAttribute("parentUns", metier.listParents());

			setCas(0);
			model.addAttribute("cas", getCas());
			//********* afficher les details et le bouton affecter à une classe
			return "redirect:/adminInsA/index?idEnfant="+idEnfant;
			
		}else if(btnChoisi.equals("Ajouter_Autre_Parent")){
			System.out.println("Ajouter_Autre_Parent ");
			setCas(2);
			model.addAttribute("cas", getCas());
			model.addAttribute("enfant", metier.getEnfant(idEnfant));
			model.addAttribute("parentUn", metier.getParent(idFirstParent));
			model.addAttribute("parentUns", metier.listParents());
			model.addAttribute("parentDeux", new Parent());
			return "enfantsAjoutValidator";
		}else{
			System.out.println("Ajouter_Accomp ");
			setCas(3);
			model.addAttribute("cas", getCas());
			model.addAttribute("enfant", getUnEnfant());
			model.addAttribute("parentUn", getFirstParent());
			
			model.addAttribute("Accompagnateur", new Accompagnateur());
			return "enfantsAjoutValidator";
		}
		

	}
	
	@RequestMapping(value="/verifierParentDeux")
	public String verifierParentDeux(@Valid @ModelAttribute("parentDeux")Parent parentDeux,BindingResult bindingResult,Model model, MultipartFile filep2, @RequestParam("btnChoisi") String btnChoisi) throws IOException
	{
		System.out.println("Debut ");
		
		if(bindingResult.hasErrors())
		{
			model.addAttribute("cas", getCas());
			model.addAttribute("enfant", getUnEnfant());
			model.addAttribute("parentUn", getFirstParent());
			model.addAttribute("parentDeux", parentDeux);
			
			return("enfantsAjoutValidator");
		}
		setSecondParent(parentDeux);
		//setSecondParentFile(filep2);
		

		Long idSecondtParent = addParent(parentDeux,filep2);
		metier.ajouterParentsPourEnfant(idSecondtParent, getUnEnfant().getIdPerson());
		
		if(btnChoisi.equals("Valider")){
			System.out.println("Valider ");
			//model.addAttribute("enfant",new Enfant());
			setCas(0);
			model.addAttribute("cas", getCas());
			//********* afficher les details 2 parent et le bouton affecter à une classe
			return "redirect:/adminInsA/index?idEnfant="+getUnEnfant().getIdPerson();
			
		}else{
			System.out.println("Ajouter_Accomp ");
			setCas(3);
			model.addAttribute("cas", getCas());
			model.addAttribute("enfant", getUnEnfant());
			model.addAttribute("parentUn", getFirstParent());
			model.addAttribute("parentDeux", getSecondParent());
			model.addAttribute("Accompagnateur",new Accompagnateur());
			return "enfantsAjoutValidator";
		}
	
	}
	
	
	@RequestMapping(value="/verifierAccompagnateur")
	public String verifierAccompagnateur(@Valid  @ModelAttribute("Accompagnateur") Accompagnateur accomp,BindingResult bindingResult,Model model, MultipartFile fileaccomp, @RequestParam("btnChoisi") String btnChoisi) throws IOException
	{
		System.out.println("Debut ");
		
		if(bindingResult.hasErrors())
		{
			model.addAttribute("cas", getCas());
			model.addAttribute("enfant", getUnEnfant());
			model.addAttribute("parentUn", getFirstParent());
			model.addAttribute("parentDeux", getSecondParent());
			model.addAttribute("Accompagnateur", accomp);
			
			return("enfantsAjoutValidator");
		}
		
		Long idAccomp = metier.ajouterAccompagnateur(accomp);
		
		if(!fileaccomp.isEmpty())
		{
			String path ="C:/Users/YOSRA/Desktop/PFE/ImageAccompagnateurs";
			fileaccomp.transferTo(new File(path +"/"+ "ACCOMPAGNATEUR_" + idAccomp + "_" + fileaccomp.getOriginalFilename()));
			Accompagnateur acc = metier.getAccompagnateur(idAccomp);
			acc.setNomPhoto(path +"/"+ "ACCOMPAGNATEUR_" +idAccomp + "_" + fileaccomp.getOriginalFilename());
			metier.modifierAccompagnateurs(acc);
		}
		metier.ajouterAccompagnateursPourEnfant(idAccomp, getUnEnfant().getIdPerson());
		
		if(btnChoisi.equals("Valider")){
			System.out.println("Valider ");
			model.addAttribute("enfant",new Enfant());
			setCas(0);
			model.addAttribute("cas", getCas());
			//********* afficher les details 2 parent et le bouton affecter à une classe
			return "redirect:/adminInsA/index?idEnfant="+getUnEnfant().getIdPerson();
			
		}else{
			
			setCas(3);
			model.addAttribute("cas", getCas());
			model.addAttribute("enfant", getUnEnfant());
			model.addAttribute("parentUn", getFirstParent());
			model.addAttribute("parentDeux", getSecondParent());
			model.addAttribute("Accompagnateur",new Accompagnateur());
			
			return "enfantsAjoutValidator";
		}
	
	}
	@RequestMapping(value="/verifierEnfant", method = RequestMethod.POST)
	public String verifierEnfant(@Valid Enfant enf,BindingResult bindingResult,Model model,MultipartFile file) throws IOException
	{
	
		if(bindingResult.hasErrors())
		{
			
			return("enfantsAjoutValidator");
		}

		
		setUnEnfant(enf);
		
		setEnfFile(file);
		
		setCas(1);
		model.addAttribute("cas", getCas());
		//model.addAttribute("file", enfFile);
		
		model.addAttribute("enfant", getUnEnfant());
		model.addAttribute("parentUn", new Parent());
		
	return "enfantsAjoutValidator";
	}
	
	@RequestMapping(value="photoEnf",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[]photoEnf(Long idEnfant) throws IOException
	{
		
		Enfant enf=metier.getEnfant(idEnfant);
		File f=new File(enf.getNomPhoto()); 
		return IOUtils.toByteArray(new FileInputStream(f));
	}
	
	
	
	
	@RequestMapping(value="photoAccomp",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	
	public byte[]photoAccomp(Long idAccompagnateur) throws IOException
	{
		
		Accompagnateur accomp=metier.getAccompagnateur(idAccompagnateur);
		File f=new File(accomp.getNomPhoto()); 
		return IOUtils.toByteArray(new FileInputStream(f));
	}
	
	
	
	
	@RequestMapping(value = "photoParent", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoParent(Long idParent) throws IOException {

		Parent par = metier.getParent(idParent);
		File f = new File(par.getNomPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));
	}

	
	
	private Long addEnfant(Enfant enf, MultipartFile fileEnf) throws IOException{

		//MultipartFile file = getEnfFile();
		Long idEnfant  = metier.ajouterEnfant(enf);
		if(!getEnfFile().isEmpty())
		{
			System.out.println("file Enfant not Empty ");
			System.out.println("Name file " + fileEnf.getOriginalFilename());
			String path ="D:/PFE/ImageEnfants";
			
			//getEnfFile().transferTo(new File(path +"/"+ "ENFANT_" + idEnfant + "_" + getEnfFile().getOriginalFilename()));
			 File convFile = new File(path +"/"+ "ENFANT_" + idEnfant + "_" + fileEnf.getOriginalFilename());
			 System.out.println("1 ");
			 convFile.createNewFile(); 
			 System.out.println("2 ");
			    FileOutputStream fos = new FileOutputStream(convFile); 
			    System.out.println("3 ");
			    try {
			    	 fos.write(fileEnf.getBytes());
				} catch (Exception e) {
					 System.out.println("problème de déplacement du fichier ");
				}
			   
			   
			    fos.close(); 

			
			
			System.out.println("image Enfant Transfert !!! ");
			Enfant f = metier.getEnfant(idEnfant);
			f.setNomPhoto(path +"/"+ "ENFANT_" +idEnfant + "_" + fileEnf.getOriginalFilename());
			System.out.println("image Enfant Seted !!! ");
			metier.modifierEnfant(f);
			
			System.out.println("image Enfant c bon !!! ");
		}
		return idEnfant;
	}
	
	private Long addParent(Parent p, MultipartFile filep) throws IOException{

		Long idParent = metier.ajouterParent(p);
		
		if(!filep.isEmpty())
		{
			
			System.out.println("file Parent not Empty ");
			String path ="C:/Users/YOSRA/Desktop/PFE/ImagesParents";
			filep.transferTo(new File(path +"/"+ "PARENT_" + idParent + "_" + filep.getOriginalFilename()));
			Parent pa = metier.getParent(idParent);
			pa.setNomPhoto(path +"/"+ "PARENT_" +idParent + "_" + filep.getOriginalFilename());
			metier.modifierParent(pa);
			System.out.println("image Parent c bon !!! ");
		}
		return idParent;
	}
	
	
    
	@Override
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object arg2, Exception ex) 
	{
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("enfant", new Enfant());
		
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("enfantsAjoutValidator");
		
		return mv;
	}
	




	public MultipartFile getEnfFile() {
		return enfFile;
	}




	public void setEnfFile(MultipartFile enfFile) {
		this.enfFile = enfFile;
	}




	public Parent getFirstParent() {
		return firstParent;
	}




	public void setFirstParent(Parent firstParent) {
		this.firstParent = firstParent;
	}




	



	public Parent getSecondParent() {
		return secondParent;
	}




	public void setSecondParent(Parent secondParent) {
		this.secondParent = secondParent;
	}


	
	public Enfant getUnEnfant() {
		return unEnfant;
	}




	public void setUnEnfant(Enfant unEnfant) {
		this.unEnfant = unEnfant;
	}




	public int getCas() {
		return cas;
	}




	public void setCas(int cas) {
		this.cas = cas;
	}
	

}
