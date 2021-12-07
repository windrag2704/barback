package com.example.barBack.repository;

import com.example.barBack.model.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Good, Long> {
    @Query("select g from Good g where g.name like concat('%', :name, '%')")
    List<Good> findGoodsByName(@Param("name") String name);

    @Query("select g from Good g "
            + "where g.name like concat('%', :name, '%') "
            + "and g.price >= :priceFrom "
            + "and g.price <= :priceTo "
            + "and g.alcohol >= :alcoholFrom "
            + "and g.alcohol <= :alcoholTo "
            + "and g.volume >= :volumeFrom "
            + "and g.volume <= :volumeTo")
    List<Good> findGoodsByCategory(
            @Param("name") String name,
            @Param("priceFrom") double priceFrom,
            @Param("priceTo") double priceTo,
            @Param("alcoholFrom") double alcoholFrom,
            @Param("alcoholTo") double alcoholTo,
            @Param("volumeFrom") double volumeFrom,
            @Param("volumeTo") double volumeTo
    );

    @Query("select g from Good g "
            + "where g.price >= :priceFrom "
            + "and g.price <= :priceTo "
            + "and g.alcohol >= :alcoholFrom "
            + "and g.alcohol <= :alcoholTo "
            + "and g.volume >= :volumeFrom "
            + "and g.volume <= :volumeTo")
    List<Good> findGoodsByCategoryWithoutName(
            @Param("priceFrom") double priceFrom,
            @Param("priceTo") double priceTo,
            @Param("alcoholFrom") double alcoholFrom,
            @Param("alcoholTo") double alcoholTo,
            @Param("volumeFrom") double volumeFrom,
            @Param("volumeTo") double volumeTo
    );

    Good findByCode(int code);

    // методы для поиска без категории и без имени и без категории

    Good getGoodById(Long id);
}
