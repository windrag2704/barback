package com.example.barBack.repository;

import com.example.barBack.model.AlcoholType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlcoholTypeRepository extends JpaRepository<AlcoholType, Long> {
    AlcoholType findByName(String name);
}
