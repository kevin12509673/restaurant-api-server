package com.example.restaurantPlaform.userInfo;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Entity
@Table
@Data
public class UserInfo {

  @Id
  @SequenceGenerator(
    name = "user_sequence",
    sequenceName = "user_sequence",
    initialValue = 1001
  )
  @GeneratedValue(
    generator = "user_sequence",
    strategy = GenerationType.SEQUENCE
  )
  private Long id;

  @Column(
    nullable = false
  )
  @NotBlank(message = "Name is mandatory")
  private String name;

  @Column(
    nullable = false
  )
  @NotBlank(message = "Email is mandatory")
  private String email;

  @Column(
    nullable = false
  )
  @NotBlank(message = "Password is mandatory")
  private String password;

  @Column(
    nullable = false
  )
  @Past(message = "Date must be a date from the past")
  @NotNull(message = "Date of birth is mandatory")
  private LocalDate dob;

  @Transient
  @Getter(value = AccessLevel.NONE)
  private Integer age;

  public UserInfo(String name, String email, String password, LocalDate dob, Integer age) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.dob = dob;
    this.age = age;
  }

  public UserInfo() {
  }

  public Integer getAge() {
    return Period.between((this.dob == null ? LocalDate.now() : this.dob), LocalDate.now()).getYears();
  }
}
