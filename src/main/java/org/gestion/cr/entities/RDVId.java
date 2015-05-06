package org.gestion.cr.entities;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Embeddable
public class RDVId  implements java.io.Serializable
{
	 @Temporal(TemporalType.DATE)
	private Date dateRDV;
	
	
	@ManyToOne
    @JoinColumn(name="idParent")
	
     private Parent parent;


	public Date getDateRDV() {
		return dateRDV;
	}


	public void setDateRDV(Date dateRDV) {
		this.dateRDV = dateRDV;
	}


	public Parent getParent() {
		return parent;
	}


	public void setParent(Parent parent) {
		this.parent = parent;
	}


	public RDVId() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		RDVId that = (RDVId) o;

		

		if (parent != null ? !parent.equals(that.parent) : that.parent != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result;
		
		result = (parent != null ? parent.hashCode() : 0);

		
		return result;
	}
    
    
	
	

}
