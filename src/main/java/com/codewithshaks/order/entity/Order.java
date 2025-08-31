package com.codewithshaks.order.entity;

import com.codewithshaks.order.dto.FoodItemDTO;
import com.codewithshaks.order.dto.RestaurantDTO;
import com.codewithshaks.order.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "order")
public class Order {
    private Integer orderId;
    private List<FoodItemDTO> foodItemList;
    private RestaurantDTO restaurant;
    private UserDTO user;
}
