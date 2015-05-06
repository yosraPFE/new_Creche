package org.gestion.cr.entities;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class ClubEnfantId implements java.io.Serializable {
	
	@ManyToOne
	private Club club;
	@ManyToOne
	private Enfant enfant;

	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date  dateDebutInscriClub;
	

	public ClubEnfantId() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public ClubEnfantId(Club club, Enfant enfant) {
		super();
		this.club = club;
		this.enfant = enfant;
	}



	public Date getDateDebutInscriClub() {
		return dateDebutInscriClub;
	}



	public void setDateDebutInscriClub(Date dateDebutInscriClub) {
		this.dateDebutInscriClub = dateDebutInscriClub;
	}



	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
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

		ClubEnfantId that = (ClubEnfantId) o;

		if (club != null ? !club.equals(that.club) : that.club != null)
			return false;

		if (enfant != null ? !enfant.equals(that.enfant) : that.enfant != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result;
		result = (club != null ? club.hashCode() : 0);

		result = 31 * result + (enfant != null ? enfant.hashCode() : 0);
		return result;
	}

}
