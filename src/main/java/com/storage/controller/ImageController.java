package com.storage.controller;

import com.storage.dto.Image;
import com.storage.service.ImageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/{yyyymmdd}")
public class ImageController {

    private ImageService imageService;

    public ImageController(ImageService imageService){
        this.imageService = imageService;
    }

    @GetMapping("/{fileName}")
    public Image get(@PathVariable(name = "yyyymmdd") Long date,
                     @PathVariable(name = "fileName") String fileName) {

    }

}
