package com.mybooking.catalogservice.controllers;

import com.mybooking.catalogservice.application.SearchHandler;
import com.mybooking.catalogservice.domain.exceptions.SomethingHappendInBackendException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    SearchHandler handler;

    @GetMapping("/{categoria}")
    public ResponseEntity getBooksByCategory(@PathVariable String categoria){
        try {
            return ResponseEntity.ok(handler.getBooksByCategory(categoria));
        } catch (SQLException e) {
            return  ResponseEntity.badRequest().body("Something went wrong with out internal services, please wait");
        }catch (SomethingHappendInBackendException e) {
            return  ResponseEntity.badRequest().body(e.getMessage());

        }

    }
    @PostMapping("/{categoria}")
    public ResponseEntity nuevo(@PathVariable String categoria){
        try {
            return ResponseEntity.ok(handler.getBooksByCategory(categoria));
        } catch (SQLException e) {
            return  ResponseEntity.badRequest().body("Something went wrong with out internal services, please wait");
        }catch (SomethingHappendInBackendException e) {
            return  ResponseEntity.badRequest().body(e.getMessage());

        }

    }
}
