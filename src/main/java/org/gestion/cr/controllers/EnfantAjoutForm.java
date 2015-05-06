package org.gestion.cr.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.gestion.cr.entities.Accompagnateur;
import org.gestion.cr.entities.Enfant;
import org.gestion.cr.entities.Parent;
import org.gestion.cr.metier.IAdminMetier;
import org.gestion.cr.models.EnfantForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;





@Controller
@RequestMapping(value="/adminEF")

public class EnfantAjoutForm  
{
	
	@Autowired
	private IAdminMetier metier;
	
	
	
	
	@RequestMapping(value="/index")
	public String index(Model model)
	{
		model.addAttribute("enfantForm", new EnfantForm());
		model.addAttribute("enfant",new Enfant());
		
		
		
		return "enfants";
		
	}
	
	
	
	
	
	@RequestMapping("/ajouterEnfantForm")
	public String ajouterEnfantForm(EnfantForm pf,BindingResult bindingResult,MultipartFile file, MultipartFile filep, MultipartFile filec, MultipartFile filem,
	Model model) throws  IOException
	{
		
     if(bindingResult.hasErrors()){
			
			
			
			
			model.addAttribute("enfantForm", new EnfantForm());
			
			
			return("enfants");
		}
     
   //instanciation du l'Enfant
		
   		Enfant ef=new Enfant();

   		ef.setNom(pf.getNomenfant());
   		ef.setPrenom(pf.getPrenomenfant());
   		ef.setSexe(pf.getSexe());
   		ef.setDateNaissance(pf.getDateNaissance());
   		ef.setLieuNaissance(pf.getLieuNaissance());
   		ef.setLangue(pf.getLangue());
   		ef.setAntecedantsMedicaux(pf.getAntecedantsMedicaux());
   		ef.setSituationParentale(pf.getSituationParentale());
   		ef.setCertificatMedicale(pf.isCertificatMedicale());
   		ef.setAutorisationPrisePhoto(pf.isAutorisationPrisePhoto());
   		ef.setNomPrenomPediatre(pf.getNomPrenomPediatre());
   		ef.setTelephonePortablePediatre(pf.getTelephonePortablePediatre());
   		
   		ef.setNomPhoto(pf.getNomPhotoEnfant());
   		//ef.setPhoto(pf.getPhotoEnfant());
   		Long idEnfant =null;
   		
   		if(!file.isEmpty())
   			
   		{
   			String path ="C:/Users/YOSRA/Desktop/PFE/ImagesForm";
   			idEnfant=metier.ajouterEnfant(ef);
   			file.transferTo(new File(path+"/"+"ENFANT_"+idEnfant+"_"+file.getOriginalFilename()));
   			ef.setNomPhoto(path+"/"+"ENFANT_"+idEnfant+"_"+file.getOriginalFilename());
   			metier.modifierEnfant(ef);
   			
   		}else
   		{
   			idEnfant=metier.ajouterEnfant(ef);
   		}
	
		
		//instanciation Mere et Pere du Parent
		
		Parent p=null;
		if(!pf.getNompere().equals(""))
		{ 
			p=new Parent();

		//Pere//

		p.setNom(pf.getNompere());
		p.setCin(pf.getCinpere());
		p.setProfession(pf.getProfessionpere());
		p.setAdresseDomicile(pf.getAdresseDomicilepere());
		p.setTelephoneDomicile(pf.getTelephoneDomicilepere());
		p.setTelephonePortable(pf.getTelephonePortablepere());
		p.setEmail(pf.getEmailpere());
		p.setLieuTravail(pf.getLieuTravailpere());
		p.setTelephoneTravail(pf.getTelephoneTravailpere());
		p.setNomUtilisateur(pf.getNomUtilisateurpere());
		p.setMotPasse(pf.getMotPasseepere());
		p.setGenre(pf.getGenrepere());
		p.setPrenom(pf.getPrenompere());
		
		p.setNomPhoto(pf.getNomPhotopere());
		//p.setPhoto(pf.getPhotoEnfant());
		Long idParent = null;
		if(!filep.isEmpty())
		{
		    String path ="C:/Users/YOSRA/Desktop/PFE/ImagesForm";
			idParent=metier.ajouterParent(p);
			filep.transferTo(new File(path+"/"+"PERE_"+idParent+"_"+filep.getOriginalFilename()));
			p.setNomPhoto(path+"/"+"PERE_"+idParent+"_"+filep.getOriginalFilename());
			metier.modifierParent(p);
		}else{
			idParent=metier.ajouterParent(p);
		}
		metier.ajouterParentsPourEnfant(idParent, idEnfant);
		}
		
		//Mere
		
		
		
		Parent m=null;
		
		if(!pf.getNommere().equals(""))
		{ 
			 m=new Parent();
		
		
		m.setNom(pf.getNommere());
		m.setCin(pf.getCinmere());
		m.setProfession(pf.getProfessionmere());
		m.setAdresseDomicile(pf.getAdresseDomicilemere());
		m.setTelephoneDomicile(pf.getTelephoneDomicilemere());
		m.setTelephonePortable(pf.getTelephonePortablemere());
		m.setEmail(pf.getEmailmere());
		m.setLieuTravail(pf.getLieuTravailmere());
		m.setTelephoneTravail(pf.getTelephoneTravailmere());
		m.setNomUtilisateur(pf.getNomUtilisateurmere());
		m.setMotPasse(pf.getMotPasseemere());
		m.setGenre(pf.getGenremere());
		m.setPrenom(pf.getPrenommere());
		Long idMere = null;
		if(!filem.isEmpty())
		{
			String path ="C:/Users/YOSRA/Desktop/PFE/ImagesForm";
			idMere=metier.ajouterParent(m);
			filem.transferTo(new File(path+"/"+"MERE_"+idMere+"_"+filem.getOriginalFilename()));
			m.setNomPhoto(path+"/"+"MERE_"+idMere+"_"+filem.getOriginalFilename());
			metier.modifierParent(m);
		}else{
			idMere=metier.ajouterParent(m);
		}
			metier.ajouterParentsPourEnfant(idMere, idEnfant);
		}
		
		//instanciation du l'Accompagnateur
		Accompagnateur ac=null;
		
		if(!pf.getNomaccompagnateur().equals(""))
		{ 
			 ac=new Accompagnateur();

		ac.setNom(pf.getNomaccompagnateur());
		ac.setPrenom(pf.getPrenomaccompagnateur());
		ac.setCin(pf.getCinaccompagnateur());
		ac.setTelephonePortable(pf.getTelephonePortableaccompagnateur());
		ac.setDescription(pf.getDescription());
		ac.setNomPhoto(pf.getNomPhotoaccompagnateur());
		//ac.setPhoto(pf.getPhotoaccompagnateur());
		Long idAccompagnateur= null;
		if(!filec.isEmpty())
		{
			String path ="C:/Users/YOSRA/Desktop/PFE/ImagesForm";
			idAccompagnateur=metier.ajouterAccompagnateur(ac);
			filec.transferTo(new File(path+"/"+"ACCOMPAGNATEUR_"+idAccompagnateur+"_"+filec.getOriginalFilename()));
			ac.setNomPhoto(path+"/"+"ACCOMPAGNATEUR_"+idAccompagnateur+"_"+filec.getOriginalFilename());
			metier.modifierAccompagnateurs(ac);
		}else{			
			idAccompagnateur=metier.ajouterAccompagnateur(ac);
		}
		metier.ajouterAccompagnateursPourEnfant(idAccompagnateur, idEnfant);
		}


		
	else
		{
			
		
		
		Long idParent=metier.ajouterParent(p);
		
		Long idMere=metier.ajouterParent(m);
		
		Long idAccompagnateur=metier.ajouterAccompagnateur(ac);
		
		
		metier.ajouterParentsPourEnfant(idParent, idEnfant);
		metier.ajouterParentsPourEnfant(idMere, idEnfant);
		metier.ajouterAccompagnateursPourEnfant(idAccompagnateur, idEnfant);
		
	
		}
	
	
	
	
	
	
	if (ef.getLangue().equals("Arabe")){
		model.addAttribute("enfants", metier.listEnfants(0, 4));
	} else if (ef.getLangue().equals("Français")) {
		model.addAttribute("enfants", metier.listEnfants(0, 4));
	}else if (ef.getLangue().equals("Anglais")) {
		model.addAttribute("enfants", metier.listEnfants(0, 4));
	}
	
	model.addAttribute("enfantForm", new EnfantForm());
	
	
	
	model.addAttribute("enfant", metier.getEnfant(ef.getIdPerson()));
	
	
	return"enfants";
		}
	
	@RequestMapping(value="photoEnf",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	
	public byte[]photoEnf(Long idEnfant) throws IOException
	{
		
		Enfant enf=metier.getEnfant(idEnfant);
		File f=new File(enf.getNomPhoto()); 
		return IOUtils.toByteArray(new FileInputStream(f));
	}
	
	
	
	@RequestMapping(value = "photoParent", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoParent(Long idParent) throws IOException {

		Parent par = metier.getParent(idParent);
		File f = new File(par.getNomPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));
	}
	
	
	
	@RequestMapping(value="photoMere",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	
	public byte[]photoMere(Long idMere) throws IOException
	{
		
		Parent parr = metier.getParent(idMere);
		File f=new File(parr.getNomPhoto()); 
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
	
	
	
	
	

}
