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
public class RegistrationController {
    private final IUserService m_userService;

    public RegistrationController(IUserService userService)
    {
        m_userService = userService;
    }

    @GetMapping("/register")
    public String register()
    {
        return "register";
    }

    @PostMapping("/register")
    public ResponseEntity<String> create(@Valid UserForm userForm, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
            return new ResponseEntity<>("ali", HttpStatus.BAD_REQUEST);

        UserFormToUser ufs = new UserFormToUser();
        User usr = ufs.convert(userForm);

        if(m_userService.isUserExist(usr))
            return new ResponseEntity<>("User already exist", HttpStatus.OK);

        m_userService.save(usr);

        return new ResponseEntity<>("User created", HttpStatus.OK);
    }
}
