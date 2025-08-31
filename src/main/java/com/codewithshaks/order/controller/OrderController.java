package com.codewithshaks.order.controller;

import com.codewithshaks.order.dto.OrderDTO;
import com.codewithshaks.order.dto.OrderDTOfromFE;
import com.codewithshaks.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    @PostMapping("/save")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOfromFE orderDetails){
        OrderDTO savedOrder = orderService.saveOrder(orderDetails);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

}
