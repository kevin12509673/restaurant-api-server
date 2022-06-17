package com.example.restaurantPlatform.userInfo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserInfoDTO {

  private Long id;

  private String name;

  private String email;

  private String password;

  private LocalDate dob;

  private Integer age;
}
