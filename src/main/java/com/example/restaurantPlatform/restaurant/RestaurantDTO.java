package com.example.restaurantPlatform.restaurant;

import lombok.Data;

@Data
public class RestaurantDTO {
  private Long id;
  private String name;
  private String address;
  private Float rate;
}
