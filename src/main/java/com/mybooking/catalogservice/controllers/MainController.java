package com.mybooking.catalogservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public ResponseEntity main(){
        return  ResponseEntity.ok("Welcome to my API");
    }

}
