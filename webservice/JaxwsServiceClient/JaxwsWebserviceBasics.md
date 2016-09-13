Service:
========

jaxws Service Provider:
=======================

   <flow name="provider" >
        <http:listener config-ref="Provider_Configuration" path="/service" allowedMethods="GET,POST" metadata:id="2c83107f-94ed-4b29-afb0-464119e1d708" doc:name="HTTP">
            <http:error-response-builder statusCode="200"/>
        </http:listener>
        <cxf:jaxws-service serviceClass="provider.LoginIntf" doc:name="CXF" soapVersion="1.2" />
        <component class="provider.AuthenticationService" doc:name="Java"/>
        <set-payload value="#[payload]" mimeType="application/xml" doc:name="Set Payload"/>
    </flow>

jaxws Service Consumer:
=======================
<flow name="soapconsumer" >
        <expression-component doc:name="soap Input"><![CDATA[import provider.LoginRequest;
LoginRequest request = new LoginRequest();
request.setName(message.inboundProperties['http.query.params'].username);
request.setPassword(message.inboundProperties['http.query.params'].password);
payload= request;
]]></expression-component>
        <cxf:jaxws-client operation="verify" serviceClass="provider.LoginIntf" soapVersion="1.2" metadata:id="3c923f5b-80bf-499b-8b39-5feb8174d2da" doc:name="request/response processor"/>
        <logger message="soap Request :::#[message.payloadAs(java.lang.String)]" level="INFO" doc:name="Logger"/>
        <http:request config-ref="consumer_response_Configuration" path="/service" method="POST" metadata:id="ccdf9d09-a861-4b81-b0ec-99be97e9f6af" doc:name="HTTP"/>
        <logger message="Soap Response OUTPUT::::#[message.payloadAs(java.lang.String)]" level="INFO" doc:name="Logger"/>
	</flow>
	
	NOTE:
	=====
	1)client is again the intf annotated with @webservice.
	
	2)<http:request> to the  service(jaxws Service Provider - path="/service") with soap input from request param.
