package com.waverley;

import lombok.experimental.UtilityClass;

import static org.joor.Reflect.on;

@UtilityClass
public class PageFactory {
    @SuppressWarnings("unchecked")
    public static <T extends Page> T open(final Class<T> pageClass) {
        return (T) at(pageClass).navigateTo();
    }

    public static <T extends Page> T at(final Class<T> pageClass) {
        return on(pageClass).create().get();
    }
}
