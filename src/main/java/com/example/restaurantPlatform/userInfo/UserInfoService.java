package com.example.restaurantPlatform.userInfo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

  private final UserInfoRepository userInfoRepository;

  public UserInfoService(UserInfoRepository userInfoRepository) {
    this.userInfoRepository = userInfoRepository;
  }

  public List<UserInfo> getUsers(Pageable pageable) {
    return userInfoRepository.findAll(pageable).toList();
  }

  public void saveUser(UserInfo userInfo) throws IllegalStateException {
    boolean sameEmailIsPresent = userInfoRepository.findUserInfoByEmail(userInfo.getEmail()).isPresent();
    if (sameEmailIsPresent)
      throw new IllegalStateException("User with the same email has been registered");

    userInfoRepository.save(userInfo);
  }

  public UserInfo getUserById(Long id) {
    return userInfoRepository.findById(id).orElseThrow(() -> new IllegalStateException("User info not found"));
  }
}
