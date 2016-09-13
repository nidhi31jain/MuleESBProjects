configuration:
=============
  <configuration> tag to import libraries 
  e.g: below configuration imports StringUtils so when use in expression no need to
  use full path else throw error if not defined in configuration it is like import block in java.
   <configuration doc:name="Configuration"> 
	    <expression-language autoResolveVariables="true">
    	    <import class="org.mule.util.StringUtils" />
    	</expression-language>
	</configuration>
	
	
set-variable:
=============
	 <set-variable variableName="searchInput" value="#[new FlightInfo();]" doc:name="searchInput"/>
	 to define global variable like  static instance variable  in java.
	 
Expression:
===========
	 Expression is available as component and transformer.
	 component to set java object to payload.
	 transformer to split the payload and return the payload in different class needed for further processing.
	 
	Important:
	=========
	
	when setting variable in component Expression 
	
	import FlightInput;
	FlightInput  input =  new FlightInput();
	input.source =message.inboundProperties['http.query.params'].get("source");
	input.destination =message.inboundProperties['http.query.params'].get("destination");
	flowVars.searchInput = input;
	
	make sure (;) is used at each line else it wont works
	
	To call the flow at the Java component 
	======================================
	message.getInvocationProperty("searchInput") //searchInput is the FLow scope variable name.
	public class CheapAirFairPredictor implements Callable {
	  public Object onCall(MuleEventContext eventContext) throws Exception {
		FlightInfo flightinfo = new FlightInfo();
		MuleMessage message = eventContext.getMessage();
		FlightInput flightInput = message.getInvocationProperty("searchInput");
	    }
	}

HTTP Static Resource Handler:
============================
	 ${app.home}/  -C:\MuleWorkspace\.mule\apps\sftpserver
	 beneath this it has sftpserver.xml mule file ,mule-app.properties,mule-deploy.properties.
	 
	 #[app.workDir] - C:\MuleWorkspace\.mule\.mule\sftpserver
	  beneath this it has directories only  objectstore\,queuestore\,queue-tx-log\,queue-xa-tx-log\
