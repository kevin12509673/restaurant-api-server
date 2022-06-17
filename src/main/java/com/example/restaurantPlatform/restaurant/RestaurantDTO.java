package com.example.restaurantPlatform.restaurant;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.Data;

@ApiModel
@Data
public class RestaurantDTO {
  @Schema(accessMode = AccessMode.READ_ONLY)
  private Long id;

  @Schema(required = true)
  private String name;

  @Schema(required = true)
  private String address;

  @Schema(required = true)
  private Float rate;
}
