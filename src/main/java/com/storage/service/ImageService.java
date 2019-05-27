package com.storage.service;

import com.storage.dto.Image;
import com.storage.exception.CannotSaveException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class ImageService {

    public Resource get(String date, String fileName) {
        ClassPathResource classPathResource = new ClassPathResource("static/images/testFileCheck.jpg");
        return classPathResource;
    }

    public void save(String folder, Image image) {
        String imgName = image.getFilePath();
        File file = new File("opt/assets/" + imgName);
        try {
            createFolder("opt/assets/"+folder);
            file.createNewFile();
            FileOutputStream fout = new FileOutputStream(file);
            fout.write(image.getFile().getBytes());
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new CannotSaveException("file save error");
        }
    }

    private void createFolder(String folder) {
        File emptyFolder = new File(folder);
        if (!emptyFolder.exists()) {
            emptyFolder.mkdir();
        }
    }
}
