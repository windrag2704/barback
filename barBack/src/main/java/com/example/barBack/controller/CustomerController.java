package com.example.barBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.barBack.dto.CustomerDto;
import com.example.barBack.service.CustomerService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping("/user")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    private final GsonBuilder gsonBuilder = new GsonBuilder();
    private final Gson gson = gsonBuilder.create();
    @PostMapping(value = "/getByPhone",
            consumes = "application/json",
            produces = "application/json")
    public String getCustomerByPhone(@RequestBody String phone) {
        CustomerDto customer = customerService.getUserByPhone(phone);
        return gson.toJson(customer);
    }
}
