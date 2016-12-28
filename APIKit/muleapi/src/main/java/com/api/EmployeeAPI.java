package com.api;

import java.util.ArrayList;
import java.util.List;

import model.Employee;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import dao.AbstractDAO;

public class EmployeeAPI extends AbstractDAO{
	 
	
	
	
	
	public  EmployeeAPI(){
		System.err.println("EmployeeAPI.EmployeeAPI()");
	}
	
	
	public String getAllEmpList1()  {
		System.out.println("EmployeeAPI.getAllEmpList()");
		//System.err.println("EmployeeAPI.getAllEmpList()"+getMongoTemplate().findAll(entityClass));
		StringBuffer buffer = new StringBuffer();
		List<Employee> list = getMongoTemplate().findAll(Employee.class);
		if(list==null){
			System.err.println("result is null");
		}
		System.err.println("EmployeeAPI.getAllEmpList()" + list);
		
		
		for(Employee emp:list){
			buffer.append("Name:"+emp.getName()+"\n");
			buffer.append("Location:"+emp.getLocation()+"\n");
			buffer.append("\n\n");
		} 

		
		return buffer.toString();
	}
	
	
	public List<Employee> getAllEmpList()  {
		System.out.println("EmployeeAPI.getAllEmpList()");
		StringBuffer buffer = new StringBuffer();
		DBCollection collection = getMongoTemplate().getDb().getCollection("employee");
		DBCursor cursor = collection.find();
		List<Employee> list = getEmpList(cursor);
	
		
	 
		
 		System.err.println("EmployeeAPI.getAllEmpList()"+buffer.toString());
 		return list;
	}
	
	
	public List<Employee> searchEmployee(String empId)  {
		System.out.println("EmployeeAPI.searchEmployee():empId:"+empId);
		DBObject query = new BasicDBObject();
		query.put("_id",empId);
		DBCursor cursor  = getMongoTemplate().getDb().getCollection("employee").find(query);
		List<Employee> list = getEmpList(cursor);
		System.err.println("EmployeeAPI.searchEmployee()"+list);
	 
		
 		return list;
	}
	
	/**
	 * To get the list
	 * @param cursor
	 * @return
	 */
	private List<Employee> getEmpList(DBCursor cursor){
		List<Employee> list = new ArrayList<Employee>();
		while(cursor.hasNext()){
			Employee employee = new Employee();
			DBObject result = cursor.next();
			
			String name = (String) result.get("name");
			String id = (String) result.get("_id");
			String location = (String) result.get("location");
			
			employee.setName(name);
			employee.setId(id);
			employee.setLocation(location);
			
			list.add(employee);
		}
		
		return list;
	}


	public String deleteEmployee(String empId)  {
		System.out.println("EmployeeAPI.deleteEmployee()");
		DBObject query = new BasicDBObject();
		query.put("_id",empId);
		String message = "";
		try{
			getMongoTemplate().getDb().getCollection("employee").remove(query);
			message ="Employee "+ empId +" deleted Successfully";
		}catch(Exception e){
			message ="Error in deletion";
		}
		
	  
		System.err.println("EmployeeAPI.searchEmployee()"+message);
		
		
 		return message;
	}
	
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}


	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
}
