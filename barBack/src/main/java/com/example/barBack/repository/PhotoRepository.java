package com.example.barBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.barBack.model.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
    Photo getPhotoById(Long id);
    Photo getPhotoByName(String name);
}
