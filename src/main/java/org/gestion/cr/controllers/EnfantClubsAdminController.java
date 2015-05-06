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
@RequestMapping(value = "/adminEnfClubPlanning")
public class EnfantClubsAdminController implements HandlerExceptionResolver
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	@Autowired
	private IAdminMetier metier;
	
	
	@Autowired 
	private HttpServletRequest request;

	
	/*
	private int page = 0;
	private int nbrLignesEnfans = 4;
	private int nbrPages;

	
	
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getNbrLignesEnfans() {
		return nbrLignesEnfans;
	}

	public void setNbrLignesEnfans(int nbrLignesEnfans) {
		this.nbrLignesEnfans = nbrLignesEnfans;
	}

	public int getNbrPages() {
		return nbrPages;
	}

	public void setNbrPages(int nbrPages) {
		this.nbrPages = nbrPages;
	}*/

	// index
	@RequestMapping(value = "/index")
	public String index(Model model) {
		
		model.addAttribute("enfant", new Enfant());
		
		model.addAttribute("enfants", metier.listEnfants());
		//chargerModel(model);
		return "EnfantClubsPlanning";

	}
	// index
		@RequestMapping(value = "/indexReturn")
		public String indexReturn(Model model, Long InscriAjoute) {
			
			model.addAttribute("InscriAjoute", InscriAjoute);
			model.addAttribute("enfant", new Enfant());
			//chargerModel(model);
			model.addAttribute("enfants", metier.listEnfants());
			return "EnfantClubsPlanning";

		}
		
		
		@RequestMapping(value = "/indexReturnFromConsultation")
		public String indexReturnFromConsultation(Model model, Long ConsuAjoute) {
			
			model.addAttribute("ConsuAjoute", ConsuAjoute);
			model.addAttribute("enfant", new Enfant());
			//chargerModel(model);
			model.addAttribute("enfants", metier.listEnfants());
			return "EnfantClubsPlanning";

		}

	@RequestMapping(value = "/validerModificationEnf")
	public String validerModificationEnf(@Valid Enfant enf,
			BindingResult bindingResult, Model model, MultipartFile file)
			throws IOException {
		if (bindingResult.hasErrors()) {
			//chargerModel(model);
			model.addAttribute("enfants", metier.listEnfants());
			return ("EnfantClubsPlanning");
		}
		Long ref = enf.getIdPerson();
		String referrerAffiliateId = null;
		if (ref != null) {
			referrerAffiliateId = Long.toString(ref);
			if (file.isEmpty()) {
				Enfant enfen = metier.getEnfant(enf.getIdPerson());
				enf.setNomPhoto(enfen.getNomPhoto());
			} else {
				
				String path = "C:/Users/YOSRA/Desktop/PFE/ImageEnfants";
				file.transferTo(new File(path + "/" + "ENFANT_"
						+ enf.getIdPerson() + "_" + file.getOriginalFilename()));
				enf.setNomPhoto(path + "/" + "ENFANT_" + enf.getIdPerson()
						+ "_" + file.getOriginalFilename());
			}
			metier.modifierEnfant(enf);

			
			

			model.addAttribute("enfant", new Enfant());
			//chargerModel(model);
			model.addAttribute("enfants", metier.listEnfants());
		}
		return "EnfantClubsPlanning";
	}

	@RequestMapping(value = "/modifierListeEnfant")
	public String modifierListeEnfant(Long idEnfant, Model model) {
		Enfant enf = metier.getEnfant(idEnfant);
		model.addAttribute("enfant", enf);
		//chargerModel(model);
		model.addAttribute("enfants", metier.listEnfants());

		return "EnfantClubsPlanning";
	}
	
	
	


	// photo
	@RequestMapping(value = "photoEnf", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoEnf(Long idEnfant) throws IOException {
		Enfant enf = metier.getEnfant(idEnfant);
		File f = new File(enf.getNomPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));
	}

	@RequestMapping(value = "/supprimerListeEnfant")
	public String supprimerListeEnfant(Long idEnfant,Model model) {

		//setPage(page);
		/*Enfant enf = metier.getEnfant(idEnfant);
		List<Parent> parents = (List<Parent>) enf.getParents();
		System.out.println(parents.size());
		for (Parent p : parents){
			System.out.println(p.getIdPerson());
			metier.supprimerEnfantDeListeParent(p.getIdPerson(), idEnfant);
			metier.modifierParent(p);
		}*/
		metier.supprimerEnfant(idEnfant);
		model.addAttribute("enfant", new Enfant());
		//chargerModel(model);
		model.addAttribute("enfants", metier.listEnfants());

		return "EnfantClubsPlanning";
	}
/*
	@RequestMapping(value = "chargerModel")
	public void chargerModel(Model model) {

		int pos = getNbrLignesEnfans() * getPage();
		long nbAc = metier.getNombreEnfants();
		setNbrPages((int) (nbAc / getNbrLignesEnfans()) +1);

		model.addAttribute("nbrPages", getNbrPages());
		model.addAttribute("page", getPage());
		model.addAttribute("enfants",
				metier.listEnfants(pos, getNbrLignesEnfans()));

	}*/
	
	/*

	@RequestMapping(value = "/indexPage")
	public String changerPage(Model model, int page) {
		setPage(page);
		model.addAttribute("enfant", new Enfant());
		chargerModel(model);
		return "enfantsListe";
	}*/

	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("enfant", new Enfant());
		mv.addObject("enfants", metier.listEnfants());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("EnfantClubsPlanning");
		return mv;
	}

}
