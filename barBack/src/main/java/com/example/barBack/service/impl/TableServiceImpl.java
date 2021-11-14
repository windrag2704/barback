package com.example.barBack.service.impl;

import com.example.barBack.dto.ReserveTableDto;
import com.example.barBack.model.BarTable;
import com.example.barBack.model.TableReservation;
import com.example.barBack.model.TableReservationId;
import com.example.barBack.repository.TableRepository;
import com.example.barBack.repository.TableReservationRepository;
import com.example.barBack.service.TableService;
import com.example.barBack.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
        if (ids.size() == 0) {
            return repository.findAll();
        } else {
            return repository.findTablesNotInIds(ids);
        }
    }

    @Override
    public boolean reserveTable(final ReserveTableDto reserveTableDto) {
        final long tableId = repository.findTableIdByNumber(reserveTableDto.getTableNumber());
        final int checkReservation = tableReservationRepository.tableReservationCheck(
                tableId,
                DateUtils.getStartDate(reserveTableDto.getReservationBegin(), true),
                DateUtils.getEndDate(reserveTableDto.getReservationBegin(), true));
        if (checkReservation > 0) {
            return false;
        }

        final TableReservationId tableReservationId = new TableReservationId();
        tableReservationId.setTableId(tableId);
        tableReservationId.setCutomerId(reserveTableDto.getCustomerId());

        final TableReservation tableReservation = new TableReservation();
        tableReservation.setId(tableReservationId);
        Timestamp reservationBeginDate = DateUtils.getDate(reserveTableDto.getReservationBegin());
        tableReservation.setReservationBegin(reservationBeginDate);

        tableReservationRepository.save(tableReservation);
        return true;
    }
}
