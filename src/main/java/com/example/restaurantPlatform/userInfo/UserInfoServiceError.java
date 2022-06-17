package com.example.restaurantPlatform.userInfo;

public enum UserInfoServiceError {
  NULL_NAME(1001, "User name is null"),
  NULL_AGE(1002, "User age is null"),
  NULL_DOB(1003, "User date of birth is null"),
  NULL_EMAIL(1004, "User email is null"),
  NULL_PASSWORD(1005, "User password is null");

  private Integer code;
  private String description;

  UserInfoServiceError(Integer code, String description) {
    this.code = code;
    this.description = description;
  }

  public Integer getCode() {
    return this.code;
  }

  public String getDescription() {
    return this.description;
  }
}
