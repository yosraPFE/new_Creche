package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TypeMateriels implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTypeMateriels;
	private String labelle;

	@OneToMany(mappedBy = "typeMateriels")
	private Set<Materiel> materiels = new HashSet<Materiel>();

	public Long getIdTypeMateriels() {
		return idTypeMateriels;
	}

	public void setIdTypeMateriels(Long idTypeMateriels) {
		this.idTypeMateriels = idTypeMateriels;
	}

	public String getLabelle() {
		return labelle;
	}

	public void setLabelle(String labelle) {
		this.labelle = labelle;
	}

	public TypeMateriels() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeMateriels(String labelle) {
		super();
		this.labelle = labelle;
	}

	public Set<Materiel> getMateriels() {
		return materiels;
	}

	public void setMateriels(Set<Materiel> materiels) {
		this.materiels = materiels;
	}

}
