package com.greenpoint.server.auth.controller;

import com.greenpoint.server.auth.response.LoginResponse;
import com.greenpoint.server.auth.service.UserService;
import com.greenpoint.server.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ResponseEntity<LoginResponse> getLogin(@RequestParam("code") String code) {

        Customer user;
        user = userService.saveUser(code);
        LoginResponse loginResponse = new LoginResponse(user.getKakaoToken(), user.getNickname(), user.getImage());

        return ResponseEntity.ok(loginResponse);
    }

}

