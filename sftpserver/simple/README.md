DownloadFlow
=============
INFO  2016-08-22 18:06:42,866 [main] org.mule.lifecycle.AbstractLifecycleManager: Initialising model: _muleSystemModel
INFO  2016-08-22 18:06:42,872 [main] org.mule.construct.FlowConstructLifecycleManager: Initialising flow: downloadFlow
INFO  2016-08-22 18:06:42,872 [main] org.mule.exception.DefaultMessagingExceptionStrategy: Initialising exception listener: org.mule.exception.DefaultMessagingExceptionStrategy@3d6fb5ef
INFO  2016-08-22 18:06:42,896 [main] org.mule.processor.SedaStageLifecycleManager: Initialising service: downloadFlow.stage1
INFO  2016-08-22 18:06:42,920 [main] org.mule.construct.FlowConstructLifecycleManager: Initialising flow: uploadFlow
INFO  2016-08-22 18:06:42,921 [main] org.mule.exception.DefaultMessagingExceptionStrategy: Initialising exception listener: org.mule.exception.DefaultMessagingExceptionStrategy@11b30a69
INFO  2016-08-22 18:06:42,937 [main] org.mule.processor.SedaStageLifecycleManager: Initialising service: uploadFlow.stage1
INFO  2016-08-22 18:06:42,981 [main] org.mule.util.journal.TransactionJournal: Using files for tx logs C:\MuleWorkspace\.mule\.\.mule\sftpserver\queue-tx-log\tx1.log and C:\MuleWorkspace\.mule\.\.mule\sftpserver\queue-tx-log\tx2.log
INFO  2016-08-22 18:06:42,995 [main] org.mule.util.journal.TransactionJournal: Using files for tx logs C:\MuleWorkspace\.mule\.\.mule\sftpserver\queue-xa-tx-log\tx1.log and C:\MuleWorkspace\.mule\.\.mule\sftpserver\queue-xa-tx-log\tx2.log
INFO  2016-08-22 18:06:43,402 [main] org.mule.config.spring.SpringXmlConfigurationBuilder: Configured Mule using "org.mule.config.spring.SpringXmlConfigurationBuilder" with configuration resource(s): "[ConfigResource{resourceName='C:\MuleWorkspace\.mule\apps\sftpserver\simplesftp.xml'}]"
INFO  2016-08-22 18:06:43,403 [main] org.mule.config.builders.AutoConfigurationBuilder: Configured Mule using "org.mule.config.builders.AutoConfigurationBuilder" with configuration resource(s): "[ConfigResource{resourceName='C:\MuleWorkspace\.mule\apps\sftpserver\simplesftp.xml'}]"
INFO  2016-08-22 18:06:43,404 [main] org.mule.module.launcher.application.DefaultMuleApplication: 
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+ Starting app 'sftpserver'                                +
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
INFO  2016-08-22 18:06:43,446 [main] org.mule.util.queue.QueueXaResourceManager: Starting ResourceManager
INFO  2016-08-22 18:06:43,446 [main] org.mule.util.queue.QueueXaResourceManager: Started ResourceManager
INFO  2016-08-22 18:06:43,645 [main] org.mule.transport.sftp.SftpConnector: Connected: SftpConnector
{
  name=connector.sftp.mule.default
  lifecycle=initialise
  this=7a423eea
  numberOfConcurrentTransactedReceivers=4
  createMultipleTransactedReceivers=true
  connected=true
  supportedProtocols=[sftp]
  serviceOverrides=<none>
}

INFO  2016-08-22 18:06:43,646 [main] org.mule.transport.sftp.SftpConnector: Starting: SftpConnector
{
  name=connector.sftp.mule.default
  lifecycle=initialise
  this=7a423eea
  numberOfConcurrentTransactedReceivers=4
  createMultipleTransactedReceivers=true
  connected=true
  supportedProtocols=[sftp]
  serviceOverrides=<none>
}

INFO  2016-08-22 18:06:43,647 [main] org.mule.lifecycle.AbstractLifecycleManager: Starting connector: connector.sftp.mule.default
INFO  2016-08-22 18:06:43,648 [main] org.mule.transport.file.FileConnector: Connected: FileConnector
{
  name=connector.file.mule.default
  lifecycle=initialise
  this=8619c73
  numberOfConcurrentTransactedReceivers=4
  createMultipleTransactedReceivers=true
  connected=true
  supportedProtocols=[file]
  serviceOverrides=<none>
}

INFO  2016-08-22 18:06:43,648 [main] org.mule.transport.file.FileConnector: Starting: FileConnector
{
  name=connector.file.mule.default
  lifecycle=initialise
  this=8619c73
  numberOfConcurrentTransactedReceivers=4
  createMultipleTransactedReceivers=true
  connected=true
  supportedProtocols=[file]
  serviceOverrides=<none>
}

