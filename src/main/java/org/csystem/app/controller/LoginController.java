package org.csystem.app.controller;

import org.csystem.app.converter.UserFormToUser;
import org.csystem.app.dtos.UserForm;
import org.csystem.app.entity.User;
import org.csystem.app.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class LoginController {
    private final IUserService m_userService;

    public LoginController(IUserService userService)
    {
        m_userService = userService;
    }

    @GetMapping("/login")
    public ResponseEntity<String> page()
    {
        return new ResponseEntity<>("login.html", HttpStatus.OK);
    }
    @PostMapping(value = "/login", produces = "application/json")
    public ResponseEntity<String> login(@Valid UserForm loginForm, BindingResult bindingResult)
    {

        if (bindingResult.hasErrors())
            return new ResponseEntity<>("login.html", HttpStatus.OK);

        UserFormToUser ltu = new UserFormToUser();
        Optional<User> usrOpt = m_userService.controlForLogin(ltu.convert(loginForm));

        return usrOpt.map(user -> ResponseEntity.ok(user.toString()))
                .orElseGet(() -> ResponseEntity.ok("Hatali kullanici adi yada sifre"));
    }
}
