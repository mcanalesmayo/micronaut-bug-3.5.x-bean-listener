package com.example.bean_lifecycle;

import com.example.model.MultiLocaleValueDTO;
import com.example.serializer.MultiLocaleValueDeserializer;
import com.example.serializer.MultiLocaleValueSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import io.micronaut.context.event.BeanCreatedEvent;
import io.micronaut.context.event.BeanCreatedEventListener;
import jakarta.inject.Singleton;

@Singleton
public class ObjectMapperBeanEventListener implements BeanCreatedEventListener<ObjectMapper> {

    @Override
    public ObjectMapper onCreated(BeanCreatedEvent<ObjectMapper> event) {
        ObjectMapper mapper = event.getBean();

        SimpleModule module = new SimpleModule();
        module.addSerializer(new MultiLocaleValueSerializer());
        module.addDeserializer(MultiLocaleValueDTO.class, new MultiLocaleValueDeserializer());
        mapper.registerModule(module);

        return mapper;
    }
}
