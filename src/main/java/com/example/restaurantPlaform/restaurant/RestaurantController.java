package com.example.restaurantPlaform.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurantPlaform.utils.ErrorResponse;

@RestController
@RequestMapping(path = "api/restaurants")
public class RestaurantController {
  
  private final RestaurantService restaurantService;

  @Autowired
  public RestaurantController(RestaurantService restaurantService) {
    this.restaurantService = restaurantService;
  }

  @GetMapping
  public List<Restaurant> getRestaurants(
    @RequestParam(value = "page", defaultValue = "0") int page,
    @RequestParam(value = "size", defaultValue = "10") int size
  ) {
    return restaurantService.getRestaurants(page, size);
  }

  @PostMapping
  public void saveRestaurant(@RequestBody Restaurant restaurant) {
    restaurantService.saveRestaurant(restaurant);
  }

  @PutMapping(path = "{restaurantId}")
  public void updateRestaurant(@PathVariable Long restaurantId, @RequestBody Restaurant restaurant) {
    restaurantService.updateRestaurant(restaurantId, restaurant);
  }

  @DeleteMapping(path = "{restaurantId}")
  public ResponseEntity<ErrorResponse> deleteRestaurant(@PathVariable Long restaurantId) {
    try {
      restaurantService.deleteRestaurant(restaurantId);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (IllegalStateException illegalStateException) {
      ErrorResponse errorResponse = new ErrorResponse();
      errorResponse.setMessage("Restarant no found");
      return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
  }
}
