package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class InscriptionId implements Serializable {
	@ManyToOne
	private Classe classe;
	@ManyToOne
	private Enfant enfant;

	private String annee;

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public InscriptionId() {
		// TODO Auto-generated constructor stub
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Enfant getEnfant() {
		return enfant;
	}

	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		InscriptionId that = (InscriptionId) o;

		if (classe != null ? !classe.equals(that.classe) : that.classe != null)
			return false;
		if (enfant != null ? !enfant.equals(that.enfant) : that.enfant != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result;
		result = (classe != null ? classe.hashCode() : 0);
		result = 31 * result + (enfant != null ? enfant.hashCode() : 0);
		return result;
	}

}
