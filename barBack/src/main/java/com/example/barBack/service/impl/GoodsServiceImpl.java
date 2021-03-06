package com.example.barBack.service.impl;

import com.example.barBack.dto.GoodDto;
import com.example.barBack.dto.GoodFilterDto;
import com.example.barBack.dto.converters.GoodConverter;
import com.example.barBack.model.AlcoholType;
import com.example.barBack.model.Containers;
import com.example.barBack.model.Good;
import com.example.barBack.repository.AlcoholTypeRepository;
import com.example.barBack.repository.GoodsRepository;
import com.example.barBack.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsRepository repository;

    @Autowired
    private AlcoholTypeRepository alcoholTypeRepository;

    @Override
    public List<GoodDto> getGoodsByCategory(GoodFilterDto goodFilterDto) {
        // обработка параметров, задать дефолтные значения
        filterValidator(goodFilterDto);
        List<Good> goods;

        if (goodFilterDto.getName().equals("")) {
            goods = repository.findGoodsByCategoryWithoutName(
                    goodFilterDto.getPriceFrom(),
                    goodFilterDto.getPriceTo(),
                    goodFilterDto.getAlcoholFrom(),
                    goodFilterDto.getAlcoholTo(),
                    goodFilterDto.getVolumeFrom(),
                    goodFilterDto.getVolumeTo()
            );
        } else {
            goods = repository.findGoodsByCategory(
                    goodFilterDto.getName(),
                    goodFilterDto.getPriceFrom(),
                    goodFilterDto.getPriceTo(),
                    goodFilterDto.getAlcoholFrom(),
                    goodFilterDto.getAlcoholTo(),
                    goodFilterDto.getVolumeFrom(),
                    goodFilterDto.getVolumeTo()
            );
        }
        return goods.stream()
                .map(GoodConverter::convertFromEntityToDto)
                .collect(Collectors.toList());
    }

    private void filterValidator(final GoodFilterDto goodFilterDto) {
        if (goodFilterDto.getScoreTo() == 0.0) {
            goodFilterDto.setScoreTo(5.0);
        }
        if (goodFilterDto.getPriceTo() == 0.0) {
            goodFilterDto.setPriceTo(1000000);
        }
        if (goodFilterDto.getAlcoholTo() == 0.0) {
            goodFilterDto.setAlcoholTo(100.0);
        }
        if (goodFilterDto.getVolumeTo() == 0.0) {
            goodFilterDto.setVolumeTo(100);
        }
    }

    @Override
    public List<GoodDto> getGoods() {
        final List<Good> goods = repository.findAll();
        return goods.stream()
                .map(GoodConverter::convertFromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<GoodDto> getGoodsByName(String name) {
        final List<Good> goods = repository.findGoodsByName(name);
        return goods.stream()
                .map(GoodConverter::convertFromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public GoodDto saveGood(GoodDto goodDto) {
        Good good = repository.findByCode(goodDto.getCode());
        if (good != null) {
            if (Containers.DRAFT.getName().equals(goodDto.getContainer())) {
                good.setVolume(good.getVolume() + goodDto.getVolume());
            } else if (Containers.BOTTLE.getName().equals(goodDto.getContainer())) {
                good.setNumOfBottles(good.getNumOfBottles() + goodDto.getNumOfBottles());
            } else {
                throw new IllegalArgumentException("Указанной тары не существует!");
            }
            final Good savedGood = repository.save(good);
            return GoodConverter.convertFromEntityToDto(savedGood);
        } else {
            Good newGood = GoodConverter.convertFromDtoToEntity(goodDto);
            final AlcoholType alcoholType = alcoholTypeRepository.findByName(goodDto.getAlcoholType());
            newGood.setAlcoholType(alcoholType);
            final Good savedGood = repository.save(newGood);
            return GoodConverter.convertFromEntityToDto(savedGood);
        }
    }

    @Override
    public GoodDto getGoodById(Long id) {
        return GoodConverter.convertFromEntityToDto(repository.getGoodById(id));
    }
}
