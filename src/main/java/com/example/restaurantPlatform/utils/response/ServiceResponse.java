package com.example.restaurantPlatform.utils.response;

import lombok.Data;

@Data
public class ServiceResponse {
  private int errorCode;
  private String message;
  private String data;
  private boolean success;

  ServiceResponse(int errorCode, String message, String data, boolean success) {
    this.errorCode = errorCode;
    this.message = message;
    this.data = data;
    this.success = success;
  }
}
