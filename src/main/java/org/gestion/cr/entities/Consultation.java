package org.gestion.cr.entities;

import java.io.Serializable;
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
		@AssociationOverride(name = "id.equipeSanitaire", joinColumns = @JoinColumn(name = "idequipeSanitaire")),
		@AssociationOverride(name = "id.enfant", joinColumns = @JoinColumn(name = "idenfant")) })
public class Consultation implements Serializable {

	@EmbeddedId
	private ConsultationId id = new ConsultationId();



	private String description;

	

	public Consultation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consultation(String description
			) {
		super();
		
		this.description = description;
		
	}

	public ConsultationId getId() {
		return id;
	}

	public void setId(ConsultationId id) {
		this.id = id;
	}

	


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Transient
	public EquipeSanitaire getEquipeSanitaire() {
		return getId().getEquipeSanitaire();
	}

	public void setEquipeSanitaire(EquipeSanitaire equipeSanitaire) {
		getId().setEquipeSanitaire(equipeSanitaire);
	}

	@Transient
	public Enfant getEnfant() {
		return getId().getEnfant();
	}

	public void setEnfant(Enfant enfant) {
		getId().setEnfant(enfant);
	}

	@Transient
	public String getDate() {
		return getId().getDate();
	}

	public void setDate(String date) {
		getId().setDate(date);
	}

	

}