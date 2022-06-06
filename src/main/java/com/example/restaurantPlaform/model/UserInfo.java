package com.example.restaurantPlaform.model;

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
import javax.validation.constraints.Past;

@Entity
@Table
public class UserInfo {

  @Id
  @SequenceGenerator(
    name = "user_sequence",
    sequenceName = "user_sequence",
    initialValue = 1
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
  @Past(message = "Date of birth is mandatory and must be a date from the past")
  private LocalDate dob;

  @Transient
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

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public LocalDate getDob() {
    return this.dob;
  }

  public void setDob(LocalDate dob) {
    this.dob = dob;
  }

  public Integer getAge() {
    return Period.between((this.dob == null ? LocalDate.now() : this.dob), LocalDate.now()).getYears();
  }

  public void setAge(Integer age) {
    this.age = age;
  }

}
