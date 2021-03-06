package com.example.barBack.service;

import com.example.barBack.dto.GoodDto;
import com.example.barBack.dto.GoodFilterDto;

import java.util.List;

public interface GoodsService {

    List<GoodDto> getGoodsByCategory(GoodFilterDto goodFilterDto);

    List<GoodDto> getGoods();

    List<GoodDto> getGoodsByName(String name);

    GoodDto saveGood(GoodDto goodDto);

    GoodDto getGoodById(Long id);
}
