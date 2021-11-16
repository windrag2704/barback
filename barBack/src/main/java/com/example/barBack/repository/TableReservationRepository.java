package com.example.barBack.repository;

import com.example.barBack.model.TableReservation;
import com.example.barBack.model.TableReservationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface TableReservationRepository
        extends JpaRepository<TableReservation, TableReservationId> {
    /**
     * Поиск забронированных столиков на указанную дату
     * @param startDate дата и время начала дня
     * @param endDate дата и время окончания дня
     * @return список ид броней
     */
    @Query("select r.id from TableReservation r "
            + "where r.reservationBegin >= :startDate "
            + "and r.reservationBegin <= :endDate")
    List<TableReservationId> findReservedTables(
            @Param("startDate") Timestamp startDate,
            @Param("endDate") Timestamp endDate);

    /**
     * Проверка, есть ли бронь на указанный столик на указанну дату
     * @param tableId ид столика
     * @param startDate дата начала брони
     * @param endDate дата окончания брони
     * @return количество броней
     */
    @Query("select count(r) from TableReservation r "
            + "where r.id.tableId = :tableId "
            + "and r.reservationBegin >= :startDate "
            + "and r.reservationBegin <= :endDate")
    int tableReservationCheck(
            @Param("tableId") long tableId,
            @Param("startDate") Timestamp startDate,
            @Param("endDate") Timestamp endDate);
}
