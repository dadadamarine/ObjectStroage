package com.storage.acceptance;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.*;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FileAcceptanceTest {
    private final Logger log = LoggerFactory.getLogger(FileAcceptanceTest.class);
    private static final String API_IMAGE_URI = "/20190517";

    @Autowired
    private TestRestTemplate template;

    private static MultipartFile content;

    @BeforeClass
    public static void init() {
        content = new MockMultipartFile("file",
                "file.png",
                "image/png",
                "datdedadsdwdssdwa".getBytes()
        );
    }

    @Test
    public void 이미지_생성_API_성공() {
        //given
        MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<>();
        parameters.add("file", new ClassPathResource("static/images/sample.jpg"));
        //when
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.TEXT_HTML));
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<MultiValueMap<String, Object>>(parameters, headers);

        ResponseEntity<Void> responseEntity = template.exchange(API_IMAGE_URI, HttpMethod.POST, entity , Void.class, "");
        //then
        log.info("body : {}", responseEntity.getBody());
    }

}
