package com.example.barBack.service.impl;

import org.springframework.stereotype.Service;

import com.example.barBack.dto.PhotoDto;
import com.example.barBack.dto.converters.PhotoConverter;
import com.example.barBack.model.Photo;
import com.example.barBack.repository.PhotoRepository;
import com.example.barBack.service.PhotoService;

@Service
public class PhotoServiceImpl implements PhotoService {
    final PhotoRepository repository;

    public PhotoServiceImpl(PhotoRepository repository) {
        this.repository = repository;
    }

    @Override
    public PhotoDto getPhotoById(Long id) {
        return PhotoConverter.convertFromEntityToDto(repository.getPhotoById(id));
    }

    @Override
    public PhotoDto getPhotoByName(String name) {
        return PhotoConverter.convertFromEntityToDto(repository.getPhotoByName(name));
    }

    @Override
    public Long addPhoto(String name, byte[] data) {
        Photo photo = new Photo();
        photo.setName(name);
        photo.setData(data);
        Photo saved = repository.save(photo);
        return saved.getId();
    }
}
