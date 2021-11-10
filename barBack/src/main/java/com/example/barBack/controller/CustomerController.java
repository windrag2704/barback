package com.example.barBack.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.barBack.dto.CustomerDto;
import com.example.barBack.dto.GoodDto;
import com.example.barBack.model.Customer;
import com.example.barBack.service.CustomerService;
import com.example.barBack.service.GoodsService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping("/user")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    private final GsonBuilder gsonBuilder = new GsonBuilder();
    private final Gson gson = gsonBuilder.create();

    @GetMapping(value = "/getById",
            produces = "application/json")
    public String getCustomerById(@RequestParam(name = "id") Long id) {
        CustomerDto customer = customerService.getUserById(id);
        return gson.toJson(customer);
    }

    @GetMapping(value = "/getByPhone",
            produces = "application/json")
    public String getCustomerByPhone(@RequestParam(name = "phone") String phone) {
        System.out.println(phone);
        CustomerDto customer = customerService.getUserByPhone(phone);
        return gson.toJson(customer);
    }

    @GetMapping(value = "/favourites",
            produces = "application/json")
    public String getFavourites(@RequestParam(name = "id") Long id) {
        Set<GoodDto> favourites = customerService.getUserFavourites(id);
        return gson.toJson(favourites);
    }

    @PostMapping(value = "/addFavourite")
    public String addFavourites(@RequestParam(name = "uid") Long uid,
                                @RequestParam(name = "pid") Long pid) {
        customerService.addFavourite(uid, pid);
        return null;
    }

    @DeleteMapping(value = "/deleteFavourite")
    public String removeFavourites(@RequestParam(name = "uid") Long uid,
                                   @RequestParam(name = "pid") Long pid) {
        customerService.removeFavourite(uid, pid);
        return null;
    }
}
