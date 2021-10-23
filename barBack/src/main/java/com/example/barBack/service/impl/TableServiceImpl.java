package com.example.barBack.service.impl;

import com.example.barBack.model.BarTable;
import com.example.barBack.model.TableLocation;
import com.example.barBack.repository.TableRepository;
import com.example.barBack.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableServiceImpl implements TableService {
    private final TableRepository repository;

    @Autowired
    public TableServiceImpl(
            final TableRepository repository
    ) {
        this.repository = repository;
    }

    @Override
    public List<BarTable> getTables() {

        List<BarTable> tables = new ArrayList<>();
        BarTable table = new BarTable();
        table.setLocation(TableLocation.BAT_TABLE.getName());
        table.setNumber(1);
        table.setPhoto("123.jpg");
        table.setSeatCnt(4);
        tables.add(table);
        repository.save(table);
        return repository.findAll();
    }
}
