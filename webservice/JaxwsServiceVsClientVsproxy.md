Jaxws Service:
==============
<flow name="provider" >
        <http:listener config-ref="Provider_Configuration" path="/service" allowedMethods="GET,POST" metadata:id="2c83107f-94ed-4b29-afb0-464119e1d708" doc:name="HTTP">
            <http:error-response-builder statusCode="200"/>
        </http:listener>
        <cxf:jaxws-service serviceClass="provider.LoginIntf" doc:name="CXF" soapVersion="1.2" />
        <component class="provider.AuthenticationService" doc:name="Java"/>
        <set-payload value="#[payload]" mimeType="application/xml" doc:name="Set Payload"/>
    </flow>
    
NOTE:
=====

Used to expose Webservice.

Jaxws Client:
============
NOTE:
=====
without JAXWS proxy service need to persist the output to flowscope variable in and rendor in soap output.

since subflow, flow wont work in this context.

<flow name="soapconsumer" >
		<http:listener config-ref="Provider_Configuration"
			path="/response" doc:name="HTTP" allowedMethods="GET,POST">
			<http:response-builder statusCode="200" />
		</http:listener>
        <expression-component doc:name="soap Input"><![CDATA[import provider.LoginRequest;
LoginRequest request = new LoginRequest();

request.setName(message.inboundProperties['http.query.params'].username);
request.setPassword(message.inboundProperties['http.query.params'].password);
request.setUserType(1);
payload= request;
]]></expression-component>
        <response>
            <logger level="INFO" doc:name="Logger"/>
        </response>
        <response>
            <set-payload value="#[flowVars.response]" doc:name="Set Payload"/>
        </response>
        <cxf:jaxws-client operation="verify" serviceClass="provider.LoginIntf" soapVersion="1.2" metadata:id="3c923f5b-80bf-499b-8b39-5feb8174d2da" doc:name="request/response processor"/>
        <logger message="soap Request :::#[message.payloadAs(java.lang.String)]" level="INFO" doc:name="Logger"/>
        <http:request config-ref="consumer_response_Configuration" path="/service" method="POST" metadata:id="ccdf9d09-a861-4b81-b0ec-99be97e9f6af" doc:name="HTTP"/>
        <logger message="Soap Response OUTPUT::::#[message.payloadAs(java.lang.String)]" level="INFO" doc:name="Logger"/>
        <response>
            <set-variable variableName="response" value="#[payload]" mimeType="application/xml" doc:name="Variable"/>
        </response>
        <response>
            <object-to-string-transformer mimeType="application/xml" doc:name="Object to String"/>
        </response>

	</flow>

 Improved Jaxws cosumer with Proxy Service in response:
 ======================================================

NOTE:
=====
with proxy service you can see that response java code is converted to xml output easy . otherwise 
it renders as provider.LoginResponse object stream.

	
	<flow name="soapconsumer" >
		<http:listener config-ref="Provider_Configuration"
			path="/response" doc:name="HTTP" allowedMethods="GET,POST">
			<http:response-builder statusCode="200" />
		</http:listener>
        <expression-component doc:name="soap Input"><![CDATA[import provider.LoginRequest;
LoginRequest request = new LoginRequest();

request.setName(message.inboundProperties['http.query.params'].username);
request.setPassword(message.inboundProperties['http.query.params'].password);
request.setUserType(1);
payload= request;
]]></expression-component>
        <response>
            <logger level="INFO" doc:name="Logger"/>
            <cxf:proxy-service service="provider.LoginIntf" payload="body" doc:name="CXF"/>
        </response>

        <cxf:jaxws-client operation="verify" serviceClass="provider.LoginIntf" soapVersion="1.2" metadata:id="3c923f5b-80bf-499b-8b39-5feb8174d2da" doc:name="request/response processor"/>
        <logger message="soap Request :::#[message.payloadAs(java.lang.String)]" level="INFO" doc:name="Logger"/>
        <http:request config-ref="consumer_response_Configuration" path="/service" method="POST" metadata:id="ccdf9d09-a861-4b81-b0ec-99be97e9f6af" doc:name="HTTP"/>
        <logger message="Soap Response OUTPUT::::#[message.payloadAs(java.lang.String)]" level="INFO" doc:name="Logger"/>
        <response>
            <object-to-string-transformer mimeType="application/xml" doc:name="Object to String"/>
        </response>


	</flow>
