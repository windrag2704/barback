package com.example.barBack.dto.converters;

import com.example.barBack.dto.GoodDto;
import com.example.barBack.model.Good;

public class GoodConverter {
    public static GoodDto convertFromEntityToDto(final Good entity) {
        final GoodDto dto = new GoodDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setAlcohol(entity.getAlcohol());
        dto.setVolume(entity.getVolume());
        dto.setDescription(entity.getDescription());
        dto.setAlcoholType(entity.getAlcoholType().getName());
        dto.setCode(entity.getCode());
        dto.setContainer(entity.getContainer());
        dto.setNumOfBottles(entity.getNumOfBottles());

        dto.setPhotoId(entity.getPhotoId());
        return dto;
    }

    public static Good convertFromDtoToEntity(final GoodDto dto) {
        final Good entity = new Good();

        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setAlcohol(dto.getAlcohol());
        entity.setVolume(dto.getVolume());
        entity.setDescription(dto.getDescription());
        entity.setCode(dto.getCode());
        entity.setContainer(dto.getContainer());
        entity.setNumOfBottles(dto.getNumOfBottles());

        return entity;
    }
}
