package com.colisweb.microservice.entity;

import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Carrier {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotEmpty(message="{carrier.name}")
	private String name;
	
	@NotNull(message="{carrier.age.notnull}")
	@Min(value=17,  message="{carrier.age.major}")
	private int age;
	
	@NotEmpty(message="{carrier.licence}")
	@ElementCollection(targetClass=LicenceType.class)
	@Enumerated(EnumType.STRING)
	private List<LicenceType> licenceType;
	

	public Carrier( @NotEmpty(message = "{carrier.name}") String name,
			@NotNull(message = "{carrier.age.notnull}")  @Min(value = 17, message = "{carrier.age.major}") int age,
			@NotEmpty(message = "{carrier.licence}") List<LicenceType> licenceType) {
		super();
		this.name = name;
		this.age = age;
		this.licenceType = licenceType;
	}



	public Carrier()
	{	
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public List<LicenceType> getLicenceType() {
		return licenceType;
	}



	public void setLicenceType(List<LicenceType> licenceType) {
		this.licenceType = licenceType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	
	
	
	
}
