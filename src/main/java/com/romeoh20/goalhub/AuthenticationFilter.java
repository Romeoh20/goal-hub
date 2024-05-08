package com.romeoh20.goalhub;

import com.romeoh20.goalhub.controllers.AuthenticationController;
import com.romeoh20.goalhub.models.User;
import com.romeoh20.goalhub.models.data.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthenticationFilter implements HandlerInterceptor {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthenticationController authenticationController;

    private static final List<String> whiteList = Arrays.asList("/login", "/signup", "/logout", "/css");

    private static boolean isWhiteListed(String path){
        for(String pathRoot : whiteList){
            if(path.startsWith(pathRoot)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                            Object handler) throws IOException {

        if(isWhiteListed(request.getRequestURI())){
            return true;
        }

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        if(user != null){
            return true;
        }

        response.sendRedirect("/login");
        return false;
    }
}