INFO  2016-08-22 18:06:43,649 [main] org.mule.lifecycle.AbstractLifecycleManager: Starting connector: connector.file.mule.default
INFO  2016-08-22 18:06:43,660 [main] org.mule.modules.oauth2.provider.agents.DefaultSplashScreenAgent: 
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+ DevKit Extensions (0) used in this application 
                             +
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
INFO  2016-08-22 18:06:43,661 [main] org.mule.lifecycle.AbstractLifecycleManager: Starting model: _muleSystemModel
INFO  2016-08-22 18:06:43,663 [main] org.mule.construct.FlowConstructLifecycleManager: Starting flow: downloadFlow
INFO  2016-08-22 18:06:43,664 [main] org.mule.processor.SedaStageLifecycleManager: Starting service: downloadFlow.stage1
INFO  2016-08-22 18:06:43,678 [main] org.mule.transport.sftp.SftpConnector: Registering listener: downloadFlow on endpointUri: sftp://sfbdf:****@sftp.test.com:22/dvl/nqp/nqp_docs/TESTING/input
INFO  2016-08-22 18:06:43,702 [main] org.mule.lifecycle.AbstractLifecycleManager: Initialising: 'null'. Object is: SftpMessageReceiver
INFO  2016-08-22 18:06:43,704 [main] org.mule.transport.sftp.SftpMessageReceiver: Connecting clusterizable message receiver
Kerberos username [667651]: sfbdf
Kerberos password for sfbdf: sfbdxxxx
INFO  2016-08-22 18:06:57,521 [main] org.mule.lifecycle.AbstractLifecycleManager: Starting: 'null'. Object is: SftpMessageReceiver
INFO  2016-08-22 18:06:57,522 [main] org.mule.transport.sftp.SftpMessageReceiver: Starting clusterizable message receiver
INFO  2016-08-22 18:06:57,525 [main] org.mule.construct.FlowConstructLifecycleManager: Starting flow: uploadFlow
INFO  2016-08-22 18:06:57,525 [main] org.mule.processor.SedaStageLifecycleManager: Starting service: uploadFlow.stage1
INFO  2016-08-22 18:06:57,529 [main] org.mule.transport.file.FileConnector: Registering listener: uploadFlow on endpointUri: file:///C:/ESB/input/
INFO  2016-08-22 18:06:57,540 [main] org.mule.lifecycle.AbstractLifecycleManager: Initialising: 'null'. Object is: FileMessageReceiver
INFO  2016-08-22 18:06:57,545 [main] org.mule.transport.file.FileMessageReceiver: Connecting clusterizable message receiver
INFO  2016-08-22 18:06:57,546 [main] org.mule.lifecycle.AbstractLifecycleManager: Starting: 'null'. Object is: FileMessageReceiver
INFO  2016-08-22 18:06:57,546 [main] org.mule.transport.file.FileMessageReceiver: Starting clusterizable message receiver
INFO  2016-08-22 18:06:57,587 [main] org.mule.module.management.agent.WrapperManagerAgent: This JVM hasn't been launched by the wrapper, the agent will not run.
INFO  2016-08-22 18:06:57,607 [main] org.mule.module.management.agent.AbstractJmxAgent: Attempting to register service with name: Mule.sftpserver:type=Endpoint,service="downloadFlow",connector=connector.sftp.mule.default,name="endpoint.sftp.sftp.test.com.22.dvl.nqp.nqp.docs.TESTING.input"
INFO  2016-08-22 18:06:57,608 [main] org.mule.module.management.agent.AbstractJmxAgent: Registered Endpoint Service with name: Mule.sftpserver:type=Endpoint,service="downloadFlow",connector=connector.sftp.mule.default,name="endpoint.sftp.sftp.test.com.22.dvl.nqp.nqp.docs.TESTING.input"
INFO  2016-08-22 18:06:57,608 [main] org.mule.module.management.agent.AbstractJmxAgent: Attempting to register service with name: Mule.sftpserver:type=Endpoint,service="uploadFlow",connector=connector.file.mule.default,name="endpoint..C.ESB.input"
INFO  2016-08-22 18:06:57,609 [main] org.mule.module.management.agent.AbstractJmxAgent: Registered Endpoint Service with name: Mule.sftpserver:type=Endpoint,service="uploadFlow",connector=connector.file.mule.default,name="endpoint..C.ESB.input"
INFO  2016-08-22 18:06:57,610 [main] org.mule.module.management.agent.AbstractJmxAgent: Registered Connector Service with name Mule.sftpserver:type=Connector,name="connector.sftp.mule.default.1"
INFO  2016-08-22 18:06:57,611 [main] org.mule.module.management.agent.AbstractJmxAgent: Registered Connector Service with name Mule.sftpserver:type=Connector,name="connector.file.mule.default.1"
INFO  2016-08-22 18:06:57,615 [main] org.mule.DefaultMuleContext: 
**********************************************************************
* Application: sftpserver                                            *
* OS encoding: \, Mule encoding: UTF-8                               *
*                                                                    *
* Agents Running:                                                    *
*   Batch module default engine                                      *
*   JMX Agent                                                        *
*   DevKit Extension Information                                     *
*   Wrapper Manager                                                  *
**********************************************************************
INFO  2016-08-22 18:06:57,615 [main] org.mule.module.launcher.MuleDeploymentService: 
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+ Started app 'sftpserver'                                 +
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
INFO  2016-08-22 18:06:57,619 [main] org.mule.module.launcher.DeploymentDirectoryWatcher: 
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+ Mule is up and kicking (every 5000ms)                    +
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
INFO  2016-08-22 18:06:57,631 [main] org.mule.module.launcher.StartupSummaryDeploymentListener: 
**********************************************************************
*              - - + DOMAIN + - -               * - - + STATUS + - - *
**********************************************************************
* default                                       * DEPLOYED           *
**********************************************************************

