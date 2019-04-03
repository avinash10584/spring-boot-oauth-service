package io.avi.testapps.oauth.rest;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {

    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;
    
    @GetMapping("/userinfo")
    public String userinfo(Model model, OAuth2AuthenticationToken authentication) {
        
        OAuth2AuthorizedClient authorizedClient = this.authorizedClientService.loadAuthorizedClient(authentication.
                getAuthorizedClientRegistrationId(), authentication.getName());
        
        String userInfoEndpointUri = authorizedClient.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUri();
        
        if (!StringUtils.isEmpty(userInfoEndpointUri)) {    // userInfoEndpointUri is optional for OIDC Clients
            System.out.println("test");
        }
        model.addAttribute("userAttributes", userAttributes);
        return "userinfo";
    }
}
