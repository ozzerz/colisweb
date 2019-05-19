package com.colisweb.microservice.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.colisweb.microservice.entity.LicenceType;
import com.colisweb.microservice.entity.Transporter;
import com.colisweb.microservice.repository.TransporterRepository;

@RestController
@RequestMapping("/api")
public class TransporterController {
	
	private final TransporterRepository transporterRepository;
		
	TransporterController(TransporterRepository transporterRepository) {
		    this.transporterRepository = transporterRepository;
		  }
		
	@Transactional
	@PostMapping(path = "/transporters")
	ResponseEntity<HttpStatus> addTransporter(@Valid  @RequestBody Transporter transporters) {
		transporterRepository.save(transporters);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	@GetMapping(path="/transporters")
	@ResponseBody
	List<Transporter> get(@RequestParam(name = "with_licence_type")  LicenceType licenceType)
	{	
		return transporterRepository.get(licenceType);
	}

}
