package com.colisweb.microservice.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Entity
public class Transporter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotEmpty(message="{transporter.name}")
	private String name;
	
	@NotEmpty(message="{transporter.siret}")
	@Column(unique = true)
	private String siret;
	
	@ElementCollection(targetClass=String.class)
	private List<String> codePostal;
	
	@NotEmpty(message="{transporter.carrier}")
	@OneToMany(cascade = CascadeType.ALL)
	@Valid
	private List<Carrier> carriers;
	

	public Transporter(@NotEmpty(message = "{transporter.name}") String name,
			@NotEmpty(message = "{transporter.siret") String siret, List<String> codePostal,
			@NotEmpty(message = "{transporter.carrier") @Valid List<Carrier> carriers) {
		super();
		this.name = name;
		this.siret = siret;
		this.codePostal = codePostal;
		this.carriers = carriers;
	}

	public Transporter()
	{
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public List<String> getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(List<String> codePostal) {
		this.codePostal = codePostal;
	}

	public List<Carrier> getCarriers() {
		return carriers;
	}

	public void setCarriers(List<Carrier> carriers) {
		this.carriers = carriers;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	
	
}


