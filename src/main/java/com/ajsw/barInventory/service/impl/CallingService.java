package com.ajsw.barInventory.service.impl;

import com.ajsw.barInventory.domain.dto.BarDto;
import com.ajsw.barInventory.domain.dto.BarResponse;
import com.google.gson.Gson;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class CallingService {
    public static BarDto FindBarById(String id){
        try{
            String uriFinal = "http://localhost:8082/v1/barLocation/getById/" + id;

            RestTemplate restTemplate = new RestTemplate();

            BarResponse jsonResponse = restTemplate.getForObject(uriFinal, BarResponse.class);

            if (jsonResponse != null && jsonResponse.getBody() != null)
                return jsonResponse.getBody();

        } catch (HttpClientErrorException e){
            System.out.println(e.getResponseBodyAsString());
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
