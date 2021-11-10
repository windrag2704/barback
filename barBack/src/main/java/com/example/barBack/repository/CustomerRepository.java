package com.example.barBack.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.barBack.model.Customer;
import com.example.barBack.model.Good;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("select c from Customer c where c.phone = :phone")
    Customer findCustomerByPhone(String phone);
    @Query("select fav.favourites from Customer fav")
    Set<Good> getCustomerFavourites(Long id);
    Customer getCustomerById(Long id);
}
