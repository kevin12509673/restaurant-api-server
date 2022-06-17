package com.example.restaurantPlatform.restaurant;

import org.springframework.stereotype.Component;

import com.example.restaurantPlatform.converter.EntityConverter;

@Component
public class RestaurantConverter implements EntityConverter<RestaurantDTO, Restaurant> {
  public RestaurantDTO convertEntityToDto(Restaurant restaurant) {
    RestaurantDTO restaurantDTO = new RestaurantDTO();
    restaurant.setId(restaurant.getId());
    restaurant.setAddress(restaurant.getAddress());
    restaurant.setName(restaurant.getName());
    restaurant.setRate(restaurant.getRate());
    return restaurantDTO;
  }

  public Restaurant convertDtoToEntity(RestaurantDTO restaurantDTO) {
    return new Restaurant(
        restaurantDTO.getName(),
        restaurantDTO.getAddress(),
        restaurantDTO.getRate());
  }
}
