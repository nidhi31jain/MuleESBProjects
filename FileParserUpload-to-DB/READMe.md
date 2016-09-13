components used
===============
poll - get the file every day set in configuration else you can configure to trigger the poll every minute also
====
poll used as java class which reads the file list and set it to outbound properties.
#[message.outboundProperties['fileList']]

Variable- flow scope variable #[new java.util.LinkedList()] it creates a linked list and it maintains a global flow scope.
========
it iterates overs the files in the folder and iterate over  lines  in the file.

FileToString- change file object to string object content in file.
============

subflow
=======
it is like method call like we call a method and get result and use it in other method.
flow
====
To refer a flow.use flow to call a subflow.
Message Enricher
================
<enricher source="#[payload]" target="#[flowVars.isCollectionExists]" doc:name="Message Enricher">
            <mongo:exists-collection config-ref="Mongo_DB" collection="T_employee" doc:name="Mongo DB"/>
</enricher>
Above code check mongo collection T_employee exists or not . if exists true else false and assign to variable
#[flowVars.isCollectionExists] . dynamic variable creation and population - above code create a
flow variable [flowVars.isCollectionExists] dynamically and assign the result of <mongo:exists-collection > object


MongoDB_Exists collection T_employee --> #[flowVars.isCollectionExists] is updated with true or false.
if collection not exists create else log "collection already exists" message in log.
NOTE:important:
===============
source can also be set as empty if no source exists i.e source="#[payload]" can be removed, still will works!!!.
  <enricher  target="#[flowVars.isCollectionExists]" doc:name="Message Enricher">
            <mongo:exists-collection config-ref="Mongo_DB" collection="T_employee" doc:name="Mongo DB"/>
        </enricher>
NOTE:
====
<!--
			if flowvar is used as target variable it wont work first variable will not be bind next loop only it gets the value.
			<enricher source="#[flowVars.employeeList[finalcounter-1]]" target="#[flowVars.employeeBean]" doc:name="Message Enricher">
			 -->
if create a flowscope variable [flowVars.employeeBean] by getting from existing flowscope variable 
#[flowVars.employeeList[finalcounter-1]] wont work. since once in next iteration only it gets assigned value


 <foreach collection="#[flowVars.employeeList]" counterVariableName="finalcounter" rootMessageVariableName="finalrootMessage" doc:name="For Each">
            <json:object-to-json-transformer mimeType="application/json" doc:name="Object to JSON"/>
            <logger message="Message enricher payload ::;#[payload]" level="INFO" doc:name="Logger"/>
            <mongo:save-object config-ref="Mongo_DB" collection="T_employee" doc:name="Mongo DB"/>
			<!--
			if flowvar is used as target variable it wont work first variable will not be bind next loop only it gets the value.
			<enricher source="#[flowVars.employeeList[finalcounter-1]]" target="#[flowVars.employeeBean]" doc:name="Message Enricher">
			 -->
</foreach>

<!--
			if flowvar is used as target variable it wont work first variable will not be bind next loop only it gets the value.
			<enricher source="#[flowVars.employeeList[finalcounter-1]]" target="#[flowVars.employeeBean]" doc:name="Message Enricher">
			 -->
	  if above is used , first value in collection return  null and  all values in collections expect last values .
	since it increment collections but wont get populated.
	flow scope collection -> iterate and form flowscope employeeBean will be available only in next iteration.
	
	expression-component
	====================
	To Split the values in text input below , parse line by line each files in folder given and tokenize as arr[0]-empid
	arr[1]-name arr[2]: address.
input:
=====
101|Test1|Guindy
102|Test2|Mylapore
103|Test3|T.Nagar
104|Test4|Ambatur
105|Test5|velachery111

object-to-json-transformer
=========================
to convert to json.

output:
=======
 db.T_employee.find()
 "_id" : 101, "name" : "Test1", "address" : "Guindy" }
 "_id" : 102, "name" : "Test2", "address" : "Mylapore" }
 "_id" : 103, "name" : "Test3", "address" : "T.Nagar" }
 "_id" : 104, "name" : "Test4", "address" : "Ambatur" }
 "_id" : 105, "name" : "Test5", "address" : "velachery" }

