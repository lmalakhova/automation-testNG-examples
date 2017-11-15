package com.waverley.model.utils;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;

/**
 * Utility Class for reading json data sources.
 */
public final class JsonUtils {
    private JsonUtils() {
        throw new UnsupportedOperationException("Illegal access");
    }

    // @SuppressWarnings("unchecked")
    public static <T> T jsonToEntity(final String dataSource, final Class<T> entityClass) {
        final Gson gson = new Gson();
        final String path = ClassLoader.getSystemResource(dataSource).getPath();
        try (final FileReader r = new FileReader(path)) {
            JsonReader reader = new JsonReader(r);
            return gson.fromJson(reader, entityClass);
        } catch (IOException e) {
            throw new IllegalArgumentException("Unable to read " + dataSource, e);
        }
    }
}
