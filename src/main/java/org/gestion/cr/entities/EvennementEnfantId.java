package org.gestion.cr.entities;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class EvennementEnfantId implements java.io.Serializable {
	@ManyToOne
	private Evenement evenement;
	@ManyToOne
	private Enfant enfant;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dateDebuInscription;

	public EvennementEnfantId() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public EvennementEnfantId(Evenement evenement, Enfant enfant) {
		super();
		this.evenement = evenement;
		this.enfant = enfant;
	}

	public Evenement getEvenement() {
		return evenement;
	}

	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}

	public Enfant getEnfant() {
		return enfant;
	}

	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}

	

	



	public Date getDateDebuInscription() {
		return dateDebuInscription;
	}



	public void setDateDebuInscription(Date dateDebuInscription) {
		this.dateDebuInscription = dateDebuInscription;
	}



	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		EvennementEnfantId that = (EvennementEnfantId) o;

		if (evenement != null ? !evenement.equals(that.evenement)
				: that.evenement != null)
			return false;

		if (enfant != null ? !enfant.equals(that.enfant) : that.enfant != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result;
		result = (evenement != null ? evenement.hashCode() : 0);

		result = 31 * result + (enfant != null ? enfant.hashCode() : 0);
		return result;
	}

}
