package com.example.barBack.dto;

public class ReserveTableDto {
    private String reservationBegin;
    private int tableNumber;
    private long customerId;

    public String getReservationBegin() {
        return reservationBegin;
    }

    public void setReservationBegin(String reservationBegin) {
        this.reservationBegin = reservationBegin;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
