package org.gestion.cr.entities;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@AssociationOverrides({
		@AssociationOverride(name = "id.materiel", joinColumns = @JoinColumn(name = "idMatriel")),

		@AssociationOverride(name = "id.equipeEducatif", joinColumns = @JoinColumn(name = "idEqEquipeEducatif")) })
public class MatrielUtiliser implements java.io.Serializable {
	@EmbeddedId
	private MaterielUtiliserId id = new MaterielUtiliserId();
	private int quantite;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date  dateFinUtilisation;
	
	
	

	public Date getDateFinUtilisation() {
		return dateFinUtilisation;
	}

	public void setDateFinUtilisation(Date dateFinUtilisation) {
		this.dateFinUtilisation = dateFinUtilisation;
	}

	public MatrielUtiliser(int quantite) {
		super();
		this.quantite = quantite;
	}

	public MatrielUtiliser(MaterielUtiliserId id, int quantite) {
		super();
		this.id = id;
		this.quantite = quantite;
	}

	public MatrielUtiliser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MaterielUtiliserId getId() {
		return id;
	}

	public void setId(MaterielUtiliserId id) {
		this.id = id;
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
	public EquipeEducatif getEquipeEducatif() {
		return getId().getEquipeEducatif();
	}

	public void setEquipeEducatif(EquipeEducatif equipeEducatif) {
		getId().setEquipeEducatif(equipeEducatif);
	}

	@Transient
	public Date getDateDebutUtilisationMateriel() {
		return getId().getDateDebutUtilisationMateriel();
	}

	public void setDateDebutUtilisationMateriel(Date dateM) {
		getId().setDateDebutUtilisationMateriel(dateM);
	}
}
