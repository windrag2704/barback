package com.example.barBack.service.impl;

import com.example.barBack.dto.GoodDto;
import com.example.barBack.dto.GoodFilterDto;
import com.example.barBack.dto.converters.GoodConverter;
import com.example.barBack.model.Good;
import com.example.barBack.repository.GoodsRepository;
import com.example.barBack.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsRepository repository;

    @Override
    public List<Good> getGoodsByCategory(GoodFilterDto goodFilterDto) {
        return null;
    }

    @Override
    public List<GoodDto> getGoodsByName(String name) {
        final List<Good> goods = repository.findAll();
        List<GoodDto> goodsDto = new ArrayList<>();
        // переделать в стрим
        for(Good good : goods) {
            goodsDto.add(GoodConverter.convertFromEntityToDto(good));
        }
        return goodsDto;
        //return repository.findGoodsByName(name);
    }
}
