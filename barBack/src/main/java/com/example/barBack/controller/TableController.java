package com.example.barBack.controller;

import com.example.barBack.model.BarTable;
import com.example.barBack.service.TableService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
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
            LocalDate date = LocalDate.parse(body);
            Timestamp startDate = Timestamp.valueOf(date.atStartOfDay());
            Timestamp endDate = Timestamp.valueOf(date.plusDays(1).atStartOfDay());
            final List<BarTable> tables = service.getAllByDate(startDate, endDate);
            return gson.toJson(tables);
        } catch (DateTimeParseException ex) {
            return "Некорректно указана дата!";
        }
    }

    @PostMapping(value = "/reserve",
            consumes = "application/json",
            produces = "application/json")
    public String reserveTable(@RequestBody String body) {
        try{
            int num = Integer.parseInt(body);
            return service.reserveTable(num) ? "Столик успешно забронирован" : "Не удалось забронировать столик";
        } catch (NumberFormatException ex) {
            return "Не удалось забронировать столик, " +
                    "стола с таким номером не существует";
        }
    }
}
