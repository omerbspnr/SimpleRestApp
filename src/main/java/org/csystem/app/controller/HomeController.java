package org.csystem.app.controller;

import org.csystem.app.dtos.LoginResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@RestController
public class HomeController {
    @GetMapping("/")
    public ResponseEntity<LoginResult> index(HttpSession httpSession)
    {
        Optional<LoginResult> res =  Optional.ofNullable((LoginResult) httpSession.getAttribute("userInfo"));

        return res.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.ok().build());
    }
}
