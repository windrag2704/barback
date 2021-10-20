package com.example.barBack.controller;

import com.example.barBack.entity.BarTable;
import com.example.barBack.service.TableService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tables")
public class TableController {

    private final TableService service;
    private final GsonBuilder gsonBuilder = new GsonBuilder();
    private final Gson gson = gsonBuilder.create();

    @Autowired
    public TableController(
            final TableService service
    ) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getTables")
    public String getTables() {
        List<BarTable> tables = service.getTables();
        return gson.toJson(tables);
    }
}
