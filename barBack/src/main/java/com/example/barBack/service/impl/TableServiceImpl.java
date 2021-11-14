package com.example.barBack.service.impl;

import com.example.barBack.model.BarTable;
import com.example.barBack.model.TableLocation;
import com.example.barBack.model.TableReservationId;
import com.example.barBack.repository.TableRepository;
import com.example.barBack.repository.TableReservationRepository;
import com.example.barBack.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TableServiceImpl implements TableService {
    private final TableRepository repository;
    private final TableReservationRepository tableReservationRepository;

    @Autowired
    public TableServiceImpl(
            final TableRepository repository,
            final TableReservationRepository tableReservationRepository
    ) {
        this.repository = repository;
        this.tableReservationRepository = tableReservationRepository;
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

    @Override
    public List<BarTable> getAllByDate(Timestamp startDate, Timestamp endDate) {
        // находим забронированные на указанную дату
        final List<TableReservationId> tableReservationIds
                = tableReservationRepository.findReservedTables(startDate, endDate);
        List<Long> ids = tableReservationIds.stream()
                .map(TableReservationId::getTableId)
                .collect(Collectors.toList());
        // возвращаем не забронированные
        return repository.findTablesNotInIds(ids);
    }

    @Override
    public boolean reserveTable(final int number) {

        return false;
    }
}
