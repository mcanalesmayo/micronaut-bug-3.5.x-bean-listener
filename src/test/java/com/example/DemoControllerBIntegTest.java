package com.example;

import com.example.model.MultiLocaleValueDTO;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class DemoControllerBIntegTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void should_return_the_request_body() {
        MultiLocaleValueDTO req = new MultiLocaleValueDTO();
        req.getValues().put(Locale.US, "US locale");
        req.getValues().put(Locale.JAPAN, "JP locale");

        HttpResponse<MultiLocaleValueDTO> res = client.toBlocking().exchange(HttpRequest.POST("/testB", req));

        assertEquals(HttpStatus.OK, res.getStatus());
    }
}
