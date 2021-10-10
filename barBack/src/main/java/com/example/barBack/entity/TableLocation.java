package com.example.barBack.entity;

public enum TableLocation {
    BAR_COUNTER("bar_counter"),
    BAT_TABLE("bar_table"),
    TABLE_BY_WINDOW("table_by_window");

    private String name;
    TableLocation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
