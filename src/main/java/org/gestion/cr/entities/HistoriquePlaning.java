package org.gestion.cr.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class HistoriquePlaning {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idHistPlan;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   private Date dateDebut;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   private Date dateFin;
   private String type;
   @ManyToOne
   @JoinColumn(name="idPlanningH")
   	private PlanningHorraires planing;

public HistoriquePlaning() {
	// TODO Auto-generated constructor stub
}

public Long getIdHistPlan() {
	return idHistPlan;
}

public void setIdHistPlan(Long idHistPlan) {
	this.idHistPlan = idHistPlan;
}

public Date getDateDebut() {
	return dateDebut;
}

public void setDateDebut(Date dateDebut) {
	this.dateDebut = dateDebut;
}

public Date getDateFin() {
	return dateFin;
}

public void setDateFin(Date dateFin) {
	this.dateFin = dateFin;
}

public PlanningHorraires getPlaning() {
	return planing;
}

public void setPlaning(PlanningHorraires planing) {
	this.planing = planing;
}

public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

}
