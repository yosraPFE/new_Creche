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
public class HistoriqueClub 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idHistClub;
	
   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   private Date dateDebut;
   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   private Date dateFin;
   private String nom;
   
  
   @ManyToOne
   @JoinColumn(name="idClub")
   	private Club club;

public HistoriqueClub() {
	// TODO Auto-generated constructor stub
}

public Long getIdHistClub() {
	return idHistClub;
}

public void setIdHistClub(Long idHistClub) {
	this.idHistClub = idHistClub;
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

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}



public Club getClub() {
	return club;
}

public void setClub(Club club) {
	this.club = club;
}




}
