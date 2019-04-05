package io.avi.testapps.oauth.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.avi.testapps.oauth.AccessToken;
import io.avi.testapps.oauth.client.OAuthProvider;
import io.avi.testapps.oauth.client.social.OAuthApiClient;

@RestController
public class OAuthController {
    
    @Autowired
    protected AccessToken accessToken;
    
    @Autowired
    private OAuthProvider oauthProvider;
    
    @GetMapping("/userinfo")
    public String userinfo() {     
                
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userInfoEndpointUri = oauthProvider.getApiRegistration((OAuth2AuthenticationToken)authentication).
                getProviderDetails().getUserInfoEndpoint().getUri();
        
        if (!StringUtils.isEmpty(userInfoEndpointUri)) {    // userInfoEndpointUri is optional for OIDC Clients
            OAuthApiClient apiClient = new OAuthApiClient(accessToken.getToken());
            return apiClient.getUserInfo(userInfoEndpointUri);
        }
        return "User Info Endpoint not configured";
    }
}
