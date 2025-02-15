package org.example.oauth2.service.oauth2;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.oauth2.dto.oauth2.CustomOAuth2User;
import org.example.oauth2.dto.oauth2.GoogleResponse;
import org.example.oauth2.dto.oauth2.NaverResponse;
import org.example.oauth2.dto.oauth2.OAuth2Response;
import org.example.oauth2.entity.MemberEntity;
import org.example.oauth2.repository.MemberRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberEntity member = memberRepository.findByUserName(username);

        UserDetails userDetails = User.builder()
                .username(member.getUserName())
                .password(member.getPassword())
                .roles(member.getRole())
                .build();
        log.info("userDetails: {}", userDetails);
        return userDetails;
    }
}
