package org.gestion.cr.entities;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class PlanningEnfantId implements java.io.Serializable {
	@ManyToOne
	private PlanningHorraires planningHorraires;
	@ManyToOne
	private Enfant enfant;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dateDebutInscriPlannings;

	

	public PlanningEnfantId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlanningEnfantId(PlanningHorraires planningHorraires, Enfant enfant) {
		super();
		this.planningHorraires = planningHorraires;
		this.enfant = enfant;
	}

	public PlanningHorraires getPlanningHorraires() {
		return planningHorraires;
	}

	public void setPlanningHorraires(PlanningHorraires planningHorraires) {
		this.planningHorraires = planningHorraires;
	}

	public Enfant getEnfant() {
		return enfant;
	}

	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}



	
	public Date getDateDebutInscriPlannings() {
		return dateDebutInscriPlannings;
	}

	public void setDateDebutInscriPlannings(Date dateDebutInscriPlannings) {
		this.dateDebutInscriPlannings = dateDebutInscriPlannings;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		PlanningEnfantId that = (PlanningEnfantId) o;

		if (planningHorraires != null ? !planningHorraires
				.equals(that.planningHorraires)
				: that.planningHorraires != null)
			return false;

		if (enfant != null ? !enfant.equals(that.enfant) : that.enfant != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result;
		result = (planningHorraires != null ? planningHorraires.hashCode() : 0);

		result = 31 * result + (enfant != null ? enfant.hashCode() : 0);
		return result;
	}

}
