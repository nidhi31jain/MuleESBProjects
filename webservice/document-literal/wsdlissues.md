JMS Message issue
==================
<ws:consumer-config name="Web_Service_Consumer"
		wsdlLocation="http://localhost:9085/ESCS/AircraftEngineInfoService/AircraftEngineInfoService.wsdl" service="AircraftEngineInfoService"
		port="AircraftEngineInfoPort" serviceAddress="http://localhost:9085/ESCS/AircraftEngineInfoService"
		doc:name="Web Service Consumer" />
	
or	

<ws:consumer-config name="Web_Service_Consumer"
		wsdlLocation="AircraftEngineInfoService.wsdl" service="AircraftEngineInfoService"
		port="AircraftEngineInfoPort" serviceAddress="http://localhost:9085/ESCS/AircraftEngineInfoService"
		doc:name="Web Service Consumer" />
 check whether  <wmq:message-to-object-transformer doc:name="Message to Object"/> this object in use
 this uses "com.ibm.jms.JMSMessage queue of ibm"
	 
