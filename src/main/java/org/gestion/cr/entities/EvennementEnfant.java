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
		@AssociationOverride(name = "id.evenement", joinColumns = @JoinColumn(name = "idEvenement")),

		@AssociationOverride(name = "id.enfant", joinColumns = @JoinColumn(name = "idEnfant")) })
public class EvennementEnfant implements java.io.Serializable

{
	@EmbeddedId
	private EvennementEnfantId id = new EvennementEnfantId();
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dateFinInscriptionEvennement;
	
	
	

	public Date getDateFinInscriptionEvennement() {
		return dateFinInscriptionEvennement;
	}

	public void setDateFinInscriptionEvennement(Date dateFinInscriptionEvennement) {
		this.dateFinInscriptionEvennement = dateFinInscriptionEvennement;
	}

	public EvennementEnfant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EvennementEnfantId getId() {
		return id;
	}

	public void setId(EvennementEnfantId id) {
		this.id = id;
	}

	@Transient
	public Enfant getEnfant() {
		return getId().getEnfant();
	}

	public void setEnfant(Enfant enfant) {
		getId().setEnfant(enfant);
	}

	@Transient
	public Evenement getEvenement() {
		return getId().getEvenement();
	}

	public void setEvenement(Evenement evenement) {
		getId().setEvenement(evenement);
	}

	@Transient
	public Date getDateDebuInscription() {
		return getId().getDateDebuInscription();
	}

	public void setDateDebuInscription(Date dateDebuInscription) {
		getId().setDateDebuInscription(dateDebuInscription);
	}

}
