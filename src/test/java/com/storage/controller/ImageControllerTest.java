package com.storage.controller;

import com.storage.dto.Image;
import com.storage.service.ImageService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;

@RunWith(MockitoJUnitRunner.class)
public class ImageControllerTest {
    private final String FOLDER_NAME = "/20190517";

    private MockMvc mockMvc;

    @InjectMocks
    private ImageController imageController;


    private MockImageService imageService = new MockImageService();

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(imageController)
                .build();
    }

    @Test
    public void get_성공() throws Exception {
    }

    @Test
    public void save_성공() throws Exception {
    }

    public class MockImageService extends ImageService {


        @Override
        public MultipartFile get(String date, String fileName) {
            return null;
        }

        @Override
        public void save(String folder, Image image) {
        }

    }
}