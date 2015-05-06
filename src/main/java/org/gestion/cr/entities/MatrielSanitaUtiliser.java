package org.gestion.cr.entities;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@AssociationOverrides({
		@AssociationOverride(name = "id.materiel", joinColumns = @JoinColumn(name = "idMatriel")),

		@AssociationOverride(name = "id.equipeSanitaire", joinColumns = @JoinColumn(name = "idEquipeSanitaire")) })
public class MatrielSanitaUtiliser implements java.io.Serializable {
	@EmbeddedId
	private MaterielSanitaireUtiliserId id = new MaterielSanitaireUtiliserId();
	private int quantite;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dateFinUtilisation;

	
	
	
	public Date getDateFinUtilisation() {
		return dateFinUtilisation;
	}

	public void setDateFinUtilisation(Date dateFinUtilisation) {
		this.dateFinUtilisation = dateFinUtilisation;
	}

	public MatrielSanitaUtiliser(int quantite) {
		super();
		this.quantite = quantite;
	}

	public MatrielSanitaUtiliser(MaterielSanitaireUtiliserId id, int quantite) {
		super();
		this.id = id;
		this.quantite = quantite;
	}

	public MatrielSanitaUtiliser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Transient
	public Materiel getMateriel() {
		return getId().getMateriel();
	}

	public void setMateriel(Materiel materiel) {
		getId().setMateriel(materiel);
	}

	@Transient
	public EquipeSanitaire getEquipeSanitaire() {
		return getId().getEquipeSanitaire();
	}

	public void setEquipeSanitaire(EquipeSanitaire equipeSanitaire) {
		getId().setEquipeSanitaire(equipeSanitaire);
	}

	@Transient
	public Date getDateDebutUtilisation() {
		return getId().getDateDebutUtilisation();
	}

	public void setDateDebutUtilisation(Date dateDebutUtilisation) {
		getId().setDateDebutUtilisation(dateDebutUtilisation);
	}

	public MaterielSanitaireUtiliserId getId() {
		return id;
	}

	public void setId(MaterielSanitaireUtiliserId id) {
		this.id = id;
	}
}
