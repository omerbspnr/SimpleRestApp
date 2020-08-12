package org.csystem.app.controller;

import org.csystem.app.converter.RegistrationFormToUser;
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

@RestController
public class RegistrationController {
    private final IUserService m_userService;
    private final HttpSession m_httpSession;
    public RegistrationController(IUserService userService, HttpSession httpSession)
    {
        m_userService = userService;
        m_httpSession = httpSession;
    }

    @GetMapping("/register")
    public ResponseEntity<String> register()
    {
        if (m_httpSession.getAttribute("userInfo") != null)
            return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).header(HttpHeaders.LOCATION, "/").build();

        return ResponseEntity.ok("register");
    }

    @PostMapping("/register")
    public ResponseEntity<String> create(@RequestBody RegistrationForm registrationForm, BindingResult bindingResult, HttpSession httpSession)
    {
        if (m_httpSession.getAttribute("userInfo") != null)
            return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).header(HttpHeaders.LOCATION, "/").build();

        if (bindingResult.hasErrors())
            return new ResponseEntity<>("invalid form", HttpStatus.BAD_REQUEST);

        RegistrationFormToUser regFromToUser = new RegistrationFormToUser();
        User usr = regFromToUser.convert(registrationForm);

        if(m_userService.isUserExist(usr))
            return new ResponseEntity<>("User already exist", HttpStatus.OK);

        m_userService.save(usr);

        return new ResponseEntity<>("User created", HttpStatus.OK);
    }
}
