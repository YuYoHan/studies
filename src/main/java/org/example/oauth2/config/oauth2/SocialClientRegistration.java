package org.example.oauth2.config.oauth2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
import org.springframework.stereotype.Component;

@Component
public class SocialClientRegistration {

    @Value("${spring.security.oauth2.client.registration.google.client-id}")
    private String googleClientId;
    @Value("${spring.security.oauth2.client.registration.google.client-secret}")
    private String googleSecret;
    @Value("${spring.security.oauth2.client.registration.google.redirect-uri}")
    private String googleRedirectUri;
    @Value("${spring.security.oauth2.client.registration.google.scope}")
    private String googleScope;
    @Value("${spring.security.oauth2.client.provider.naver.authorization-uri}")
    private String googleAuthorizationUri;
    @Value("${spring.security.oauth2.client.provider.naver.token-uri}")
    private String googleTokenUri;
    @Value("${spring.security.oauth2.client.provider.naver.user-info-uri}")
    private String googleUserInfo;

    public ClientRegistration googleClientRegistration() {
        return ClientRegistration.withRegistrationId("google")
                .clientId(googleClientId)
                .clientSecret(googleSecret)
                .redirectUri(googleRedirectUri)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .scope(googleScope)
                .authorizationUri(googleAuthorizationUri)
                .tokenUri(googleTokenUri)
                .userInfoUri(googleUserInfo)
                .userNameAttributeName(IdTokenClaimNames.SUB)
                .build();
    }
}
