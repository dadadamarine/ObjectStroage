package com.storage.service;

import com.storage.dto.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class ImageService {

    public MultipartFile get(String date, String fileName) {

        return null;
    }

    public void save(Image image) {
        String imgName = image.getFile().getOriginalFilename();
        File upl = new File(imgName);
        try {
            upl.createNewFile();
            FileOutputStream fout = new FileOutputStream(upl);
            fout.write(image.getFile().getBytes());
            fout.close();
        } catch (IOException e) {
        }
    }
}
