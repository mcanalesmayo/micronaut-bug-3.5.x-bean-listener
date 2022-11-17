package com.example.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;

public class MultiLocaleValueDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private final HashMap<Locale, String> values = new HashMap<>();

    public HashMap<Locale, String> getValues() {
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MultiLocaleValueDTO that = (MultiLocaleValueDTO) o;
        return values.equals(that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