*******************************************************************************************************
*            - - + APPLICATION + - -            *       - - + DOMAIN + - -       * - - + STATUS + - - *
*******************************************************************************************************
* sftpserver                                    * default                        * DEPLOYED           *
*******************************************************************************************************

Kerberos username [667651]: sfbdf
Kerberos password for sfbdf: sfbdxxxx
Kerberos username [667651]: sfbdf
Kerberos password for sfbdf: sfbdxxxx
INFO  2016-08-22 18:07:22,140 [[sftpserver].connector.file.mule.default.dispatcher.01] org.mule.lifecycle.AbstractLifecycleManager: Initialising: 'connector.file.mule.default.dispatcher.1884954755'. Object is: FileMessageDispatcher
INFO  2016-08-22 18:07:22,140 [[sftpserver].connector.file.mule.default.dispatcher.01] org.mule.lifecycle.AbstractLifecycleManager: Starting: 'connector.file.mule.default.dispatcher.1884954755'. Object is: FileMessageDispatcher
INFO  2016-08-22 18:07:22,146 [[sftpserver].connector.sftp.mule.default.dispatcher.01] org.mule.lifecycle.AbstractLifecycleManager: Initialising: 'connector.sftp.mule.default.dispatcher.1942734199'. Object is: SftpMessageDispatcher
INFO  2016-08-22 18:07:22,147 [[sftpserver].connector.sftp.mule.default.dispatcher.01] org.mule.lifecycle.AbstractLifecycleManager: Starting: 'connector.sftp.mule.default.dispatcher.1942734199'. Object is: SftpMessageDispatcher
INFO  2016-08-22 18:07:22,177 [[sftpserver].connector.file.mule.default.dispatcher.01] org.mule.transport.file.FileConnector: Writing file to: C:\ESB\input\Test.txt
Kerberos username [667651]: INFO  2016-08-22 18:07:22,573 [[sftpserver].connector.file.mule.default.receiver.01] org.mule.transport.file.FileMessageReceiver: Lock obtained on file: C:\ESB\input\Test.txt


UPload flow
============
INFO  2016-08-22 18:07:22,581 [[sftpserver].connector.sftp.mule.default.dispatcher.02] org.mule.lifecycle.AbstractLifecycleManager: Initialising: 'connector.sftp.mule.default.dispatcher.1775121814'. Object is: SftpMessageDispatcher
INFO  2016-08-22 18:07:22,581 [[sftpserver].connector.sftp.mule.default.dispatcher.02] org.mule.lifecycle.AbstractLifecycleManager: Starting: 'connector.sftp.mule.default.dispatcher.1775121814'. Object is: SftpMessageDispatcher
Kerberos username [667651]: Kerberos username [667651]: sfbdf
Kerberos password for sfbdf: sfbdxxxx
Kerberos password for sfbdxxxx: sfbdxxxx
Kerberos password for sfbdxxxx: sfbdxxxx
WARN  2016-08-22 18:07:38,058 [[sftpserver].connector.sftp.mule.default.dispatcher.02] org.mule.transport.sftp.SftpClient: listing files for: /dvl/nqp/nqp_docs/TESTING/output//Test.txt
INFO  2016-08-22 18:07:38,319 [[sftpserver].connector.sftp.mule.default.dispatcher.02] org.mule.transport.sftp.SftpMessageDispatcher: Successfully wrote file 'Test.txt' to sftp://sfbdf:****@sftp.test.com:22/dvl/nqp/nqp_docs/TESTING/output/
