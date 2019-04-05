package io.avi.testapps.oauth.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.avi.testapps.oauth.AccessToken;
import io.avi.testapps.oauth.client.social.GoogleApiClient;

@RestController
@RequestMapping("/google")
public class GoogleController {
    
    @Autowired
    protected AccessToken accessToken;
    
    @GetMapping("/gmail")    
    public String getProfile() {
        return new GoogleApiClient(accessToken.getToken()).getProfile();
    }
}
