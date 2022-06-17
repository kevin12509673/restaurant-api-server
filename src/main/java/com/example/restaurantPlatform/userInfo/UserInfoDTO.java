package com.example.restaurantPlatform.userInfo;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserInfoDTO {

  private Long id;

  @NotBlank
  private String name;

  @NotBlank
  private String email;

  @NotBlank
  private String password;

  @NotBlank
  private LocalDate dob;

  private Integer age;
}
