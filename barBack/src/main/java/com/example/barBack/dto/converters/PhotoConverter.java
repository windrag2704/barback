package com.example.barBack.dto.converters;

import com.example.barBack.dto.PhotoDto;
import com.example.barBack.model.Photo;

public class PhotoConverter {
    public static PhotoDto convertFromEntityToDto(Photo entity) {
        if (entity == null) {
            return null;
        }
        final PhotoDto photoDto = new PhotoDto();
        photoDto.setId(entity.getId());
        photoDto.setName(entity.getName());
        photoDto.setData(entity.getData());
        return photoDto;
    }
}
