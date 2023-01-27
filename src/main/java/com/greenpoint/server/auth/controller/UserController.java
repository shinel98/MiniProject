package com.greenpoint.server.auth.controller;

import com.greenpoint.server.auth.response.AccountResponse;
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


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        userInfo = (Customer) obArr[0];
        isRegistered = (boolean) obArr[1];
        LoginResponse loginResponse = new LoginResponse(userInfo.getKakaoToken(), userInfo.getNickname(), userInfo.getImage(), isRegistered);
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/makeAccount")
    public ResponseEntity<AccountResponse> makeAccount(@RequestBody HashMap<String, String> param) {
        Boolean result;
        System.out.println("param = " + param);
        result = userService.getUserInfoByForm(param);
        if(result == false) {
            AccountResponse accountResponse = new AccountResponse(false);
            return ResponseEntity.ok(accountResponse);
        }
        AccountResponse accountResponse = new AccountResponse(true);
        return ResponseEntity.ok(accountResponse);
    }

    @DeleteMapping("/deleteMember")
    public String deleteAccount(HttpSession session, @RequestParam("token") String token){
        String resultCode = "";
        int result = userService.memberDelete(token);
        if(result == 0){
            resultCode = "회원 탈퇴 실패";

        } else {
            session.removeAttribute("sessionId");
            resultCode = "회원 탈퇴 성공";
        }
        return resultCode;
    }

}

