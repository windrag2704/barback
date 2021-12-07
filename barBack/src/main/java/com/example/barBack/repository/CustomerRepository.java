package com.example.barBack.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.barBack.model.Customer;
import com.example.barBack.model.Good;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("select c from Customer c where c.phone = :phone")
    Customer findCustomerByPhone(@Param("phone") String phone);
    @Query("select cus.favourites from Customer cus where cus.id = :id")
    Set<Good> getCustomerFavourites(@Param("id") Long id);
    Customer getCustomerById(Long id);
}
