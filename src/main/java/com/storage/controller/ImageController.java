package com.storage.controller;

import com.storage.dto.Image;
import com.storage.service.ImageService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/{folder}")
public class ImageController {

    private ImageService imageService;

    public ImageController(ImageService imageService){
        this.imageService = imageService;
    }

    @GetMapping("/{filename}")
    public MultipartFile get(@PathVariable String folder,
                     @PathVariable String filename) {
        return imageService.get(folder,filename);
    }

    @PostMapping("")
    public ResponseEntity<Void> save(
            @PathVariable String folder,
            @RequestParam("file") MultipartFile file){
        imageService.save(file);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(headers ,HttpStatus.CREATED);
    }

}
