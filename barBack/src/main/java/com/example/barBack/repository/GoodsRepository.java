package com.example.barBack.repository;

import com.example.barBack.model.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Good, Long> {
    // не работает
//    @Query("select p from product p where p.name = :name")
//    public List<Good> findGoodsByName(@Param("name") String name);
}
