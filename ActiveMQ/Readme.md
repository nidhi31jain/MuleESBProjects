
AMQ configuration:
===================
STEP 1:
=======
Install AMQ 

STEP 2:
=======
MQ start  using below command.
C:\apache-activemq-5.8.0\bin\win32>activemq.bat start

if not started when trying to invoke queue you get below message:
Cannot process event as "Active_MQ" is stopped (org.mule.api.lifecycle.LifecycleException). Message payload is of type: String

STEP 3:
=======
To get the brokerURL (tcp://localhost:61616) check the 
path C:\apache-activemq-5.8.0\conf\activemq-demo.xml it has sample snipplet
under the below header.
<!--
            The transport connectors expose ActiveMQ over a given protocol to
            clients and other brokers. For more information, see:
            http://activemq.apache.org/configuring-transports.html
        -->
        <transportConnectors>
            <!-- Create a TCP transport that is advertised on via an IP multicast
              group named default. -->
            <transportConnector name="openwire" uri="tcp://localhost:61616" discoveryUri="multicast://default"/>
            <!-- Create a SSL transport. Make sure to configure the SSL options
              via the system properties or the sslContext element. -->
            <transportConnector name="ssl" uri="ssl://localhost:61617"/>
            <!-- Create a STOMP transport for STOMP clients. -->
            <transportConnector name="stomp" uri="stomp://localhost:61613"/>
            <!-- Create a XMPP transport for XMPP clients. -->
            <transportConnector name="xmpp" uri="xmpp://localhost:61222"/>
            <!-- Create a Websocket transport for the websocket dmeo -->
            <transportConnector name="ws" uri="ws://localhost:61614/" />
        </transportConnectors>
        
        
STEP 4:
=======
From above choose TCP transport comment
<!-- Create a TCP transport that is advertised on via an IP multicast
              group named default. -->
            <transportConnector name="openwire" uri="tcp://localhost:61616" discoveryUri="multicast://default"/>
Add to below mule config.
========================
<jms:activemq-connector name="Active_MQ"
		username="admin" password="admin" brokerURL="tcp://localhost:61616"
		validateConnections="true" doc:name="Active MQ" />

STEP 5:
=======
Add JAVAFeed Queue in the AMQ http://127.0.0.1:8161/admin/queues.jsp.
Set priority in header whatever set in this priority comes in output.
<jms:outbound-endpoint queue="JavaFeed"
				connector-ref="Active_MQ" doc:name="JMS">
				<message-properties-transformer>
					<add-message-property key="Priority" value="9" />
				</message-properties-transformer>
</jms:outbound-endpoint>
		
STEP 6:
=======
Run the mule and check the queue it has message  "Hai From Mule"

<set-payload value="Hai From Mule "
			doc:name="Set Payload" />
	<logger message="Payload :- #[message.payload]" level="INFO" doc:name="Logger" />
	  <jms:outbound-endpoint queue="JavaFeed" connector-ref="Active_MQ" doc:name="JMS">
				<message-properties-transformer>
					<add-message-property key="Priority" value="9" />
				</message-properties-transformer>
          </jms:outbound-endpoint>
</flow>
STEP 7:
=======
ony activemq-all-5.8.0.jar is needed in classpath of mule to run.

Add jars to classpath from installed activemq - C:\apache-activemq-5.8.0\activemq-all-5.8.0.jar
