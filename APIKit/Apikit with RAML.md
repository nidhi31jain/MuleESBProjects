Advantages:
===========
1)helps to define endpoint and response type(xml,json,text)
2)It provides validation control like some field is mandtory using include schema validation
           e.g below line in employee.raml. schema: !include schema/employee-input-schema.json  
3)it provides console environment in .net to test the service.
below code loads employee.raml and based on endpoint (e.g /employeeList,searchEmpID/{empID},/delEmp/{empID})
configured in raml to render service by redirect to apikit flowref (payload) attribute
<apikit:config consoleEnabled="true" consolePath="console"
		doc:name="Router" name="employee-config" raml="employee.raml">
         
  
  
  <flow name="delete:/delEmp/{empID}:employee-config">
	
		<expression-component doc:name="Call API"><![CDATA[
		var empId = message.inboundProperties['http.uri.params'].empID;
		payload = app.registry["empAPI"].deleteEmployee(empId);]]>
		</expression-component> 
		
		<set-payload doc:name="Set Payload to Null Payload" value="#[payload]"/>
	</flow>
            
employee.raml
=============
baseUri: http://localhost:8081/api
documentation:
  - title: get Employees List
    content: |
      To get Employees List
/employeeList:
  displayName: Employees
  #description: |
  #  A collection of teams that are participating in La Liga. Teams API allow you add, remove and retrieve individual team information from La Liga.
  get:
    description: get All emp information
    responses:
      200:
        body:
          application/json:
            schema: !include schema/employee-input-schema.json         
            example: !include schema/employee.json     
             

3)
