package com.colisweb.microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.colisweb.microservice.entity.LicenceType;
import com.colisweb.microservice.entity.Transporter;


public interface TransporterRepository extends CrudRepository<Transporter, Long>  {

	@Query(
			value ="SELECT  tr FROM Transporter tr LEFT JOIN tr.carriers ca WHERE :licenceType MEMBER OF ca.licenceType"  )
	List<Transporter> get(@Param("licenceType")  LicenceType licenceType);
	
}
