package com.greenpoint.server.auth.controller;

import com.greenpoint.server.auth.response.LoginResponse;
import com.greenpoint.server.auth.service.UserService;
import com.greenpoint.server.customer.model.Customer;
import com.greenpoint.server.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ResponseEntity<LoginResponse> getLogin(@RequestParam("code") String code) {

        boolean isRegistered;
        Object[] obArr = new Object[2];
        Customer userInfo = new Customer();
        obArr = userService.saveUser(code);
        System.out.println("obArr = " + obArr);
        userInfo =(Customer)obArr[0];
        isRegistered = (boolean)obArr[1];
        LoginResponse loginResponse = new LoginResponse(userInfo.getKakaoToken(), userInfo.getNickname(), userInfo.getImage(), isRegistered);
        return ResponseEntity.ok(loginResponse);
    }

}


