package org.example.oauth2.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable());

        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll());

        http
                .formLogin(Customizer.withDefaults());

        return http.build();
    }

    // OAuth2 및 OIDC 기능을 제공하는 인증 서버(Authorization Server)를 설정
    @Bean
    public AuthorizationServerSettings authorizationServerSettings() {
        return AuthorizationServerSettings.builder()
                .issuer("http://localhost:9000")  // 인증 서버의 기본 URL (issuer)
                .authorizationEndpoint("/oauth2/v1/authorize")  // 인증 요청 (Authorization) 엔드포인트
                .tokenEndpoint("/oauth2/v1/token")  // 액세스 토큰 발급 엔드포인트
                .tokenIntrospectionEndpoint("/oauth2/v1/introspect")  // 액세스 토큰 유효성 검사 엔드포인트
                .tokenRevocationEndpoint("/oauth2/v1/revoke")  // 액세스 토큰 취소 (Revocation) 엔드포인트
                .jwkSetEndpoint("/oauth2/v1/jwks")  // JSON Web Key Set (JWK) 엔드포인트
                .oidcLogoutEndpoint("/connect/v1/logout")  // OIDC 로그아웃 엔드포인트
                .oidcUserInfoEndpoint("/connect/v1/userinfo")  // OIDC 사용자 정보 엔드포인트
                .oidcClientRegistrationEndpoint("/connect/v1/register")  // OIDC 클라이언트 등록 엔드포인트
                .build();
    }

}
