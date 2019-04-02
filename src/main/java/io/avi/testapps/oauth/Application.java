package io.avi.testapps.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.bind.annotation.RestController;

import io.avi.testapps.oauth.service.UserInfoOAuthService;

@SpringBootApplication
@RestController
public class Application extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserInfoOAuthService userInfoService;
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
        
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /* @formatter:off */ 
        http
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()     
            .authorizeRequests()
            .anyRequest().authenticated()
        .and()
            .oauth2Login()  
                .userInfoEndpoint()
                .userService(userInfoService);
        /* @formatter:on */  
    }
}
