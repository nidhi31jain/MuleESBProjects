soapservice.xml
===============
Note:
=====
Jaxws Service

http://localhost:8081/service?wsdl

soapconsumer.xml
==================
Note:
=====
Jaxws Client

http://localhost:8081/response?username=arun&password=arun
global:
=======
<http:request-config name="consumer_response_Configuration"
		host="localhost" port="8081" doc:name="HTTP Request Configuration" />
Actual call:
============
  <cxf:jaxws-client operation="verify" serviceClass="provider.LoginIntf" soapVersion="1.2" metadata:id="3c923f5b-80bf-499b-8b39-5feb8174d2da" doc:name="request/response processor"/>
        <logger message="soap Request :::#[message.payloadAs(java.lang.String)]" level="INFO" doc:name="Logger"/>
        <http:request config-ref="consumer_response_Configuration" path="/service" method="POST" metadata:id="ccdf9d09-a861-4b81-b0ec-99be97e9f6af" doc:name="HTTP"/>
        <logger message="Soap Response OUTPUT::::#[message.payloadAs(java.lang.String)]" level="INFO" doc:name="Logger"/>
        
Above lines we make a service request to service available (soapservice.mxl)        http://localhost:8081/service?wsdl
from soapconsumer.xml and get response.

NOTE:
=====
 <http:request config-ref="consumer_response_Configuration" path="/service" method="POST" metadata:id="ccdf9d09-a861-4b81-b0ec-99be97e9f6af" doc:name="HTTP"/>
 
see in soapconsumer.xml we make a call to soapservice.xml using service host port (8081)/service.
before that we get the request and convert to soap request using <cxf:jaxws-client 

OUTPUT:
======

<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope">
<soap:Body>
<ns2:verifyResponse xmlns:ns2="http://provider/">
<return>
<authroized>true</authroized>
</return>
</ns2:verifyResponse>
</soap:Body>
</soap:Envelope>
