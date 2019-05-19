package com.colisweb.microservice.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Before;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CarrierTest {

	 private Validator validator;

	    @Before
	    public void setUp() {
	        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	        validator = factory.getValidator();
	    }
	
	
	@Test
	public void test_nameEmpty_KO() throws Exception {
		//GIVEN
		 ArrayList<LicenceType> licences=  new ArrayList<>(EnumSet.allOf(LicenceType.class));
		 Carrier carrier=new Carrier("", 18, licences);
		 //WHEN
		 Set<ConstraintViolation<Carrier>> violations = validator.validate(carrier);
		 //THEN
	     assertFalse(violations.isEmpty());
	}

	
	@Test
	public void test_namenull_KO() throws Exception {
		//GIVEN
		 ArrayList<LicenceType> licences=  new ArrayList<>(EnumSet.allOf(LicenceType.class));
		 Carrier carrier=new Carrier(null, 18, licences);
		//WHEN
		 Set<ConstraintViolation<Carrier>> violations = validator.validate(carrier);
		 //THEN
	     assertFalse(violations.isEmpty());
	}
	

	
	@Test
	public void test_agenull_KO() throws Exception {
		//GIVEN
		 ArrayList<LicenceType> licences=  new ArrayList<>(EnumSet.allOf(LicenceType.class));
		 Carrier carrier=new Carrier();
		 carrier.setName("name");
		 carrier.setLicenceType(licences);
		//WHEN
		 Set<ConstraintViolation<Carrier>> violations = validator.validate(carrier); 
		 //THEN
	     assertFalse(violations.isEmpty());
	}
	
	@Test
	public void test_ageUnder18_KO() throws Exception {
		//GIVEN
		 ArrayList<LicenceType> licences=  new ArrayList<>(EnumSet.allOf(LicenceType.class));
		 Carrier carrier=new Carrier("name", 16, licences);
		//WHEN
		 Set<ConstraintViolation<Carrier>> violations = validator.validate(carrier);
		 //THEN
	     assertFalse(violations.isEmpty());
	}
	

	@Test
	public void test_licenceTypenull_KO() throws Exception {
		//GIVEN
		 Carrier carrier=new Carrier("name", 19, null);
		//WHEN
		 Set<ConstraintViolation<Carrier>> violations = validator.validate(carrier);
		 //THEN
	     assertFalse(violations.isEmpty());
	}
	
	@Test
	public void test_licenceTypeEmpty_KO() throws Exception {
		//GIVEN
		 ArrayList<LicenceType> licences=  new ArrayList<>();
		 Carrier carrier=new Carrier("name", 19, licences);
		//WHEN
		 Set<ConstraintViolation<Carrier>> violations = validator.validate(carrier);
		 //THEN
	     assertFalse(violations.isEmpty());
	}
	
	@Test
	public void test_validator_OK() throws Exception {
		 ArrayList<LicenceType> licences=  new ArrayList<>(EnumSet.allOf(LicenceType.class));
		 Carrier carrier=new Carrier("name", 18, licences);
		//WHEN
		 Set<ConstraintViolation<Carrier>> violations = validator.validate(carrier);
		 //THEN
	     assertTrue(violations.isEmpty());
	}
	
	
}
