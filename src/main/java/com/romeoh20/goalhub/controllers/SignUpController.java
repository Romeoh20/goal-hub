package com.romeoh20.goalhub.controllers;

import com.romeoh20.goalhub.models.User;
import com.romeoh20.goalhub.models.data.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class SignUpController {

 @Autowired
 UserRepository userRepository;

 private static final String userSessionKey = "user";

 public User getUserFromSession (HttpSession session) {
  Integer userId = (Integer) session.getAttribute(userSessionKey);

  if(userId == null){
   return null;
  }

  Optional <User> user = userRepository.findById(userId);

  if(user.isEmpty()){
   return null;
  }

  return user.get();
 }






}
