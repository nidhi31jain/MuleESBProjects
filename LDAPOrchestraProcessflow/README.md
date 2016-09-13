

Flow basics:
===============

https://docs.mulesoft.com/mule-user-guide/v/3.7/flow-processing-strategies

Wrap a Flow:
============
You can wrap one or more message processors within your synchronous flow in an asynchronous scope to define a processing block that Mule processes asynchronously with the main flow. You can also create an asynchronous flow by wrapping a flow-ref in an asynchronous scope. 

Subflow: 
========
You can call out to a subflow (which always processes synchronously) or a synchronous flow from any flow, regardless of what processing strategy is applied to the triggering flow. The triggering flow waits until this synchronous processing block returns a message before proceeding with processing. See Flows and Subflows for more information about subflows and synchronous flows.

Non-Blocking:
============
You can use the new Non-Blocking Processing Strategy strategy available in Mule 3.7 and newer to take advantage of NIO with the HTTP Connector and avoid having threads blocked while waiting for HTTP responses, which also requires less tuning. Note: Not all components are currently supported, unsupported components cause a flow to fall back to synchronous processing. 

Custom: 
=======
You can create a custom flow processing strategy to fit your exact needs. For instance, you might prefer a queued-asynchronous flow that uses an increased number of threads to handle high peak loads. 

1) when running all 3 flows in default state it took 30 ms
2)when running all 3 flows in (initial state- started and processing strategy- non -blocking) - 30 ms
3)when running all 3 flows in (initial state- started and processing strategy- queued asynchronous) -
error message -Unable to process a synchronous event asynchronously. Message payload is of type: NullPayload
