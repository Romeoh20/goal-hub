package com.romeoh20.goalhub.controllers;

import com.romeoh20.goalhub.models.User;
import com.romeoh20.goalhub.models.data.UserRepository;
import com.romeoh20.goalhub.models.dto.SignUpFormDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

private static void setUserInSession(HttpSession session, User user){
  session.setAttribute(userSessionKey,user.getId());
}

@GetMapping("/SignUp")
public String displaySignUpForm(Model model){
  model.addAttribute(new SignUpFormDTO());
  return "SignUp";
}

@PostMapping("/SignUp")
public String processSignUpForm(@ModelAttribute @Valid SignUpFormDTO signUpFormDTO,
                                Errors errors, HttpServletRequest request, Model model){
  if(errors.hasErrors()){
   return "SignUp";
  }

  User existingUser = userRepository.findByUsername(signUpFormDTO.getUsername());

  if(existingUser != null){
   errors.rejectValue("username","username.alreadyexists",
           "A user with that name already exists");
   return "SignUp";
  }

  String password = signUpFormDTO.getPassword();
  String verifyPassword = signUpFormDTO.getVerifyPassword();

  if(!password.equals(verifyPassword)){
   errors.rejectValue("password","password.mismatch",
           "Password does not match");
   return "SignUp";
  }

  User newUser = new User(signUpFormDTO.getUsername(),signUpFormDTO.getPassword());
  userRepository.save(newUser);
  return "SignUp";
}




}
