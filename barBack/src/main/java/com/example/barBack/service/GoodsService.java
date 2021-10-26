package com.example.barBack.service;

import com.example.barBack.dto.GoodsFilterDto;
import com.example.barBack.model.Good;

import java.util.List;

public interface GoodsService {

    public List<Good> getGoodsByCategory(GoodsFilterDto goodsFilterDto);

    public List<Good> getGoodsByName(String name);
}
