package com.example.barBack.repository;

import com.example.barBack.model.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Good, Long> {

//    @Query("select p from product p where p.name = :name")
//    public List<Good> findGoodsByName(String name);
}
