package org.gestion.cr.entities;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class ClasseEquipeEducatifId implements java.io.Serializable
{
	@ManyToOne
	private EquipeEducatif equipeEducatif;
	@ManyToOne
	private Classe classe;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date  dateDebutEneseignementClas;

	public ClasseEquipeEducatifId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClasseEquipeEducatifId(EquipeEducatif equipeEducatif, Classe classe) {
		super();
		this.equipeEducatif = equipeEducatif;
		this.classe = classe;
	}

	public EquipeEducatif getEquipeEducatif() {
		return equipeEducatif;
	}

	public void setEquipeEducatif(EquipeEducatif equipeEducatif) {
		this.equipeEducatif = equipeEducatif;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	
	
	
	public Date getDateDebutEneseignementClas() {
		return dateDebutEneseignementClas;
	}

	public void setDateDebutEneseignementClas(Date dateDebutEneseignementClas) {
		this.dateDebutEneseignementClas = dateDebutEneseignementClas;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		ClasseEquipeEducatifId that = (ClasseEquipeEducatifId) o;

		if (classe != null ? !classe.equals(that.classe)
				: that.classe != null)
			return false;

		if (equipeEducatif != null ? !equipeEducatif.equals(that.equipeEducatif) : that.equipeEducatif != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result;
		result = (classe != null ? classe.hashCode() : 0);

		result = 31 * result + (equipeEducatif != null ? equipeEducatif.hashCode() : 0);
		return result;
	}
	
	

}
