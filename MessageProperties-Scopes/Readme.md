Scopes
======

Outbound:
========
This is the default scope when writing properties to a message.
All properties written in this scope will be attached to the outbound message (or response message)

Invocation:
==========
This scope is defined from the point that a Message is created until a service has processed the message. 
Properties set on endpoints will be found in this scope
Session:
========
Mule utilises the underlying transport for controlling the session where possible i.e. HttpSession. 
But Mule will fallback to an internal session mechanism where a session is encoded on the message 
with an expiry time associated with it.



OUtput:
=======
TestFlow.testOutbound():actualPayload:::result:::::::null

TestFlow.testOutbound():testInVocation:::result:::::::Hello From sender

TestFlow.testOutbound():testSession:::result:::::::Hello From sender

