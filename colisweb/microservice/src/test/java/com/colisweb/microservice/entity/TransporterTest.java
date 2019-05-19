package com.colisweb.microservice.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TransporterTest {
	
	private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    private List<Carrier> createCarrierList()
    {
    	 ArrayList<LicenceType> licences=  new ArrayList<>(EnumSet.allOf(LicenceType.class));
		 Carrier carrier = new Carrier("name", 18, licences);
		 ArrayList<Carrier>carriers =new ArrayList<>();
		 carriers.add(carrier);
		 return carriers;
    }
    
 
    
   
    
	@Test
	public void test_nameEmpty_KO() throws Exception {
		//GIVEN
		Transporter transporter=new Transporter("","siret",Arrays.asList("59330"),createCarrierList());
		 //WHEN
		 Set<ConstraintViolation<Transporter>> violations = validator.validate(transporter);
		 //THEN
	     assertFalse(violations.isEmpty());
	}
	
	@Test
	public void test_nameNull_KO() throws Exception {
		//GIVEN
		Transporter transporter=new Transporter(null,"siret",Arrays.asList("59330"),createCarrierList());
		 //WHEN
		 Set<ConstraintViolation<Transporter>> violations = validator.validate(transporter);
		 //THEN
	     assertFalse(violations.isEmpty());
	}
	
	@Test
	public void test_siretEmpty_KO() throws Exception {
		//GIVEN
		Transporter transporter=new Transporter("name","",Arrays.asList("59330"),createCarrierList());
		 //WHEN
		 Set<ConstraintViolation<Transporter>> violations = validator.validate(transporter);
		 //THEN
	     assertFalse(violations.isEmpty());
	}
	
	@Test
	public void test_siretNULL_KO() throws Exception {
		//GIVEN
		Transporter transporter=new Transporter("name",null,Arrays.asList("59330"),createCarrierList());
		 //WHEN
		 Set<ConstraintViolation<Transporter>> violations = validator.validate(transporter);
		 //THEN
	     assertFalse(violations.isEmpty());
	}
	
	
	@Test
	public void test_carrierEmpty_KO() throws Exception {
		//GIVEN
		Transporter transporter=new Transporter("name","SIRET",Arrays.asList("59330"),new ArrayList<Carrier>());
		 //WHEN
		 Set<ConstraintViolation<Transporter>> violations = validator.validate(transporter);
		 //THEN
	     assertFalse(violations.isEmpty());
	}
	
	@Test
	public void test_carrierNULL_KO() throws Exception {
		//GIVEN
		 Transporter transporter=new Transporter("name","SIRET",Arrays.asList("59330"),null);
		 //WHEN
		 Set<ConstraintViolation<Transporter>> violations = validator.validate(transporter);
		 //THEN
	     assertFalse(violations.isEmpty());
	}
	
	@Test
	public void test_validator_OK() throws Exception {
		//GIVEN
		 Transporter transporter=new Transporter("name","SIRET",Arrays.asList("59330"),createCarrierList());
		 //WHEN
		 Set<ConstraintViolation<Transporter>> violations = validator.validate(transporter);
		 //THEN
	     assertTrue(violations.isEmpty());
		
	}
	

}

