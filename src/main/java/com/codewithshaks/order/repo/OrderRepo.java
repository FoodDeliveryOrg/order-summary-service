package com.codewithshaks.order.repo;

import com.codewithshaks.order.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends MongoRepository<Order,Integer> {
}
