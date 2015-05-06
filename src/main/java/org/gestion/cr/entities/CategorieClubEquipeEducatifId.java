package org.gestion.cr.entities;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class CategorieClubEquipeEducatifId implements java.io.Serializable
{
	@ManyToOne
	private EquipeEducatif equipeEducatif;
	@ManyToOne
	private CategorieClub categorieClub;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date  dateDebutAnimationCategori;
	

	public EquipeEducatif getEquipeEducatif() {
		return equipeEducatif;
	}

	public void setEquipeEducatif(EquipeEducatif equipeEducatif) {
		this.equipeEducatif = equipeEducatif;
	}

	public CategorieClub getCategorieClub() {
		return categorieClub;
	}

	public void setCategorieClub(CategorieClub categorieClub) {
		this.categorieClub = categorieClub;
	}

	

	public Date getDateDebutAnimationCategori() {
		return dateDebutAnimationCategori;
	}

	public void setDateDebutAnimationCategori(Date dateDebutAnimationCategori) {
		this.dateDebutAnimationCategori = dateDebutAnimationCategori;
	}

	public CategorieClubEquipeEducatifId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategorieClubEquipeEducatifId(EquipeEducatif equipeEducatif,
			CategorieClub categorieClub) {
		super();
		this.equipeEducatif = equipeEducatif;
		this.categorieClub = categorieClub;
	}
	
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		CategorieClubEquipeEducatifId that = (CategorieClubEquipeEducatifId) o;

		if (equipeEducatif != null ? !equipeEducatif.equals(that.equipeEducatif)
				: that.equipeEducatif != null)
			return false;

		if (categorieClub != null ? !categorieClub.equals(that.categorieClub) : that.categorieClub != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result;
		result = (equipeEducatif != null ? equipeEducatif.hashCode() : 0);

		result = 31 * result + (categorieClub != null ? categorieClub.hashCode() : 0);
		return result;
	}
	
	

}
