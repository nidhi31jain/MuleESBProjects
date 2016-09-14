Changing service to proxy:
==========================
if changing jaxws service to proxy-service and jaxws client to proxy-client


provider:
========
 <flow name="provider" >
        <http:listener config-ref="Provider_Configuration" path="/service" allowedMethods="GET,POST" metadata:id="2c83107f-94ed-4b29-afb0-464119e1d708" doc:name="HTTP">
            <http:error-response-builder statusCode="200"/>
        </http:listener>
        <cxf:proxy-service  doc:name="CXF" soapVersion="1.2" payload="body" service="provider.LoginIntf"/>
        <component class="provider.AuthenticationService" doc:name="Java"/>
        <set-payload value="#[payload]" mimeType="application/xml" doc:name="Set Payload"/>
    </flow>
    
consumer:
=========

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

        <cxf:proxy-client operation="verify"  soapVersion="1.2" metadata:id="3c923f5b-80bf-499b-8b39-5feb8174d2da" doc:name="request/response processor" payload="body"/>
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

Above configuration show below error in soap UI.

ERROR:
=======
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope">
   <soap:Body>
      <soap:Fault>
         <soap:Code>
            <soap:Value>soap:Receiver</soap:Value>
         </soap:Code>
         <soap:Reason>
            <soap:Text xml:lang="en">Failed to find entry point for component, the following resolvers tried but failed: [
AnnotatedEntryPointResolver: Component: provider.AuthenticationService@3baeda93 doesn't have any annotated methods, skipping.
CallableEntryPointResolver: Object "provider.AuthenticationService@3baeda93" does not implement required interface "interface org.mule.api.lifecycle.Callable"
MethodHeaderPropertyEntryPointResolver: The required property "method" is not set on the event
ReflectionEntryPointResolver: Could not find entry point on: "provider.AuthenticationService" with arguments: "{class org.apache.cxf.staxutils.DepthXMLStreamReader}"
]</soap:Text>
         </soap:Reason>
      </soap:Fault>
   </soap:Body>
</soap:Envelope>
