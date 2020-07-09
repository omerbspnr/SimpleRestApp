package org.csystem.app.controller;

import org.csystem.app.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    @GetMapping("/register")
    public String register()
    {
        return "register.html";
    }

    @PostMapping("/register")
    public String create()
    {
        return "register.html";
    }
}
