package com.example.controller;

import com.example.resource.ExampleResource;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "security_auth")
public class ExampleController {

    @GetMapping(path = "/greetings")
    public String sayHello() {
        return "Hello";
    }

    @GetMapping(path = "/resources/{id}")
    public ExampleResource getResource(@PathVariable Long id) {
        return new ExampleResource(id, "Example");
    }

    @GetMapping(path = "/greetings/user")
    public String sayHelloTuUser(@AuthenticationPrincipal Jwt jwt) {
        String username = (String) jwt.getClaims().get("preferred_username");
        return "Hello " + username;
    }

}
