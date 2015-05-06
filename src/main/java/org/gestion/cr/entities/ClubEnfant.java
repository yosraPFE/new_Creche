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
		@AssociationOverride(name = "id.club", joinColumns = @JoinColumn(name = "idClub")),

		@AssociationOverride(name = "id.enfant", joinColumns = @JoinColumn(name = "idEnfant")) })
public class ClubEnfant implements java.io.Serializable

{
	@EmbeddedId
	private ClubEnfantId id = new ClubEnfantId();
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date  dateFinInscriClub;
	
	
	

	
	

	public ClubEnfant(Date dateFinInscriClub) {
		super();
		this.dateFinInscriClub = dateFinInscriClub;
	}



	public ClubEnfant() {
		super();
	}
	
	

	public Date getDateFinInscriClub() {
		return dateFinInscriClub;
	}

	public void setDateFinInscriClub(Date dateFinInscriClub) {
		this.dateFinInscriClub = dateFinInscriClub;
	}

	

	public ClubEnfantId getId() {
		return id;
	}

	public void setId(ClubEnfantId id) {
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
	public Date getDateDebutInscriClub() {
		return getId().getDateDebutInscriClub();
	}

	public void setDateDebutInscriClub(Date dateDebutInscriClub) {
		getId().setDateDebutInscriClub(dateDebutInscriClub);
	}
	
	@Transient
	public Club getClub() {
		return getId().getClub();
	}

	public void setClub(Club club) {
		getId().setClub(club);
	}

	

}
