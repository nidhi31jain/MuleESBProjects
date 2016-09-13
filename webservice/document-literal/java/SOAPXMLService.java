/**
 * MuleSoft Examples
 * Copyright 2014 MuleSoft, Inc.
 *
 * This product includes software developed at
 * MuleSoft, Inc. (http://www.mulesoft.com/).
 */


import static org.junit.Assert.assertNotNull;

import org.mule.api.MuleContext;
import org.mule.api.MuleMessage;
import org.mule.api.config.ConfigurationBuilder;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.context.DefaultMuleContextFactory;
import org.mule.module.client.MuleClient;

public class SOAPXMLService
{
	SOAPXMLService(){
		
	}
	
	
	public void response() 
	 {
		MuleContext context = null;
		try {
			String soapHeader = "<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:air='http://safety.delta.com/aircraftengineinfo'><soapenv:Header/>   <soapenv:Body>      <air:AircraftEngineInfoRequest>         <air:aircraftNumber>09559</air:aircraftNumber>      </air:AircraftEngineInfoRequest>   </soapenv:Body></soapenv:Envelope>";
			
			context = new DefaultMuleContextFactory().createMuleContext();
			ConfigurationBuilder builder = new SpringXmlConfigurationBuilder("webservice.xml");
			builder.configure(context);

			context.start();
			MuleClient client = new MuleClient(context);
			//Map<String, Object> props = new HashMap<String, Object>();
			//props.put("http.method", "POST");
			//props.put("http.headers", soapHeader);

			MuleMessage result = client
					.send("http://localhost:9085/ESCS/AircraftEngineInfoService?wsdl",
							soapHeader, null);
			System.out.println("RESPONSE:::" + result.getPayloadAsString());
			assertNotNull(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }

	 public static void main(String args[]){
		 SOAPXMLService xmlService =  new SOAPXMLService();
		 xmlService.response();
	 }

}
