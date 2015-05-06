package org.gestion.cr.entities;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@AssociationOverrides({
		@AssociationOverride(name = "id.planningHorraires", joinColumns = @JoinColumn(name = "idplanningHorraires")),

		@AssociationOverride(name = "id.enfant", joinColumns = @JoinColumn(name = "idEnfant")) })
public class PlanningEnfant implements java.io.Serializable

{
	@EmbeddedId
	private PlanningEnfantId id = new PlanningEnfantId();
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dateFinInscriFinPlanning;
	
	
	

	
	public PlanningEnfant(Date dateFinInscriFinPlanning) {
		super();
		this.dateFinInscriFinPlanning = dateFinInscriFinPlanning;
	}

	public Date getDateFinInscriFinPlanning() {
		return dateFinInscriFinPlanning;
	}

	public void setDateFinInscriFinPlanning(Date dateFinInscriFinPlanning) {
		this.dateFinInscriFinPlanning = dateFinInscriFinPlanning;
	}

	public PlanningEnfant() {
		super();
	}

	public PlanningEnfantId getId() {
		return id;
	}

	public void setId(PlanningEnfantId id) {
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
	public PlanningHorraires getPlanningHorraires() {
		return getId().getPlanningHorraires();
	}

	public void setPlanningHorraires(PlanningHorraires planningHorraires) {
		getId().setPlanningHorraires(planningHorraires);
	}
	
	
	@Transient
	public Date getDateDebutInscriPlannings() {
		return getId().getDateDebutInscriPlannings();
	}

	public void setDateDebutInscriPlannings(Date dateDebutInscriPlannings) {
		getId().setDateDebutInscriPlannings(dateDebutInscriPlannings);
	}

	

}
