package com.example.barBack.model;

import javax.persistence.*;

@Entity
@Table (name = "bar_table")
public class BarTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "number")
    private int number;

    @Column(name = "seat_cnt")
    private int seatCnt;

    @Column(name = "location")
    private String location;

    @Column(name = "photo")
    private String photo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
