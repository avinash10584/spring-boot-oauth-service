package io.avi.testapps.oauth.client.social;

import io.avi.testapps.oauth.client.OAuthRestTemplate;

public class GoogleApiClient extends OAuthRestTemplate {

    private static final String GMAIL_BASE_URL = "https://www.googleapis.com/gmail/v1/users/%s/profile";

    public GoogleApiClient(String accessToken) {
        super(accessToken);
    }

    public String getProfile() {
        return restTemplate.getForObject(String.format(GMAIL_BASE_URL, "me"), String.class);
    }
}