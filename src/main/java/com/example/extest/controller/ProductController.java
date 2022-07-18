package com.example.extest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/product")
    public String Product(@RequestParam(name = "name", defaultValue = "TestProduct") String name) {
        return String.format("Product is, %s", name);
    }
}
