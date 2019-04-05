package io.avi.testapps.oauth.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.avi.testapps.oauth.AccessToken;
import io.avi.testapps.oauth.client.social.FacebookApiClient;


@RestController
@RequestMapping("/facebook")
public class FacebookController {
    
    @Autowired
    protected AccessToken accessToken;
    
    @GetMapping("/profile")    
    public String getProfile() {
        return new FacebookApiClient(accessToken.getToken()).getProfile();
    }
}
