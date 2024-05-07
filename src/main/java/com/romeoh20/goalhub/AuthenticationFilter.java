package com.romeoh20.goalhub;

import com.romeoh20.goalhub.controllers.AuthenticationController;
import com.romeoh20.goalhub.models.data.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

public class AuthenticationFilter implements HandlerInterceptor {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthenticationController authenticationController;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response
                            ,Object handler) throws IOException {

        return true;
    }
}
