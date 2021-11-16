package com.example.barBack.repository;

import com.example.barBack.model.BarTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TableRepository extends JpaRepository<BarTable, Long> {
    @Query("select t.id from BarTable t where t.number = :number")
    long findTableIdByNumber(@Param("number") int number);

    @Query("select t from BarTable t where t.id not in (:ids)")
    List<BarTable> findTablesNotInIds(@Param("ids") List<Long> ids);
}
