package com.example.restaurantPlaform.service;

import java.util.List;

import com.example.restaurantPlaform.model.UserInfo;
import com.example.restaurantPlaform.model.UserInfoRepository;

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
    // if (user.getName() == null) throw new IllegalStateException("Name cannot be empty");
    // if (user.getName() == null) throw new IllegalStateException(UserInfoServiceError.Null_Name.getDescription());
    // if (user.getAge() == null) throw new IllegalStateException("Age cannot be empty");
    // if (user.getDob() == null) throw new IllegalStateException("Date of birth cannot be empty");
    // if (user.getEmail() == null) throw new IllegalStateException("Email cannot be empty");
    // if (user.getPassword() == null) throw new IllegalStateException("Password cannot be empty");

    if (userInfoRepository.findUserInfoByEmail(user.getEmail()).isPresent()) throw new IllegalStateException("User with the same email has been registered");

    userInfoRepository.save(user);
  }
}
