package com.storage.service;

import com.storage.dto.Image;
import com.storage.exception.CannotSaveException;
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
