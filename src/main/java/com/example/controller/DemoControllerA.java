package com.example.controller;

import com.example.model.MultiLocaleValueDTO;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.*;

import java.util.Locale;
import java.util.stream.Stream;

@Controller
public class DemoControllerA {

    @Post("/testA")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MutableHttpResponse<MultiLocaleValueDTO> post(@Body MultiLocaleValueDTO body, HttpRequest<MultiLocaleValueDTO> request) {
        if (Stream.of(Locale.US, Locale.JAPAN).allMatch(l -> body.getValues().containsKey(l))) {
            return HttpResponse.ok();
        }

        return HttpResponse.badRequest();
    }
}
