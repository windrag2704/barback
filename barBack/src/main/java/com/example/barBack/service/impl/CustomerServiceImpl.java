package com.example.barBack.service.impl;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.barBack.dto.CustomerDto;
import com.example.barBack.dto.converters.CustomerConverter;
import com.example.barBack.repository.CustomerRepository;
import com.example.barBack.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public CustomerDto getUserByPhone(String phone) {
        String regexPhoneCheck = "^+\\d{11,}$";
        if (!Pattern.matches(regexPhoneCheck, phone)) {
            throw new IllegalArgumentException("Incorrect phone number");
        }
        return CustomerConverter.convertFromEntitytoDto(
                customerRepository.findCustomerByPhone(phone));
    }
}
