package com.example.restaurantPlaform.userInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

  private final UserInfoRepository userInfoRepository;

  @Autowired
  public UserInfoService(UserInfoRepository userInfoRepository) {
    this.userInfoRepository = userInfoRepository;
  }

  // public List<UserInfo> getUsers() {
  //   return userInfoRepository.findAll();
  // }

  public List<UserInfo> getUsers(Integer page, Integer size) {
    if (page == null || size == null) return userInfoRepository.findAll();

    PageRequest pageRequest = PageRequest.of(page, size);
    return userInfoRepository.findAll(pageRequest).toList();
  }

  public void saveUser(UserInfo user) throws IllegalStateException {
    Boolean sameEmailIsPresent = userInfoRepository.findUserInfoByEmail(user.getEmail()).isPresent();
    if (sameEmailIsPresent) throw new IllegalStateException("User with the same email has been registered");

    userInfoRepository.save(user);
  }

  public UserInfo getUserById(Long id) {
    return userInfoRepository.findById(id).orElseThrow(() -> new IllegalStateException("User info not found"));
  }
}
