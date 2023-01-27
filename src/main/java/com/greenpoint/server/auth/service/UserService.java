package com.greenpoint.server.auth.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenpoint.server.auth.model.KakaoProfile;
import com.greenpoint.server.auth.model.KakaoProfile;
import com.greenpoint.server.customer.model.Customer;
import com.greenpoint.server.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLOutput;

import javax.servlet.http.HttpSession;
import java.sql.SQLOutput;
import java.util.HashMap;

@Service
public class UserService {
    @Autowired
    CustomerRepository customerRepository;

    public Object[] saveUser(String token) {

        Object[] obArr = new Object[2];
        String name = null;
        String imageUrl = null;
        Long id = null;

        String userInfo = getUserInfoByAccessToken(token);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(userInfo);
            System.out.println(jsonNode);
            id = Long.valueOf(String.valueOf(jsonNode.get("id")));
            System.out.println("id = " + id);
            name = String.valueOf(jsonNode.get("kakao_account").get("profile").get("nickname"));
            imageUrl = String.valueOf(jsonNode.get("kakao_account").get("profile").get("profile_image_url"));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println("userInfo" + userInfo);

        Customer user;

        user = customerRepository.findByKakaoId(id);
        System.out.println("user = " + user);
        if(user == null) {
            Customer newUser = Customer.from(id, token, name.substring(1, name.length() - 1), imageUrl.substring(1, imageUrl.length() - 1));
            obArr[0] = newUser;
            obArr[1] = false;
            customerRepository.save(newUser);
            return obArr;
        }

        obArr[0] = user;
        obArr[1] = true;
        return obArr;
    }


    public String getUserInfoByAccessToken(String accessToken) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        String url = "https://kapi.kakao.com/v2/user/me";

        return restTemplate.postForObject(url, request, String.class);
    }
    public Boolean getUserInfoByForm(HashMap<String, String> param) {
        Customer user;
        Long id = Long.valueOf(param.get("id"));
        System.out.println("id = " + id);
        try{
            user = customerRepository.findByKakaoId(id);
            user.setContact(param.get("contact"));
            user.setNickname(param.get("nickname"));
            user.setLatitude(Double.valueOf(param.get("latitude")));
            user.setLongitude(Double.valueOf(param.get("longitude")));
//        user = Customer.from(param.get("nickname"), param.get("contact"));
            user = customerRepository.save(user);
            if(user == null){
                return false;
            }
        }
        catch(Exception e){
            System.out.println("토큰이 다름!");
            return false;
        }

        return true;
    }


    public int memberDelete(Long id) {
        int result = customerRepository.deleteByKakaoId(id);
        return result;
    }

}
