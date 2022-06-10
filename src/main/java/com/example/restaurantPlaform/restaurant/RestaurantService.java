package com.example.restaurantPlaform.restaurant;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

  private final RestaurantRepository restaurantRepository;

  @Autowired
  public RestaurantService(RestaurantRepository restaurantRepository) {
    this.restaurantRepository = restaurantRepository;
  }

  public List<Restaurant> getRestaurants(Pageable pageable) {
    return restaurantRepository.findAll(pageable).toList();
  }
  
  public Restaurant getRestaurant(Long restaurantId) {
    return restaurantRepository.findById(restaurantId).orElseThrow(() -> new IllegalStateException("Restaurant not found"));
  }
  public void saveRestaurant(Restaurant restaurant) {
    restaurantRepository.save(restaurant);
  }

  @Transactional
  public void updateRestaurant(Long restaurantId, Restaurant restaurant) {
    Restaurant targetRestaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new IllegalStateException("Restarant now found"));

    if (restaurant.getName() != null) targetRestaurant.setName(restaurant.getName());
    if (restaurant.getRate() != null) targetRestaurant.setRate(restaurant.getRate());
    if (restaurant.getAddress() != null) targetRestaurant.setAddress(restaurant.getAddress());
  }

  public void deleteRestaurant(Long restaurantId) throws IllegalStateException {
    boolean exists = restaurantRepository.existsById(restaurantId);
    if (!exists) {
      throw new IllegalStateException("Restaurant does not exist");
    }

    restaurantRepository.deleteById(restaurantId);
  }

}
