package com.storage.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    private String filePath;

    private MultipartFile file;

}
