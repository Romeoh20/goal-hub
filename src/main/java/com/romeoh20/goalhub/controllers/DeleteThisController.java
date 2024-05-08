package com.romeoh20.goalhub.controllers;

import com.romeoh20.goalhub.models.User;
import com.romeoh20.goalhub.models.data.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeleteThisController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationController authenticationController;

    @GetMapping("/delete")
    public String displayDeleteThisTemplate(Model model, HttpServletRequest request){

        User currentUser = authenticationController.getUserFromSession(request.getSession());
        String username;

        if(currentUser != null){

            username = currentUser.getUsername();
        }else{
            username = "ANONYMOUS+_+";
        }

        model.addAttribute("username",username);

        return"delete-this-template";
    }



}
