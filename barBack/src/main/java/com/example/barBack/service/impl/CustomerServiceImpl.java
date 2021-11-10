package com.example.barBack.service.impl;

import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.barBack.dto.CustomerDto;
import com.example.barBack.dto.GoodDto;
import com.example.barBack.dto.converters.CustomerConverter;
import com.example.barBack.dto.converters.GoodConverter;
import com.example.barBack.model.Customer;
import com.example.barBack.model.Good;
import com.example.barBack.repository.CustomerRepository;
import com.example.barBack.repository.GoodsRepository;
import com.example.barBack.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    GoodsRepository goodsRepository;
    @Override
    public CustomerDto getUserByPhone(String phone) {
//        String regexPhoneCheck = "^+\\d{11,}$";
//        if (!Pattern.matches(regexPhoneCheck, phone)) {
//            throw new IllegalArgumentException("Incorrect phone number");
//        }
        return CustomerConverter.convertFromEntitytoDto(
                customerRepository.findCustomerByPhone(phone));
    }

    @Override
    public Set<GoodDto> getUserFavourites(Long id) {
        final Set<Good> favourites = customerRepository.getCustomerFavourites(id);
        return favourites.stream()
                .map(GoodConverter::convertFromEntityToDto)
                .collect(Collectors.toSet());
    }

    @Override
    public Boolean addFavourite(Long uid, Long pid) {
        Customer customer = customerRepository.getCustomerById(uid);
        Good good = goodsRepository.getGoodById(pid);
        boolean result = customer.getFavourites().add(good);
        customerRepository.save(customer);
        return result;
    }

    @Override
    public Boolean removeFavourite(Long uid, Long pid) {
        Customer customer = customerRepository.getCustomerById(uid);
        Good good = goodsRepository.getGoodById(pid);
        boolean result = customer.getFavourites().remove(good);
        customerRepository.save(customer);
        return result;
    }

    @Override
    public CustomerDto getUserById(Long id) {
        final Customer customer = customerRepository.getCustomerById(id);
        return CustomerConverter.convertFromEntitytoDto(customer);
    }
}
