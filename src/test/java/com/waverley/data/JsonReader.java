package com.waverley.data;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.waverley.interfaces.DataReader;
import io.vavr.control.Try;

import java.io.FileReader;

import static java.lang.ClassLoader.getSystemResource;

/**
 * Utility Class for reading json data.
 */
@SuppressWarnings("all")
public class JsonReader implements DataReader {
    @Override
    public <T> T readFrom(final String dataSource, final Class<T> entityClass) {
        return Try.of(() -> new FileReader(getSystemResource(dataSource).getPath()))
                .mapTry(com.google.gson.stream.JsonReader::new)
                .mapTry(reader -> new JsonParser().parse(reader))
                .mapTry(jsonElement -> new Gson().fromJson(jsonElement, entityClass))
                .getOrElseThrow(e -> new IllegalArgumentException("Unable to readFrom " + dataSource, e));
    }
}
