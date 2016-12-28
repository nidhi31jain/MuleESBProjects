package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class TestDAO extends AbstractDAO {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	
	
}
