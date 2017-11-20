package com.waverley.utils;

import io.vavr.control.Try;
import one.util.streamex.StreamEx;

import java.util.Collections;
import java.util.List;
import java.util.ServiceLoader;

/**
 * Utility Class for loading data sources.
 */
public final class ServiceLoaderUtils {
    private ServiceLoaderUtils() {
        throw new UnsupportedOperationException("Illegal access to private constructor");
    }

    public static <T> List<T> load(final Class<T> type, final ClassLoader classloader) {
        return Try.of(() -> StreamEx.of(ServiceLoader.load(type, classloader).iterator()).toList())
                .getOrElseGet(ex -> Collections.emptyList());
    }
}
