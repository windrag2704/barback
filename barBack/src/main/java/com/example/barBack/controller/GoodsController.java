package com.example.barBack.controller;

import com.example.barBack.dto.GoodDto;
import com.example.barBack.dto.GoodFilterDto;
import com.example.barBack.model.Good;
import com.example.barBack.service.GoodsService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService service;
    private final GsonBuilder gsonBuilder = new GsonBuilder();
    private final Gson gson = gsonBuilder.create();

    @PostMapping(value = "/getGoodsByCategory",
            consumes = "application/json",
            produces = "application/json")
    public String getGoodsByCategory(@RequestBody String body) {
        final GoodFilterDto goodFilterDto = gson.fromJson(body, GoodFilterDto.class);
        final List<Good> goods = service.getGoodsByCategory(goodFilterDto);
        return gson.toJson(goods);
    }

    @GetMapping(value = "/getGoodsByName", produces = "application/json")
    public String getGoodsByName(@RequestParam("name") String name) {
        List<GoodDto> goods = service.getGoodsByName("name");
        return gson.toJson(goods);
    }
}
