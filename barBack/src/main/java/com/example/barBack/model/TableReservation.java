package com.example.barBack.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "table_reservation")
@Entity
public class TableReservation {
    @EmbeddedId
    private TableReservationId id;

    @Column(name = "reservation_begin", nullable = false)
    private Timestamp reservationBegin;

    public Timestamp getReservationBegin() {
        return reservationBegin;
    }

    public void setReservationBegin(Timestamp reservationBegin) {
        this.reservationBegin = reservationBegin;
    }

    public TableReservationId getId() {
        return id;
    }

    public void setId(TableReservationId id) {
        this.id = id;
    }
}
