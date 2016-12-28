
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

RAML end point(employee.raml) --> flow-ref in (messageflow muleapi.xml) -->  flow name  in (messageflow muleapi.xml)

apikit:flow-mapping Format
==========================
apikit:router should be prefixed like   

([operation]-get,put,delete] ):/[RAML endpoint specified] :([apikit:router] id)

<apikit:flow-mapping resource="/employeeList"	action="get" content-type="/text/json" flow-ref="get:/employeeList:employee-config" />

<apikit:flow-mapping resource="/emp/{empID1}" action="get" content-type="text/json"flow-ref="get:/searchEmpID/{empID}:employee-config"/> 
   
<apikit:flow-mapping resource="/delete/{delempID}"	action="delete" content-type="text/json"flow-ref="delete:/delEmp/{empID}:employee-config" />
   
 </apikit:config>

http://localhost:8081/api/employeeList

http://localhost:8081/api/searchEmpID/1

http://localhost:8081/api/delEmp/1

