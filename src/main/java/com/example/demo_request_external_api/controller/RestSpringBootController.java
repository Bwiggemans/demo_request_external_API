package com.example.demo_request_external_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

        Object persons = restTemplate.getForObject(url, Object.class);

        return Arrays.asList(persons);
    }

    @GetMapping(value = "/persons{id}")
    public List<Object> getPerson(@PathVariable int id){
        String url = "https://swapi.dev/api/people";
        RestTemplate restTemplate = new RestTemplate();

        Object persons = restTemplate.getForObject(url, Object.class);

        return getPerson(id);
//        return Arrays.asList(persons);

    }



//    @GetMapping(value = "/books/{id}")
//    public ResponseEntity<Object> getBook(@PathVariable int id) {
//        return ResponseEntity.ok(bookService.getBook(id));
//    }

//    @GetMapping(value = "/names/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public String getName(@PathVariable int id){
//        return names.get(id);
//    }

}
