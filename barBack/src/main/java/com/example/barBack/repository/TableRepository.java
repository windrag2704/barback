package com.example.barBack.repository;

import com.example.barBack.model.BarTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<BarTable, Long> {

}
