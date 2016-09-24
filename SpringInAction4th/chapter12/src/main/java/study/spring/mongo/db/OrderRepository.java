package study.spring.mongo.db;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import study.spring.mongo.Order;

public interface OrderRepository extends MongoRepository<Order, String>, OrderCustomRepository {
	
	List<Order> findByCustomer(String customer);
	
	List<Order> findByCustomerLike(String customer);

	List<Order> findByCustomerAndType(String customer, String type);

	List<Order> getByType(String type);
		
	@Query("{customer:'Chuck Wagon'}")
	List<Order> findChucksOrders();

}
