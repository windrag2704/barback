package com.example.barBack.dto;

public class GoodFilterDto {
    private String name;
    private String category;

    private double scoreFrom;
    private double scoreTo;

    private double priceFrom;
    private double priceTo;

    private double alcoholFrom;
    private double alcoholTo;

    private double volumeFrom;
    private double volumeTo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getScoreFrom() {
        return scoreFrom;
    }

    public void setScoreFrom(double scoreFrom) {
        this.scoreFrom = scoreFrom;
    }

    public double getScoreTo() {
        return scoreTo;
    }

    public void setScoreTo(double scoreTo) {
        this.scoreTo = scoreTo;
    }

    public double getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(double priceFrom) {
        this.priceFrom = priceFrom;
    }

    public double getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(double priceTo) {
        this.priceTo = priceTo;
    }

    public double getAlcoholFrom() {
        return alcoholFrom;
    }

    public void setAlcoholFrom(double alcoholFrom) {
        this.alcoholFrom = alcoholFrom;
    }

    public double getAlcoholTo() {
        return alcoholTo;
    }

    public void setAlcoholTo(double alcoholTo) {
        this.alcoholTo = alcoholTo;
    }

    public double getVolumeFrom() {
        return volumeFrom;
    }

    public void setVolumeFrom(double volumeFrom) {
        this.volumeFrom = volumeFrom;
    }

    public double getVolumeTo() {
        return volumeTo;
    }

    public void setVolumeTo(double volumeTo) {
        this.volumeTo = volumeTo;
    }
}
