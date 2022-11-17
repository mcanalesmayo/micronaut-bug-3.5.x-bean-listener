package com.example.serializer;

import com.example.model.MultiLocaleValueDTO;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MultiLocaleValueDeserializer extends StdDeserializer<MultiLocaleValueDTO> {

    public MultiLocaleValueDeserializer() {
        super(MultiLocaleValueDTO.class);
    }

    @Override
    public MultiLocaleValueDTO deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException {
        Map<String, String> serializedMap = p.getCodec().readValue(p, TypeFactory.defaultInstance().constructMapType(HashMap.class, String.class, String.class));

        MultiLocaleValueDTO res = new MultiLocaleValueDTO();
        serializedMap.forEach((k, v) -> {
            Locale.Builder builder = new Locale.Builder();
            res.getValues().put(builder.setLanguageTag(k).build(), v);
        });

        return res;
    }
}
