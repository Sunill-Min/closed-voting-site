package com.minsunill.closedvotingsite.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Authentication", description = "사용자 인증")
@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @GetMapping("/test")
    public ResponseEntity<String> getTodo() {
        return ResponseEntity.ok("todo");
    }

}
