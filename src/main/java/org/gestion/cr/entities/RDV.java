package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@AssociationOverrides({
		

		@AssociationOverride(name = "id.parent", joinColumns = @JoinColumn(name = "idParent")) })
public class RDV implements Serializable{

@EmbeddedId
private RDVId id = new RDVId();


@DateTimeFormat(pattern = "HH:mm")
private Date heureRDV;

private String message;


private String validite;


public RDVId getId() {
	return id;
}


public void setId(RDVId id) {
	this.id = id;
}


public Date getHeureRDV() {
	return heureRDV;
}


public void setHeureRDV(Date heureRDV) {
	this.heureRDV = heureRDV;
}


public String getMessage() {
	return message;
}


public void setMessage(String message) {
	this.message = message;
}


public String getValidite() {
	return validite;
}


public void setValidite(String validite) {
	this.validite = validite;
}


public RDV() {
	super();
	// TODO Auto-generated constructor stub
}


@Transient
public Parent getParent() {
	return getId().getParent();
}

public void setParent(Parent parent) {
	getId().setParent(parent);
}

@Transient
public Date getDateRDV() {
	return getId().getDateRDV();
}

public void setDateRDV(Date dateRDV) {
	getId().setDateRDV(dateRDV);
}




}
