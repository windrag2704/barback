package com.example.barBack.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.Hibernate;

@Embeddable
public class TableReservationId implements Serializable {
    private static final long serialVersionUID = -6760556349190247526L;
    @Column(name = "cutomer_id", nullable = false)
    private Long cutomerId;
    @Column(name = "table_id", nullable = false)
    private Long tableId;

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public Long getCutomerId() {
        return cutomerId;
    }

    public void setCutomerId(Long cutomerId) {
        this.cutomerId = cutomerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cutomerId, tableId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TableReservationId entity = (TableReservationId) o;
        return Objects.equals(this.cutomerId, entity.cutomerId) &&
                Objects.equals(this.tableId, entity.tableId);
    }
}
