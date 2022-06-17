package com.example.restaurantPlatform.converter;

public interface EntityConverter<D, E> {
  public D convertEntityToDto(E entity);

  public E convertDtoToEntity(D dto);
}
