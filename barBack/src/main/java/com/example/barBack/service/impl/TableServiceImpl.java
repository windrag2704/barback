package com.example.barBack.service.impl;

import com.example.barBack.service.TableService;

public class TableServiceImpl implements TableService {
    private final TableRepository repository;

    @Autovired
    public TableServiceImpl(
            final TableRepository repository
    ) {
        this.repository = repository;
    }
}
