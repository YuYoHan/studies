package org.example.oauth2.controller.oauth2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oauth2")
public class LoginController {
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
