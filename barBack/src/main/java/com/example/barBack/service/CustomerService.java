package com.example.barBack.service;

import com.example.barBack.dto.CustomerDto;

public interface CustomerService {
    CustomerDto getUserByPhone(String phone);
}
