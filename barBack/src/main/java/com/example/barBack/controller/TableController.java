package com.example.barBack.controller;

import com.example.barBack.entity.BarTable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tables")
public class TableController {

    @RequestMapping(method = RequestMethod.GET, value = "/getTables")
    public List<BarTable> getTables() {
        return new ArrayList<>();
    }
}
