package com.example.serializer;

import com.example.model.MultiLocaleValueDTO;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MultiLocaleValueSerializer extends StdSerializer<MultiLocaleValueDTO> {

    public MultiLocaleValueSerializer() {
        super(MultiLocaleValueDTO.class);
    }

    @Override
    public void serialize(MultiLocaleValueDTO multiLocaleValue, JsonGenerator gen, SerializerProvider provider)
            throws IOException {
        Map<String, String> locales = new HashMap<>();
        multiLocaleValue.getValues().forEach((k, v) -> locales.put(k.toLanguageTag(), v));

        gen.writeObject(locales);
    }
}
