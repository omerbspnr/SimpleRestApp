package org.csystem.app.controller;

import org.csystem.app.dtos.LoginResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class HomeController {
    @GetMapping("/")
    public ResponseEntity<String> index(@Valid LoginResult loginResult)
    {
        return new ResponseEntity<>("index", HttpStatus.OK);
    }
}
