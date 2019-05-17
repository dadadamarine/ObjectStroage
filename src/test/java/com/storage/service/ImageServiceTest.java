package com.storage.service;

import com.storage.controller.ImageController;
import com.storage.controller.ImageControllerTest;
import com.storage.dto.Image;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ImageServiceTest {
    private final String FOLDER_NAME = "/20190517";

    private MockMvc mockMvc;

    @InjectMocks
    private ImageService imageService;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(imageService)
                .build();
    }

    @Test
    public void get_성공(){
        MultipartFile multipartFile = imageService.get(FOLDER_NAME, "testfile.jpg");
    }

    @Test
    public void save_성공(){
        MultipartFile file = new MockMultipartFile("file",
                "file.png",
                "image/png",
                "datdedadsdwdssdwa".getBytes()
        );
        Image image = new Image("testfile.png", file);
        imageService.save("20190517",image);
    }
}