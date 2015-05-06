package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@AssociationOverrides({
		

		@AssociationOverride(name = "id.enfant", joinColumns = @JoinColumn(name = "idEnfant")) })
public class Payment implements Serializable
{
	@EmbeddedId
	private PaymentId id = new PaymentId();
	
	
    private double montantAvantRemise;
    private double montantApresRemise;
    
    private  String typePayement;
    
    @Temporal(TemporalType.DATE)
    private Date datePayement;
    
    
    private int numeroFacture;
    
    private float remise;
    
    
    private String naturePayement;
    
   
    
     
	

public Payment() {
	// TODO Auto-generated constructor stub
}






public PaymentId getId() {
	return id;
}






public void setId(PaymentId id) {
	this.id = id;
}






public String getNaturePayement() {
	return naturePayement;
}






public void setNaturePayement(String naturePayement) {
	this.naturePayement = naturePayement;
}






public Date getDatePayement() {
	return datePayement;
}






public void setDatePayement(Date datePayement) {
	this.datePayement = datePayement;
}






public double getMontantAvantRemise() {
	return montantAvantRemise;
}






public String getTypePayement() {
	return typePayement;
}






public void setTypePayement(String typePayement) {
	this.typePayement = typePayement;
}






public int getNumeroFacture() {
	return numeroFacture;
}






public void setNumeroFacture(int numeroFacture) {
	this.numeroFacture = numeroFacture;
}






public void setMontantAvantRemise(double montantAvantRemise) {
	this.montantAvantRemise = montantAvantRemise;
}






public double getMontantApresRemise() {
	return montantApresRemise;
}





public void setMontantApresRemise(double montantApresRemise) {
	this.montantApresRemise = montantApresRemise;
}



public float getRemise() {
	return remise;
}




public void setRemise(float remise) {
	this.remise = remise;
}


@Transient
public Enfant getEnfant() {
	return getId().getEnfant();
}

public void setEnfant(Enfant enfant) {
	getId().setEnfant(enfant);
}

@Transient
public String getMoisPayment() {
	return getId().getMoisPayment();
}

public void setMoisPayment(String moisPayment) {
	getId().setMoisPayment(moisPayment);
}







}
