package com.example.barBack.service;

import java.util.Set;

import com.example.barBack.dto.CustomerDto;
import com.example.barBack.dto.GoodDto;

public interface CustomerService {
    CustomerDto getUserByPhone(String phone);
    Set<GoodDto> getUserFavourites(Long id);
    Boolean addFavourite(Long uid, Long pid);
    Boolean removeFavourite(Long uid, Long pid);
    CustomerDto getUserById(Long id);
}
