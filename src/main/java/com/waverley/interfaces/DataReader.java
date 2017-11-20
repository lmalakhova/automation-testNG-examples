package com.waverley.interfaces;

/**
 * An interface.
 */
public interface DataReader {
    <T> T readFrom(String dataSource, Class<T> entityClass);
}
