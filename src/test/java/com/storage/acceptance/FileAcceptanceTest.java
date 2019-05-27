package com.storage.acceptance;

import com.storage.support.AcceptanceTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import static org.assertj.core.api.Assertions.assertThat;

public class FileAcceptanceTest extends AcceptanceTest {
    private final Logger log = LoggerFactory.getLogger(FileAcceptanceTest.class);
    private static final String API_IMAGE_URI = "/20190517";

    @Test
    public void 이미지_생성_API_성공() {
        //given
        MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<>();
        parameters.add("filePath", "20190517/testFileCheck.jpg");
        parameters.add("file", new ClassPathResource("static/images/sample.jpg"));
        //when
        ResponseEntity<Void> responseEntity =
                sendFile(API_IMAGE_URI, parameters, Void.class);
        //then
        log.info("body : {}", responseEntity.getBody());
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

//    @Test
//    public void getApi_success() {
//        //when
//        ResponseEntity<Object> responseEntity =
//                sendGet(API_IMAGE_URI+"/1" , Object.class);
//        //then
//        log.info("body : {}", responseEntity.getBody());
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
//    }

}
