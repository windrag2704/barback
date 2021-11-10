package com.example.barBack.dto.converters;

import com.example.barBack.dto.CustomerDto;
import com.example.barBack.model.Customer;

public class CustomerConverter {
    public static CustomerDto convertFromEntitytoDto(final Customer entity) {
        final CustomerDto customerDto = new CustomerDto();
        customerDto.setId(entity.getId());
        customerDto.setName(entity.getName());
        customerDto.setPhone(entity.getPhone());
        return customerDto;
    }
}
