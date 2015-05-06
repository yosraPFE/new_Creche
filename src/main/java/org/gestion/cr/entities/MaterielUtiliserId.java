package org.gestion.cr.entities;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class MaterielUtiliserId implements java.io.Serializable {
	@ManyToOne
	private Materiel materiel;
	@ManyToOne
	private EquipeEducatif equipeEducatif;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date  dateDebutUtilisationMateriel;
	

	public MaterielUtiliserId(Materiel materiel, EquipeEducatif equipeEducatif) {
		super();
		this.materiel = materiel;

		this.equipeEducatif = equipeEducatif;
	}

	public MaterielUtiliserId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

	

	public Date getDateDebutUtilisationMateriel() {
		return dateDebutUtilisationMateriel;
	}

	public void setDateDebutUtilisationMateriel(Date dateDebutUtilisationMateriel) {
		this.dateDebutUtilisationMateriel = dateDebutUtilisationMateriel;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		MaterielUtiliserId that = (MaterielUtiliserId) o;

		if (materiel != null ? !materiel.equals(that.materiel)
				: that.materiel != null)
			return false;

		if (equipeEducatif != null ? !equipeEducatif
				.equals(that.equipeEducatif) : that.equipeEducatif != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result;
		result = (materiel != null ? materiel.hashCode() : 0);

		result = 31 * result
				+ (equipeEducatif != null ? equipeEducatif.hashCode() : 0);
		return result;
	}

	public EquipeEducatif getEquipeEducatif() {
		return equipeEducatif;
	}

	public void setEquipeEducatif(EquipeEducatif equipeEducatif) {
		this.equipeEducatif = equipeEducatif;
	}

}
