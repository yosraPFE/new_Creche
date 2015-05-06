package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class PlanningHorraires implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPlanningH;
	private String typePlanning;
	private double prixPlanning;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.planningHorraires", cascade = CascadeType.ALL)
	private Set<PlanningEnfant> planningEnfant = new HashSet<PlanningEnfant>(0);

	/*
	 * @ManyToMany(mappedBy="planningHorraires") private Set<Enfant> enfants =
	 * new HashSet<Enfant>();
	 */

	public PlanningHorraires() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdPlanningH() {
		return idPlanningH;
	}

	public void setIdPlanningH(Long idPlanningH) {
		this.idPlanningH = idPlanningH;
	}

	public String getTypePlanning() {
		return typePlanning;
	}

	public void setTypePlanning(String typePlanning) {
		this.typePlanning = typePlanning;
	}

	public double getPrixPlanning() {
		return prixPlanning;
	}

	public void setPrixPlanning(double prixPlanning) {
		this.prixPlanning = prixPlanning;
	}

	public Set<PlanningEnfant> getPlanningEnfant() {
		return planningEnfant;
	}

	public void setPlanningEnfant(Set<PlanningEnfant> planningEnfant) {
		this.planningEnfant = planningEnfant;
	}

	public PlanningHorraires(String typePlanning, double prixPlanning) {
		super();
		this.typePlanning = typePlanning;
		this.prixPlanning = prixPlanning;
	}

	
	
	

}
