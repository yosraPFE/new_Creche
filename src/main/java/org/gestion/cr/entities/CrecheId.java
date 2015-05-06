package org.gestion.cr.entities;

import javax.persistence.Embeddable;

@Embeddable
public class CrecheId implements java.io.Serializable
{
	
	private String annee;

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public CrecheId() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
