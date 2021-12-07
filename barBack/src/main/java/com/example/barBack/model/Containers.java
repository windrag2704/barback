package com.example.barBack.model;

public enum Containers {
    DRAFT ("draft"),
    BOTTLE ("bottle");

    private String name;
    Containers(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
