package org.example.oauth2.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.example.oauth2.dto.MemberDTO;
import org.example.oauth2.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@Slf4j
public class JoinController {
    private final MemberService memberService;

    @GetMapping("/join")
    public String joinPage() {
        return "joinPage";
    }

    @PostMapping("/join")
    @ResponseBody
    public String join(@ModelAttribute MemberDTO member) {
        log.info("member: {}", member);
        memberService.join(member);
        return "ok";
    }
}
