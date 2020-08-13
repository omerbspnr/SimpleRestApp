package org.csystem.app.controller;

import org.csystem.app.converter.LoginFormToUser;
import org.csystem.app.converter.RegistrationFormToUser;
import org.csystem.app.converter.UserToLoginResult;
import org.csystem.app.dtos.LoginForm;
import org.csystem.app.dtos.LoginResult;
import org.csystem.app.dtos.RegistrationForm;
import org.csystem.app.entity.User;
import org.csystem.app.service.IUserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
public class LoginController {
    private final IUserService m_userService;

    public LoginController(IUserService userService)
    {
        m_userService = userService;
    }

    @GetMapping("/login")
    public ResponseEntity<String> page(HttpSession httpSession)
    {
        if (httpSession.getAttribute("userInfo") != null)
            return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).header(HttpHeaders.LOCATION,"/").build();

        return new ResponseEntity<>("login.html", HttpStatus.OK);
    }

    @PostMapping(value = "/login", produces = "application/json")
    public ResponseEntity<String> login(@RequestBody LoginForm loginForm, BindingResult bindingResult, HttpSession httpSession)
    {

        if (bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        if (httpSession.getAttribute("userInfo") != null)
            return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).header(HttpHeaders.LOCATION, "/").build();

        LoginFormToUser loginToUser = new LoginFormToUser();
        Optional<User> usrOpt = m_userService.controlForLogin(loginToUser.convert(loginForm));

        if (!usrOpt.isPresent())
            return new ResponseEntity<>("Kullanıcı adı veya sifre gecersiz",HttpStatus.OK);

        httpSession.setAttribute("userInfo",new UserToLoginResult().convert(usrOpt.get()));

        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).header(HttpHeaders.LOCATION,"/").build();
    }
}
