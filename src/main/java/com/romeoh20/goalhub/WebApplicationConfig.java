package com.romeoh20.goalhub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebApplicationConfig implements WebMvcConfigurer {

    @Bean
    public AuthenticationFilter authenticationFilter (){
        return new AuthenticationFilter();
    }


}
