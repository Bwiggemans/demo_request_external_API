package com.example.demo_request_external_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class RestSpringBootController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping(value = "/callclienthello")
    private String getHelloClient(){
        String uri = "http://localhost:8081/hello";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }

    @GetMapping(value = "/countries")
    public List<Object> getCountries(){
        String url = "https://restcountries.com/v2/all";
        RestTemplate restTemplate = new RestTemplate();

        Object[] countries = restTemplate.getForObject(url, Object[].class);

        return Arrays.asList(countries);

    }
    @GetMapping(value = "/persons")
    public List<Object> getPersons(){
        String url = "https://swapi.dev/api/people";
        RestTemplate restTemplate = new RestTemplate();

        Object[] persons = restTemplate.getForObject(url, Object[].class);

        return Arrays.asList(persons);

    }
}
