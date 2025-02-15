package org.example.oauth2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.oauth2.dto.MemberDTO;
import org.example.oauth2.entity.MemberEntity;
import org.example.oauth2.repository.MemberRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void join(MemberDTO member) {
        log.info("비번체크 {} ", member.getPassword());

        MemberEntity entity = MemberEntity.builder()
                .userName(member.getUserName())
                .password(bCryptPasswordEncoder.encode(member.getPassword()))
                .nickName(member.getNickName())
                .phone(member.getPhone())
                .role("ADMIN")
                .build();

        memberRepository.save(entity);
    }
}
