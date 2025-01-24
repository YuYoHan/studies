package org.example.oauth2.controller.artillery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artillery")
public class ScenarioController {

    @PostMapping("/login")
    public String login() throws InterruptedException {
        Thread.sleep(20);
        return "Login Success";
    }

    @GetMapping("/som-function-one")
    public String someFunctionOne() throws InterruptedException {
        Thread.sleep(30);
        return "Result One";
    }

    @GetMapping("/some-function-two")
    public String someFunctionTwo() throws InterruptedException {
        Thread.sleep(15);
        return "Result Two";
    }
}
