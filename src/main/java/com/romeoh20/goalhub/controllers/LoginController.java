package com.romeoh20.goalhub.controllers;

import com.romeoh20.goalhub.models.User;
import com.romeoh20.goalhub.models.data.UserRepository;
import com.romeoh20.goalhub.models.dto.LoginFormDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String displayLoginForm(Model model){
        model.addAttribute(new LoginFormDTO());
        return "login";
    }

    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute @Valid LoginFormDTO loginFormDTO, Errors errors,
                                   HttpServletRequest request, SignUpController signUpController){

        if(errors.hasErrors()){
            return "login";
        }

        User theUser = userRepository.findByUsername(loginFormDTO.getUsername());

        if(theUser == null){
            errors.rejectValue("username","user.valid","Invalid Login");
            return "login";
        }

        String password = loginFormDTO.getPassword();

        if(!theUser.isMatchingPassword(password)){
            errors.rejectValue("password","password.invalid","Invalid Login");
            return "login";
        }

        signUpController.setUserInSession(request.getSession(), theUser);
        return "login";
    }

}
