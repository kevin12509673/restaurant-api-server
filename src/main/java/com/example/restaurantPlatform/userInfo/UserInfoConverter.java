package com.example.restaurantPlatform.userInfo;

import org.springframework.stereotype.Component;

import com.example.restaurantPlatform.converter.EntityConverter;

@Component
public class UserInfoConverter implements EntityConverter<UserInfoDTO, UserInfo> {
  public UserInfo convertDtoToEntity(UserInfoDTO userInfoDTO) {
    UserInfo userInfo = new UserInfo();
    userInfo.setDob(userInfoDTO.getDob());
    userInfo.setEmail(userInfoDTO.getEmail());
    userInfo.setId(userInfoDTO.getId());
    userInfo.setName(userInfoDTO.getName());
    userInfo.setPassword(userInfoDTO.getPassword());
    return userInfo;
  }

  public UserInfoDTO convertEntityToDto(UserInfo userInfo) {
    UserInfoDTO userInfoDTO = new UserInfoDTO();
    userInfoDTO.setAge(userInfo.getAge());
    userInfoDTO.setDob(userInfo.getDob());
    userInfoDTO.setEmail(userInfo.getEmail());
    userInfoDTO.setId(userInfo.getId());
    userInfoDTO.setName(userInfo.getName());
    userInfoDTO.setPassword(userInfo.getPassword());
    return userInfoDTO;
  }
}
