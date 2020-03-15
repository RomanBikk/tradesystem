package com.tradesystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/web")
public class AuthWebController {

    @GetMapping("login")
    public String login() {
        return "login";
    }
}
