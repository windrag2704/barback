package com.example.barBack.controller;

import com.example.barBack.dto.ReserveTableDto;
import com.example.barBack.model.BarTable;
import com.example.barBack.service.TableService;
import com.example.barBack.utils.DateUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("/tables")
public class TableController {

    @Autowired
    private TableService service;
    private final GsonBuilder gsonBuilder = new GsonBuilder();
    private final Gson gson = gsonBuilder.create();

    @GetMapping("/getAll")
    public String getTables() {
        List<BarTable> tables = service.getTables();
        return gson.toJson(tables);
    }

    @PostMapping(value = "/getAllByDate",
            consumes = "application/json",
            produces = "application/json")
    public String getAllByDate(@RequestBody String body) {
        try {
            final List<BarTable> tables = service.getAllByDate(
                    DateUtils.getStartDate(body, false),
                    DateUtils.getEndDate(body, false)
            );
            return gson.toJson(tables);
        } catch (DateTimeParseException ex) {
            return "Некорректно указана дата!";
        }
    }

    @PostMapping(value = "/reserve",
            consumes = "application/json",
            produces = "application/json")
    public String reserveTable(@RequestBody String body) {
        final ReserveTableDto reserveTableDto = gson.fromJson(body, ReserveTableDto.class);
        return service.reserveTable(reserveTableDto) ?
                "Столик успешно забронирован" : "Не удалось забронировать столик";
    }
}
