package org.gestion.cr.entities;

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
		@AssociationOverride(name = "id.equipeEducatif", joinColumns = @JoinColumn(name = "idEquipeEducatif")),

		@AssociationOverride(name = "id.classe", joinColumns = @JoinColumn(name = "idClasse")) })

public class ClasseEquipeEducatif implements java.io.Serializable
{
	@EmbeddedId
	private ClasseEquipeEducatifId id = new ClasseEquipeEducatifId();
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date  dateFinEnseignementClas;

	public ClasseEquipeEducatif() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClasseEquipeEducatifId getId() {
		return id;
	}

	public void setId(ClasseEquipeEducatifId id) {
		this.id = id;
	}
	
	
	
	public Date getDateFinEnseignementClas() {
		return dateFinEnseignementClas;
	}

	public void setDateFinEnseignementClas(Date dateFinEnseignementClas) {
		this.dateFinEnseignementClas = dateFinEnseignementClas;
	}

	@Transient
	public Classe getClasse() {
		return getId().getClasse();
	}

	public void setClasse(Classe classe) {
		getId().setClasse(classe);
	}

	@Transient
	public EquipeEducatif getEquipeEducatif() {
		return getId().getEquipeEducatif();
	}

	public void setEquipeEducatif(EquipeEducatif equipeEducatif) {
		getId().setEquipeEducatif(equipeEducatif);
	}

	@Transient
	public Date getDateDebutEneseignementClas() {
		return getId().getDateDebutEneseignementClas();
	}

	public void setDateDebutEneseignementClas(Date dateDebutEneseignementClas) {
		getId().setDateDebutEneseignementClas(dateDebutEneseignementClas);
	}
	
	
	
	
	
	
	
	
	
}