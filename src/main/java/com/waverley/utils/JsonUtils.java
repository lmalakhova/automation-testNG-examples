package com.waverley.utils;

import com.waverley.interfaces.DataReader;

import static java.util.ServiceLoader.load;

/**
 * Utility Class for reading json data sources.
 */
@SuppressWarnings("unchecked")
public final class JsonUtils {
    private JsonUtils() {
        throw new UnsupportedOperationException();
    }

    public static <T> T jsonToEntity(final String dataSource, final Class<T> entityClass) {
        return (T) load(DataReader.class, ClassLoader.getSystemClassLoader());
    }
}

