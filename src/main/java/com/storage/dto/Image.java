package com.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    private MultipartFile image;

}
