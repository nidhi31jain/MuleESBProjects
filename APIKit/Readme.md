
POM.xml
=======

 if no mongodb driver given in dependencies then mongo-java-driver-2.14.3.jar gets downloaded default.
so better to specify the mongodb driver version which you used in environment.  


To Load Spring
===============
app.registry["empAPI"]  where empAPI is the name of the spring bean loaded.


Console:
========

you can access console in the MuleStudio as web withurl http://localhost:8081/api/console/


RAML:
======


/employeeList

/searchEmpID/{empID}

/delEmp/{empID}


flow:
=====
it looks on RAML above three flows then checks on muleapi.xml message flow 
1)when request comes it looks on the RAML file.
2)if requested endpoint is present in raml it checks from the validation if any like if any field is mandatory
  for e.g if empId is given as mandatory it shows "required" error in /api/console 
3)web API takes prefix based on value in RAML baseUri: http://localhost:8081/api
4)after that it check in apikit-config  
  
RAML end point(employee.raml) --> flow-ref in (messageflow muleapi.xml) -->  flow name  in (messageflow muleapi.xml)

apikit:flow-mapping Format
==========================
apikit:router should be prefixed like   

([operation]-get,put,delete] ):/[RAML endpoint specified] :([apikit:config] id)

NOTE:
====
1)apikit:router is for default api console.

2)apikit:config has other definition of /getEmployeeList,/searchEmpID/{empID} , /delEmp/{empID}

3) resource="/emp/{empID1}" in apikit:config has no special importance. but flow-ref attribute in <api-kit:config> and 
name in <flow> has very importance. if even parameter changed naming with caps or lower it won't work.

like below should match exactly.

<apikit:flow-mapping action="get" flow-ref="get:/searchEmpID/{empID}:employee-config" />
<flow name="get:/searchEmpID/{empID}:employee-config">
if for e.g empID named as empId it wont work.


it shows error like below 
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+ Failed to deploy artifact 'muleapi', see below           +
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
org.mule.module.launcher.DeploymentInitException: NoSuchBeanDefinitionException: No bean named 'get:/searchEmpID/{empId}:employee-config' is defined

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'employee-config': Cannot create inner bean '(inner bean)#63751a11' of type [org.mule.module.apikit.FlowMapping] while setting bean property 'flowMappings' with key [1]; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name '(inner bean)#63751a11': Cannot resolve reference to bean 'get:/searchEmpID/{empId}:employee-config' while setting bean property 'flow'; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'get:/searchEmpID/{empId}:employee-config' is defined


Error creating bean with name 'employee-config': Cannot create inner bean '(inner bean)#63751a11' of type [org.mule.module.apikit.FlowMapping] while setting bean property 'flowMappings' with key [1]; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name '(inner bean)#63751a11': Cannot resolve reference to bean 'get:/searchEmpID/{empId}:employee-config' while setting bean property 'flow'; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'get:/searchEmpID/{empId}:employee-config' is defined


Error creating bean with name '(inner bean)#63751a11': Cannot resolve reference to bean 'get:/searchEmpID/{empId}:employee-config' while setting bean property 'flow'; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'get:/searchEmpID/{empId}:employee-config' is defined
ed by: org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'get:/searchEmpID/{empId}:employee-config' is defined


Full config:
============
<apikit:config consoleEnabled="true" consolePath="console"
		doc:name="Router" name="employee-config" raml="employee.raml">
		<apikit:flow-mapping resource="/employeeList"	action="get" content-type="/text/json" flow-ref="get:/employeeList:employee-config" />
		<apikit:flow-mapping resource="/emp/{empID1}"	action="get" content-type="text/json" flow-ref="get:/searchEmpID/{empID}:employee-config" />
		<apikit:flow-mapping resource="/delete/{delempID}"	action="delete" content-type="text/json" flow-ref="delete:/delEmp/{empID}:employee-config" />
	</apikit:config>

http://localhost:8081/api/employeeList

http://localhost:8081/api/searchEmpID/1

http://localhost:8081/api/delEmp/1

