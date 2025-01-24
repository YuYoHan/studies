package org.example.oauth2.config;

import lombok.RequiredArgsConstructor;
import org.example.oauth2.config.oauth2.CustomClientRegistrationRepo;
import org.example.oauth2.config.oauth2.CustomOAuth2AuthorizationService;
import org.example.oauth2.service.oauth2.CustomOAuth2UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomOAuth2UserService oAuth2UserService;
    private final CustomClientRegistrationRepo customClientRegistrationRepo;
    private final JdbcTemplate jdbcTemplate;
    private final CustomOAuth2AuthorizationService customOAuth2AuthorizationService;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable());
        http.formLogin(login -> login.disable());
        http.httpBasic(basic -> basic.disable());

        http.oauth2Login(oauth2 -> oauth2
                .loginPage("/login")
                .clientRegistrationRepository(customClientRegistrationRepo.clientRegistrationRepository())
                .authorizedClientService(customOAuth2AuthorizationService.oAuth2AuthorizedClientService(jdbcTemplate, customClientRegistrationRepo.clientRegistrationRepository()))
                .userInfoEndpoint((userInfoEndpointConfig -> userInfoEndpointConfig
                        .userService(oAuth2UserService))));

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/oauth2/**", "/login/**").permitAll()
                .anyRequest().authenticated());

        return http.build();
    }
}
