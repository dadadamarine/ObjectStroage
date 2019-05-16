package com.storage.controller;

import com.storage.dto.Image;
import com.storage.service.ImageService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.*;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;

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
        MockMultipartFile imageFile = new MockMultipartFile("name", "ded.png", "image/png", "data".getBytes());

        MockHttpServletResponse response = mockMvc.perform(get("/{folder}/{filename}","20190517","sample.jpg"))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void save_성공() throws Exception {
        MockMultipartFile imageFile = new MockMultipartFile("name", "ded.png", "image/png", "data".getBytes());
        MockHttpServletResponse imageResponseEntity = mockMvc.perform(multipart(FOLDER_NAME)
                .file(imageFile)
                .contentType(MediaType.MULTIPART_FORM_DATA))
                .andReturn().getResponse();

        assertThat(imageResponseEntity.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    public class MockImageService extends ImageService {

        @Override
        public Image get(String date, String fileName) {
            MockMultipartFile imageFile = new MockMultipartFile("name", "ded.png", "image/png", "data".getBytes());
            return new Image(imageFile);
        }

        @Override
        public void save(MultipartFile multipartFile) {
        }
    }
}