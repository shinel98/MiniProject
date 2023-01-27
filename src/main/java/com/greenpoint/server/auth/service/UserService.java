
package com.greenpoint.server.auth.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenpoint.server.customer.model.Customer;
import com.greenpoint.server.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private CustomerRepository customerRepository;


    public Object[] saveUser(String token) {

        Object[] obArr = new Object[2];
        String name = null;
        String imageUrl = null;

        String userInfo = getUserInfoByAccessToken(token);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(userInfo);
            name = String.valueOf(jsonNode.get("kakao_account").get("profile").get("nickname"));
            imageUrl = String.valueOf(jsonNode.get("kakao_account").get("profile").get("profile_image_url"));

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println("userInfo" + userInfo);

        Customer user = customerRepository.findByKakaoToken(token);
        if(user == null) {
            Customer newUser = Customer.from(token, name.substring(1, name.length() - 1), imageUrl.substring(1, imageUrl.length() - 1));
            obArr[0] = newUser;
            obArr[1] = false;
//            customerRepository.save(newUser);
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

}
