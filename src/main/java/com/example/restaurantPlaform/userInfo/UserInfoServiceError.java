package com.example.restaurantPlaform.userInfo;

public enum UserInfoServiceError {
  Null_Name(1001, "User name is null"),
  Null_Age(1002, "User age is null"),
  Null_Dob(1003, "User date of birth is null"),
  Null_Email(1004, "User email is null"),
  Null_Password(1005, "User password is null");

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
