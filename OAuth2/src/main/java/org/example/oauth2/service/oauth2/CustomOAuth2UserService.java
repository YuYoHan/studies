package org.example.oauth2.service.oauth2;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.oauth2.dto.oauth2.CustomOAuth2User;
import org.example.oauth2.dto.oauth2.GoogleResponse;
import org.example.oauth2.dto.oauth2.NaverResponse;
import org.example.oauth2.dto.oauth2.OAuth2Response;
import org.example.oauth2.entity.MemberEntity;
import org.example.oauth2.repository.MemberRepository;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    private final MemberRepository memberRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        log.info(oAuth2User.getAttributes());

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        log.info(registrationId);
        OAuth2Response oAuth2Response = null;

        if (registrationId.equals("naver")) {
            oAuth2Response = new NaverResponse(oAuth2User.getAttributes());
        }

        if (registrationId.equals("google")) {
            oAuth2Response = new GoogleResponse(oAuth2User.getAttributes());
        }

        String role = null;
        if(oAuth2Response != null) {
            String userName = oAuth2Response.getProvider() + " " + oAuth2Response.getProviderId();
            MemberEntity existData = memberRepository.findByUserName(userName);

            if(existData == null) {
                memberRepository.save( MemberEntity.builder()
                        .userName(userName)
                        .email(oAuth2Response.getEmail())
                        .role("ROLE_USER")
                        .build());
            }

            role = existData.getRole();

            existData.setEmail(oAuth2Response.getEmail());
            memberRepository.save(existData);

            return new CustomOAuth2User(oAuth2Response, role);
        }

        return null;
    }
}
