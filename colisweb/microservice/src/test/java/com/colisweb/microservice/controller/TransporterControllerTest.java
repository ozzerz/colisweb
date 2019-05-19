package com.colisweb.microservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import com.colisweb.microservice.entity.Carrier;
import com.colisweb.microservice.entity.LicenceType;
import com.colisweb.microservice.entity.Transporter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TransporterControllerTest {

	    @Autowired
	    private TransporterController transporterController;
	 
	 
	@Test
	@Transactional
	public void testPost_OK() throws Exception
		 {
	    //GIVEN
	    Transporter transporter=new Transporter("name","SIRET",Arrays.asList("59330"),createCarrierList(LicenceType.C));
		//WHEN
		 ResponseEntity<HttpStatus> httpStatus = transporterController.addTransporter(transporter);
		 //THEN
		 assertEquals(HttpStatus.CREATED, httpStatus.getStatusCode());	 
		 }
	
	@Test
	public void testPost_SiretUniqueKO() throws Exception
		 {
	    //GIVEN
	    Transporter transporter=new Transporter("name","SIRETDuplicated",Arrays.asList("59330"),createCarrierList(LicenceType.C));
	    Transporter transporter2=new Transporter("name","SIRETDuplicated",Arrays.asList("59330"),createCarrierList(LicenceType.C));
		//WHEN
	    transporterController.addTransporter(transporter);
	    try {
		 transporterController.addTransporter(transporter2);
		fail();
		 //THEN
	    }
	    catch(Exception e)
	    {
	    	
	    }	 
		}
	    
	    
	
	 
	 @Test
	 @Transactional
	 public void testGet_OK() throws Exception
	 {
		//GIVEN
		 Transporter transporter=new Transporter("nameGEt","SIRET",Arrays.asList("59330"),createCarrierList(LicenceType.A));
		 transporterController.addTransporter(transporter);
		 //WHEN
		 List<Transporter> listTransporter = transporterController.get(LicenceType.A);
		 //THEN
		 assertEquals(1, listTransporter.size());
		 listTransporter = transporterController.get(LicenceType.B);
		 assertEquals(0, listTransporter.size());
	 }

		    
			 
	   private List<Carrier> createCarrierList(LicenceType licence)
	    {
	    	 ArrayList<LicenceType> licences=  new ArrayList<>();
	    	 licences.add(licence);
			 Carrier carrier = new Carrier("name", 18, licences);
			 ArrayList<Carrier>carriers =new ArrayList<>();
			 carriers.add(carrier);
			 return carriers;
	    } 
		 
		 
		 
	 
	
}
