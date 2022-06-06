package com.example.restaurantPlaform.restaurant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Restaurant {
  @Id
  @SequenceGenerator(
    name = "restaurant_sequence",
    sequenceName = "restaurant_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    generator = "restaurant_sequence",
    strategy = GenerationType.SEQUENCE
  )
  private Long id;

  @Column(
    nullable = false
  )
  private String name;

  @Column(
    nullable = false
  )
  private String address;

  @Column(
    nullable = false
  )
  private Float rate;

  public Restaurant(String name, String address, Float rate) {
    this.name = name;
    this.address = address;
    this.rate = rate;
  }

  public Restaurant() {
  }
}
