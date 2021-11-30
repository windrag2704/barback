package com.example.barBack.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.barBack.dto.PhotoDto;
import com.example.barBack.service.PhotoService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping("/photo")
public class PhotoController {
    private final PhotoService photoService;
    private final GsonBuilder gsonBuilder = new GsonBuilder();
    private final Gson gson = gsonBuilder.create();

    PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @PostMapping(value = "/upload",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public HttpStatus upload(@RequestPart(name = "photo") MultipartFile file, HttpServletResponse response) {
        try {
            if (file == null || file.getOriginalFilename() == null || file.getOriginalFilename().equals("")) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return HttpStatus.BAD_REQUEST;
            }
            photoService.addPhoto(file.getOriginalFilename(), file.getBytes());
        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return HttpStatus.BAD_REQUEST;
        }
        response.setStatus(HttpServletResponse.SC_OK);
        return HttpStatus.OK;
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<byte[]> getById(@PathVariable(name = "id") Long id) {
        PhotoDto result = photoService.getPhotoById(id);
        byte[] content = result.getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        String fileName = result.getName();
        headers.setContentDisposition(
                ContentDisposition.builder("inline")
                        .name(fileName)
                        .build());
        return new ResponseEntity<>(content, headers, HttpStatus.OK);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<byte[]> getByName(@PathVariable(name = "name") String name) {
        PhotoDto result = photoService.getPhotoByName(name);
        if (result == null) {
            return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
        }
        byte[] content = result.getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentDisposition(
                ContentDisposition.builder("inline")
                        .name(name)
                        .build()
        );
        return new ResponseEntity<>(content, headers, HttpStatus.OK);
    }
}
