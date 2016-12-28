package dao;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

/**
 * 
 * Class Responsible for Abstracting dao operations
 * 
 * @version 1.0
 *
 */
@Repository
public class AbstractDAO implements InitializingBean, DisposableBean {
	@Autowired
	public MongoTemplate mongoTemplate;
	//public Employee employee;
	public AbstractDAO() {
		super();
	}


	

	/**
	 * @return the mongoTemplate
	 */
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	/**
	 * @param mongoTemplate
	 *            the mongoTemplate to set
	 */
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(this.mongoTemplate, "mongoTemplate must be provided");
		
	
	}

	public void destroy() throws Exception {
		Assert.notNull(this.mongoTemplate, "mongoTemplate must be provided");
	}
}
