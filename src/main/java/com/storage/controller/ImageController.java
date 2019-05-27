package com.storage.controller;

import com.storage.dto.Image;
import com.storage.service.ImageService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{folder}")
public class ImageController {

    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping(value = "/{filename}", produces = "image/jpg")
    public Resource get(@PathVariable String folder,
                        @PathVariable String filename) {
        return imageService.get(folder, filename);
    }

    @PostMapping("")
    public ResponseEntity<Void> save(
            @PathVariable String folder,
            @ModelAttribute Image image) {
        imageService.save(folder, image);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

}
