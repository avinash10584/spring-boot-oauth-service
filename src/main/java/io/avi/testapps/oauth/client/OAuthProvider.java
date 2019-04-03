package io.avi.testapps.oauth.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.stereotype.Component;

@Component
public class OAuthProvider {

    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;

    public ClientRegistration getApiRegistration(OAuth2AuthenticationToken authentication) {
        OAuth2AuthorizedClient authorizedClient = this.authorizedClientService.loadAuthorizedClient(authentication.
                getAuthorizedClientRegistrationId(), authentication.getName());        
        return authorizedClient.getClientRegistration();
    }
}
