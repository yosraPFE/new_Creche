package org.gestion.cr.entities;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class MaterielSanitaireUtiliserId implements java.io.Serializable {
	@ManyToOne
	private Materiel materiel;
	@ManyToOne
	private EquipeSanitaire equipeSanitaire;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dateDebutUtilisation;

	public MaterielSanitaireUtiliserId(Materiel materiel,
			EquipeSanitaire equipeSanitaire) {
		super();
		this.materiel = materiel;

		this.equipeSanitaire = equipeSanitaire;
	}

	public MaterielSanitaireUtiliserId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

	
	public Date getDateDebutUtilisation() {
		return dateDebutUtilisation;
	}

	public void setDateDebutUtilisation(Date dateDebutUtilisation) {
		this.dateDebutUtilisation = dateDebutUtilisation;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		MaterielSanitaireUtiliserId that = (MaterielSanitaireUtiliserId) o;

		if (materiel != null ? !materiel.equals(that.materiel)
				: that.materiel != null)
			return false;

		if (equipeSanitaire != null ? !equipeSanitaire
				.equals(that.equipeSanitaire) : that.equipeSanitaire != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result;
		result = (materiel != null ? materiel.hashCode() : 0);

		result = 31 * result
				+ (equipeSanitaire != null ? equipeSanitaire.hashCode() : 0);
		return result;
	}

	public EquipeSanitaire getEquipeSanitaire() {
		return equipeSanitaire;
	}

	public void setEquipeSanitaire(EquipeSanitaire equipeSanitaire) {
		this.equipeSanitaire = equipeSanitaire;
	}

}
