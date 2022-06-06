package com.example.restaurantPlaform.utils.response;

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

  // public static ServiceResponse success() {

  // }

  public int getErrorCode() {
    return this.errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getData() {
    return this.data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public boolean isSuccess() {
    return this.success;
  }

  public boolean getSuccess() {
    return this.success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

}
