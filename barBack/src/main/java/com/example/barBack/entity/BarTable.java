package com.example.barBack.entity;

import javax.persistence.*;

@Entity
@Table (name = "bar_table")
public class BarTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "number")
    private int number;

    @Column(name = "seat_cnt")
    private int seatCnt;

    @Column(name = "location")
    private TableLocation location;

    @Column(name = "photo")
    private String photo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSeatCnt() {
        return seatCnt;
    }

    public void setSeatCnt(int seatCnt) {
        this.seatCnt = seatCnt;
    }

    public TableLocation getLocation() {
        return location;
    }

    public void setLocation(TableLocation location) {
        this.location = location;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
