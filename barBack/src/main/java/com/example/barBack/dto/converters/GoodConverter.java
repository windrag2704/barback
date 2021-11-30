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
        dto.setPhotoId(entity.getPhotoId());
        return dto;
    }
}
