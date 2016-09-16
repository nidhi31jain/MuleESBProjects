+ Started app 'aqmq'                                       +
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
INFO  2016-09-16 18:31:57,504 [[aqmq].JMS_Sender.worker.01] org.mule.api.processor.LoggerMessageProcessor: Message index value ::::::Hello from Sender  1
INFO  2016-09-16 18:31:57,506 [[aqmq].JMS_Sender.worker.01] org.mule.transport.service.DefaultTransportServiceDescriptor: Loading default outbound transformer: org.mule.transport.jms.transformers.ObjectToJMSMessage
INFO  2016-09-16 18:31:57,506 [[aqmq].JMS_Sender.worker.01] org.mule.transport.service.DefaultTransportServiceDescriptor: Loading default response transformer: org.mule.transport.jms.transformers.ObjectToJMSMessage
WARN  2016-09-16 18:31:57,507 [[aqmq].JMS_Sender.worker.01] com.mulesoft.mule.transport.jms.EeJmsMessageDispatcher: Starting patched JmsMessageReceiver
INFO  2016-09-16 18:31:57,508 [[aqmq].JMS_Sender.worker.01] org.mule.lifecycle.AbstractLifecycleManager: Initialising: 'activemqSender.dispatcher.781524917'. Object is: EeJmsMessageDispatcher
INFO  2016-09-16 18:31:57,508 [[aqmq].JMS_Sender.worker.01] org.mule.lifecycle.AbstractLifecycleManager: Starting: 'activemqSender.dispatcher.781524917'. Object is: EeJmsMessageDispatcher
INFO  2016-09-16 18:31:57,533 [[aqmq].JMS_Sender.worker.01] org.mule.api.processor.LoggerMessageProcessor: Message index value ::::::Hello from Sender  2
INFO  2016-09-16 18:31:57,537 [[aqmq].JMS_Sender.worker.01] org.mule.api.processor.LoggerMessageProcessor: Message index value ::::::Hello from Sender  3
INFO  2016-09-16 18:31:57,541 [[aqmq].JMS_Sender.worker.01] org.mule.api.processor.LoggerMessageProcessor: Message index value ::::::Hello from Sender  4
INFO  2016-09-16 18:31:57,546 [[aqmq].JMS_Sender.worker.01] org.mule.api.processor.LoggerMessageProcessor: Message index value ::::::Hello from Sender  5
INFO  2016-09-16 18:31:57,573 [ActiveMQ Session Task-1] org.mule.transport.service.DefaultTransportServiceDescriptor: Loading default outbound transformer: org.mule.transport.jms.transformers.ObjectToJMSMessage
INFO  2016-09-16 18:31:57,574 [ActiveMQ Session Task-1] org.mule.transport.service.DefaultTransportServiceDescriptor: Loading default response transformer: org.mule.transport.jms.transformers.ObjectToJMSMessage
WARN  2016-09-16 18:31:57,574 [ActiveMQ Session Task-1] com.mulesoft.mule.transport.jms.EeJmsMessageDispatcher: Starting patched JmsMessageReceiver
INFO  2016-09-16 18:31:57,575 [ActiveMQ Session Task-1] org.mule.lifecycle.AbstractLifecycleManager: Initialising: 'activemqReceiver.dispatcher.1918162940'. Object is: EeJmsMessageDispatcher
INFO  2016-09-16 18:31:57,575 [ActiveMQ Session Task-1] org.mule.lifecycle.AbstractLifecycleManager: Starting: 'activemqReceiver.dispatcher.1918162940'. Object is: EeJmsMessageDispatcher
INFO  2016-09-16 18:31:57,587 [ActiveMQ Session Task-1] org.mule.api.processor.LoggerMessageProcessor: ::::::::::::::::::::::::::::::: Message Received: Acknowledge - Received Message :::Hello from Sender  1 ::::: Total Message Delivered: null
INFO  2016-09-16 18:31:57,596 [ActiveMQ Session Task-1] org.mule.api.processor.LoggerMessageProcessor: ::::::::::::::::::::::::::::::: Message Received: Acknowledge - Received Message :::Hello from Sender  2 ::::: Total Message Delivered: null
INFO  2016-09-16 18:31:57,624 [ActiveMQ Session Task-1] org.mule.api.processor.LoggerMessageProcessor: ::::::::::::::::::::::::::::::: Message Received: Acknowledge - Received Message :::Hello from Sender  3 ::::: Total Message Delivered: null
INFO  2016-09-16 18:31:57,649 [ActiveMQ Session Task-1] org.mule.api.processor.LoggerMessageProcessor: ::::::::::::::::::::::::::::::: Message Received: Acknowledge - Received Message :::Hello from Sender  4 ::::: Total Message Delivered: null
INFO  2016-09-16 18:31:57,658 [ActiveMQ Session Task-1] org.mule.api.processor.LoggerMessageProcessor: ::::::::::::::::::::::::::::::: Message Received: Acknowledge - Received Message :::Hello from Sender  5 ::::: Total Message Delivered: null
