package com.example.barBack.service.impl;

import com.example.barBack.dto.GoodsFilterDto;
import com.example.barBack.model.Good;
import com.example.barBack.repository.GoodsRepository;
import com.example.barBack.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsRepository repository;

    @Override
    public List<Good> getGoodsByCategory(GoodsFilterDto goodsFilterDto) {
        return null;
    }

    @Override
    public List<Good> getGoodsByName(String name) {
        return null;
    }
}
