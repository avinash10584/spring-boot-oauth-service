package io.avi.testapps.oauth.client.social;

import io.avi.testapps.oauth.client.OAuthRestTemplate;

public class OAuthApiClient extends OAuthRestTemplate {

    public OAuthApiClient(String accessToken) {
        super(accessToken);
    }
    
    public String getUserInfo(String userInfoEndpoint) {
        return restTemplate.getForObject(userInfoEndpoint, String.class);
    }
}