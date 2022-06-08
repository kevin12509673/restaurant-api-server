package com.example.restaurantPlaform.userInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

  private final UserInfoRepository userInfoRepository;

  @Autowired
  public UserInfoService(UserInfoRepository userInfoRepository) {
    this.userInfoRepository = userInfoRepository;
  }

  public List<UserInfo> getUsers() {
    return userInfoRepository.findAll();
  }

  public void saveUser(UserInfo user) throws IllegalStateException {
    Boolean sameEmailIsPresent = userInfoRepository.findUserInfoByEmail(user.getEmail()).isPresent();
    if (sameEmailIsPresent) throw new IllegalStateException("User with the same email has been registered");

    userInfoRepository.save(user);
  }
}
