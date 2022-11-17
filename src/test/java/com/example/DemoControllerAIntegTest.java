package com.example;

import com.example.model.MultiLocaleValueDTO;
import com.example.model.ReqDTO;
import com.example.model.ResDTO;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class DemoControllerAIntegTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void should_return_the_request_body() {
        MultiLocaleValueDTO req = new MultiLocaleValueDTO();
        req.getValues().put(Locale.US, "US locale");
        req.getValues().put(Locale.JAPAN, "JP locale");

        HttpResponse<MultiLocaleValueDTO> res = client.toBlocking().exchange(HttpRequest.POST("/testA", req));

        assertEquals(HttpStatus.OK, res.getStatus());
    }
}
