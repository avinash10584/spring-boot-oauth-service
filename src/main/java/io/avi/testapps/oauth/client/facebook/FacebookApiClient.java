package io.avi.testapps.oauth.client.facebook;

import io.avi.testapps.oauth.client.AbstractOauthApiClient;

public class FacebookApiClient extends AbstractOauthApiClient {

    private static final String GRAPH_API_BASE_URL = "https://graph.facebook.com/v2.12";

    public FacebookApiClient(String accessToken) {
        super(accessToken);
    }

    public String getProfile() {
        return restTemplate.getForObject(GRAPH_API_BASE_URL + "/me", String.class);
    }

    public String getFeed() {
        return restTemplate.getForObject(GRAPH_API_BASE_URL + "/me/feed", String.class);
    }

}