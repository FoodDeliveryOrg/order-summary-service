package com.codewithshaks.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTOfromFE {

    private List<FoodItemDTO> foodItemList;
    private Integer userId;
    private RestaurantDTO restaurant;
}
