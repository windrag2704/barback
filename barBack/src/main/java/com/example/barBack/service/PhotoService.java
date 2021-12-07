package com.example.barBack.service;

import com.example.barBack.dto.PhotoDto;

public interface PhotoService {
    PhotoDto getPhotoById(Long id);
    PhotoDto getPhotoByName(String name);
    Long addPhoto(String name, byte[] data);
}
