 
                                       service vs proxy
                                       ================
                                       
 
 JAXWS Service
 ==============
  <flow name="provider" >
        <http:listener config-ref="Provider_Configuration" path="/service" allowedMethods="GET,POST" metadata:id="2c83107f-94ed-4b29-afb0-464119e1d708" doc:name="HTTP">
            <http:error-response-builder statusCode="200"/>
        </http:listener>
        <cxf:jaxws-service serviceClass="provider.LoginIntf" doc:name="CXF" soapVersion="1.2" />
        <component class="provider.AuthenticationService" doc:name="Java"/>
        <set-payload value="#[payload]" mimeType="application/xml" doc:name="Set Payload"/>
    </flow>
    
    
    
  JAXWS Proxy
 =============
 
  <flow name="provider" >
        <http:listener config-ref="Provider_Configuration" path="/service" allowedMethods="GET,POST" metadata:id="2c83107f-94ed-4b29-afb0-464119e1d708" doc:name="HTTP">
            <http:error-response-builder statusCode="200"/>
        </http:listener>
        <cxf:proxy-service  doc:name="CXF" soapVersion="1.2" payload="body" service="provider.LoginIntf"/>
        <component class="provider.AuthenticationService" doc:name="Java"/>
        <set-payload value="#[payload]" mimeType="application/xml" doc:name="Set Payload"/>
    </flow>
    
Difference:
=============

<cxf:jaxws-service serviceClass="provider.LoginIntf" doc:name="CXF" soapVersion="1.2" />
<cxf:proxy-service  doc:name="CXF" soapVersion="1.2" payload="body" service="provider.LoginIntf"/>
if jaxws-service given with service it shows error also same if proxy-service is given with serviceClass it shows error.

ERRORS:
=======
1.service given with service:
--------------------------------
<cxf:jaxws-service  doc:name="CXF" soapVersion="1.2" service="provider.LoginIntf"/>

Caused by: org.mule.api.DefaultMuleException: You must specify a serviceClass attribute on the inbound endpoint
when you are using a PassThroughComponent, BridgeComponent, or forward router.

2.proxy given with serviceclass:
--------------------------------
<cxf:proxy-service  doc:name="CXF" soapVersion="1.2" payload="body" serviceClass="provider.LoginIntf"/>

Caused by: org.springframework.beans.NotWritablePropertyException: Invalid property 'serviceClass'
of bean class [org.mule.module.cxf.config.ProxyServiceFactoryBean]: Bean property 'serviceClass'
is not writable or has an invalid setter method. Does the parameter type of the setter match the return type of the getter?

