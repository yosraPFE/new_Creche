package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;



@Embeddable
public class PaymentId implements Serializable
{
	

	private String moisPayment;
	
   
    
    @ManyToOne
    @JoinColumn(name="idEnfant")
	
     private Enfant enfant;

	

	
	public String getMoisPayment() {
		return moisPayment;
	}

	public void setMoisPayment(String moisPayment) {
		this.moisPayment = moisPayment;
	}

	public Enfant getEnfant() {
		return enfant;
	}

	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}

	public PaymentId() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		PaymentId that = (PaymentId) o;

		

		if (enfant != null ? !enfant.equals(that.enfant) : that.enfant != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result;
		
		result = (enfant != null ? enfant.hashCode() : 0);

		
		return result;
	}
    
    
 




}
