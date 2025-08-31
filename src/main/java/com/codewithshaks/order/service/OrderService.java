package com.codewithshaks.order.service;

import com.codewithshaks.order.dto.OrderDTO;
import com.codewithshaks.order.dto.OrderDTOfromFE;
import com.codewithshaks.order.dto.UserDTO;
import com.codewithshaks.order.entity.Order;
import com.codewithshaks.order.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    SequenceGenerator sequenceGenerator;
    @Autowired
    RestTemplate restTemplate;

    public OrderDTO saveOrder(OrderDTOfromFE orderDetails) {
        Integer nextOrderId = sequenceGenerator.generateNextOrderId();
        UserDTO user = fetchUserById(orderDetails.getUserId());

        Order orderToBeSaved = new Order(nextOrderId, orderDetails.getFoodItemList(), orderDetails.getRestaurant(), user);
        Order savedOrder = orderRepo.save(orderToBeSaved);
        return new OrderDTO(savedOrder.getOrderId(), savedOrder.getFoodItemList(), savedOrder.getRestaurant(), savedOrder.getUser());
    }

    private UserDTO fetchUserById(Integer userId) {
        return restTemplate.getForObject("http://USERINFO-SERVICE/user/getUserById/"+userId,UserDTO.class);
    }
}
