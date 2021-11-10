package com.example.barBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.barBack.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("select c from Customer c where c.phone = :phone")
    Customer findCustomerByPhone(String phone);
}
