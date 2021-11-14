package com.example.barBack.service;

import com.example.barBack.model.BarTable;

import java.sql.Timestamp;
import java.util.List;

public interface TableService {
    List<BarTable> getTables();

    List<BarTable> getAllByDate(Timestamp startDate, Timestamp endDate);

    boolean reserveTable(int number);
}
