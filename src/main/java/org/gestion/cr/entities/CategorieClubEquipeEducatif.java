package org.gestion.cr.entities;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@AssociationOverrides({
		@AssociationOverride(name = "id.equipeEducatif", joinColumns = @JoinColumn(name = "idEquipeEducatif")),

		@AssociationOverride(name = "id.categorieClub", joinColumns = @JoinColumn(name = "idCategorieClub")) })

public class CategorieClubEquipeEducatif implements java.io.Serializable
{
	
	@EmbeddedId
	private CategorieClubEquipeEducatifId id = new CategorieClubEquipeEducatifId();

	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date  dateFinAnimateCateg;
	
	
	
	
	public Date getDateFinAnimateCateg() {
		return dateFinAnimateCateg;
	}

	public void setDateFinAnimateCateg(Date dateFinAnimateCateg) {
		this.dateFinAnimateCateg = dateFinAnimateCateg;
	}

	public CategorieClubEquipeEducatifId getId() {
		return id;
	}

	public void setId(CategorieClubEquipeEducatifId id) {
		this.id = id;
	}

	public CategorieClubEquipeEducatif() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Transient
	public CategorieClub getCategorieClub() {
		return getId().getCategorieClub();
	}

	public void setCategorieClub(CategorieClub categorieClub) {
		getId().setCategorieClub(categorieClub);
	}

	@Transient
	public EquipeEducatif getEquipeEducatif() {
		return getId().getEquipeEducatif();
	}

	public void setEquipeEducatif(EquipeEducatif equipeEducatif) {
		getId().setEquipeEducatif(equipeEducatif);
	}

	@Transient
	public Date getDateDebutAnimationCategori() {
		return getId().getDateDebutAnimationCategori();
	}

	public void setDateDebutAnimationCategori(Date dateDebutAnimationCategori) {
		getId().setDateDebutAnimationCategori(dateDebutAnimationCategori);
	}
	

}
