package com.storage.controller;

import com.storage.dto.Image;
import com.storage.service.ImageService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.*;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(MockitoJUnitRunner.class)
public class ImageControllerTest {
    private final String FOLDER_NAME = "/20190517";

    @Autowired
    private TestRestTemplate template;

    private MockMvc mockMvc;

    private MockImageService imageService = new MockImageService();

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(ImageController.class)
                .build();
    }

    @Test
    public void get_성공() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/20190517/sample.jpg"))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void save_성공() throws Exception {
        MultiValueMap<String,Object> params = new LinkedMultiValueMap<>();
        params.add("file", new ClassPathResource("static/images/sample.jpg"));
        ResponseEntity<Image> imageResponseEntity = sendFile(FOLDER_NAME, params, Image.class);
        assertThat(imageResponseEntity.getBody().getImage().getName()).isEqualTo("sample.jpg");

    }

    protected <T> ResponseEntity<T> sendFile(String uri, MultiValueMap body, Class<T> responseType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.TEXT_HTML));
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<MultiValueMap<String, Object>>(body, headers);
        return template.exchange(uri, HttpMethod.POST, entity, responseType, "");
    }


    public class MockImageService extends ImageService {

    }

}