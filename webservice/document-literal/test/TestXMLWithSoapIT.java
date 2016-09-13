/**
 * MuleSoft Examples
 * Copyright 2014 MuleSoft, Inc.
 *
 * This product includes software developed at
 * MuleSoft, Inc. (http://www.mulesoft.com/).
 */


import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mule.api.MuleMessage;
import org.mule.module.client.MuleClient;
import org.mule.tck.junit4.FunctionalTestCase;

public class TestXMLWithSoapIT extends FunctionalTestCase
{
	private String MESSAGE;
	 
	
	 @Override
	 protected String getConfigResources()
	 {
	  return "webservice.xml";
	 }

	 @Before
	 public void setUp(){
			 MESSAGE = "<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:air='http://safety.delta.com/aircraftengineinfo'><soapenv:Header/>   <soapenv:Body>      <air:AircraftEngineInfoRequest>         <air:aircraftNumber>09559</air:aircraftNumber>      </air:AircraftEngineInfoRequest>   </soapenv:Body></soapenv:Envelope>";
			 System.out.println("XMLWithSoapIT.setUp()"+MESSAGE);
	 }
	 
	 @Test
	 public void testXMLwithSoap() throws Exception
	 {
		  MuleClient client = new MuleClient(muleContext);
		  Map<String, Object> props = new HashMap<String, Object>();
		  props.put("http.method", "POST");
		  props.put("http.headers", MESSAGE);
			try {
				MuleMessage result = client.send("http://localhost:9085/ESCS/AircraftEngineInfoService", MESSAGE,null);
				assertNotNull(result);
				System.out.println("RESPONSE:::"+result.getPayloadAsString());
				//assertFalse(result.getPayload() instanceof NullPayload);
				//assertTrue(result.getPayloadAsString().contains(REPLY1));
				//assertTrue(result.getPayloadAsString().contains(REPLY2));
			} catch (Exception e) {
				e.printStackTrace();
			}
	 }

}
