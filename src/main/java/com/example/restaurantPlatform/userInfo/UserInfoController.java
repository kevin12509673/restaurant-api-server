package com.example.restaurantPlatform.userInfo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurantPlatform.utils.ErrorResponse;

@RestController
@RequestMapping(path = "/api/users")
public class UserInfoController {

  private final UserInfoService userInfoService;
  private final UserInfoConverter userInfoConverter;

  public UserInfoController(UserInfoService userInfoService, UserInfoConverter userInfoConverter) {
    this.userInfoService = userInfoService;
    this.userInfoConverter = userInfoConverter;
  }

  @GetMapping
  public List<UserInfo> getUsers(Pageable pageRequest) {
    return userInfoService.getUsers(pageRequest);
  }

  @GetMapping(path = "/{id}")
  public UserInfo getUserById(@PathVariable Long id) {
    return userInfoService.getUserById(id);
  }

  @PostMapping()
  public ResponseEntity<?> saveUser(@Valid @RequestBody UserInfoDTO userInfoDTO) {
    try {
      UserInfo userInfo = userInfoConverter.convertDtoToEntity(userInfoDTO);
      userInfoService.saveUser(userInfo);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (IllegalStateException e) {
      ErrorResponse errorResponse = new ErrorResponse();
      errorResponse.setMessage(e.getMessage());
      return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }
  }
}
