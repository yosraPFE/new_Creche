package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Basic;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@AssociationOverrides({
		@AssociationOverride(name = "id.classe", joinColumns = @JoinColumn(name = "idClasse")),
		@AssociationOverride(name = "id.enfant", joinColumns = @JoinColumn(name = "idEnfant")) })
public class Inscription implements Serializable {
	@EmbeddedId
	private InscriptionId id = new InscriptionId();

	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dateInscription;
	
	
	
	

	public Inscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	






	public Inscription(Date dateInscription
			) {
		super();
		this.dateInscription = dateInscription;
		
	}








	@Transient
	public Enfant getEnfant() {
		return getId().getEnfant();
	}

	public void setEnfant(Enfant enfant) {
		getId().setEnfant(enfant);
	}

	@Transient
	public String getAnnee() {
		return getId().getAnnee();
	}

	public void setAnnee(String annee) {
		getId().setAnnee(annee);
	}

	@Transient
	public Classe getClasse() {
		return getId().getClasse();
	}

	public void setClasse(Classe classe) {
		getId().setClasse(classe);
	}

	public InscriptionId getId() {
		return id;
	}

	public void setId(InscriptionId id) {
		this.id = id;
	}

	

	

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
}
