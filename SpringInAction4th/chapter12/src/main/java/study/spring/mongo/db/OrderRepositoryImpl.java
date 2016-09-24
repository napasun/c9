package study.spring.mongo.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

public class OrderRepositoryImpl implements OrderCustomRepository {
	@Autowired MongoOperations mongo;
}
