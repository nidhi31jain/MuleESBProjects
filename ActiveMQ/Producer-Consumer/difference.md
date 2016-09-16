Diff when listener commented vs uncommented.
============================================

COmmented
=========
when commented you can see all the messages received properly in order.

Uncommented:
============
when uncommented only Message 1,2,3 or 2,4 Message received properly  based on BEGIN_OR_JOIN or JOIN_IF_POSSIBLE

<jms:inbound-endpoint queue="jms.message.post"
			doc:name="checkFailureReceiver" connector-ref="activemqReceiver">
			<jms:transaction action="BEGIN_OR_JOIN" />

		</jms:inbound-endpoint> 

		<set-payload value="Failed message - Acknowledge - Received Message :::#[payload]"
			doc:name="AckMessageHeader"></set-payload>
			
			
		<jms:outbound-endpoint queue="jms.ack.post"
			doc:name="JMSAckMessage" connector-ref="activemqReceiver">
			<jms:transaction action="BEGIN_OR_JOIN" />
		</jms:outbound-endpoint>  
