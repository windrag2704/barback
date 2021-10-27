package com.example.barBack.service;

import com.example.barBack.dto.GoodDto;
import com.example.barBack.dto.GoodFilterDto;
import com.example.barBack.model.Good;

import java.util.List;

public interface GoodsService {

    public List<Good> getGoodsByCategory(GoodFilterDto goodFilterDto);

    public List<GoodDto> getGoodsByName(String name);
}
