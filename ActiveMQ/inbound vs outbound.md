							Inbound 
							=======
							
							
<flow name="jms.single.consumer.single.node.trigger"
		processingStrategy="synchronous">
 		<http:listener config-ref="JMS_Consumer" path="/consumer" doc:name="HTTP" /> 
		<jms:inbound-endpoint queue="jms.message.post"
			doc:name="consumer" connector-ref="activemq-retry-single-node">
           <jms:transaction action="ALWAYS_BEGIN"/>
		</jms:inbound-endpoint>
</flow>

ERROR:
======
org.mule.module.launcher.DeploymentInitException: SAXParseException: cvc-complex-type.2.4.a: Invalid
content was found starting with element 'jms:inbound-endpoint'.
One of '{"http://www.mulesoft.org/schema/mule/core":abstract-message-processor, 
"http://www.mulesoft.org/schema/mule/core":abstract-outbound-endpoint, 
"http://www.mulesoft.org/schema/mule/core":abstract-mixed-content-message-processor, 
"http://www.mulesoft.org/schema/mule/core":response}' is expected.

Reason:
======
inbound should be in the source not in 	Process
actualflow is source ---> process
see after commenting http-listener it works.

<flow name="jms.single.consumer.single.node.trigger"
	processingStrategy="synchronous">
<!-- 	<http:listener config-ref="JMS_Consumer" path="/consumer" -->
<!-- 		doc:name="HTTP" /> -->
	<jms:inbound-endpoint queue="jms.message.post"
		doc:name="consumer" connector-ref="activemq-retry-single-node">
		<jms:transaction action="ALWAYS_BEGIN" />
	</jms:inbound-endpoint>
</flow>

		
		

outbound
========

<flow name="response">
  <http:listener config-ref="JMS_Consumer" path="/consumer"  
  		doc:name="HTTP" />
  <jms:outbound-endpoint queue="jms.message.post"
		doc:name="consumer" connector-ref="activemq-retry-single-node">
		<jms:transaction action="ALWAYS_BEGIN" />
	</jms:outbound-endpoint>

</flow>
     
